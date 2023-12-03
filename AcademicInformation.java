/**
 * Abstract class that contains the basic information for adding and getting Academic information from a csv file.
 */
public abstract class AcademicInformation {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int idNumber;
    private String collegeLevel;

    /**
     * Constructor for AcademicInformation class.
     * @param idNumber of the person
     */
    public AcademicInformation(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Constructor for AcademicInformation class.
     * @param name of the person
     * @param idNumber of the person
     * @param collegeLevel of the person
     * @param phoneNumber of the person
     * @param email of the person
     * @param address of the person
     */
    public AcademicInformation(String name, int idNumber, String collegeLevel, String phoneNumber, String email, String address) {
        this.name = name;
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    /**
     * Abstract method for adding to a csv file.
     */
    public abstract void addToCsvFile();
    /**
     * Abstract method for getting from a csv file.
     * @param idNumber of the person
     * @return String array of the person's information
     */
    public abstract String[] getFromCsvFile(int idNumber);

    /**
     * Setter for the person's name.
     * @param name of the person
     */
    public void setName(String name) { this.name = name; }
    /**
     * Setter for the person's address.
     * @param address of the person
     */
    public void setAddress(String address) { this.address = address; }
    /**
     * Setter for the person's phone number.
     * @param phoneNumber of the person
     */
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    /**
     * Setter for the person's email.
     * @param email of the person
     */
    public void setEmail(String email) { this.email = email; }
    /**
     * Setter for the person's id number.
     * @param idNumber of the person
     */
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }
    /**
     * Setter for the person's college level.
     * @param collegeLevel of the person
     */
    public void setCollegeLevel(String collegeLevel) { this.collegeLevel = collegeLevel; }

    /**
     * Getter for the person's name.
     * @return name of the person
     */
    public String getName() { return this.name; }
    /**
     * Getter for the person's address.
     * @return address of the person
     */
    public String getAddress() { return this.address; }
    /**
     * Getter for the person's phone number.
     * @return phone number of the person
     */
    public String getPhoneNumber() { return this.phoneNumber; }
    /**
     * Getter for the person's email.
     * @return email of the person
     */
    public String getEmail() { return this.email; }
    /**
     * Getter for the person's id number.
     * @return id number of the person
     */
    public int getIdNumber() { return this.idNumber; }
    /**
     * Getter for the person's college level.
     * @return college level of the person
     */
    public String getCollegeLevel() { return this.collegeLevel; }

}

