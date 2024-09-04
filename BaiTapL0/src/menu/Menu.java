package menu;

import utils.Validator;

import java.util.ArrayList;

public class Menu { 
   
    private ArrayList<String> options = new ArrayList<>();
    private String menuTitle;

    public Menu(){
        this.menuTitle = "Student Management";
        initializeMenu(); // Gọi phương thức để thêm các tùy chọn vào menu
    }

    public void addOption(String option){
        options.add(option);
    }

    public void initializeMenu(){
        addOption("1. Add student");
        addOption("2. Update student");
        addOption("3. Delete student");
        addOption("4. Search student");
        addOption("5. Show student");
        addOption("6. Sort student by gpa");
        addOption("7. Exit");
    }

    public void showMenu() {
        if (options.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\n=============================================");
        System.out.println("Welcome to " + menuTitle);
        for (String x : options)
            System.out.println(x); 
    }
    
    public int getChoice(){
        int maxOption = options.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "Invalid choice. Please enter a valid number (" + 1 + " - " + maxOption + "): ";
        int choice = Validator.getNumber(inputMsg, errorMsg, 1, maxOption);
        return choice;
    }
}
