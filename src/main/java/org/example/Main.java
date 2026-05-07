package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmps;


    public static void main(String[] args) {
        List<Employee> employess = new ArrayList<>();
        employess.add(new Employee(1, "Jane", "Doe"));
        employess.add(new Employee(2, "John", "Doe"));
        employess.add(new Employee(3, "Conan", "Con"));
        employess.add(new Employee(4, "Kobe", "Bryant"));
        employess.add(new Employee(4, "Kobe", "Bryant"));
        employess.add(new Employee(3, "Conan", "Con"));
        employess.add(new Employee(5, "Bob", "Bobo"));


        System.out.println(findDuplicates(employess));
        System.out.println(findUniques(employess));
        System.out.println(removeDuplicates(employess));

        System.out.println("*******************************");

        System.out.println(WordCounter.calculatedWord());
    }

    public static List<Employee> findDuplicates(List<Employee> emps){
        employeeMap = new HashMap<>();
        duplicatedEmps = new LinkedList<>();

        Iterator<Employee> iter = emps.iterator();
        while (iter.hasNext()){
            Employee employee = iter.next();
            if(employee == null){
                System.out.println("Null");
                continue;
            }

            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmps.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmps;
    }

    public static  Map<Integer, Employee> findUniques(List<Employee> emps){

        employeeMap = new HashMap<>();

        Iterator<Employee> iter = emps.iterator();
        while (iter.hasNext()){
            Employee employee = iter.next();
            if(employee == null){
                System.out.println("Null");
                continue;
            }

            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> emps){

        List<Employee> duplicates = (findDuplicates(emps));
        Map<Integer, Employee> singles = findUniques(emps);
        List<Employee> uniques = new LinkedList<>(singles.values());
        uniques.removeAll(duplicates);
        return uniques;
    }

}