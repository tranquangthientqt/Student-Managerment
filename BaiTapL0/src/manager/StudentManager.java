package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.Valid;

import java.time.LocalDate;
import model.Student;
import utils.Validator;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        int pos;
        String studentId;
        try {
            do {
                studentId = Validator.getStudentId("Enter student ID (10 characters): ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^(?!.*(.).*\\1)STUDENT\\d{3}$");
                pos = searchStudentById(studentId);
                if (pos != -1) {
                    System.out.println("Student ID already exists.");
                }
            } while (pos != -1);

            sc.nextLine();
            String university = Validator.getString("Enter university name: ", "University name must be less than 200 characters", 0, Valid.MAX_SCHOOL_NAME_LENGTH.getValue());
            int yearOfEntry = Validator.getNumber("Enter year of entry: ", "Year of entry must be between 1900 and " + LocalDate.now().getYear(), Valid.START_YEAR.getValue(), LocalDate.now().getYear());
            double gpa = Validator.getNumber("Enter student GPA: ", "GPA must be between 0.0 and 10.0", Valid.MIN_GPA.getValue(), Valid.MAX_GPA.getValue());
            String name = Validator.getString("Enter student name", "Student name must be less than 100 characters", 0, Valid.MAX_NAME_LENGTH.getValue());
            LocalDate dob = Validator.getDate("Enter student date of birth: ", "Invalid date. Please enter a valid date.");
            String address = Validator.getString("Enter student address: ", "Student address must be less than 300 characters", 0, Valid.MAX_ADDRESS_LENGTH.getValue());
            double height = Validator.getNumber("Enter student height: ", "Height must be between 50.0 and 300.0", Valid.MIN_HEIGHT.getValue(), Valid.MAX_HEIGHT.getValue());
            double weight = Validator.getNumber("Enter student weight: ", "Weight must be between 5.0 and 1000.0", Valid.MIN_WEIGHT.getValue(), Valid.MAX_WEIGHT.getValue());

            Student student = new Student(name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
            students.add(student);
            student.showInfo();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again.");
        }
    }

    // private String getInput(Scanner sc, String prompt) {
    //     System.out.print(prompt);
    //     return sc.nextLine();
    // }

    // private <T> T getInput(Scanner sc, String prompt, Class<T> type) {
    //     while (true) {
    //         try {
    //             System.out.print(prompt);
    //             String input = sc.nextLine();
    //             if (type == Integer.class) {
    //                 return type.cast(Integer.parseInt(input));
    //             } else if (type == Double.class) {
    //                 return type.cast(Double.parseDouble(input));
    //             } else {
    //                 throw new IllegalArgumentException("Unsupported type");
    //             }
    //         } catch (NumberFormatException e) {
    //             System.out.println("Invalid input. Please enter a valid " + type.getSimpleName().toLowerCase() + ".");
    //         } 
    //     }
    // }

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

    private int searchStudentById(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentsByGpa() {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Students sorted by GPA.");
    }
}
