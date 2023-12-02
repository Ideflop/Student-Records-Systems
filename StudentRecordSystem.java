import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class StudentRecordSystem is used to run the Student Record System.
 * It uses a cli interface to interact with the user.
 */
public class StudentRecordSystem {
    private static Scanner scanner = InputUtils.scanOpen();
    private TeacherMenu teacherMenu; 
    private AdministratorMenu administratorMenu;

    private static final int STUDENT_INT = 1;
    private static final int TEACHER_INT = 2;
    private static final int ADMINISTRTION_INT = 3;
    private static final int CHECK_MODULE_INT = 4;
    private static final int CHECK_PROGRAMME_INT = 5;
    private static final int CHECK_DEPARTMENT_INT = 6;
    private static final int EXIT_INT = 7;

    private static final String CHOOSE_STRING = "Choose an option: ";
    private static final String STUDENT_STRING = " : I am a Student";
    private static final String TEACHER_STRING = " : I am a Teacher";
    private static final String ADMINISTRTION_STRING = " : I am an Administrator";
    private static final String CHECK_MODULE_STRING = " : Check a Module";
    private static final String CHECK_PROGRAMME_STRING = " : Check a Program";
    private static final String CHECK_DEPARTMENT_STRING = " : Check a Department";
    private static final String EXIT_STRING = " : Exit";


    /**
     * The main method is used to run the Student Record System
     * @param args the command line arguments (not used)
     */
    public static void main( String[] args) {
        new StudentRecordSystem().start();
    }

    /**
     * The start method is used to start the Student Record System
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

        sb.append("\n")
            .append(CHOOSE_STRING).append("\n")
            .append(STUDENT_INT).append(STUDENT_STRING).append("\n")
            .append(TEACHER_INT).append(TEACHER_STRING).append("\n")
            .append(ADMINISTRTION_INT).append(ADMINISTRTION_STRING).append("\n")
            .append(CHECK_MODULE_INT).append(CHECK_MODULE_STRING).append("\n")
            .append(CHECK_PROGRAMME_INT).append(CHECK_PROGRAMME_STRING).append("\n")
            .append(CHECK_DEPARTMENT_INT).append(CHECK_DEPARTMENT_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>>");

        System.out.print(sb);
    }

    /**
     * This method is used to read the user input and return it
     * @return userInput as an Integer
     */
    private int readUserInput() {
        int userInput = InputUtils.scanInt(scanner);
        return userInput;
    }

    /**
     * This method is used to process the user input
     * @param userInput the user input
     */
    private void InputProcessing(int userInput) {
        switch(userInput) {
            case STUDENT_INT:
                //TODO
                break;
            case TEACHER_INT:
                teacherLogIn();
                break;
            case ADMINISTRTION_INT:
                administrationLogIn();
                break;
            case CHECK_MODULE_INT:
                checkModule();
                break;
            case CHECK_PROGRAMME_INT:
                checkProgramme();
                break;
            case CHECK_DEPARTMENT_INT:
                checkDepartment();
                break;
            case EXIT_INT:
                System.out.println("Exit");
                InputUtils.scanClose(scanner);
                break;
            default:
                System.out.println(userInput + " is not a valid option");
                break;
        }

    }

    /**
     * This method is used to log in as a teacher
     */
    private void teacherLogIn() {
        System.out.println("Input your username: ");
        String username = InputUtils.scanString(scanner);
        System.out.println("Input your id number: ");
        int id = InputUtils.scanInt(scanner);
        
        if (Teacher.checkIfTeacherExists(id)) {
            Teacher teacher = new Teacher(id);
            teacher.getTeacherFromCSV();
            if (teacher.getName().equals(username)) {
                System.out.println("Welcome " + teacher.getName());
                this.teacherMenu = new TeacherMenu(teacher, scanner);
                this.teacherMenu.start();
            } else {
                System.out.println("Wrong username");
            }
        } else {
            System.out.println("Teacher with ID Number " + id + " does not exist.");
        }
        
    }

    /**
     * This method is used to log in as an administrator
     */
    private void administrationLogIn() {
        System.out.println("Input your username: ");
        String username = InputUtils.scanString(scanner);
        System.out.println("Input your id number: ");
        int id = InputUtils.scanInt(scanner);
        
        if (Administrator.checkIfAdministratorExists(id)) {
            Administrator administrator = new Administrator(id);
            administrator.getAdministratorFromCSV();
            if (administrator.getName().equals(username)) {
                System.out.println("Welcome " + administrator.getName());
                this.administratorMenu = new AdministratorMenu(administrator, scanner);
                this.administratorMenu.start();
            } else {
                System.out.println("Wrong username");
            }
        } else {
            System.out.println("Administrator with ID Number " + id + " does not exist.");
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

}
