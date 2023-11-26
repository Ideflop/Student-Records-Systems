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

    public AcademicInformation(String name, int idNumber, String collegeLevel, String phoneNumber, String email, String address) {
        this.name = name;
        this.idNumber = idNumber;
        this.collegeLevel = collegeLevel;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public abstract void addToCsvFile();
    public abstract void getFromCsvFile(int idNumber);

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }
    public void setcollegeLevel(String collegeLevel) { this.collegeLevel = collegeLevel; }

    public String getName() { return this.name; }
    public String getAddress() { return this.address; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public String getEmail() { return this.email; }
    public int getIdNumber() { return this.idNumber; }
    public String getcollegeLevel() { return this.collegeLevel; }

}

