/**
 * AcademicInformationStudent class
 */
public class AcademicInformationStudent extends AcademicInformation {

    private static final String FILE = "student.csv";
    private String program;

    /**
     * Constructor for AcademicInformationStudent class.
     * @param student object
     */
    public AcademicInformationStudent(Student student) {
        super(student.getName(), student.getIdNumber(), student.getcollegeLevel(), student.getPhoneNumber(), student.getEmail(), student.getAddress());
        this.program = student.getProgram();
    }

    /**
     * Constructor for AcademicInformationStudent class.
     * @param idNumber of the student
     * @param student object
     */
    public AcademicInformationStudent(int idNumber, Student student) {
        super(idNumber);
    }


    /**
     * Adds the student to the student.csv file
     */
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

    /**
     * Gets the student from the student.csv file
     * @param idNumber of the student
     * @return String array of the student's information
     */
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


    /**
     * Checks if the student exists in the student.csv file
     * @param idNumber of the student
     * @return true if the student exists, false otherwise
     */
    public static boolean checkIfStudentExistsInCSVFile(int idNumber) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, idNumber);
    }
}
