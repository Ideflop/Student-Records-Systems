/**
 * The Administrator class is used to create an administrator object
 * It extends the Person class
 * It is used to add and get information from the administration.csv file
 * It is used to check if an administrator exists in the administration.csv file
 */
public class Administrator extends Person {

    private static final String FILE = "administration.csv";
    private int idNumber;
    private String collegeLevel;
    private AcademicInformationAdministrator academicInfo;


    /**
     * Constructor for Administrator class.
     * @param name of the administrator
     * @param address of the administrator
     * @param phoneNumber of the administrator
     * @param email of the administrator
     * @param idNumber of the administrator
     * @param collegeLevel of the administrator
     */
    public Administrator(String name, String address, String phoneNumber, String email, int idNumber, String collegeLevel) {
        super(name, address, phoneNumber, email);
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
    }

    /**
     * Constructor for Administrator class.
     * @param idNumber of the administrator
     */
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

    /**
     * The getAdministratorFromCSV() method is used to get an administrator from a csv file
     * using the AcademicInformationAdministration class
     */
    public void getAdministratorFromCSV() {
        extractDataFromString(idNumber);
    }

    /**
     * The getAdministratorFromCSV() method is used to get an administrator from a csv file
     * using the AcademicInformationAdministration class
     * @param idNumber of the administrator
     */
    public void getAdministratorFromCSV(int idNumber) {
        extractDataFromString(idNumber);
    }

    /**
     * The extractDataFromString() method is used to extract data from a string
     * @param idNumber of the administrator
     */
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

    /**
     * The checkIfAdministratorExistsInCSVFile() method is used to check if an administrator exists in a csv file
     * using the AcademicInformationAdministration class
     * @param idNumber of the administrator
     * @return true if the administrator exists, false otherwise
     */
    public void createTeacher(Teacher teacher) {
        teacher.addTeacherToCSV();
    }

    /**
     * Setter for the collegeLevel attribute
     * @param collegeLevel of the administrator
     */
    public void setCollegeLevel(String collegeLevel) {this.collegeLevel = collegeLevel; }
    /**
     * Setter for the idNumber attribute
     * @param idNumber of the administrator
     */
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }

    /**
     * Getter for the collegeLevel attribute
     * @return collegeLevel of the administrator
     */
    public String getCollegeLevel() { return this.collegeLevel; }
    /**
     * Getter for the idNumber attribute
     * @return idNumber of the administrator
     */
    public int getIdNumber() { return this.idNumber; }



    /**
     * The checkIfAdministratorExistsInCSVFile() method is used to check if an administrator exists in a csv file
     * using the AcademicInformationAdministration class
     * @param idNumber of the administrator
     * @return true if the administrator exists, false otherwise
     */
    public static boolean checkIfAdministratorExists(int idNumber) {
        return AcademicInformationAdministrator.checkIfAdministratorExistsInCSVFile(idNumber);
    }

    /**
     * The removeAdministratorFromCsv() method is used to remove an administrator from a csv file
     * using the AcademicInformationAdministration class
     * @param idNumber of the administrator
     * @return 1 if the administrator was removed, -1 otherwise
     */
    public static int removeAdministratorFromCsv(int idNumber){
        if (checkIfAdministratorExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    /**
     * The toString() method is used to print the attributes of an administrator
     * @return a string containing the attributes of an administrator
     */
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
