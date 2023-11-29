public class Administrator extends Person {

    private static final String FILE = "administration.csv";
    private int idNumber;
    private String collegeLevel;
    private AcademicInformationAdministrator academicInfo;


    public Administrator(String name, String address, String phoneNumber, String email, int idNumber, String collegeLevel) {
        super(name, address, phoneNumber, email);
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
    }

    public Administrator(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * The addAdministrationToCSV() method is used to add an administrator to a csv file
     * using the AcademicInformationAdministration class
     */
    public void addAdministrationToCSV() {
        this.academicInfo = new AcademicInformationAdministrator(this);
        this.academicInfo.addToCsvFile();
    }

    public void getAdministratorFromCSV() {
        extractDataFromString(idNumber);
    }

    public void getAdministratorFromCSV(int idNumber) {
        extractDataFromString(idNumber);
    }
    private void extractDataFromString(int idNumber) {
        this.academicInfo = new AcademicInformationAdministrator(this);
        String[] line = this.academicInfo.getFromCsvFile(idNumber);
        if (line != null) {
            this.setIdNumber(Integer.parseInt(line[0]));
            this.setName(line[1]);
            this.setCollegeLevel(line[2]);
            this.setPhoneNumber(line[3]);
            this.setEmail(line[4]);
            this.setAddress(line[5]);
        }
    }

    public void createTeacher(Teacher teacher) {
        teacher.addTeacherToCSV();
    }

    public void createStudent(Student student) {
        // TODO
        //student.addStudentToCSV();
    }


    public void setCollegeLevel(String collegeLevel) {this.collegeLevel = collegeLevel; }
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }

    public String getCollegeLevel() { return this.collegeLevel; }
    public int getIdNumber() { return this.idNumber; }



    public static boolean checkIfAdministratorExists(int idNumber) {
        return AcademicInformationAdministrator.checkIfAdministratorExistsInCSVFile(idNumber);
    }

    public static int removeAdministratorFromCsv(int idNumber){
        if (checkIfAdministratorExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    @Override
    public String toString() {
        if (this.collegeLevel == null || this.idNumber == 0) {
            getAdministratorFromCSV();
        }
        return "Administrator: " + super.toString() +
                " idNumber: " + idNumber +
                ", setCollegeLevel: " + collegeLevel;
    }
}
