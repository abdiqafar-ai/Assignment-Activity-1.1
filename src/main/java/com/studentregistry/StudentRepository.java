package com.studentregistry;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository<T extends Student> {

    private final List<T> students = new ArrayList<>();

    public void add(T student) {
        students.add(student);
    }

    public List<T> findAll() {
        return new ArrayList<>(students);
    }
}