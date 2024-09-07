import manager.StudentManager;
import menu.Menu;
import config.SeedData;

public class Application {
    private static Menu menu = new Menu("Student Management");
    private static StudentManager studentManager = new StudentManager();
    private static SeedData seedData = new SeedData(studentManager);
    
    public static void initializeMenu(){
        menu.addOption("1. Add new student");
        menu.addOption("2. Search student by id");
        menu.addOption("3. Update student");
        menu.addOption("4. Remove student");
        menu.addOption("5. Show list student");
        menu.addOption("6. Sort student by gpa");
        menu.addOption("7. Exit");
    }

    public static void run(Class<?> mainClass) {
        seedData.run();
        initializeMenu();
        runMenu();
    }
    private static void runMenu(){
        int choice = -1; // Initialize choice to an invalid value
        do {
            menu.showMenu(); // Gọi phương thức showMenu thay vì menu.showMenu
            try {
                choice = menu.getChoice(); // Read input as a string and parse to integer
                switch (choice) {
                    case 1:
                        studentManager.addStudent();
                        break;
                    case 2:
                        studentManager.searchStudentById();
                        break;
                    case 3:
                        studentManager.updateStudent();
                        break;
                    case 4:
                        studentManager.removeStudent();
                        break;
                    case 5:
                        studentManager.showStudents();
                        break;
                    case 6:
                        studentManager.sortStudentsByGpa();
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
