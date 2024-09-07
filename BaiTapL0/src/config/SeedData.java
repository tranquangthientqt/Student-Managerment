package config;

import manager.StudentManager;
import model.Student; // Import the Student model
import java.time.LocalDate;
public class SeedData {
    private final StudentManager studentManager;

    public SeedData(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public void run() {
        System.out.println("Seed data");

        // Create fake student data
        Student student1 = new Student("John Doe", LocalDate.of(2000, 1, 1), "Address1", 110.0, 60.0, "student001", "University1", 2020, 7.2);
        Student student2 = new Student("Forester", LocalDate.now(), "Address1", 170.0, 60.0, "student002", "University2", 2021, 3.5);
        Student student3 = new Student("Wayne", LocalDate.now(), "Address1", 170.0, 60.0, "student003", "University3", 2022, 5.2);
        Student student4 = new Student("John Doe", LocalDate.of(2000, 1, 1), "Address1", 110.0, 60.0, "student001", "University1", 2020, 6.4);
        Student student5 = new Student("Kim", LocalDate.now(), "Address7", 170.0, 60.0, "student002", "University2", 2021, 8.7);
        Student student6 = new Student("Dogg", LocalDate.now(), "Address8", 170.0, 60.0, "student003", "University3", 2022, 2.6);

        // Add students to the manager
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);
        studentManager.addStudent(student4);
        studentManager.addStudent(student5);
        studentManager.addStudent(student6);
        System.out.println("Fake data added");
    }
}
