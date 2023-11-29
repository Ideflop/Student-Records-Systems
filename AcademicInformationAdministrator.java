public class AcademicInformationAdministrator extends AcademicInformation {
    private Administrator administrator;
    private static final String FILE = "administration.csv";

    public AcademicInformationAdministrator(Administrator administrator) {
        super(administrator.getName(), administrator.getIdNumber(), administrator.getCollegeLevel(), administrator.getPhoneNumber(), administrator.getEmail(), administrator.getAddress());
        this.administrator = administrator;
    }


    public AcademicInformationAdministrator(int idNumber, Administrator administrator) {
        super(idNumber);
        this.administrator = administrator;
    }

    @Override
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getIdNumber()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getIdNumber()).append(",").append(this.getName()).append(",").append(this.getCollegeLevel()).append(",").append(this.getPhoneNumber()).append(",").append(this.getEmail()).append(",").append(this.getAddress());
            int result = CSVFileManager.addLineToCSVFile(FILE, sb.toString()); 
            if (result == 0) {
                System.out.println("Administrator with ID Number " + this.getIdNumber() + " successfully added.");
            } else {
                System.out.println("Administrator with ID Number " + this.getIdNumber() + " was not added.");
            }
        } else {
            System.out.println("Administrator with ID Number " + this.getIdNumber()+ " already exists.");
        }
    }

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

    public static boolean checkIfAdministratorExistsInCSVFile(int idNumber) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, idNumber);
    }
}
