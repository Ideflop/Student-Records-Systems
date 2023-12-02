/**
 * Write a description of class AcademicInformationStudents here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AcademicInformationStudent extends AcademicInformation {

    private static final String FILE = "student.csv";
    private String program;

    public AcademicInformationStudent(Student student) {
        super(student.getName(), student.getIdNumber(), student.getcollegeLevel(), student.getPhoneNumber(), student.getEmail(), student.getAddress());
        this.program = student.getProgram();
    }

    public AcademicInformationStudent(int idNumber, Student student) {
        super(idNumber);
    }


    @Override
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getIdNumber()) ) {
            int result = CSVFileManager.addLineToCSVFile(FILE, this.getIdNumber() + "," + this.getName() + "," + this.getCollegeLevel() + "," + this.getPhoneNumber() + "," + this.getEmail() + "," + this.getAddress() + "," + this.program);
            if (result == 0) {
                System.out.println("Student with ID Number " + this.getIdNumber() + " successfully added.");
            } else {
                System.out.println("Student with ID Number " + this.getIdNumber() + " was not added.");
            }
        } else {
            System.out.println("Student with ID Number " + this.getIdNumber()+ " already exists.");
        }
    }

    @Override
    public String[] getFromCsvFile(int idNumber) {
        String studentInfo = CSVFileManager.getLineFromCSVFile(FILE, idNumber);
        if (studentInfo == null) {
            System.out.println("Student with ID Number " + idNumber + " does not exist.");
            return new String[0];
        } else {
            return studentInfo.split(",");
        }
    }


    public static boolean checkIfStudentExistsInCSVFile(int idNumber) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, idNumber);
    }
}
