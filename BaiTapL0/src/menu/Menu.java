package menu;

import utils.Validator;

import java.util.ArrayList;

public class Menu { 
   
    private ArrayList<String> options = new ArrayList<>();
    private String menuTitle;

    public Menu(String menuTitle){
        this.menuTitle = menuTitle;
    }

    public void addOption(String option){
        options.add(option);
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
