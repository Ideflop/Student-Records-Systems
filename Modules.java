/**
 * Modules class is a class that stores the information of a module.
 */
public class Modules {
    private final String FILE = "modules.csv";
    private String name;
    private String code;
    private Student[] students;
    private Teacher teacher;

    /**
     * Constructor for objects of class Modules
     */
    public Modules(String name, String code, Student[] students, Teacher teacher) {
        this.name = name;
        this.code = code;
        this.students = students;
        this.teacher = teacher;
    }

    public String getName() { return this.name; }
    public String getCode() { return this.code; }
    public Student[] getStudents() { return this.students; }
    public Teacher getTeacher() { return this.teacher; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setStudents(Student[] students) { this.students = students; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    /**
     * Adds a new module to the csv file.
     */
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getCode()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getCode()+ "," + this.getName()+ "," + this.teacher.getIdNumber()); 
            for (int i = 0; i < this.students.length; i++) {
                sb.append(this.students[i].getIdNumber());
                if (i != this.students.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("\n");
            CSVFileManager.addLineToCSVFile(FILE, sb.toString()); 
        } else {
            System.out.println("Module with Code " + this.getCode()+ " already exists.");
        }
    }
}
