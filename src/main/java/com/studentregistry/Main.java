package com.studentregistry;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentRepository<Student> repository =
                new StudentRepository<>();

        StudentService service =
                new StudentService(repository);

        boolean running = true;

        while (running) {

            printMenu();

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    addStudent(scanner, service);
                    break;

                case "2":
                    service.listStudents();
                    break;

                case "3":
                    searchStudent(scanner, service);
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1-4."
                    );
            }
        }

        scanner.close();
    }

        private static void printMenu() {

        System.out.println();
        System.out.println("===== STUDENT REGISTRY =====");
        System.out.println("1. Add Student");
        System.out.println("2. List All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Quit");
        System.out.print("Choose an option: ");
    }

        private static void addStudent(
            Scanner scanner,
            StudentService service) {

        try {

            int id = readInt(
                    scanner,
                    "Enter student ID: "
            );

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            double gpa = readDouble(
                    scanner,
                    "Enter GPA: "
            );

            System.out.println();
            System.out.println("Student Type:");
            System.out.println("1. Undergraduate");
            System.out.println("2. Postgraduate");

            int studentType = readInt(
                    scanner,
                    "Choose student type: "
            );

            service.addStudent(
                    id,
                    name,
                    gpa,
                    studentType
            );

            System.out.println(
                    "Student added successfully."
            );

        } catch (InvalidStudentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

        private static void searchStudent(
            Scanner scanner,
            StudentService service) {

        int id = readInt(
                scanner,
                "Enter student ID: "
        );

        service.searchById(id);
    }

        private static int readInt(
            Scanner scanner,
            String prompt) {

        while (true) {

            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: Please enter a valid whole number."
                );
            }
        }
    }

    
        private static double readDouble(
            Scanner scanner,
            String prompt) {

        while (true) {

            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: Please enter a valid number."
                );
            }
        }
    }
}