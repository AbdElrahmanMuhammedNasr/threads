package task.hashtm;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        new Thread(()-> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < 10000; i++) {
                    int rand = new Random().nextInt(20000);
                    System.out.println("adding ");
                    map.put(rand, " "+i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(10000);
        new Thread(()-> {
            try {
                for (int i = 0; i < 5; i++) {
                    int rand = new Random().nextInt(20000);
                    if(map.get(rand)!=null) {
                        System.out.println("getting " + map.get(rand));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
