import java.util.Scanner;

import menu.Menu;

public class Application {

    public static void run(Class<?> mainClass) {
        mainClass.getClassLoader();
        Menu.run(new Scanner(System.in));
    }

}
