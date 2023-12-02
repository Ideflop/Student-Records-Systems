import java.util.Arrays;
import java.util.ArrayList;
/**
 * Modules class is a class that stores the information of a module.
 */
public class Modules {
    private static final String FILE = "modules.csv";
    private String name;
    private String code;
    private ArrayList<String> assignmentName;
    private int[] students;
    private int teacher;

    public Modules(String code) {
        this.code = code;
    }

    /**
     * Constructor for objects of class Modules
     */
    public Modules(String name, String code, int[] students, int teacher) {
        this.name = name;
        this.code = code;
        this.students = students;
        this.teacher = teacher;
    }

    public String getName() { return this.name; }
    public String getCode() { return this.code; }
    public ArrayList<String> getAssignmentName() { return this.assignmentName; }
    public int[] getStudents() { return this.students; }
    public int getTeacher() { return this.teacher; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setAssignmentName(ArrayList<String> assignmentName) { this.assignmentName = assignmentName; }
    public void setStudents(int[] students) { this.students = students; }
    public void setTeacher(int teacher) { this.teacher = teacher; }
    public void addAssignmentName(String assignmentName) { this.assignmentName.add(assignmentName); }

    /**
     * Adds a new module to the csv file.
     */
    public void addToCsvFile() {
        if ( !CSVFileManager.checkIfLineExistsInCSVFile(FILE, this.getCode()) ) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getCode()).append(",").append(this.getName()).append(",").append(this.teacher).append(",").append(this.students.length);
            for (int i = 0; i < this.students.length; i++) {
                sb.append(",").append(this.students[i]);
                if (i != this.students.length - 1) {
                    sb.append(",");
                }
            }
            for (String s : this.assignmentName) {
                sb.append(",").append(s);
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
            this.teacher = Integer.parseInt(line2[2]);
            int numberOfStudents = Integer.parseInt(line2[3]);
            this.students = new int[numberOfStudents];
            for (int i = 0; i < numberOfStudents; i++) {
                this.students[i] = Integer.parseInt(line2[4 + i]);
            }
            this.assignmentName = new ArrayList<>();
            this.assignmentName.addAll(Arrays.asList(line2).subList(4 + numberOfStudents, line2.length));
        }
    }

    /**
     * This method is used to remove a student from a module
     * @param studentId the id of the student
     */
    public void removeStudentFromModule(int studentId) {
        boolean found = checkIfStudentIsInModule(studentId);
        if (found) {
            int[] newStudents = new int[this.students.length - 1];
            int j = 0;
            for (int student : this.students) {
                if (student != studentId) {
                    newStudents[j] = student;
                    j++;
                }
            }
            this.students = newStudents;
            removeModulesFromCsv(this.getCode());
            addToCsvFile();
        } else {
            System.out.println("Student with ID " + studentId + " does not exist in module with Code " + this.getCode());
        }
    }

    /**
     * This method is used to check if a student is in a module
     * @param studentId the id of the student
     * @return true if the student is in the module, false otherwise
     */
    public boolean checkIfStudentIsInModule(int studentId) {
        for (Integer student : this.students) {
            if (student == studentId) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfModuleExists(String code) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, code);
    }

    public static int removeModulesFromCsv(String idNumber){
        if (checkIfModuleExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    public double[] getStudentMark(int studentId) {
        getFromCsvFile(this.code);
        ArrayList<Integer> students = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();
        for (int student : this.students) {
            students.add(student);
        }
        if (students.contains(studentId)) {
            for (String assignmentName : this.assignmentName) {
                if (Assignment.checkIfAssignmentExists(assignmentName)) {
                    Assignment assignment = new Assignment(assignmentName);
                    String result = assignment.getStudentMark(studentId);
                    if (result != null) {
                        marks.add(Double.parseDouble(result));
                    }
                }
            }
        } else {
            System.out.println("Student with ID " + studentId + " does not exist in module with Code " + this.getCode());
            return null;
        }
        double[] marks2 = new double[marks.size()];
        for (int i = 0; i < marks.size(); i++) {
            marks2[i] = marks.get(i);
        }
        return marks2;
    }

    @Override
    public String toString() {
        if ( this.name == null || this.code == null || this.students == null || this.teacher == 0 ) {
            getFromCsvFile(this.code);
        }
        return "Module " + 
                "name: " + name +
                ", code: " + code + 
                ", students: " + Arrays.toString(students) +
                ", teacher: " + teacher +
                ", assignmentName: " + assignmentName;
    }
}
