package java8.streams;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {

    private static void printArr(int[] numbers) {
        System.out.println("Print numbers: ");
        for (int i: numbers) {
            System.out.print(" "+i);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,12,23,34,11,56,11,22,2,3,4,5,12,34,23,12,234,231,111,222,33,333,44 };
        printArr(numbers);

        //Till Java 7 //Find Minimum number form array
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(min > numbers[i]){
                min= numbers[i];
            }
        }
        System.out.print("\nminimum number="+min);

        //Using Streams e.g. = 1  //get int from Optional Class
        OptionalInt min1 = IntStream.of(numbers).min();
        int asInt = min1.getAsInt();
        System.out.print("\nminimum number using Streams ="+asInt);

        //Using Streams e.g. = 2
        int asInt1 = IntStream.of(numbers)
                .min()
                .getAsInt();
        System.out.println("\nminimum number using Streams ="+asInt1);

        //Using Streams e.g. = 3  //Print using method reference.
        IntStream.of(numbers)
                .min()
                .ifPresent(System.out::println);

        IntStream.of(numbers).max();
        IntStream.of(numbers).average();
        IntStream.of(numbers).sum();
        IntStream.of(numbers).count();

        // instead of calling IntStream.of(numbers) each time  use summaryStatistics object.
        IntSummaryStatistics intSummaryStatistics = IntStream.of(numbers).summaryStatistics();
        intSummaryStatistics.getMin();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getAverage();
        intSummaryStatistics.getCount();
        intSummaryStatistics.getSum();

        //Find 3 distinct smallest numbers
        //Without Streams
        int[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copyOfNumbers);
        System.out.println("Find 3 distinct smallest numbers without Streams= ");
        for (int i = 0; i < 3; i++) {
            System.out.println(copyOfNumbers[i]);  // it is not distinct
        }
        //with Streams
        System.out.println("Find 3 distinct smallest numbers WITH Streams= ");
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
//Multiple ways to create a stream
        IntStream.of(numbers);
        IntStream.range(1, 100);// 1 to 99
        IntStream.rangeClosed(1,100); //1 to 100
//        IntStream.generate(supplier());??
        System.out.println("Streams range= ");
        IntStream.range(1, 100)
                .forEach(System.out::print);
        System.out.println("\nStreams rangeClosed=  ");
        IntStream.rangeClosed(1,100).forEach(System.out::print);

        //skip first 50 numbers
        System.out.println("\nskip first 50 numbers=  ");
        IntStream.range(1, 101)
                .skip(50)
                .forEach(System.out::print);

        System.out.println("\nfilter odd number =  ");
        IntStream.rangeClosed(1, 100)
                .filter(n->n%2==0)
                .forEach(System.out::print);

        System.out.println("\nfilter odd number and skip 48numbers=  ");
        IntStream.rangeClosed(1, 100)
                .filter(n->n%2==0)
                .skip(48)
                .forEach(System.out::print);
        System.out.println("\nfilter odd number and skip 49 numbers and double it=  ");
        IntStream.rangeClosed(1, 100)
                .filter(n->n%2==0)
                .skip(49)
                .map(n->n*2)
                .forEach(System.out::print);


        System.out.println("\nfilter EVEN number and skip 48 numbers and double it convert it in to INTEGER LIST=  ");
        IntStream.rangeClosed(1, 100)
                .filter(n->n%2==1)
                .skip(48)
                .map(n->n*2)
                .boxed()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nfilter EVEN number and return true if at least one number is odd in list ");
        boolean b = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 1)
                .anyMatch(n -> n % 2 == 0);
        System.out.println("result = "+b);
        System.out.println("\nfilter EVEN number and return true if all numbers all even in list ");
        boolean b1 = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 1)
                .allMatch(n -> n % 2 == 0);
        System.out.println("result = "+b1);

    }
}
