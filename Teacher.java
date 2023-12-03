/**
 * Teacher is a subclass of Person and is used to create a teacher object
 */
public class Teacher extends Person {
    private static final String FILE = "teacher.csv";
    private String office;
    private String collegeLevel;
    private int idNumber;
    private String modules;
    private boolean isOnExaminationBoard;
    private AcademicInformationTeacher academicInfo;

    /**
     * This constructor is used to create a teacher object
     * @param idNumber the id number of the teacher
     */
    public Teacher(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * This constructor is used to create a teacher object
     * @param name the name of the teacher
     * @param address the address of the teacher
     * @param collegeLevel the college level of the teacher
     * @param phoneNumber the phone number of the teacher
     * @param email the email of the teacher
     * @param office the office of the teacher
     * @param idNumber the id number of the teacher
     * @param modules the modules of the teacher
     * @param isOnExaminationBoard the isOnExaminationBoard of the teacher
     */
    public Teacher(String name, String address, String collegeLevel, String phoneNumber, String email, String office, int idNumber, String modules, boolean isOnExaminationBoard) {
        super(name, address, phoneNumber, email);
        this.collegeLevel = collegeLevel;
        this.office = office;
        this.idNumber = idNumber;
        this.modules = modules;
        this.isOnExaminationBoard = isOnExaminationBoard;
    } 

    /**
     * The getOffice() method is used to get the office of a teacher
     */
    public String getOffice() { return this.office; }
    /**
     * The getCollegeLevel() method is used to get the college level of a teacher
     */
    public String getCollegeLevel() { return this.collegeLevel; }
    /**
     * The getIdNumber() method is used to get the id number of a teacher
     */
    public int getIdNumber() { return this.idNumber; }
    /**
     * The getModules() method is used to get the modules of a teacher
     */
    public String getModules() { return this.modules; }
    /**
     * The getIsOnExaminationBoard() method is used to get the isOnExaminationBoard of a teacher
     */
    public boolean getIsOnExaminationBoard() { return this.isOnExaminationBoard; }

    /**
     * The setOffice() method is used to set the office of a teacher
     * @param office the office of the teacher
     */
    public void setOffice(String office) { this.office = office; }
    /**
     * The setCollegeLevel() method is used to set the college level of a teacher
     * @param collegeLevel the college level of the teacher
     */
    public void setCollegeLevel(String collegeLevel) { this.collegeLevel = collegeLevel; }
    /**
     * The setIdNumber() method is used to set the id number of a teacher
     * @param idNumber the id number of the teacher
     */
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }
    /**
     * The setModules() method is used to set the modules of a teacher
     * @param modules the modules of the teacher
     */
    public void setModules(String modules) { this.modules = modules; }
    /**
     * The setIsOnExaminationBoard() method is used to set the isOnExaminationBoard of a teacher
     * @param isOnExaminationBoard the isOnExaminationBoard of the teacher
     */
    public void setIsOnExaminationBoard(boolean isOnExaminationBoard) { this.isOnExaminationBoard = isOnExaminationBoard; }

    /**
     * The addTeacherToCSV() method is used to add a teacher to a csv file
     * using the AcademicInformationTeacher class
     */
    public void addTeacherToCSV() {
        this.academicInfo = new AcademicInformationTeacher(this);
        this.academicInfo.addToCsvFile();
    }

    /**
     * The getTeacherFromCSV() method is used to get a teacher from a csv file
     * using the AcademicInformationTeacher class
     */
    public void getTeacherFromCSV() {
        this.academicInfo = new AcademicInformationTeacher(this.idNumber, this);
        String[] line = this.academicInfo.getFromCsvFile(this.idNumber);
        if (line != null) {
            this.setIdNumber(Integer.parseInt(line[0]));
            this.setName(line[1]);
            this.setCollegeLevel(line[2]);
            this.setPhoneNumber(line[3]);
            this.setEmail(line[4]);
            this.setAddress(line[5]);
            this.office = line[6];
            this.modules = line[7];
            this.isOnExaminationBoard = Boolean.parseBoolean(line[8]);
        }
    }

    /**
     * The getTeacher() method is used to get a teacher
     * @return the teacher
     */
    public Teacher getTeacher() {
        return this;
    }

    /**
     * The checkIfTeacherExists() method is used to check if a teacher exists
     * @param idNumber the id number of the teacher
     * @return true if the teacher exists, false otherwise
     */
    public static boolean checkIfTeacherExists(int idNumber) {
        return AcademicInformationTeacher.checkIfTeacherExistsInCSVFile(idNumber);
    }

    /**
     * The removeTeacherFromCsv() method is used to remove a teacher from a csv file
     * @param idNumber the id number of the teacher
     * @return 1 if the teacher was removed, -1 otherwise
     */
    public static int removeTeacherFromCsv(int idNumber){
        if (checkIfTeacherExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    /**
     * The removeStudentFromModule() method is used to remove a student from a module
     * @param idNumber the id number of the student
     */
    public void removeStudentFromModule(int idNumber) {
        getTeacherFromCSV();
        if (Modules.checkIfModuleExists(this.modules)) {
            Modules module = new Modules(this.modules);
            module.removeStudentFromModule(idNumber);
        } else {
            System.out.println("The module " + this.modules + " does not exist");
        }
    }

    /**
     * The checkIfStudentExistsInModule() method is used to check if a student exists in a module
     * @param idNumber the id number of the student
     * @return true if the student exists in the module, false otherwise
     */
    public boolean checkIfStudentExistsInModule(int idNumber) {
        getTeacherFromCSV();
        if (Modules.checkIfModuleExists(this.modules)) {
            Modules module = new Modules(this.modules);
            return module.checkIfStudentIsInModule(idNumber);
        }
        return false;
    }

    /**
     * The toString() method is used to print the information of a teacher
     * @return the information of a teacher
     */
    @Override
    public String toString() {
        if (this.office == null || this.collegeLevel == null || this.idNumber == 0 || this.modules == null) {
            getTeacherFromCSV();
        }
        return "Teacher: " + super.toString() 
            + " Office: " + this.office 
            + " College Level: " + this.collegeLevel 
            + " ID Number: " + this.idNumber 
            + " Modules: " + this.modules
            + " Is on Examination Board: " + this.isOnExaminationBoard;

    }
}
