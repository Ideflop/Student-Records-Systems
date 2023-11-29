import java.util.Scanner;
import java.util.InputMismatchException;

public class TeacherMenu {
    private Teacher teacher;

    private static Scanner scanner = InputUtils.scanOpen();

    private static final int CHECK_STUDENT_IN_MODULE_INT = 1;
    private static final int CHECK_STUDENT_IN_PROGRAM_INT = 2;
    private static final int CHECK_STUDENT_MARKS_INT = 3;
    private static final int UPDATE_STUDENT_MARKS_INT = 4;
    private static final int CREATE_ASSIGNMENT_INT = 5;
    private static final int CHECK_ASSIGNMENT_INT = 6;
    private static final int CHECK_MODULE_INT = 7;
    private static final int ADD_STUDENT_MARKS_INT = 8;
    private static final int CHECK_PROGRAM_INT = 9;
    private static final int CHECK_STUDENT_INT = 10; 
    private static final int REMOVE_STUDENT_FROM_MODULE_INT = 11;
    // if from departemnt then can loggin as departement peopele


    /**
     * This is the constructor for the TeacherMenu class
     * @param teacher the teacher that is logged in
     */
    public TeacherMenu(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * The start method is used to access the teacher actions
     */
    public void start() {
        int userInput = 0;
        while (userInput != 6) {
            try {
                //menuOutput();
                //userInput = readUserInput();
                //InputProcessing(userInput);
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
    
}
