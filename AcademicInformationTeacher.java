/**
 * This class is used to create the academic information of a teacher
 * It extends the AcademicInformation class
 * It is used to add and get information from the teacher.csv file
 * It is used to check if a teacher exists in the teacher.csv file
 * It is used to get the information of a teacher from the teacher.csv file
 */
public class AcademicInformationTeacher extends AcademicInformation {
    private static final String FILE = "teacher.csv";
    private String office;
    private String modules;
    private boolean isOnExaminationBoard;
    private Teacher teacher;


    /**
     * This constructor is used create the academic information of a teacher
     * @param teacher the teacher
     */
    public AcademicInformationTeacher(Teacher teacher) {
        super(teacher.getName(), teacher.getIdNumber(), teacher.getCollegeLevel(), teacher.getPhoneNumber(), teacher.getEmail(), teacher.getAddress());
        this.office = teacher.getOffice();
        this.modules = teacher.getModules();
        this.isOnExaminationBoard = teacher.getIsOnExaminationBoard();
        this.teacher = teacher;
    }

    /**
     * This constructor is used create the academic information of a teacher
     * @param idNumber the id number of the teacher
     * @param teacher the teacher
     */
    public AcademicInformationTeacher(int idNumber, Teacher teacher) {
        super(idNumber);
        this.teacher = teacher;
    }

    /**
     * This method is used to add the information of a teacher to a csv file
     */
    @Override
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getIdNumber()) ) {
            int result = CSVFileManager.addLineToCSVFile(FILE, this.getIdNumber() + "," + this.getName() + "," + this.getCollegeLevel() + "," + this.getPhoneNumber() + "," + this.getEmail() + "," + this.getAddress() + "," + this.office + "," + this.modules + "," + this.isOnExaminationBoard);
            if (result == 0) {
                System.out.println("Teacher with ID Number " + this.getIdNumber() + " added successfully.");
            } else {
                System.out.println("Teacher with ID Number " + this.getIdNumber() + " could not be added.");
            }
        } else {
            System.out.println("Teacher with ID Number " + this.getIdNumber()+ " already exists.");
        }
    }

    /**
     * This method is used to get the information of a teacher from a csv file
     * @param idNumber the id number of the teacher
     */
    @Override
    public String[] getFromCsvFile(int idNumber) {
        String line = CSVFileManager.getLineFromCSVFile(FILE, idNumber);
        if (line == null) {
            System.out.println("Teacher with ID Number " + idNumber + " does not exist.");
            return new String[0];
        } else {
            return line.split(",");
        }
    }

    /**
     * This method is used to get the information of a teacher from a csv file
     * @return the teacher
     */
    public Teacher getTeacherFromAcademicInformation() {
            return new Teacher(this.getName(), this.getAddress(), this.getCollegeLevel(), this.getPhoneNumber(), this.getEmail(), this.office, this.getIdNumber(), this.modules, this.isOnExaminationBoard);
    }

    /**
     * This method is used to check if a teacher exists in a csv file
     * @param idNumber the id number of the teacher
     * @return true if the teacher exists, false otherwise
     */
    public static boolean checkIfTeacherExistsInCSVFile(int idNumber) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, idNumber);
    }

    /**
     * The getOffice() method is used to get the office of a teacher
     * @return the office of the teacher as a string
     */
    public String getOffice() { return this.office; }

    /**
     * The getModules() method is used to get the modules of a teacher
     * @return the modules of the teacher as an array of Modules
     */
    public String getModules() { return this.modules; }

    /**
     * The getIsOnExaminationBoard() method is used to get if a teacher is on the examination board
     * @return true if the teacher is on the examination board, false otherwise
     */
    public boolean getIsOnExaminationBoard() { return this.isOnExaminationBoard; }
}
