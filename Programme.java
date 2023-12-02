import java.util.ArrayList;
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

    public Programme(String name) {
        this.name = name;
        this.students = new ArrayList<Student>();
        this.modules = new ArrayList<Modules>();
        getFromCsvFile(this.getName());
    }

    public Programme(String name, String duration, String level, String type, double passingQca) {
        this.name = name;
        this.duration = duration;
        this.level = level;
        this.type = type;
        this.passingQca = passingQca;
        this.students = new ArrayList<Student>();
        this.modules = new ArrayList<Modules>();
    }
    public void setName(String n) {this.name = n;}
    public void setDuration(String d) {this.duration = d;}
    public void setLevel(String l) {this.level = l;}
    public void setType(String t) {this.type = t;}
    public void setPassingQca(double q) {this.passingQca = q;}

    public String getName() {return this.name;}
    public String getDuration() {return this.duration;}
    public String getLevel() {return this.level;}
    public String getType() {return this.type;}
    public double getPassingQca() {return this.passingQca;}

    public void addStudent(Student student) {
        if (!this.students.contains(student)){
            this.students.add(student);
        }
    }
    public ArrayList<Student> getStudentsEnrolled() {return this.students;}
    public ArrayList<Modules> getModules() {return this.modules;}
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

    public static boolean checkIfProgrammeExists(String name) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, name);
    }

    /**
     * remove the programme from the csv file
     * @param name the name of the programme to be removed
     */
    public static int removeProgrammeFromCsv(String name){
        if (checkIfProgrammeExists(name)){
            return CSVFileManager.removeLineFromCSVFile(FILE, name);
        }
        return -1;
    }

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
