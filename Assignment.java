import java.util.ArrayList;
/**
 * Assignment class is a class that stores the information of an assignment
 */
public class Assignment{
    private static final String FILE = "assignment.csv";
    private String name;
    private String code;
    private String moduleCode;
    private int outOf;
    private int[] students;
    private double[] studentsMarks;

    /**
     * Constructor for objects of class Assignment
     * @param code of the assignment
     */
    public Assignment(String code) {
        this.code = code;
    }

    /**
     * Constructor for objects of class Assignment
     * @param name of the assignment
     * @param code of the assignment
     * @param outOf of the assignment
     * @param students of the assignment
     * @param studentsMarks of the assignment
     */
    public Assignment(String name, String code, int outOf, int[] students, double[] studentsMarks) {
        this.name = name;
        this.code = code;
        this.outOf = outOf;
        this.students = students;
        this.studentsMarks = studentsMarks;
    }

    /**
     * Getter for the name of the assignment
     * @return the name of the assignment
     */
    public String getName() { return this.name; }
    /**
     * Getter for the code of the assignment
     * @return the code of the assignment
     */
    public String getCode() { return this.code; }
    /**
     * Getter for the module code of the assignment
     * @return the module code of the assignment
     */
    public String getModuleCode() { return this.moduleCode; }
    /**
     * Getter for the out of  the assignment
     * @return the out of  the assignment
     */
    public int getOutOf() { return this.outOf; }
    /**
     * Getter for the students of the assignment
     * @return the students of the assignment
     */
    public int[] getStudents() { return this.students; }
    /**
     * Getter for the students marks of the assignment
     * @return the students marks of the assignment
     */
    public double[] getStudentsMarks() { return this.studentsMarks; }

    /**
     * Setter for the name of the assignment
     * @param name of the assignment
     */
    public void setName(String name) { this.name = name; }
    /**
     * Setter for the code of the assignment
     * @param code of the assignment
     */
    public void setCode(String code) { this.code = code; }
    /**
     * Setter for the module code of the assignment
     * @param moduleCode of the assignment
     */
    public void setModuleCode(String moduleCode) { this.moduleCode = moduleCode; }
    /**
     * Setter for the out of  the assignment
     * @param outOf of the assignment
     */
    public void setOutOf(int outOf) { this.outOf = outOf; }
    /**
     * Setter for the students of the assignment
     * @param students of the assignment
     */
    public void setStudents(int[] students) { this.students = students; }
    /**
     * Setter for the students marks of the assignment
     * @param studentsMarks of the assignment
     */
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
            }
            int result = CSVFileManager.addLineToCSVFile(FILE, sb.toString());
            if (result == 0) {
                System.out.println("Assignment with Code " + this.getCode()+ " added successfully.");
            } else {
                System.out.println("Assignment with Code " + this.getCode()+ " could not be added.");
            }
        } else {
            System.out.println("Assignment with Code " + this.getCode()+ " already exists.");
        }
    }

    /**
     * This method is used to get the information of a assignment from a csv file
     * @param code the code of the assignment
     */
    public void getFromCsvFile(String code) {
        String line = CSVFileManager.getLineFromCSVFile(FILE, code);
        if (line == null) {
            System.out.println("Assignment with Code " + code + " does not exist.");
        } else {
            String[] line2 = line.split(",");
            this.code = line2[0];
            this.name = line2[1];
            this.moduleCode = line2[2];
            this.outOf = Integer.parseInt(line2[3]);
            ArrayList<Integer> students = new ArrayList<>();
            ArrayList<Double> studentsMarks = new ArrayList<>();
            for (int i = 4; i < line2.length; i=i+2) {
                students.add(Integer.parseInt(line2[i]));
                studentsMarks.add(Double.parseDouble(line2[i+1]));
            }
            this.students = students.stream().mapToInt(i -> i).toArray();
            this.studentsMarks = studentsMarks.stream().mapToDouble(i -> i).toArray();
        }
    }


    /**
     * This method is used to check if an assignment exists in a csv file
     * @param code the code of the assignment
     * @return the result of the operation
     */
    public static boolean checkIfAssignmentExists(String code) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, code);
    }

    /**
     * This method is used to remove an assignment from a csv file
     * @param idNumber the id number of the assignment
     * @return the result of the operation
     */
    public static int removeAssignmentFromCsv(String idNumber){
        if (checkIfAssignmentExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    /**
     * This method is used to get the marks of a student from a csv file
     * @param studentId the id of the student
     * @return the marks of the student
     */
    public String getStudentMark(int studentId) {
        getFromCsvFile(code);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == studentId) {
                System.out.println(studentsMarks[i]);
                return String.valueOf(studentsMarks[i]);
            }
        }
        return null;
    }

    /**
     * This method is used to update the marks of a student in a csv file
     * @param studentId the id of the student
     * @param mark the mark of the student
     */
    public void updateStudentMark(int studentId, int mark) {
        getFromCsvFile(code);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == studentId) {
                studentsMarks[i] = mark;
            }
        }
        CSVFileManager.removeLineFromCSVFile(FILE, code);
        addToCsvFile();
    }

    /**
     * This method is used to add a mark to a student in a csv file
     * @param studentId the id of the student
     * @param mark the mark of the student
     */
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
        CSVFileManager.removeLineFromCSVFile(FILE, code);
        addToCsvFile();
    }

    /**
     * To string method
     * @return the string representation of the assignment
     */
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
