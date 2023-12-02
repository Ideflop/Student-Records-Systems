import java.util.ArrayList;
/**
 * Assignment class is a class that stores the information of a assignment
 */
public class Assignment{
    private static final String FILE = "assignment.csv";
    private String name;
    private String code;
    private String moduleCode;
    private int outOf;
    private int[] students;
    private double[] studentsMarks;

    public Assignment(String code) {
        this.code = code;
    }

    /**
     * Constructor for objects of class Assignment
     */
    public Assignment(String name, String code, int outOf, int[] students, double[] studentsMarks) {
        this.name = name;
        this.code = code;
        this.outOf = outOf;
        this.students = students;
        this.studentsMarks = studentsMarks;
    }

    public String getName() { return this.name; }
    public String getCode() { return this.code; }
    public String getModuleCode() { return this.moduleCode; }
    public int getOutOf() { return this.outOf; }
    public int[] getStudents() { return this.students; }
    public double[] getStudentsMarks() { return this.studentsMarks; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setModuleCode(String moduleCode) { this.moduleCode = moduleCode; }
    public void setOutOf(int outOf) { this.outOf = outOf; }
    public void setStudents(int[] students) { this.students = students; }
    public void setStudentsMarks(double[] studentsMarks) { this.studentsMarks = studentsMarks; }

    /**
     * Adds a new Assignment to the csv file.
     */
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getCode()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getCode()).append(",").append(this.getName()).append(",").append(this.getModuleCode()).append(",").append(this.getOutOf());
            for (int i = 0; i < this.students.length; i++) {
                sb.append(",").append(this.students[i]).append(",").append(this.studentsMarks[i]);
                if (i != this.students.length - 1) {
                    sb.append(",");
                }
                
            }
            int result = CSVFileManager.addLineToCSVFile(FILE, sb.toString());
            if (result == 0) {
                System.out.println("Module with Code " + this.getCode()+ " added successfully.");
            } else {
                System.out.println("Module with Code " + this.getCode()+ " could not be added.");
            }
        } else {
            System.out.println("Module with Code " + this.getCode()+ " already exists.");
        }
    }

    /**
     * This method is used to get the information of a module from a csv file
     * @param code the code of the module
     */
    public void getFromCsvFile(String code) {
        String line = CSVFileManager.getLineFromCSVFile(FILE, code);
        if (line == null) {
            System.out.println("Module with Code " + code + " does not exist.");
        } else {
            String[] line2 = line.split(",");
            this.code = line2[0];
            this.name = line2[1];
            this.moduleCode = line2[2];
            this.outOf = Integer.parseInt(line2[3]);
            ArrayList<Integer> students = new ArrayList<>();
            ArrayList<Integer> studentsMarks = new ArrayList<>();
            for (int i = 4; i < line2.length; i=i+2) {
                students.add(Integer.parseInt(line2[i]));
                studentsMarks.add(Integer.parseInt(line2[i+1]));
            }
            this.students = students.stream().mapToInt(i -> i).toArray();
            this.studentsMarks = studentsMarks.stream().mapToDouble(i -> i).toArray();
        }
    }


    public static boolean checkIfAssignmentExists(String code) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, code);
    }

    public static int removeAssignmentFromCsv(String idNumber){
        if (checkIfAssignmentExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    public String getStudentMark(int studentId) {
        getFromCsvFile(code);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == studentId) {
                return String.valueOf(studentsMarks[i]);
            }
        }
        return null;
    }

    public void updateStudentMark(int studentId, int mark) {
        getFromCsvFile(code);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == studentId) {
                studentsMarks[i] = mark;
            }
        }
        addToCsvFile();
    }

    public void addMarkToStudent(int studentId, int mark) {
        getFromCsvFile(code);
        int[] newStudents = new int[students.length + 1];
        double[] newStudentsMarks = new double[studentsMarks.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
            newStudentsMarks[i] = studentsMarks[i];
        }
        newStudents[students.length] = studentId;
        newStudentsMarks[studentsMarks.length] = mark;
        this.students = newStudents;
        this.studentsMarks = newStudentsMarks;
        addToCsvFile();
    }

    @Override
    public String toString() {
        if ( this.name == null || this.code == null || this.students == null || this.studentsMarks == null ) {
            getFromCsvFile(this.code);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Assignment").append("\n").append("Name: ").append(this.name).append("\n").append("Code: ").append(this.code).append("\n").append("Out of: ").append(this.outOf).append("\n");
        for (int i = 0; i < this.students.length; i++) {
            sb.append("Student: ").append(this.students[i]).append(" Mark: ").append(this.studentsMarks[i]).append("\n");
        }

        return sb.toString();
    }
}
