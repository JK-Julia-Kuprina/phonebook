package midterm_test_2_Java_ToyShop;

import java.util.PriorityQueue;

public class Lottery {

    PriorityQueue<LotteryToy> items = new PriorityQueue<>();

    public void add(Toy toy, Integer count) {
        for(int i = 0; i < count; i++) {
            this.items.add(new LotteryToy(toy, count));
        }
    }

    public LotteryToy get(){
        return this.items.poll();
    }
}
