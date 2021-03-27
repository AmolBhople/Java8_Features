package java8.functionalinterface;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate< Person > predicate = (person1) -> person1.getAge() > 28;
        boolean result = predicate.test(new Person("ramesh", 29));
        System.out.println(result);

    }
}