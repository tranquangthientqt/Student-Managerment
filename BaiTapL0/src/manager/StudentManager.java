package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Student;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Scanner sc) {
        System.out.println("==========================");
        System.out.println("Enter student information:");
        try {
            String studentId = getInput(sc, "Enter student ID: ");
            sc.nextLine();
            String university = getInput(sc, "Enter university name: ");
            int yearOfEntry = getInput(sc, "Enter student year of entry: ", Integer.class);
            double gpa = getInput(sc, "Enter student GPA: ", Double.class);
            String name = getInput(sc, "Enter student name: ");
            String dob = getInput(sc, "Enter student date of birth: ");
            String address = getInput(sc, "Enter student address: ");
            double height = getInput(sc, "Enter student height: ", Double.class);
            double weight = getInput(sc, "Enter student weight: ", Double.class);

            Student student = new Student(name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
            students.add(student);
            student.showInfo();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again.");
        }
    }

    private String getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private <T> T getInput(Scanner sc, String prompt, Class<T> type) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine();
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(input));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(input));
                } else {
                    throw new IllegalArgumentException("Unsupported type");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid " + type.getSimpleName().toLowerCase() + ".");
            } 
        }
    }

    // public void updateStudent() {
    //     System.out.print("Enter student ID to update: ");
    //     int id = scanner.nextInt();
    //     if (id >= 0 && id < students.size()) {
    //         System.out.print("Enter new name: ");
    //         String name = scanner.next();
    //         System.out.print("Enter new GPA: ");
    //         double gpa = scanner.nextDouble();
    //         students.get(id).setName(name);
    //         students.get(id).setGpa(gpa);
    //         System.out.println("Student updated successfully.");
    //     } else {
    //         System.out.println("Student not found.");
    //     }
    // }

    // public void deleteStudent() {
    //     System.out.print("Enter student ID to delete: ");
    //     int id = scanner.nextInt();
    //     if (id >= 0 && id < students.size()) {
    //         students.remove(id);
    //         System.out.println("Student deleted successfully.");
    //     } else {
    //         System.out.println("Student not found.");
    //     }
    // }

    // public void searchStudent() {
    //     System.out.print("Enter student name to search: ");
    //     String name = scanner.next();
    //     for (Student student : students) {
    //         if (student.getName().equalsIgnoreCase(name)) {
    //             System.out.println(student);
    //             return;
    //         }
    //     }
    //     System.out.println("Student not found.");
    // }

    public void showStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentsByGpa() {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Students sorted by GPA.");
    }
}
