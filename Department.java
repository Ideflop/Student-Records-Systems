import java.util.ArrayList;
public class Department
{
    private static final String FILE = "department.csv";

    private String name;
    private int deptID;
    private ExaminationBoard[] examBoard; // for each dpartment
    private ArrayList<Programme> programmes;
    private ArrayList<Modules> modules;

    public Department(int deptID) {
        this.deptID = deptID;
        this.programmes = new ArrayList<Programme>();
        this.modules = new ArrayList<Modules>();
    }

    public Department(String name, int ID) {
        this.name = name;
        this.deptID = ID;
        this.programmes = new ArrayList<Programme>();
        this.modules = new ArrayList<Modules>();
    }

    public String getName() {return this.name;}
    public int getID() {return this.deptID;}
    public void setName(String n) {this.name = n;}
    public void setID(int id) {this.deptID = id;}
    public void addProgramme(Programme prog) {
        if (!this.programmes.contains(prog)) {
            this.programmes.add(prog);
        }
    }
    public void addModule(Modules module) {
        if (!this.modules.contains(module)) {
            this.modules.add(module);
        }
    }
    // create exam board for all programmes
    public void createExamBoard(Programme p) {
        ExaminationBoard exams = new ExaminationBoard(p, p.getPassingQca());
        
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

    public static boolean checkIfDepartmentExists(int id) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, id);
    }

    /**
     * remove the department from the csv file
     * @param id the name of the department to be removed
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
    public double getQcaScoreForStudent(Student student) {
        return new QCAcalculator().calculateQcaScore(student);  
    }
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
