/**
 * AcademicInformationTeacher class is a subclass of AcademicInformation
 * that add and get information from a Teacher from a csv file.
 */
public class AcademicInformationTeacher extends AcademicInformation {
    private final String FILE = "teacher.csv";
    private String office;
    private Modules[] modules;


    public AcademicInformationTeacher(Teacher teacher) {
        super(teacher.getName(), teacher.getIdNumber(), teacher.getCollegeLevel(), teacher.getPhoneNumber(), teacher.getEmail(), teacher.getAddress());
        this.office = teacher.getOffice();
        this.modules = teacher.getModules();
    }

    @Override
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getIdNumber()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getIdNumber()+ "," + this.getName()+ "," + this.getcollegeLevel()+ "," + this.getPhoneNumber()+ "," + this.getEmail()+ "," + this.getAddress()+ "," + this.office+ "," + this.modules + "\n"); 
            CSVFileManager.addLineToCSVFile(FILE, sb.toString()); 
        } else {
            System.out.println("Teacher with ID Number " + this.getIdNumber()+ " already exists.");
        }
    }

    @Override
    public void getFromCsvFile(int idNumber) {
        String[] line = CSVFileManager.getLineFromCSVFile(FILE, idNumber);

        if ( line != null ) {
            this.setIdNumber(Integer.parseInt(line[0]));
            this.setName(line[1]);
            this.setcollegeLevel(line[2]);
            this.setPhoneNumber(line[3]);
            this.setEmail(line[4]);
            this.setAddress(line[5]);
            this.office = line[6];
            //TODO this.modules = line[7];
        } else {
            System.out.println("Teacher with ID Number " + idNumber + " does not exist.");
        }
    }

    public String getOffice() { return this.office; }
    public Modules[] getModules() { return this.modules; }
}
