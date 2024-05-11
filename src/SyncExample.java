public class SyncExample {
    public static void main(String[] args) {

    }
}

class  WokerSync{

    int i=0;
    public synchronized   void  sync(){
        i ++;
        System.out.println(" sync ");
    }

    public void order(){
        synchronized (this){
                i ++;
        }
        System.out.println(" sync ");
    }
}
