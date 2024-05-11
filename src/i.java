interface x{
     default String a(){
         return String.valueOf(":");
     }
}

 interface f extends  x{

   @Override
   default String a(){
        return String.valueOf("this is tamer");
    }
}
class c implements x{


    public String get(){
       return this.a();
    }
}

public class i  {
    public static void main(String[] args) {
        try {
            c cx = new c();
            System.out.println(cx.get());
        }catch (Exception e){
            throw new RuntimeException("RuntimeException");
        } finally{
        }
        System.out.println("end");
    }
}
