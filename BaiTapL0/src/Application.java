import manager.StudentManager;
import menu.Menu;

public class Application {
    private static Menu menu = new Menu();
    private static StudentManager studentManager = new StudentManager();
    
    public static void run(Class<?> mainClass) {
        mainClass.getClassLoader();
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
