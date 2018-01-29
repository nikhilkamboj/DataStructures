package com.developement.datastructures.hashing;

import java.util.HashMap;
import java.util.Map;

public class Executor {
    public static void main(String[] args) {
//        HashMap<Employee, String> employeeMap = new HashMap<Employee, String>();
//
//
//
//        employeeMap.put(new Employee("Rahul", 32), "MH02PW3424");
//        employeeMap.put(new Employee("Ram", 44), "MH02PW343");
//        employeeMap.put(new Employee("Nik", 20), "MH02PWXXXXX");
//
//        System.out.println(employeeMap);

        HashMap<Integer, Integer> map =  new HashMap<>();


        if(map.containsKey(new Integer(1))) {
            Integer currentValue = map.get(new Integer(1));
            map.put(new Integer(1), currentValue + 1);
        }


        for (Map.Entry<Integer, Integer> entry: map.entrySet()  ) {
            if(entry.getValue() > 1 ) {
                System.out.println(entry.getKey());
            }
        }
    }
}
