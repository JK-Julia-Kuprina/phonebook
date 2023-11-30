package midterm_test_data_structures4;

import java.util.Iterator;

public class HashMap<K, V> implements Iterable<HashMap.Entity> { // пара ключ-значение

    private static final int INIT_BUCKET_COUNT = 16; // начальная размерность массива
    private static final double LOAD_FACTOR = 0.5;//вводим дополнительную переменную
    private int size = 0;//переменная количества элементов в хэш-таблице


    private Bucket[] buckets;

    @Override
    public Iterator<HashMap.Entity> iterator() {
        return new HashMapIterator();
    }

    class HashMapIterator implements Iterator<HashMap.Entity>{

        int bucketIndex = 0; // Текущий индекс
        int nodeIndex = 0;  // Индекс ноды
        Entity entity;

        @Override
        public boolean hasNext() { // Есть ли следующий элемент

            for (int i = bucketIndex; i < buckets.length; i ++) {
                Bucket<K, V> bucket = buckets[i];
                if (bucket != null) {

                    Bucket.Node node = bucket.head; // Перебираем связный список с ноды, на которой остановились
                    int j = 0;
                    while (node != null) {
                        if (j < nodeIndex) {
                            j ++;
                            node = node.next;
                            continue;
                        }

                        entity = new Entity();
                        entity.key = (K)node.value.key;
                        entity.value = (V)node.value.value;
                        nodeIndex ++;
                        return true;
                    }
                    nodeIndex = 0;
                }
                bucketIndex ++;
            }
            return false;
        }

        @Override
        public Entity next() { //метод возвращает следующий элемент
            return entity;
        }
    }

    class Entity{
        K key;
        V value;
    }

    class Bucket<K, V>{

        private Node head;
        class Node{
            Node next;
            Entity value;
        }

        public V add(Entity entity){ // метод добавления нового элемента, создаем node и присваиваем значение
            Node node = new Node();
            node.value = entity;

            if (head == null){
                head = node;
                return null;
            }

            Node currentNode = head;//перебор значений от головы до хвоста, сверяя каждый элемент по ключу
            while (true){
                if (currentNode.value.key.equals(entity.key)){
                    V buf = (V)currentNode.value.value;//временная переменная buffer, записываем в нее старое значение
                    currentNode.value.value = entity.value;//перезаписываем старое значение на новое
                    return buf;
                }
                if (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                else {
                    currentNode.next = node;
                    return null;
                }
            }

        }

        public V remove(K key){ // удаление по ключу
            if (head == null)
                return null;
            if (head.value.key.equals(key)){
                V buf = (V)head.value.value;
                head = head.next;
                return buf;
            }
            else {
                Node node = head;
                while (node.next != null){
                    if (node.next.value.key.equals(key)){
                        V buf = (V)node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }

        public V get(K key){
            Node node = head;
            while (node != null){
                if (node.value.key.equals(key))
                    return (V)node.value.value;
                node = node.next;
            }
            return null;
        }


    }

    private int calculateBucketIndex(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void recalculate(){//выделяем пары значений из старого массива и добавляем в новый, без задвоения
        size = 0;
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++){
            Bucket<K, V> bucket = old[i];
            if (bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null){
                    put((K)node.value.key, (V)node.value.value);
                    node = node.next;
                }
            }
        }
    }

    public V put(K key, V value){ // метод добавления нового элемента в HashMap

        if (buckets.length * LOAD_FACTOR <= size){//при добавлении проверяем длину
            recalculate();
        }

        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];//значение null по умолчанию
        if (bucket == null){
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();//ключ значение
        entity.key = key;
        entity.value = value;

        V res = (V)bucket.add(entity);//добавляем значение
        if (res == null){
            size++;
        }
        return res;
    }

    public V remove(K key){ //метод удаления элементов
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];

        if (bucket == null)
            return null;
        V res = (V)bucket.remove(key);
        if (res != null){
            size--;
        }
        return res;
    }

    public V get(K key){ //метод возвращения элементов
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V)bucket.get(key);
    }

    public HashMap(){
        buckets = new HashMap.Bucket[INIT_BUCKET_COUNT];

    }

    public HashMap(int initCount){    //передаем начальный размер массива
        buckets = new Bucket[initCount];
    }

}
