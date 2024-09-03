package menu;

import java.util.Scanner;
import manager.StudentManager;

public class Menu { 
    private static StudentManager studentManager = new StudentManager();
    public static void showMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Add student");
        System.out.println("2. Update student");
        System.out.println("3. Delete student");
        System.out.println("4. Search student");
        System.out.println("5. Show student");
        System.out.println("6. Sort student by gpa");
        System.out.println("7. Exit");
        System.out.println("==========================");
        System.out.print("Enter your choice: ");
    }

    public static void run(Scanner sc) {
        int choice = -1; // Initialize choice to an invalid value
        do {
            showMenu();
            try {
                choice = Integer.parseInt(sc.nextLine()); // Read input as a string and parse to integer
                switch (choice) {
                    case 1:
                        studentManager.addStudent(sc);
                        break;
                    case 5:
                        studentManager.showStudents();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (choice != 7);
    }
}
