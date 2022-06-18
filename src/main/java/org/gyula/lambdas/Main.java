package org.gyula.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        new Thread(()-> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n", 3);
//        }).start();



        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName()));

//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));

        Collections.sort(employees, Comparator.comparing(Employee::getName));



        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }


        UpperConcat uc = (s1, s2) -> s1.toUpperCase()+s2.toUpperCase();
        System.out.println(uc.upperConcat(employees.get(0).getName(), employees.get(1).getName()));

        UpperConcat uc2 = (s1, s2) -> s1.toLowerCase()+s2.toLowerCase();
        System.out.println(uc2.upperConcat(employees.get(0).getName(), employees.get(1).getName()));

        System.out.println("Our lambda's class is: " + uc.getClass());

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);


//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() +  s2.toUpperCase();
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperConcat(s1, s2);
    }
}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
//@FunctionalInterface
//interface UpperConcat {
//    public String upperConcat(String s1, String s2);
//}

class AnotherClass {

    public String doSomething() {
        int i = 0;
        i++;

        UpperConcat uc = (s1, s2) -> {
//            System.out.println(i);
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1","String2");
    }
}

