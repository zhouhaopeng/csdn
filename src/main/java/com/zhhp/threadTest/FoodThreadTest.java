package com.zhhp.threadTest;

public class FoodThreadTest {


    static class Producer implements Runnable{

        Food food ;

        public Producer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            for (;;){
                food.produce();
            }
        }
    }

    static class Consumer implements Runnable{

        Food food ;

        public Consumer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            for(;;){
                food.consume();
            }
        }
    }

    public static void main(String[] args){

        Food food = new Food();
        for(int i = 0 ; i < 5 ; i ++){
            new Thread(new Consumer(food),"consumer_"+i).start();
            new Thread(new Producer(food),"producer_"+i).start();
        }

    }
}
