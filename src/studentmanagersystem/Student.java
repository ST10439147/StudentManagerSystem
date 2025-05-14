/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagersystem;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG6112 GR01
 */
public class Student
{
    //--------------------------DECLARATION--------------------------------//
    private String studName;
    private int studAge;
    private String studID;
    private String studCourse;
    private String studEmail;
    Menu M = new Menu();
    
    
    //-----------------CONSTRUCTOR---------------------------------------------//
    public Student(String studID, String studName, int studAge,  String studCourse, String studEmail)
    {
        this.studName = studName;
        this.studAge = studAge;
        this.studID = studID;
        this.studCourse = studCourse;
        this.studEmail = studEmail;
    }
    //---------------------------------------------------------------------------------------------//
    public String getName()
    {
        return studName;
    }
    //---------------------------------------------------------------------------------------------//
    public int getAge()
    {
        return studAge;
    }
    //---------------------------------------------------------------------------------------------//
    public String getID()
    {
        return studID;
    }
    //---------------------------------------------------------------------------------------------//
    public String getCourse()
    {
        return studCourse;
    }
    //---------------------------------------------------------------------------------------------//
    public String getEmail()
    {
        return studEmail;
    }
}
//-----------------------------------oooooooooooooooooDDDDDDDDD END OF FILE oooooooooooooooooDDDDDDDDD-----------------------------------------------------//

