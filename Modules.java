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

    /**
     * Constructor for objects of class Modules
     * @param code of the module
     */
    public Modules(String code) {
        this.code = code;
    }

    /**
     * Constructor for objects of class Modules
     * @param name of the module
     * @param code of the module
     * @param students of the module
     * @param teacher of the module
     */
    public Modules(String name, String code, int[] students, int teacher) {
        this.name = name;
        this.code = code;
        this.students = students;
        this.teacher = teacher;
    }

    /**
     * Getter for the name of the module
     * @return the name of the module
     */
    public String getName() { return this.name; }
    /**
     * Getter for the code of the module
     * @return the code of the module
     */
    public String getCode() { return this.code; }
    /**
     * Getter for the assignment name of the module
     * @return the assignment name of the module
     */
    public ArrayList<String> getAssignmentName() { 
        getFromCsvFile(this.code);
        return this.assignmentName; 
    }
    /**
     * Getter for the students of the module
     * @return the students of the module
     */
    public int[] getStudents() { return this.students; }
    /**
     * Getter for the teacher of the module
     * @return the teacher of the module
     */
    public int getTeacher() { return this.teacher; }

    /**
     * Setter for the name of the module
     * @param name of the module
     */
    public void setName(String name) { this.name = name; }
    /**
     * Setter for the code of the module
     * @param code of the module
     */
    public void setCode(String code) { this.code = code; }
    /**
     * Setter for the assignment name of the module
     * @param assignmentName of the module
     */
    public void setAssignmentName(ArrayList<String> assignmentName) { this.assignmentName = assignmentName; }
    /**
     * Setter for the students of the module
     * @param students of the module
     */
    public void setStudents(int[] students) { this.students = students; }
    /**
     * Setter for the teacher of the module
     * @param teacher of the module
     */
    public void setTeacher(int teacher) { this.teacher = teacher; }

    /**
     * Adds a new assignment name to the module
     * @param assignmentName of the module
     */
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
            }
            if (this.assignmentName != null) {
                for (String s : this.assignmentName) {
                    sb.append(",").append(s);
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
        getFromCsvFile(this.code);
        for (Integer student : this.students) {
            if (student == studentId) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to check if a module exists
     * @param code the code of the module
     * @return true if the module exists, false otherwise
     */
    public static boolean checkIfModuleExists(String code) {
        return CSVFileManager.checkIfLineExistsInCSVFile(FILE, code);
    }

    /**
     * This method is used to remove a module from the csv file
     * @param idNumber the id of the module
     * @return 0 if the module was removed successfully, -1 otherwise
     */
    public static int removeModulesFromCsv(String idNumber){
        if (checkIfModuleExists(idNumber)){
            return CSVFileManager.removeLineFromCSVFile(FILE, idNumber);
        }
        return -1;
    }

    /**
     * This method is used to add an assignment to a module
     * @param assignmentName the name of the assignment
     */
    public void addAssignmentToModule(String assignmentName) {
        getFromCsvFile(this.code);
        if (this.assignmentName == null) {
            this.assignmentName = new ArrayList<>();
        }
        this.assignmentName.add(assignmentName);
        removeModulesFromCsv(this.getCode());
        addToCsvFile();
    }

    /**
     * This method is used to get the mark of a student in a module
     * @param studentId the id of the student
     * @return the mark of the student
     */
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
                    System.out.println("Assignment Name: " + assignmentName);
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

    /**
     * To string method
     * @return the string representation of the module
     */
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
