public class VolatileExample {
    public static volatile boolean flag= false;
    public static void main(String[] args) {
        System.out.println("tamer");
        System.out.println("tamer2");
        new Thread(()->{
            for (int i = 0; i <1000 ; i++) {
                System.out.println("i = " + i);
            }
            flag=true;
            System.out.println("thread 1 flag = " + flag);
        }).start();

        new Thread(()->{
           int i =0;
            while (!flag) {
               ++i;
           }
            System.out.println("thread 2  wait = " + i);
        }).start();
    }
}
