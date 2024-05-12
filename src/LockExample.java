import java.util.concurrent.locks.ReentrantLock;

class MyClass {
    private final ReentrantLock lock = new ReentrantLock();
    public void method1() {
        System.out.println(Thread.currentThread().getName() + "Method 1 is Trying to acquire lock");
        lock.lock();
        try {
            System.out.println("Method 1 is running "+Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Method 1 is releasing lock" +Thread.currentThread().getName());
        }
    }

}
public class LockExample {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        new Thread(() -> myClass.method1()).start();
        new Thread(() -> myClass.method1()).start();
        new Thread(() -> myClass.method1()).start();


    }
}
