public class Teacher extends Person {
    
    private String office;
    private String collegeLevel;
    private int idNumber;
    private Modules[] modules;
    private AcademicInformationTeacher acadamicInfo;


    public Teacher(String name, String address, String collegeLevel, String phoneNumber, String email, String office, int idNumber, Modules[] modules) {
        super(name, address, phoneNumber, email);
        this.collegeLevel = collegeLevel;
        this.office = office;
        this.idNumber = idNumber;
        this.modules = modules;
    } 

    public String getOffice() { return this.office; }
    public String getCollegeLevel() { return this.collegeLevel; }
    public int getIdNumber() { return this.idNumber; }
    public Modules[] getModules() { return this.modules; }

    public void setOffice(String office) { this.office = office; }
    public void setCollegeLevel(String collegeLevel) { this.collegeLevel = collegeLevel; }
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }
    public void setModules(Modules[] modules) { this.modules = modules; }

    public void addTeachertoCSV() {
        this.acadamicInfo = new AcademicInformationTeacher(this);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}
