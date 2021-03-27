package java8.methodref;

public class ReferenceToStaticMethod {

    // Syntax : ContainingClass::staticMethodName
    public static void main(String[] args) {
  
        // Using lambda expression
        Thread thread = new Thread(() -> System.out.println("Thread is running using lambda..."));
        thread.start();
  
        // using predefined functional interface Runnable to refer static method
        Thread t2 = new Thread(ReferenceToStaticMethod::ThreadStatus);
        t2.start();
    }

    public static void ThreadStatus() {
        System.out.println("Thread is running...");
    }
}