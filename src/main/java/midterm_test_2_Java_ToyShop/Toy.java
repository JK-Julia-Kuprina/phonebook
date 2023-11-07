package midterm_test_2_Java_ToyShop;

public class Toy {
        private Integer id;
        private String name;

        public Toy(Integer id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ID: " + this.id + "; Имя: " + this.name + ";";
        }
}

