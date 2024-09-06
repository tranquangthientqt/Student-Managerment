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
        Student student1 = new Student("Student123", LocalDate.now(), "Address1", 170.0, 60.0, "student001", "University1", 2020, 8.0);
        Student student2 = new Student("Student123", LocalDate.now(), "Address1", 170.0, 60.0, "student002", "University2", 2021, 7.0);
        Student student3 = new Student("Student123", LocalDate.now(), "Address1", 170.0, 60.0, "student003", "University3", 2022, 6.0);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        // int pos;
        // String studentId;
        // try {
        //     do {
        //         studentId = Validator.getStudentId("Enter student ID (10 characters): ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
        //         pos = searchStudentById(studentId);
        //         if (pos != -1) {
        //             System.out.println("Student ID already exists.");
        //         }
        //     } while (pos != -1);
        //     String university = Validator.getString("Enter university name: ", "University name must be less than 200 characters", 0, Valid.MAX_SCHOOL_NAME_LENGTH.getValue());
        //     int yearOfEntry = Validator.getNumber("Enter year of entry: ", "Year of entry must be between 1900 and " + LocalDate.now().getYear(), Valid.START_YEAR.getValue(), LocalDate.now().getYear());
        //     double gpa = Validator.getNumber("Enter student GPA: ", "GPA must be between 0.0 and 10.0", Valid.MIN_GPA.getValue(), Valid.MAX_GPA.getValue());
        //     String name = Validator.getString("Enter student name: ", "Student name must be less than 100 characters", 0, Valid.MAX_NAME_LENGTH.getValue());
        //     LocalDate dob = Validator.getDate("Enter student date of birth: ", "Invalid date. Please enter a valid date.");
        //     String address = Validator.getString("Enter student address: ", "Student address must be less than 300 characters", 0, Valid.MAX_ADDRESS_LENGTH.getValue());
        //     double height = Validator.getNumber("Enter student height: ", "Height must be between 50.0 and 300.0", Valid.MIN_HEIGHT.getValue(), Valid.MAX_HEIGHT.getValue());
        //     double weight = Validator.getNumber("Enter student weight: ", "Weight must be between 5.0 and 1000.0", Valid.MIN_WEIGHT.getValue(), Valid.MAX_WEIGHT.getValue());

        //     Student student = new Student(name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
        //     students.add(student);
        //     System.out.println("Student added successfully. Here is the student information:");
        //     System.out.println(Validator.header());
        //     student.showInfo();
        // } catch (Exception e) {
        //     System.out.println("An unexpected error occurred. Please try again.");
        // }
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

    public void removeStudent() {
        int pos;
        do {
            String studentId = Validator.getStudentId("Enter student ID to delete: ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
            pos = searchStudentById(studentId);
            if (pos == -1) {
                System.out.println("Not found student with id " + studentId + " in the list. Please try again.");
            } else {
                Student x;
                x = students.get(pos);
                x.showInfo();
                String confirm = Validator.getString("Are you sure you want to delete this student? (Y/N): ", "Invalid input. Please enter Y or N.");
                if (confirm.equalsIgnoreCase("Y")) {
                    students.remove(pos);
                    System.out.println("Student deleted successfully.");
                } else {
                    return;
                }
            }
        } while (pos == -1);
    }

    public void searchStudentById() {
        String studentId = Validator.getStudentId("Enter student ID to search: ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
        Student x = searchStudentObjectById(studentId);
        if (x != null) {
            System.out.println("Here is the Student "
                    + "that you want to search");
            System.out.println(Validator.header());
            x.showInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudentObjectById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    private int searchStudentById(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equalsIgnoreCase(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println(Validator.header());
        for (Student student : students) {
            student.showInfo();
        }
    }

    public void sortStudentsByGpa() {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Students sorted by GPA.");
    }
}
