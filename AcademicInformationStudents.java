import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
/**
 * Write a description of class AcademicInformationStudents here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AcademicInformationStudents extends AcademicInformation
{
    public AcademicInformationStudents(String name,int idNumber,String collegeLevel,String phoneNumber,String email,String address){
        super(name,idNumber,collegeLevel,phoneNumber,email,address);
    }
}