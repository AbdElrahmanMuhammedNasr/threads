public class NotifierExample {
    public static void main(String[] args) throws InterruptedException {
        final Course course = new Course("Java");


        new Thread(()->{
            synchronized (course) {
                System.out.println(Thread.currentThread().getName() + " student is   watting the course");
                try {
                    course.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " the course is ready");
            }
        },"Student A").start();

        new Thread(()->{
            synchronized (course) {
                System.out.println(Thread.currentThread().getName() + " student is   watting the course");
                try {
                    course.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " the course is ready");
            }
        },"Student B").start();

        Thread.sleep(2000);

        new Thread(()->{
            synchronized (course) {
                System.out.println(Thread.currentThread().getName() + " instractor is   get ready  the course");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                course.notifyAll();
                System.out.println(Thread.currentThread().getName() + " the course is ready");
            }
        },"instractor").start();
    }
}

class Course{
    public String title;
    public  Course(String title){
        this.title = title;
    }
}