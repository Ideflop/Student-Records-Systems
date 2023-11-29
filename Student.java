
public class Student extends Person {
    private static final String FILE = "student.csv";
    private int idNumber;//The unique student id number
    private double qcaSem1;//  students QCA
    private double qcaSem2;//  students QCA
    private double qcaYear;//  students QCA
    private String collegeLevel;//The college level of the student.
    private String program;//The program of the student.
    AcademicInformationStudent acadamicInfo;//Reference to `AcademicInformationStudents` for academic-related information.
    /**
     * Default constructor, initializes a student with default values and adds the student to the CSV file.
     */
    public Student() {
        super(); 
        this.idNumber = 0;
        this.collegeLevel = "";
    }

    public Student(int idNumber) {
        this.idNumber = idNumber;
    }
    /**
     * Parameterized constructor, initializes a student with specified values and adds the student to the CSV file.
     *
     * @param name          The name of the student.
     * @param address       The address of the student.
     * @param phoneNumber   The phone number of the student.
     * @param email         The email address of the student.
     * @param idNumber      The ID number of the student.
     * @param collegeLevel  The college level of the student.
     * @param program       The program of the student 
     */
    public Student(String name, String address, String phoneNumber, String email, int idNumber,String collegeLevel, String program) {
        super(name, address, phoneNumber, email);
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
        this.program = program;
        addStudentToCsv();
    }
   
     /**
     * Retrieves the ID number of the student.
     *
     * @return The ID number of the student.
     */
    public int getIdNumber() {
        return idNumber;
    }
    /**
     * Sets the ID number of the student.
     *
     * @param idNumber The new ID number of the student.
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    /**
     * Retrieves the first semester QCA of the student.
     *
     * @return The first semester QCA of the student.
     */
    public double getQcaSem1() {
        return qcaSem1;
    }
    /**
     * Sets the first semester QCA of the student.
     *
     * @param qca The new first semester QCA of the student.
     */
    public void setQcaSem1(double qcaSem1) {
        this.qcaSem1 = qcaSem1;
    }
    /**
     * Retrieves the second semester QCA of the student.
     *
     * @return The second semester QCA of the student.
     */
    public double getQcaSem2() {
        return qcaSem2;
    }
    /**
     * Sets the second semester QCA of the student.
     *
     * @param qca The new second semester QCA of the student.
     */
    public void setQcaSem2(double qcaSem2) {
        this.qcaSem2 = qcaSem2;
    }
    /**
     * Retrieves the whole year QCA of the student.
     *
     * @return The the whole year QCA of the student.
     */
    public double getQcaYear() {
        return qcaYear;
    }
    /**
     * Sets the whole year QCA of the student.
     *
     * @param  The new whole year QCA of the student.
     */
    public void setQcaYear(double qcaYear) {
        this.qcaYear = qcaYear;
    }
    /**
     * Retrieves the college level of the student.
     *
     * @return The college level of the student.
     */
    public String getcollegeLevel() {
        return collegeLevel;
    }
    /**
     * Retrieves the program of the student.
     *
     * @return The program of the student.
     */
    public String getProgram() {
        return program;
    }
    /**
     * Sets the program of the student.
     *
     * @param  The new program of the student.
     */
    public void setProgram(String program) {
        this.program = program;
    }
    /**
     * Adds the student's information to the CSV file.
     */
    public void addStudentToCsv(){
        acadamicInfo = new AcademicInformationStudent(this);
        this.acadamicInfo.addToCsvFile();
    }

    public void getStudentFromCSV() {
        this.acadamicInfo = new AcademicInformationStudent(this.idNumber, this);
        String[] line = this.acadamicInfo.getFromCsvFile(this.idNumber);
        if (line != null) {
            this.setIdNumber(Integer.parseInt(line[0]));
            this.setName(line[1]);
            this.collegeLevel = line[2];
            this.setPhoneNumber(line[3]);
            this.setEmail(line[4]);
            this.setAddress(line[5]);
            this.program = line[6];
        }
    }

    public static boolean checkStudentExists(int idNumber){
        return AcademicInformationStudent.checkIfStudentExistsInCSVFile(idNumber);
    }

    public static int removeStudentFromCsv(int idNumber){
        if (checkStudentExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }


    @Override
    public String toString() {
        if (idNumber == 0 || collegeLevel == null || program == null) {
            getStudentFromCSV();
        }
        return super.toString() + String.format("%n ID Number: %d%n  Progam: %s QCAsem1: %.2f %n QCAsem2: %.2f %n QCAyear: %.2f %n", idNumber, program, qcaSem1,qcaSem2, qcaYear);
    }
}

