import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentMenu {
    private static Scanner scanner;
    private Student student;
    
    private static final int CHECK_QCA_YEAR = 1;
    private static final int CHECK_PROGRAMME_INT = 2;
    private static final int CHECK_MODULE_INT = 3;
    private static final int CHECK_DEPARTMENT_INT = 4;
    private static final int CHECK_MODULE_GRADE_INT = 5;
    private static final int CHECK_PASSING_INT = 6;
    private static final int EXIT_INT = 7;

    private static final String CHOOSE_OPTION = "Choose an option: ";
    private static final String CHECK_QCA_YEAR_STRING = " : Check QCA for the whole year";
    private static final String CHECK_PROGRAMME_STRING = " : Check Programme";
    private static final String CHECK_MODULE_STRING = " : Check Module";
    private static final String CHECK_DEPARTMENT_STRING = " : Check Department";
    private static final String CHECK_MODULE_GRADE_STRING = " : Check Module Grade";
    private static final String CHECK_PASSING_STRING = " : Check Passing";
    private static final String EXIT_STRING = " : Exit";


    public StudentMenu(Student student, Scanner scanner) {
        this.student = student;
        StudentMenu.scanner = scanner;
    }

    /**
     * The start method is used to start the Student menu
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
            }

        }
    }

    /**
     * The menuOutput method is used to output the menu
     */
    private void menuOutput() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(CHOOSE_OPTION).append("\n")
            .append(CHECK_QCA_YEAR).append(CHECK_QCA_YEAR_STRING).append("\n")
            .append(CHECK_PROGRAMME_INT).append(CHECK_PROGRAMME_STRING).append("\n")
            .append(CHECK_MODULE_INT).append(CHECK_MODULE_STRING).append("\n")
            .append(CHECK_DEPARTMENT_INT).append(CHECK_DEPARTMENT_STRING).append("\n")
            .append(CHECK_MODULE_GRADE_INT).append(CHECK_MODULE_GRADE_STRING).append("\n")
            .append(CHECK_PASSING_INT).append(CHECK_PASSING_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb);
    }

    /**
     * The readUserInput method is used to read the user input
     * @return the user input
     */
    private int readUserInput() {
        return InputUtils.scanInt(scanner);
    }

    /**
     * The InputProcessing method is used to process the user input
     * @param userInput the user input
     * @throws StudentRecordSystemException if the user input is not valid
     */
    private void InputProcessing(int userInput) throws StudentRecordSystemException{
        switch (userInput) {
            case CHECK_QCA_YEAR:
                checkQCA();
                break;
            case CHECK_PROGRAMME_INT:
                checkProgramme();
                break;
            case CHECK_MODULE_INT:
                checkModule();
                break;
            case CHECK_DEPARTMENT_INT:
                checkDepartment();
                break;
            case CHECK_MODULE_GRADE_INT:
                checkModuleGrade();
                break;
            case CHECK_PASSING_INT:
                checkPassing();
                break;
            case EXIT_INT:
                System.out.println("Exiting to Main Menu");
                break;
            default:
                throw new StudentRecordSystemException(userInput + " is not a valid option");
        }
    }

    /**
     * The checkQCA method is used to get the QCA of a student
     */
    public void checkQCA() {
        System.out.println(this.student.getQcaYear());
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

    /**
     * The checkDepartment method is used to get the information of a department
     */
    public void checkDepartment() {
        System.out.println("Input Department id: ");
        int id = InputUtils.scanInt(scanner);
        if(Department.checkIfDepartmentExists(id)) {
            Department department = new Department(id);
            System.out.println(department);
        } else {
            System.out.println("Department does not exist");
        }
    }

    /**
     * The checkModuleGrade method is used to get the grade of a module
     */
    public void checkModuleGrade() {
        System.out.println("Input Module code: ");
        String code = InputUtils.scanString(scanner);
        if(Modules.checkIfModuleExists(code)) {
            double[] result = new Modules(code).getStudentMark(this.student.getIdNumber());
            for (Double d : result ) {
                System.out.println(d);
            }
        } else {
            System.out.println("Module does not exist");
        }
    }

    /**
     * The checkPassing method is used to check if a student is passing
     */
    public void checkPassing() {
        ExaminationBoard examinationBoard = new ExaminationBoard(new Programme(this.student.getProgram()));
        String resutl = examinationBoard.checkQca(3, this.student);
        System.out.println(resutl);
    }
}
