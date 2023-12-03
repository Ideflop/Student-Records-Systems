import java.util.ArrayList;
/**
 * Department class is a class that stores the information of a department
 */
public class Department
{
    private static final String FILE = "department.csv";

    private String name;
    private int deptID;
    private ExaminationBoard examBoard; // for each department
    private ArrayList<Programme> programmes;
    private ArrayList<Modules> modules;

    /**
     * Constructor for objects of class Department
     */
    public Department() {}

    /**
     * Constructor for objects of class Department
     * @param deptID of the department
     */
    public Department(int deptID) {
        this.deptID = deptID;
        this.programmes = new ArrayList<>();
        this.modules = new ArrayList<>();
    }

    /**
     * Constructor for objects of class Department
     * @param name of the department
     * @param ID of the department
     */
    public Department(String name, int ID) {
        this.name = name;
        this.deptID = ID;
        this.programmes = new ArrayList<>();
        this.modules = new ArrayList<>();
    }

    /**
     * Getter for the name of the department
     * @return the name of the department
     */
    public String getName() {return this.name;}
    /**
     * Getter for the ID of the department
     * @return the ID of the department
     */
    public int getID() {return this.deptID;}
    /**
     * Setter for the name of the department
     * @param n the name of the department
     */
    public void setName(String n) {this.name = n;}
    /**
     * Setter for the ID of the department
     * @param id the ID of the department
     */
    public void setID(int id) {this.deptID = id;}

    /**
     * Add a programme to the department
     * @param prog the programme to be added
     */
    public void addProgramme(Programme prog) {
        if (!this.programmes.contains(prog)) {
            this.programmes.add(prog);
        }
    }
    /**
     * Add a module to the department
     * @param module the module to be added
     */
    public void addModule(Modules module) {
        if (!this.modules.contains(module)) {
            this.modules.add(module);
        }
    }

    /**
     * add the Department to the csv file
     */
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getID()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getID()).append(",").append(this.getName()).append(",");
            sb.append(programmes.size()).append(",").append(modules.size());
            for (Programme prog : this.programmes) {
                sb.append(",").append(prog.getName());
            }
            for (Modules module : this.modules) {
                sb.append(",").append(module.getCode());
            }
            int result = CSVFileManager.addLineToCSVFile(FILE, sb.toString());
            if (result == 0) {
                System.out.println("Department with name" + this.getID()+ " added successfully.");
            } else {
                System.out.println("Department with name" + this.getID()+ " could not be added.");
            }
        } else {
            System.out.println("Department with name" + this.getID()+ " already exists.");
        }
    } 

    /**
     * check if the department exists in the csv file
     * @param id the name of the department to be checked
     * @return true if the department exists, false otherwise
     */
    public static boolean checkIfDepartmentExists(int id) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, id);
    }

    /**
     * remove the department from the csv file
     * @param id the name of the department to be removed
     * @return 0 if the department was removed successfully, -1 otherwise
     */
    public static int removeDepartmentFromCsv(int id){
        if (checkIfDepartmentExists(id)){
            return CSVFileManager.removeLineFromCSVFile(FILE, id);
        }
        return -1;
    }

    /**
     * get the department from the csv file
     * @param id the name of the department to be retrieved
     */
    public void getFromCsvFile(int id) {
        if ( CSVFileManager.checkIfLineExistsInCSVFile(FILE, id) ) {
            String line = CSVFileManager.getLineFromCSVFile(FILE, id);
            if (line == null) {
                System.out.println("Department with Name" + id + " does not exist.");
            } else {
                String[] parts = line.split(",");
                this.setID(Integer.parseInt(parts[0]));
                this.setName(parts[1]);
                int numProgrammes = Integer.parseInt(parts[2]);
                int numModules = Integer.parseInt(parts[3]);
                for (int i = 0; i < numProgrammes; i++) {
                    Programme prog = new Programme(parts[4 + i]);
                    this.addProgramme(prog);
                }
                for (int i = 0; i < numModules; i++) {
                    Modules module = new Modules(parts[4 + numProgrammes + i]);
                    this.addModule(module);
                }
            }
        } else {
            System.out.println("Default with Name" + id + " does not exist.");
        }
    }

    /**
     * get QCA score for a student
     * @param student the student to get the QCA score for
     * @return the QCA score for the student
     */
    public double getQcaScoreForStudent(Student student) {
        return new QCAcalculator().calculateQcaScore(student);  
    }

    /**
     * To string method for the department
     * @return the string representation of the department
     */
    @Override
    public String toString() {
        if (this.getName() == null) {
            getFromCsvFile(this.getID());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Department Name: ").append(this.getName()).append("\n");
        sb.append("Department ID: ").append(this.getID()).append("\n");
        sb.append("Programmes: ").append(this.programmes.size()).append("\n");
        for (Programme prog : this.programmes) {
            sb.append(prog.getName()).append("\n");
        }
        sb.append("Modules: ").append(this.modules.size()).append("\n");
        for (Modules module : this.modules) {
            sb.append(module.getCode()).append("\n");
        }
        return sb.toString();
    }
    
}
