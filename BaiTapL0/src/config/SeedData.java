package config;

import manager.StudentManager;
import model.Student; // Import the Student model
import java.time.LocalDate;
import java.util.Random;

public class SeedData {
    private final StudentManager studentManager;

    public SeedData(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public void generateRandomStudents(int numStudents) {
        Random random = new Random();

        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        String[] addresses = {"123 Main St", "456 Elm St", "789 Oak St", "321 Pine St", "654 Cedar St"};
        String[] universities = {"Stanford University", "Harvard University", "MIT", "Caltech", "Princeton University"};

        for (int i = 0; i < numStudents; i++) {
            String name = names[random.nextInt(names.length)];
            LocalDate dob = LocalDate.now().minusYears(18 + random.nextInt(5)); // Age between 18 and 22
            String address = addresses[random.nextInt(addresses.length)];
            double height = 150 + random.nextDouble() * 30; // Height between 150cm and 180cm
            double weight = 50 + random.nextDouble() * 30; // Weight between 50kg and 80kg
            String studentId = String.format("student%03d", i + 1);
            String university = universities[random.nextInt(universities.length)];
            int yearOfEntry = LocalDate.now().getYear() - random.nextInt(4); // Year of entry within the last 4 years
            double gpa = random.nextDouble() * 10; // GPA between 2.0 and 4.0

            studentManager.addStudent(new Student(name, dob, address, height, weight, studentId, university, yearOfEntry, gpa));
        }
    }
}
