/**
 * Write a description of class AcademicInformationStudents here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AcademicInformationStudent extends AcademicInformation {

    private final String FILE = "student.csv";
    private String program;

    public AcademicInformationStudent(Student student) {
        super(student.getName(), student.getIdNumber(), student.getcollegeLevel(), student.getPhoneNumber(), student.getEmail(), student.getAddress());
        this.program = student.getProgram();
    }

    @Override
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getIdNumber()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getIdNumber()+ "," + this.getName()+ "," + this.getcollegeLevel()+ "," + this.getPhoneNumber()+ "," + this.getEmail()+ "," + this.getAddress()+ "," + this.program + "\n");
            CSVFileManager.addLineToCSVFile(FILE, sb.toString()); 
        } else {
            System.out.println("Student with ID Number " + this.getIdNumber()+ " already exists.");
        }
    }

    @Override
    public void getFromCsvFile(int idNumber) {
        // TODO : to be implemented
    }
}
