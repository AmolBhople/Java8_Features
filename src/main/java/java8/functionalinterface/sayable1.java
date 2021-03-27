package java8.functionalinterface;

interface sayable1{
    void say(String msg);   // abstract method  
}  
@FunctionalInterface  
interface Doable extends sayable1{
    // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface  
//    void doIt();   //remove this comment. it shows error
}  