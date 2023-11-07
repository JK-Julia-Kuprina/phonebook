package midterm_test_2_Java_ToyShop;

import java.util.Random;

public class LotteryToy implements Comparable<LotteryToy>{
    Toy toy;
    Integer weight;
    Integer priority;

    public LotteryToy(Toy toy, Integer weight){
        this.toy = toy;
        this.weight = weight;
        Random r = new Random();
        this.priority = r.nextInt(weight);
    }

    public Integer getPriority() {
        return this.priority;
    }

    public int compareTo(LotteryToy item) {
        if (this.getPriority() > item.getPriority()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.toy.toString() + " Вес: " + this.weight + "; Приоритет: " + this.priority + ";";
    }
}
