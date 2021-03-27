package java8.functionalinterface;

@FunctionalInterface
interface Sayable{
    void say(String msg);
}


public class FunctionalInterfaceExample implements Sayable{

    public void say(String msg){  
        System.out.println(msg);  
    }

    public static void main(String[] args) {  
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
        fie.say("Hello there");  
    }  
}  