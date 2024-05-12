package task.hashtm;

import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class HashTableExample {
    public static void main(String[] args) throws InterruptedException {
        Hashtable<Integer, String> map = new Hashtable<>();

        new Thread(()-> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < 10000; i++) {
                    int rand = new Random().nextInt(20000);
                    System.out.println("adding ");
                    map.put(i, "number "+i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Thread.sleep(10000);
        new Thread(()-> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("===================================");
                    int rand = new Random().nextInt(20000);
                    if(map.get(rand)!=null) {
                        System.out.println("getting " + map.get(i));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
