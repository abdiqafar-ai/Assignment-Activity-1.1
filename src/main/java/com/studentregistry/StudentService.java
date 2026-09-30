package com.studentregistry;

public class StudentService {

    private final StudentRepository<Student> repository;

    public StudentService(StudentRepository<Student> repository) {
        this.repository = repository;
    }

    public void addStudent(int id, String name, double gpa, int studentType)
            throws InvalidStudentException {

        validateStudent(name, gpa);

        if (studentType == 1) {
            repository.add(new Student(id, name.trim(), gpa));
        } else if (studentType == 2) {
            repository.add(new PostgraduateStudent(id, name.trim(), gpa));
        } else {
            throw new InvalidStudentException(
                    "Student type must be 1 or 2."
            );
        }
    }

    private void validateStudent(String name, double gpa)
            throws InvalidStudentException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentException(
                    "Student name cannot be blank."
            );
        }

        if (gpa < 0.0 || gpa > 4.0) {
            throw new InvalidStudentException(
                    "GPA must be between 0.0 and 4.0."
            );
        }
    }

    public void listStudents() {

        if (repository.findAll().isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        repository.findAll()
                .stream()
                .forEach(System.out::println);
    }

    public void searchById(int id) {

        repository.findAll()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Student not found.")
                );
    }
}
