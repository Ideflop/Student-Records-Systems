/**
 * AcademicInformationAdministrator class
 * This class is used to create an AcademicInformationAdministrator object
 * It extends the AcademicInformation class
 * It is used to add and get information from the administration.csv file
 * It is used to check if an administrator exists in the administration.csv file
 */
public class AcademicInformationAdministrator extends AcademicInformation {
    private Administrator administrator;
    private static final String FILE = "administration.csv";

    /**
     * Constructor for AcademicInformationAdministrator class.
     * @param administrator object
     */
    public AcademicInformationAdministrator(Administrator administrator) {
        super(administrator.getName(), administrator.getIdNumber(), administrator.getCollegeLevel(), administrator.getPhoneNumber(), administrator.getEmail(), administrator.getAddress());
        this.administrator = administrator;
    }


    /**
     * Constructor for AcademicInformationAdministrator class.
     * @param idNumber of the administrator
     * @param administrator object
     */
    public AcademicInformationAdministrator(int idNumber, Administrator administrator) {
        super(idNumber);
        this.administrator = administrator;
    }

    /**
     * Adds the administrator to the administration.csv file
     */
    @Override
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getIdNumber()) ) {
            int result = CSVFileManager.addLineToCSVFile(FILE, this.getIdNumber() + "," + this.getName() + "," + this.getCollegeLevel() + "," + this.getPhoneNumber() + "," + this.getEmail() + "," + this.getAddress());
            if (result == 0) {
                System.out.println("Administrator with ID Number " + this.getIdNumber() + " successfully added.");
            } else {
                System.out.println("Administrator with ID Number " + this.getIdNumber() + " was not added.");
            }
        } else {
            System.out.println("Administrator with ID Number " + this.getIdNumber()+ " already exists.");
        }
    }

    /**
     * Gets the administrator from the administration.csv file
     * @param idNumber of the administrator
     * @return String array of the administrator's information
     */
    @Override
    public String[] getFromCsvFile(int idNumber) {
        String line = CSVFileManager.getLineFromCSVFile(FILE, idNumber);
        if (line == null) {
            System.out.println("Administrator with ID Number " + idNumber + " does not exist.");
            return new String[0];
        } else {
            return line.split(",");
        }
    }

    /**
     * Checks if the administrator exists in the administration.csv file
     * @param idNumber of the administrator
     * @return true if the administrator exists, false otherwise
     */
    public static boolean checkIfAdministratorExistsInCSVFile(int idNumber) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, idNumber);
    }
}
