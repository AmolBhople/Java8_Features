package java8.streams;

import java8.model.Employee;
import java8.model.Gender;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectStreamExample {

    public static void main(String[] args) {
        List<Employee> empList = getEmployees();

        System.out.println("Print 2 top  salary emp : ");
        empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("Print 2 top salary emp [FEMALE] : ");
        empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .filter(emp -> emp.getGender().equals(Gender.FEMALE))
                .limit(2)
                .forEach(System.out::println);


        //collect names in a list
        System.out.println("Print 2 top salary emp [Male] names only: ");
        List<String> stringList = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .filter(emp -> emp.getGender().equals(Gender.MALE))
                .limit(2)
                .map(Employee::getName)
                .collect(Collectors.toList());
        stringList.stream().forEach(System.out::println);

        //collect names and emp object in a map
        System.out.println("collect names and emp object in a map ");
        Map<String, Employee> stringEmployeeMap = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toMap(e -> e.getName(), e -> e));

        stringEmployeeMap.keySet().stream().forEach(System.out::println);
        stringEmployeeMap.values().stream().forEach(System.out::println);

//Joining names

        String collect = empList.stream()
                .limit(4)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Joining 4 names by comma.... "+collect);


        //grouping by gender
        Map<Gender, List<Employee>> groupByGender = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        groupByGender.forEach(((gender, employees) -> {
            System.out.println(gender);
            employees.stream()
                    .forEach(System.out::println);
        }));
        //grouping by gender and count
        Map<Gender, Long> groupByGenderAndCount = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        groupByGenderAndCount.forEach(((gender, aLong) -> {
            System.out.println(gender+"    "+aLong);
        }));

    }

    private static List<Employee> getEmployees(){
        List<Employee> empList = new ArrayList();
        Employee e = new Employee();
        e.setAge(1);
        e.setGender(Gender.MALE);
        e.setName("AB");
        e.setSalary(233333d);
    empList.add(e);
        empList.add(new Employee("A231",11,20d, Gender.MALE));
        empList.add(new Employee("A341",13,24d, Gender.MALE));
        empList.add(new Employee("A3561",12,24d, Gender.FEMALE));
        empList.add(new Employee("r453A1",12,23d, Gender.MALE));
        empList.add(new Employee("A4325351",15,22d, Gender.FEMALE));
        empList.add(new Employee("Afghdh1",16,22d, Gender.FEMALE));
        empList.add(new Employee("A42345grg1",18,12d, Gender.FEMALE));
        empList.add(new Employee("546gheA1",17,25d, Gender.MALE));
        empList.add(new Employee("456gdgA1",14,29d, Gender.MALE));
        empList.add(new Employee("456356hgftrgA1",11,452d, Gender.MALE));
        return empList;
    }
}
