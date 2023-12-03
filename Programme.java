import java.util.ArrayList;
/**
 * Programme class is a class that stores the information of a programme.
 */
public class Programme
{
    private static final String FILE = "programme.csv";
    private String name;
    private String duration;
    private String level; //undergrad, postgrad
    private String type; //taught, research
    private double passingQca;
    private ArrayList<Student> students;
    private ArrayList<Modules> modules;

    /**
     * Constructor for objects of class Programme
     * @param name of the programme
     */
    public Programme(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.modules = new ArrayList<>();
        getFromCsvFile(this.getName());
    }

    /**
     * Constructor for objects of class Programme
     * @param name of the programme
     * @param duration of the programme
     * @param level of the programme
     * @param type of the programme
     * @param passingQca of the programme
     */
    public Programme(String name, String duration, String level, String type, double passingQca) {
        this.name = name;
        this.duration = duration;
        this.level = level;
        this.type = type;
        this.passingQca = passingQca;
        this.students = new ArrayList<>();
        this.modules = new ArrayList<>();
    }

    /**
     * Setter for the name of the programme
     * @param n the name of the programme
     */
    public void setName(String n) {this.name = n;}
    /**
     * Setter for the duration of the programme
     * @param d the duration of the programme
     */
    public void setDuration(String d) {this.duration = d;}
    /**
     * Setter for the level of the programme
     * @param l the level of the programme
     */
    public void setLevel(String l) {this.level = l;}
    /**
     * Setter for the type of the programme
     * @param t the type of the programme
     */
    public void setType(String t) {this.type = t;}
    /**
     * Setter for the passingQca of the programme
     * @param q the passingQca of the programme
     */
    public void setPassingQca(double q) {this.passingQca = q;}

    /**
     * Getter for the name of the programme
     * @return the name of the programme
     */
    public String getName() {return this.name;}
    /**
     * Getter for the duration of the programme
     * @return the duration of the programme
     */
    public String getDuration() {return this.duration;}
    /**
     * Getter for the level of the programme
     * @return the level of the programme
     */
    public String getLevel() {return this.level;}
    /**
     * Getter for the type of the programme
     * @return the type of the programme
     */
    public String getType() {return this.type;}
    /**
     * Getter for the passingQca of the programme
     * @return the passingQca of the programme
     */
    public double getPassingQca() {return this.passingQca;}

    /**
     * add the student to the programme
     * @param student to be added
     */
    public void addStudent(Student student) {
        if (!this.students.contains(student)){
            this.students.add(student);
        }
    }
    /**
     * Get the students enrolled in the programme
     * @return the students enrolled in the programme
     */
    public ArrayList<Student> getStudentsEnrolled() {return this.students;}
    /**
     * Get the modules in the programme
     * @return the modules in the programme
     */
    public ArrayList<Modules> getModules() {return this.modules;}
    /**
     * add the module to the programme
     * @param module to be added
     */
    public void addModule(Modules module) {
        if (!this.modules.contains(module)) {
            this.modules.add(module);
        }
    }

    /**
     * add the programme to the csv file
     */
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getName()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getName()).append(",").append(this.getDuration()).append(",").append(this.getPassingQca()).append(",").append(this.getLevel()).append(",").append(this.getType()).append(",");
            sb.append(students.size()).append(",").append(modules.size());
            for (Student student : this.students) {
                sb.append(",").append(student.getIdNumber());
            }
            for (Modules module : this.modules) {
                sb.append(",").append(module.getCode());
            }
            int result = CSVFileManager.addLineToCSVFile(FILE, sb.toString());
            if (result == 0) {
                System.out.println("Programme with name" + this.getName()+ " added successfully.");
            } else {
                System.out.println("Programme with name" + this.getName()+ " could not be added.");
            }
        } else {
            System.out.println("Programme with Name" + this.getName() + " already exists.");

        }
    } 

    /**
     * check if the programme exists in the csv file
     * @param name the name of the programme to be checked
     * @return true if the programme exists, false otherwise
     */
    public static boolean checkIfProgrammeExists(String name) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, name);
    }

    /**
     * remove the programme from the csv file
     * @param name the name of the programme to be removed
     * @return 0 if the programme was removed, -1 otherwise
     */
    public static int removeProgrammeFromCsv(String name){
        if (checkIfProgrammeExists(name)){
            return CSVFileManager.removeLineFromCSVFile(FILE, name);
        }
        return -1;
    }

    /**
     * check if the student exists in the programme
     * @param studentId the id of the student to be checked
     * @return true if the student exists, false otherwise
     */
    public boolean checkIfStudentExists(int studentId) {
        for (Student student : this.students) {
            if (student.getIdNumber() == studentId) {
                return true;
            }
        }
        return false;
    }
    /**
     * get the programme from the csv file
     * @param name the name of the programme to be retrieved
     */
    public void getFromCsvFile(String name) {
        if ( CSVFileManager.checkIfLineExistsInCSVFile(FILE, name) ) {
            String line = CSVFileManager.getLineFromCSVFile(FILE, name);
            if (line == null) {
                System.out.println("Programme with Name" + name + " does not exist.");
            } else {
                String[] parts = line.split(",");
                this.setName(parts[0]);
                this.setDuration(parts[1]);
                this.setPassingQca(Double.parseDouble(parts[2]));
                this.setLevel(parts[3]);
                this.setType(parts[4]);
                int numStudents = Integer.parseInt(parts[5]);
                int numModules = Integer.parseInt(parts[6]);
                for (int i = 0; i < numStudents; i++) {
                    Student student = new Student(Integer.parseInt(parts[7 + i]));
                    this.addStudent(student);
                }
                for (int i = 0; i < numModules; i++) {
                    Modules module = new Modules(parts[7 + numStudents + i]);
                    this.addModule(module);
                }
            }
        } else {
            System.out.println("Programme with Name" + name + " does not exist.");
        }
    }

    /**
     * To string method for the programme
     * @return the string representation of the programme
     */
    @Override
    public String toString() {
        if (this.getDuration() == null || this.getLevel() == null || this.getType() == null) {
            getFromCsvFile(this.getName());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Programme Name: ").append(this.getName()).append("\n");
        sb.append("Duration: ").append(this.getDuration()).append("\n");
        sb.append("Passing QCA: ").append(this.getPassingQca()).append("\n");
        sb.append("Level: ").append(this.getLevel()).append("\n");
        sb.append("Type: ").append(this.getType()).append("\n");
        sb.append("Students Enrolled: ").append(this.getStudentsEnrolled().size()).append("\n");
        for (Student student : this.getStudentsEnrolled()) {
            sb.append(student).append("\n");
        }
        sb.append("Modules: ").append(this.modules.size()).append("\n");
        for (Modules module : this.modules) {
            sb.append(module).append("\n");
        }
        return sb.toString();
    }
}
