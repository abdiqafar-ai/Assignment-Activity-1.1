# Student Registry

A Java console-based Student Registry application developed using core Java and Object-Oriented Programming concepts.

The application allows users to add students, view registered students, search for students by ID, and safely handle invalid input without crashing.

## Features

* Add students
* List all students
* Search students by ID
* Undergraduate and postgraduate student types
* Input validation
* Exception handling
* Generic repository
* Java Collections
* Java Streams
* Inheritance
* Method overriding
* Encapsulation
* Polymorphism
* Menu-driven console interface
* Safe handling of invalid numeric input

## Technologies

* Java 21
* Maven
* Git
* GitHub

## Project Structure

```text
student-registry/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── studentregistry/
    │               ├── Main.java
    │               ├── Student.java
    │               ├── PostgraduateStudent.java
    │               ├── StudentRepository.java
    │               ├── StudentService.java
    │               └── InvalidStudentException.java
    │
    └── test/
        └── java/
```

## Application Architecture

The application separates responsibilities between different classes.

### `Main`

Responsible for:

* Starting the application
* Displaying the menu
* Reading user input
* Handling the main program loop
* Using `switch` to select operations

### `Student`

Represents a student in the system.

It contains:

* Student ID
* Student name
* GPA
* Getters
* Constructor
* Student type method
* `toString()` method

### `PostgraduateStudent`

A subclass of `Student` that demonstrates inheritance.

It overrides:

```java
getStudentType()
```

to return:

```text
Postgraduate
```

### `StudentRepository`

Provides generic storage for students.

The repository uses:

```java
StudentRepository<T extends Student>
```

and stores students using:

```java
List<T>
```

### `StudentService`

Contains the application's business logic.

It is responsible for:

* Validating student information
* Adding students
* Listing students
* Searching students
* Creating undergraduate and postgraduate students

### `InvalidStudentException`

A custom checked exception used when student information is invalid.

Examples include:

* Blank student name
* GPA below `0.0`
* GPA above `4.0`
* Invalid student type

## Object-Oriented Programming Concepts

### Encapsulation

Student fields are declared as private:

```java
private int id;
private String name;
private double gpa;
```

They are accessed through public getter methods.

### Inheritance

`PostgraduateStudent` extends `Student`:

```java
public class PostgraduateStudent extends Student
```

This allows the postgraduate student to inherit the properties and methods of `Student`.

### Method Overriding

`PostgraduateStudent` overrides the `getStudentType()` method:

```java
@Override
public String getStudentType() {
    return "Postgraduate";
}
```

### Polymorphism

The repository is declared as:

```java
StudentRepository<Student>
```

This allows it to store both normal `Student` objects and `PostgraduateStudent` objects.

When `toString()` calls:

```java
getStudentType()
```

Java uses the overridden method of the actual object.

## Collections and Generics

The application uses the Java Collections Framework.

The repository stores students using:

```java
List<T>
```

with:

```java
ArrayList<T>
```

The repository is generic:

```java
public class StudentRepository<T extends Student>
```

The bounded type parameter ensures that the repository can only store `Student` objects or subclasses of `Student`.

## Java Streams

Java Streams are used for listing and searching students.

### Listing students

```java
repository.findAll()
        .stream()
        .forEach(System.out::println);
```

### Searching by ID

```java
repository.findAll()
        .stream()
        .filter(student -> student.getId() == id)
        .findFirst();
```

The search operation uses:

* `stream()`
* `filter()`
* `findFirst()`
* `ifPresentOrElse()`

## Exception Handling

The application is designed to reject invalid input without crashing.

A custom exception is used for invalid student information:

```java
InvalidStudentException
```

For example, a GPA outside the allowed range:

```text
Enter GPA: 5.0
Error: GPA must be between 0.0 and 4.0.
```

Blank names are also rejected:

```text
Enter student name:
Error: Student name cannot be blank.
```

Invalid numeric input is handled using `NumberFormatException`.

For example:

```text
Enter student ID: abc
Error: Please enter a valid whole number.
```

The program continues running and returns to the appropriate input or menu instead of terminating.

## Application Menu

When the application starts, the following menu is displayed:

```text
===== STUDENT REGISTRY =====
1. Add Student
2. List All Students
3. Search Student by ID
4. Quit
Choose an option:
```

## Example Usage

### Adding an Undergraduate Student

```text
Choose an option: 1

Enter student ID: 101
Enter student name: Abdiqafar
Enter GPA: 3.6

Student Type:
1. Undergraduate
2. Postgraduate

Choose student type: 1

Student added successfully.
```

### Adding a Postgraduate Student

```text
Choose an option: 1

Enter student ID: 102
Enter student name: Ahmed
Enter GPA: 3.8

Student Type:
1. Undergraduate
2. Postgraduate

Choose student type: 2

Student added successfully.
```

### Listing Students

```text
Choose an option: 2

ID: 101, Name: Abdiqafar, GPA: 3.6, Type: Undergraduate
ID: 102, Name: Ahmed, GPA: 3.8, Type: Postgraduate
```

### Searching by ID

```text
Choose an option: 3

Enter student ID: 102

ID: 102, Name: Ahmed, GPA: 3.8, Type: Postgraduate
```

If the student does not exist:

```text
Student not found.
```

## Input Validation Example

The application rejects an invalid GPA:

```text
Enter GPA: 5.0

Error: GPA must be between 0.0 and 4.0.
```

The application also rejects a blank name:

```text
Enter student name:

Error: Student name cannot be blank.
```

The program remains running instead of crashing.

## How to Run

### Prerequisites

Make sure the following are installed:

* Java 21
* Maven
* Git

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

### Clone the Repository

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
```

Navigate into the project:

```bash
cd student-registry
```

### Compile the Project

```bash
mvn clean compile
```

### Run the Application

```bash
java -cp target/classes com.studentregistry.Main
```

## Build Verification

The project should compile successfully with:

```bash
mvn clean compile
```

Expected result:

```text
BUILD SUCCESS
```

## Git Workflow

The project is version-controlled using Git.

Example commands:

```bash
git status
git add .
git commit -m "feat: implement student registry console application"
git push
```

## Learning Objectives

This project demonstrates practical understanding of:

* Java syntax and program structure
* Classes and objects
* Constructors
* Encapsulation
* Inheritance
* Method overriding
* Polymorphism
* Collections
* Generics
* Streams
* Exception handling
* Input validation
* Control flow
* Loops
* `switch` statements
* Maven project management
* Git version control
* GitHub repository management

## Assignment

**Assignment 1 — Student Registry**

This project was developed as a console-based Java Student Registry application to demonstrate core Java and Object-Oriented Programming concepts, including collections, generics, streams, inheritance, exception handling, and safe user input.

## Author

**Abdiqafar**

Student Registry — Java Console Application
