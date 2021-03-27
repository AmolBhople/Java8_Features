package java8.methodref;

interface EmployeeEmpty {
    Employee get();
}
interface EmployeeWithName {
    Employee get(String name);
}

//https://www.amitph.com/java-method-and-constructor-reference/

public class Employee {
    private String name;
    Employee() {
        System.out.println("Empty Constructor");
    }
    Employee(String name) {
        System.out.println("Name Constructor");
        this.name = name;
    }
    public String toString() {
        return "name: " + name;
    }


    public static void main(String[] args) {

        EmployeeEmpty empEmpty = Employee::new;
        System.out.println("Constructor isn't called yet");
        System.out.println(empEmpty.get());
// Output
// Constructor isn't called yet
// Empty Constructor
// name: null



        EmployeeWithName empWithName = Employee::new;
        System.out.println("Constructor isn't called yet");
        System.out.println(empWithName.get("Java"));
// Output
// Constructor isn't called yet
// Name Constructor
// name: Java
    }
}
