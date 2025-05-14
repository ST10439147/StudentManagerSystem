/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagersystem;

import java.util.Scanner;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG6112 GR01
 */
public class Menu
{
     private Scanner scan = new Scanner(System.in);
    private int num = 0;
    private String key;
    private StudentManager stud = new StudentManager();

    public Menu() {
    }

    //---------------------------------------------------------------------------------------------------//
    public void firstStep() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("******************************************");

        do {
            System.out.println("Enter (1) to launch menu or any other key to exit");
            key = scan.nextLine();
            if (!key.equals("1")) {
                System.out.println("Have a nice day");
                break;
            } else {
                displayMenu();
            }
        } while (key.equals("1"));

        scan.close();
    }

    //---------------------------------------------------------------------------------------------------//
    public void Menu() {
        System.out.println("Please select an option from the menu:");
        System.out.println("(1) Capture a new student");
        System.out.println("(2) Search for a student");
        System.out.println("(3) Delete a student");
        System.out.println("(4) Print student report");
        System.out.println("(5) Exit application");
    }

    //---------------------------------------------------------------------------------------------------//
    public void displayMenu() {
    boolean exit = false;

    while (!exit) { // Keep looping until the user chooses to exit
        Menu(); // Display the menu options

        try {
            num = Integer.parseInt(scan.nextLine());
            if (num >= 1 && num <= 5) {
                handleMenuSelection(num);
                if (num == 5) {
                    exit = true; // Exit the loop when option 5 is selected
                }
            } else {
                System.out.println(Colours.RED + "Invalid selection. Please choose a number between 1 and 5.");
            }
        } catch (NumberFormatException e) {
            System.out.println(Colours.RED + "Invalid input. Please enter a valid number.");
        }
    }
}

    //---------------------------------------------------------------------------------------------------//
    private void handleMenuSelection(int option) {
        switch (option) {
            case 1:
                stud.stud();
                break;
            case 2:
                stud.searchStudent();
                break;
            case 3:
                stud.deleteStudent();
                break;
            case 4:
                stud.studentReport();
                break;
            case 5:
                System.out.println(Colours.GREEN + "Have a nice day");
                break;
            default:
                System.out.println(Colours.RED + "Invalid Input");
                displayMenu();
                break;
        }
    }

}
//-----------------------------------oooooooooooooooooDDDDDDDDD END OF FILE oooooooooooooooooDDDDDDDDD-----------------------------------------------------//