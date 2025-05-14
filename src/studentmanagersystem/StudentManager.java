/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagersystem;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG6112 GR01
 */
public class StudentManager
{
    //---------Variable Declarations----------//
    public Student[] studData;
   // Colours c = new Colours();
    Scanner s = new Scanner(System.in);   
    //Question1 W = new Question1();
    int studAge;
    int i;
    int numStudents;
    String studID;
    String studName;
    String studEmail;
    String studCourse;
    //--------------------------------------------------------------------------------//
    //DEFAULT CONSTRUCTOR
    public StudentManager()
    {        
    }
    
     protected boolean studentAge() 
     { 
        if (studAge < 16) {
            System.out.println(Colours.RED + "Age must be 16 or older. Please try again.");
            return false;
        } else {
            return true;
        }
    }
    public void stud() 
    {
        //JOptionPane.showMessageDialog(null, "Description too long, Please enter again" + DESCRIP_LENGTH + " characters.", "Tasks", JOptionPane.ERROR_MESSAGE);
       // System.out.println("How many students would you like to create?");
        numStudents =  Integer.parseInt(JOptionPane.showInputDialog(null, "How many students would you like to create?"));
        newStudent();
    }
    //---------------------------------------------------------------------------------------------------//
    //Capture a new students or students
    public void newStudent() 
    {
    studData = new Student[numStudents];  // Initialize the array with the specified number of students
    i = 0;

    while (i < numStudents) 
    {
        System.out.println("                        CAPTURE STUDENT " + (i + 1));
        System.out.println("*******************************************************************");
//Had to use Joptionpane to enter the students ID 
//Because the console would not allow me to enter the student ID in console
//It blocked me from entering the first ID, but could enter the others
//The debug statements make sure that the input given has been received
        
        //System.out.print("Enter student ID >> "); 
        //studID = s.nextLine();  // Read the student ID
        studID = JOptionPane.showInputDialog(null, "Enter Sudent ID", "Capturing student", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("ID Entered: " + studID); // Debug statement

        System.out.print("Enter Student's Name >> ");
        studName = s.nextLine();  // Read the student's name
        System.out.println("Name Entered: " + studName); // Debug statement

        boolean validAge = false;
        while (!validAge) 
        {
            System.out.print("Please enter student age >> ");
            try {
                studAge = s.nextInt();  // Read the student's age
                s.nextLine();  // Consume the newline character left over from nextInt()
                validAge = studentAge();  // Validate the student's age
            } catch (InputMismatchException e) {
                System.out.println(Colours.RED + "Your Age is incorrect! Please enter a valid number.");
                s.next();  // Clear the invalid input
            }
        }

        System.out.print("Enter Student email >> ");
        studEmail = s.nextLine();  // Read the student's email
        System.out.println("Email Entered: " + studEmail); // Debug statement

        System.out.print("Enter course enrolled in >> ");
        studCourse = s.nextLine();  // Read the student's course
        System.out.println("Course Entered: " + studCourse); // Debug statement

        // Creating the student and storing it in the array
        studData[i] = new Student(studID, studName, studAge, studCourse, studEmail);
        i++;  // Move to the next student
    }
}
    //-----------------------------------------------------------------------------------------------------//
    //Print all the students
    // Using StringBuilder for the ease of use and makes code easier to edit and read
    public void studentReport() 
    {
        int studentNo = 0;

        for (Student student : studData)
        {
            if (student != null) // If student is not null
            {
                studentNo++;// Increment studentNo
            }
        }

        StringBuilder output = new StringBuilder("Number of students: ").append(studentNo).append("\n\n");

        for (int j = 0; j < numStudents; j++)
        {
            if (studData[j] != null)  // Check if the array element is not null
            {
                output.append("Student ").append(j + 1).append(" Details: \n");
                output.append("---------------------------------------------------------").append("\n");
                output.append("Student ID:     ").append(studData[j].getID()).append("\n");
                output.append("Student Name:   ").append(studData[j].getName()).append("\n");
                output.append("Student Age:    ").append(studData[j].getAge()).append("\n");
                output.append("Student Email:  ").append(studData[j].getEmail()).append("\n");
                output.append("Student Course: ").append(studData[j].getCourse()).append("\n\n");
                output.append("---------------------------------------------------------").append("\n");
            } 
            /*else 
            {
                output.append("Student ").append(j + 1).append(" is null\n");
            }*/
        }
        System.out.println(Colours.GREEN_BOLD + output.toString());
    }

    //-----------------------------------------------------------------------------------------------------//
    //Search for the student
    //Searches for student using the student ID
     public void searchStudent()
     {
        System.out.println("What student are you looking for?");
        System.out.print("Enter student ID >> ");
        String searchID = s.nextLine();
        System.out.println("-------------------------------------------");

        if (searchID == null || searchID.isEmpty()) 
        {
            System.out.println(Colours.RED + "There is no student with this ID");
            return;
        }

        StringBuilder output = new StringBuilder();
        boolean found = false;
        for (Student student : studData) 
        {
            if (student != null && student.getID().equals(searchID))
            {
                output.append("Student ID:     ").append(student.getID()).append("\n");
                output.append("Student Name:   ").append(student.getName()).append("\n");
                output.append("Student Age:    ").append(student.getAge()).append("\n");
                output.append("Student Email:  ").append(student.getEmail()).append("\n");
                output.append("Student Course: ").append(student.getCourse()).append("\n\n");
                found = true;
                break; // Exit loop once the student is found
            }
        }
        if (!found) {
            output.append("No student found with the given ID.\n");
            System.out.println("-------------------------------------------");
        }

        System.out.println(Colours.GREEN_BOLD + output.toString());
         System.out.println("-------------------------------------------");
    }

    //------------------------------------------------------------------------------------------------------//
    //Delete the student ID
    public void deleteStudent()
    {
        System.out.println("Enter the student ID that you would like to delete >> ");
        String deleteID = s.nextLine();
        System.out.println("-------------------------------------------");
        boolean delete = false;
        
        for (int j = 0; j < studData.length; j++)
        {
            if (studData[j] != null && studData[j].getID().equals(deleteID))
            {
                studData[j] = null; // Wipes all the information for the specific student
                delete = true;
                System.out.println("Student " + deleteID + " has been deleted");
                System.out.println("-------------------------------------------");
                break;
            }
        }
        if (!delete)
        {
            System.out.println(Colours.RED + "No student has been found with the ID " + deleteID);
        }
        
    }
    
}
//-----------------------------------oooooooooooooooooDDDDDDDDD END OF FILE oooooooooooooooooDDDDDDDDD-----------------------------------------------------//
