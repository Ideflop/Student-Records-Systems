import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
public abstract class AcademicInformation 
{
    private String File_PathStudent = "C:\\Users\\UGO\\Documents\\UNI courses year 2\\CS4013\\student.csv";
    private String File_PathTeachers = "C:\\Users\\UGO\\Documents\\UNI courses year 2\\CS4013\\teacher.csv";
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int idNumber;
    private String collegeLevel;
    public AcademicInformation(String name,int idNumber,String collegeLevel,String phoneNumber,String email,String address )
    {
        this.name = name;
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        writeToCsvStudents();
    }
    public void writeToCsvStudents() {
    try {
        File csvFile = new File(File_PathStudent);
        FileWriter csvWriter = new FileWriter(File_PathStudent, true);
        Scanner fileReader = new Scanner(csvFile);
        boolean studentCheck = false;
        if(fileReader.hasNextLine()){
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(",");
            int idNumberCheck = Integer.parseInt(parts[1].trim());
            String nameCheck = parts[0].trim().toUpperCase();
            if (idNumber == idNumberCheck && name.toUpperCase().trim().equals(nameCheck)) {
                studentCheck = true;
                System.out.println("Student already exists in the system.");
                break;
            }
        }
        }
        if (!studentCheck) {
            csvWriter.write(name + "," + idNumber + "," + collegeLevel + "," +
                    phoneNumber + "," + email + "," + address + "\n");
            System.out.println("Student successfully added to the system.");
        }
        fileReader.close();
        csvWriter.close();
    } catch (IOException e) {
        System.out.println("File not found.");
    }
    }
    
}
