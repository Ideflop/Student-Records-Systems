
public class Student extends Person {
    private int idNumber;//The unique student id number
    private double qcaSem1;//  students QCA
    private double qcaSem2;//  students QCA
    private double qcaYear;//  students QCA
    private String collegeLevel;//The college level of the student.
    private String program;//The program of the student.
    AcademicInformationStudents acadamicInfo;//Reference to `AcademicInformationStudents` for academic-related information.
    /**
     * Default constructor, initializes a student with default values and adds the student to the CSV file.
     */
    public Student() {
        super(); 
        this.idNumber = 0;
        this.collegeLevel = "";
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
        //acadamicInfo = new AcademicInformationStudent(getName(),idNumber,collegeLevel,getPhoneNumber(),getEmail(),getAddress());
        acadamicInfo = new AcademicInformationStudent(this);
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%n ID Number: %d%n  Progam: %s QCAsem1: %.2f %n QCAsem2: %.2f %n QCAyear: %.2f %n", idNumber, program, qcaSem1,qcaSem2, qcaYesr);
    }
}

