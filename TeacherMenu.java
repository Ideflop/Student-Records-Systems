import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class TeacherMenu {
    private Teacher teacher;

    private static Scanner scanner;

    private static final int CREATE_ASSIGNMENT_INT = 1;
    private static final int ADD_STUDENT_MARKS_INT = 2;
    private static final int UPDATE_STUDENT_MARKS_INT = 3;
    private static final int REMOVE_STUDENT_FROM_MODULE_INT = 4;
    private static final int CHECK_ASSIGNMENT_INT = 5;
    private static final int CHECK_STUDENT_IN_MODULE_INT = 6;
    private static final int CHECK_STUDENT_IN_PROGRAMME_INT = 7;
    private static final int CHECK_STUDENT_MARKS_INT = 8;
    private static final int CHECK_MODULE_INT = 9;
    private static final int CHECK_PROGRAMME_INT = 10;
    private static final int CHECK_STUDENT_INT = 11; 
    private static final int EXIT_INT = 12;
    // if from departemnt then can loggin as departement peopele

    private static final String CHOOSE_STRING = "Choose an option: ";
    private static final String CREATE_ASSIGNMENT_STRING = " : Create an Assignment";
    private static final String ADD_STUDENT_MARKS_STRING = " : Add Student Marks";
    private static final String UPDATE_STUDENT_MARKS_STRING = " : Update Student Marks";
    private static final String REMOVE_STUDENT_FROM_MODULE_STRING = " : Remove Student from Module";
    private static final String CHECK_ASSIGNMENT_STRING = " : Check an Assignment";
    private static final String CHECK_STUDENT_IN_MODULE_STRING = " : Check Students in a Module";
    private static final String CHECK_STUDENT_IN_PROGRAMME_STRING = " : Check Students in a Program";
    private static final String CHECK_STUDENT_MARKS_STRING = " : Check Student Marks";
    private static final String CHECK_MODULE_STRING = " : Check a Module";
    private static final String CHECK_PROGRAMME_STRING = " : Check a Program";
    private static final String CHECK_STUDENT_STRING = " : Check a Student";
    private static final String EXIT_STRING = " : Exit to Main Menu";

    /**
     * This is the constructor for the TeacherMenu class
     * @param teacher the teacher that is logged in
     */
    public TeacherMenu(Teacher teacher, Scanner scanner) {
        this.teacher = teacher;
        TeacherMenu.scanner = scanner;
    }

    /**
     * The start method is used to access the teacher actions
     */
    public void start() {
        int userInput = 0;
        while (userInput != EXIT_INT) {
            try {
                menuOutput();
                userInput = readUserInput();
                InputProcessing(userInput);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }
    }

    /**
     * This method is used to output the menu
     */
    private void menuOutput() {
        StringBuilder sb = new StringBuilder();

        sb.append(CHOOSE_STRING).append("\n")
            .append(CREATE_ASSIGNMENT_INT).append(CREATE_ASSIGNMENT_STRING).append("\n")
            .append(ADD_STUDENT_MARKS_INT).append(ADD_STUDENT_MARKS_STRING).append("\n")
            .append(UPDATE_STUDENT_MARKS_INT).append(UPDATE_STUDENT_MARKS_STRING).append("\n")
            .append(REMOVE_STUDENT_FROM_MODULE_INT).append(REMOVE_STUDENT_FROM_MODULE_STRING).append("\n")
            .append(CHECK_ASSIGNMENT_INT).append(CHECK_ASSIGNMENT_STRING).append("\n")
            .append(CHECK_STUDENT_IN_MODULE_INT).append(CHECK_STUDENT_IN_MODULE_STRING).append("\n")
            .append(CHECK_STUDENT_IN_PROGRAMME_INT).append(CHECK_STUDENT_IN_PROGRAMME_STRING).append("\n")
            .append(CHECK_STUDENT_MARKS_INT).append(CHECK_STUDENT_MARKS_STRING).append("\n")
            .append(CHECK_MODULE_INT).append(CHECK_MODULE_STRING).append("\n")
            .append(CHECK_PROGRAMME_INT).append(CHECK_PROGRAMME_STRING).append("\n")
            .append(CHECK_STUDENT_INT).append(CHECK_STUDENT_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb);
    }

    /**
     * This method is used to read the user input
     * @return the user input
     */
    private int readUserInput() {
        return InputUtils.scanInt(scanner);
    }

    /**
     * This method is used to process the user input
     * @param userInput the user input
     */
    private void InputProcessing(int userInput) {
        switch(userInput) {
            case CREATE_ASSIGNMENT_INT:
                createAssignment();
                break;
            case ADD_STUDENT_MARKS_INT:
                addStudentMarks();
                break;
            case UPDATE_STUDENT_MARKS_INT:
                updateStudentMarks();
                break;
            case REMOVE_STUDENT_FROM_MODULE_INT:
                removeStudentFromModule();
                break;
            case CHECK_ASSIGNMENT_INT:
                checkAssignment();
                break;
            case CHECK_STUDENT_IN_MODULE_INT:
                checkStudentInModule();
                break;
            case CHECK_STUDENT_IN_PROGRAMME_INT:
                checkStudentInProgramme();
                break;
            case CHECK_STUDENT_MARKS_INT:
                checkStudentMarks();
                break;
            case CHECK_MODULE_INT:
                checkModule();
                break;
            case CHECK_PROGRAMME_INT:
                checkProgramme();
                break;
            case CHECK_STUDENT_INT:
                checkStudent();
                break;
            case EXIT_INT:
                System.out.println("Exiting to Main Menu");
                break;
            default:
                System.out.println(userInput + " is not a valid option");
                break;
        }
    }

    /**
     * The createAssignment method is used to create an assignment
     */
    public void createAssignment() {
        System.out.println("Input Assignment code: ");
        String code = InputUtils.scanString(scanner);
        if (Assignment.checkIfAssignmentExists(code)) {
            System.out.println("Assignment already exists");
            return;
        }

        System.out.println("Input modules code: ");
        String moduleCode = InputUtils.scanString(scanner);
        if (!Modules.checkIfModuleExists(moduleCode)) {
            System.out.println("Module does not exist");
            return;
        }

        System.out.println("Input Assignment name: ");
        String name = InputUtils.scanString(scanner);
        System.out.println("Input Assignment out of: ");
        int outOf = InputUtils.scanInt(scanner);
        System.out.println("Add students and mark: ");
        ArrayList<Integer> students = new ArrayList<>();
        ArrayList<Double> studentsMarks = new ArrayList<>();

        while(true) {
            System.out.println("Do you want to add a student? (y/n)");
            String input = InputUtils.scanString(scanner);
            if(input.equals("y")) {
                System.out.println("Input student id: ");
                int id = InputUtils.scanInt(scanner);
                if(Student.checkStudentExists(id)) {
                    students.add(id);
                    System.out.println("Input student mark: ");
                    double mark = InputUtils.scanDouble(scanner);
                    studentsMarks.add(mark);
                } else {
                    System.out.println("Student does not exist");
                }
            } else if(input.equals("n")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }


        int[] studentsArray = new int[students.size()];
        double[] studentsMarksArray = new double[studentsMarks.size()];
        for(int i = 0; i < students.size(); i++) {
            studentsArray[i] = students.get(i);
            studentsMarksArray[i] = studentsMarks.get(i);
        }
        Assignment assignment = new Assignment(name, code, outOf, studentsArray, studentsMarksArray); 
        assignment.setModuleCode(moduleCode);
        assignment.addToCsvFile();
    }

    /**
     * The addStudentMarks method is used to add marks to a student
     */
    public void addStudentMarks() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            System.out.println("Input Assignment code: ");
            String assignmentCode = InputUtils.scanString(scanner);
            if(Assignment.checkIfAssignmentExists(assignmentCode)) {
                Assignment assignment = new Assignment(assignmentCode);
                System.out.println("Input mark: ");
                int mark = InputUtils.scanInt(scanner);
                assignment.addMarkToStudent(id, mark);
            } else {
                System.out.println("Assignment does not exist");
            }
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The updateStudentMarks method is used to update a students marks
     */
    public void updateStudentMarks() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            System.out.println("Input Assignment code: ");
            String assignmentCode = InputUtils.scanString(scanner);
            if(Assignment.checkIfAssignmentExists(assignmentCode)) {
                Assignment assignment = new Assignment(assignmentCode);
                System.out.println("Input new mark: ");
                int mark = InputUtils.scanInt(scanner);
                assignment.updateStudentMark(id, mark);
            } else {
                System.out.println("Assignment does not exist");
            }
        } else {
            System.out.println("Student does not exist");
        }
    }


    /**
     * The removeStudentFromModule method is used to remove a student from a module
     */
    public void removeStudentFromModule() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            this.teacher.removeStudentFromModule(id);
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The checkStudentInModule method is used to check if a student is in a module
     */
    public void checkStudentInModule() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            if(this.teacher.checkIfStudentExistsInModule(id)) {
                System.out.println("Student is in module");
            } else {
                System.out.println("Student is not in module");
            }
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The checkStudentInProgramme method is used to check if a student is in a programme
     */
    public void checkStudentInProgramme() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            System.out.println("Input Programme code: ");
            String code = InputUtils.scanString(scanner);
            if(Programme.checkIfProgrammeExists(code)) {
                Programme programme = new Programme(code);
                if(programme.checkIfStudentExists(id)) {
                    System.out.println("Student is in programme");
                } else {
                    System.out.println("Student is not in programme");
                }
            } else {
                System.out.println("Programme does not exist");
            }
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The checkStudentMarks method is used to check the marks of a student
     */
    public void checkStudentMarks() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            System.out.println("Input Assignment code: ");
            String code = InputUtils.scanString(scanner);
            if(Assignment.checkIfAssignmentExists(code)) {
                Assignment assignment = new Assignment(code);
                System.out.println(assignment.getStudentMark(id));
            } else {
                System.out.println("Assignment does not exist");
            }
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The checkAssignment method is used to get the information of an assignment
     */
    public void checkAssignment() {
        System.out.println("Input Assignment code: ");
        String code = InputUtils.scanString(scanner);
        if(Assignment.checkIfAssignmentExists(code)) {
            Assignment assignment = new Assignment(code);
            System.out.println(assignment);
        } else {
            System.out.println("Assignment does not exist");
        }
    }


    /**
     * The checkStudent method is used to get the information of a student
     */
    public void checkStudent() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            Student student = new Student(id);
            System.out.println(student);
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The checkModule method is used to get the information of a module
     */
    public void checkModule() {
        System.out.println("Input Module code: ");
        String code = InputUtils.scanString(scanner);
        if(Modules.checkIfModuleExists(code)) {
            Modules module = new Modules(code);
            System.out.println(module);
        } else {
            System.out.println("Module does not exist");
        }
    }

    /**
     * The checkProgramme method is used to get the information of a program
     */
    public void checkProgramme() {
        System.out.println("Input Program name: ");
        String name = InputUtils.scanString(scanner);
        if(Programme.checkIfProgrammeExists(name)) {
            Programme programme = new Programme(name);
            System.out.println(programme);
        } else {
            System.out.println("Program does not exist");
        }
    }
}
