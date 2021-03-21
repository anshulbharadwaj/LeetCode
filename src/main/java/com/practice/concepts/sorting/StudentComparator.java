package com.practice.concepts.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparator {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // using Lambda to sort
        Collections.sort(populateStudent(), (o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getMarks() - o2.getMarks();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // Sort according to Name
        Collections.sort(populateStudent(), Comparator.comparing(Student::getName));

        // Sort by Name then by Marks
        Collections.sort(populateStudent(),
                Comparator.comparing(Student::getName)
                        .thenComparing(Student::getMarks));

        // Reverse the defined sorting order
        Collections.sort(populateStudent(),
                Comparator.comparing(Student::getName)
                        .thenComparing(Student::getMarks).reversed());

        students.forEach(System.out::println);
    }

    private static List<Student> populateStudent() {
        students.add(new Student("Ram", 23));
        students.add(new Student("Shaym", 35));
        students.add(new Student("Aman", 83));
        students.add(new Student("Rohit", 13));
        students.add(new Student("Anuj", 65));
        return students;
    }
}

