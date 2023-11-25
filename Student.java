
public class Student extends Person {
    private int idNumber;
    private double qca;
    private String collegeLevel;
    AcademicInformationStudents acadamicInfo;
    public Student() {
        super(); 
        this.idNumber = 0;
        this.qca = 0.0; 
        this.collegeLevel = "";
    }
    public Student(String name, String address, String phoneNumber, String email, int idNumber,String collegeLevel) {
        super(name, address, phoneNumber, email);
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
        addStudentToCsv();
    }
    public void setName(String collegeLevel) {
        this.collegeLevel = collegeLevel;
    }
    public int getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    public double getQca() {
        return qca;
    }
    public void setQca(double qca) {
        this.qca = qca;
    }
    public String getcollegeLevel() {
        return collegeLevel;
    }
    public void setcollegeLevel(String collegeLevel) {
        this.collegeLevel = collegeLevel;
    }
    public void addStudentToCsv(){
        acadamicInfo = new AcademicInformationStudents(getName(),idNumber,collegeLevel,getPhoneNumber(),getEmail(),getAddress());
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%n ID Number: %d%n QCA: %.2f", idNumber, qca);
    }
}

