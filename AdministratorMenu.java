import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class AdministratorMenu {
    private Administrator administrator;
    private static Scanner scanner;

    private static final int ADD_STUDENT_INT = 1;
    private static final int ADD_TEACHER_INT = 2;
    private static final int ADD_ADMINISTRATOR_INT = 3;
    private static final int ADD_MODULE_INT = 4;
    private static final int ADD_PROGRAMME_INT = 5;
    private static final int ADD_DEPARTMENT_INT = 6;
    private static final int REMOVE_STUDENT_INT = 7;
    private static final int REMOVE_TEACHER_INT = 8;
    private static final int REMOVE_ADMINISTRATOR_INT = 9;
    private static final int REMOVE_MODULE_INT = 10;
    private static final int REMOVE_PROGRAMME_INT = 11;
    private static final int REMOVE_DEPARTMENT_INT = 12;
    private static final int CHECK_STUDENT_INT = 13;
    private static final int CHECK_TEACHER_INT = 14;
    private static final int CHECK_ADMINISTRATOR_INT = 15;
    private static final int CHECK_MODULE_INT = 16;
    private static final int CHECK_PROGRAMME_INT = 17;
    private static final int CHECK_DEPARTMENT_INT = 18;
    private static final int EXIT_INT = 19;

    private static final String CHOICE_STRING = "Please enter your choice: ";
    private static final String ADD_STUDENT_STRING = " : Add a Student";
    private static final String ADD_TEACHER_STRING = " : Add a Teacher";
    private static final String ADD_ADMINISTRATOR_STRING = " : Add an Administrator";
    private static final String ADD_MODULE_STRING = " : Add a Module";
    private static final String ADD_PROGRAMME_STRING = " : Add a Program";
    private static final String ADD_DEPARTMENT_STRING = " : Add a Department";
    private static final String REMOVE_STUDENT_STRING = " : Remove a Student";
    private static final String REMOVE_TEACHER_STRING = " : Remove a Teacher";
    private static final String REMOVE_ADMINISTRATOR_STRING = " : Remove an Administrator";
    private static final String REMOVE_MODULE_STRING = " : Remove a Module";
    private static final String REMOVE_PROGRAMME_STRING = " : Remove a Program";
    private static final String REMOVE_DEPARTMENT_STRING = " : Remove a Department";
    private static final String CHECK_STUDENT_STRING = " : Check a Student";
    private static final String CHECK_TEACHER_STRING = " : Check a Teacher";
    private static final String CHECK_ADMINISTRATOR_STRING = " : Check an Administrator";
    private static final String CHECK_MODULE_STRING = " : Check a Module";
    private static final String CHECK_PROGRAMME_STRING = " : Check a Program";
    private static final String CHECK_DEPARTMENT_STRING = " : Check a Department";
    private static final String EXIT_STRING = " : Exit to Main Menu";


    public AdministratorMenu(Administrator administrator, Scanner scanner) {
        this.administrator = administrator;
        AdministratorMenu.scanner = scanner;
    }

    /**
     * The start method is used to access the Administrator actions
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
     * The readUserInput method is used to read the user input
     * @return the user input
     */
    private int readUserInput() {
        return scanner.nextInt();
    }

    /**
     * The menuOutput method is used to output the Administrator menu
     */
    private void menuOutput() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n")
            .append(CHOICE_STRING).append("\n")
            .append(ADD_STUDENT_INT).append(ADD_STUDENT_STRING).append("\n")
            .append(ADD_TEACHER_INT).append(ADD_TEACHER_STRING).append("\n")
            .append(ADD_ADMINISTRATOR_INT).append(ADD_ADMINISTRATOR_STRING).append("\n")
            .append(ADD_MODULE_INT).append(ADD_MODULE_STRING).append("\n")
            .append(ADD_PROGRAMME_INT).append(ADD_PROGRAMME_STRING).append("\n")
            .append(ADD_DEPARTMENT_INT).append(ADD_DEPARTMENT_STRING).append("\n")
            .append(REMOVE_STUDENT_INT).append(REMOVE_STUDENT_STRING).append("\n")
            .append(REMOVE_TEACHER_INT).append(REMOVE_TEACHER_STRING).append("\n")
            .append(REMOVE_ADMINISTRATOR_INT).append(REMOVE_ADMINISTRATOR_STRING).append("\n")
            .append(REMOVE_MODULE_INT).append(REMOVE_MODULE_STRING).append("\n")
            .append(REMOVE_PROGRAMME_INT).append(REMOVE_PROGRAMME_STRING).append("\n")
            .append(REMOVE_DEPARTMENT_INT).append(REMOVE_DEPARTMENT_STRING).append("\n")
            .append(CHECK_STUDENT_INT).append(CHECK_STUDENT_STRING).append("\n")
            .append(CHECK_TEACHER_INT).append(CHECK_TEACHER_STRING).append("\n")
            .append(CHECK_ADMINISTRATOR_INT).append(CHECK_ADMINISTRATOR_STRING).append("\n")
            .append(CHECK_MODULE_INT).append(CHECK_MODULE_STRING).append("\n")
            .append(CHECK_PROGRAMME_INT).append(CHECK_PROGRAMME_STRING).append("\n")
            .append(CHECK_DEPARTMENT_INT).append(CHECK_DEPARTMENT_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>>");

        System.out.print(sb);
    }

    /**
     * The InputProcessing method is used to process the user input
     * @param userInput the user input
     */
    private void InputProcessing(int userInput) {
        switch(userInput) {
            case ADD_STUDENT_INT:
                addStudent();
                break;
            case ADD_TEACHER_INT:
                addTeacher();
                break;
            case ADD_ADMINISTRATOR_INT:
                addAdministrator();
                break;
            case ADD_MODULE_INT:
                addModule();
                break;
            case ADD_PROGRAMME_INT:
                addProgramme();
                break;
            case ADD_DEPARTMENT_INT:
                addDepartment();
                break;
            case REMOVE_STUDENT_INT:
                removeStudent();
                break;
            case REMOVE_TEACHER_INT:
                removeTeacher();
                break;
            case REMOVE_ADMINISTRATOR_INT:
                removeAdministrator();
                break;
            case REMOVE_MODULE_INT:
                removeModule();
                break;
            case REMOVE_PROGRAMME_INT:
                removeProgramme();
                break;
            case REMOVE_DEPARTMENT_INT:
                removeDepartment();
                break;
            case CHECK_STUDENT_INT:
                checkStudent();
                break;
            case CHECK_TEACHER_INT:
                checkTeacher();
                break;
            case CHECK_ADMINISTRATOR_INT:
                checkAdministrator();
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
                System.out.println("Exiting to Main Menu");
                break;
            default:
                System.out.println(userInput + " is not a valid option");
                break;
        }
    }

    /**
     * The addStudent method is used to add a student
     */
    public void addStudent() {
        System.out.println("Input Student degree (bachelor: b, master: m, phd, p): ");
        String degree = InputUtils.scanString(scanner);
        System.out.println("Input Student name: ");
        String name = InputUtils.scanString(scanner);
        System.out.println("Input Student address: ");
        String address = InputUtils.scanString(scanner);
        System.out.println("Input Student phone number: ");
        String phoneNumber = InputUtils.scanString(scanner);
        System.out.println("Input Student email: ");
        String email = InputUtils.scanString(scanner);
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        System.out.println("Input Student program: ");
        String program = InputUtils.scanString(scanner);

        switch (degree) {
            case "b" -> {
                Undergraduate undergraduate = new Undergraduate(name, address, phoneNumber, email, id, program);
                undergraduate.addStudentToCsv();
            }
            case "m" -> {
                Masters masters = new Masters(name, address, phoneNumber, email, id, program);
                masters.addStudentToCsv();
            }
            case "p" -> {
                Phd phd = new Phd(name, address, phoneNumber, email, id, program);
                phd.addStudentToCsv();
            }
            default -> System.out.println("Invalid degree");
        }
        
    }

    /**
     * The addTeacher method is used to add a teacher
     */
    public void addTeacher() {
        System.out.println("Input Teacher name: ");
        String name = InputUtils.scanString(scanner);
        System.out.println("Input Teacher id number: ");
        int id = InputUtils.scanInt(scanner);
        System.out.println("Input Teacher college level: ");
        String collegeLevel = InputUtils.scanString(scanner);
        System.out.println("Input Teacher hone number: ");
        String phoneNumber = InputUtils.scanString(scanner);
        System.out.println("Input Teacher email: ");
        String email = InputUtils.scanString(scanner);
        System.out.println("Input Teacher address: ");
        String address = InputUtils.scanString(scanner);
        System.out.println("Input Teacher office: ");
        String office = InputUtils.scanString(scanner);
        System.out.println("Input Teacher modules: ");
        String modules = InputUtils.scanString(scanner);
        System.out.println("Is the Teacher on the examination board? (y/n)");
        String examBoard = InputUtils.scanString(scanner);

        boolean isExamBoard = examBoard.equals("y");

        Teacher teacher = new Teacher(name, address, collegeLevel, phoneNumber, email, office, id, modules, isExamBoard);
        teacher.addTeacherToCSV();
    }

    /**
     * The addAdministrator method is used to add an administrator
     */
    public void addAdministrator() {
        System.out.println("Input Administrator name: ");
        String name = InputUtils.scanString(scanner);
        System.out.println("Input Administrator id number: ");
        int id = InputUtils.scanInt(scanner);
        System.out.println("Input Administrator college level: ");
        String collegeLevel = InputUtils.scanString(scanner);
        System.out.println("Input Administrator hone number: ");
        String phoneNumber = InputUtils.scanString(scanner);
        System.out.println("Input Administrator email: ");
        String email = InputUtils.scanString(scanner);
        System.out.println("Input Administrator address: ");
        String address = InputUtils.scanString(scanner);

        Administrator administrator = new Administrator(name, phoneNumber, email, address, id, collegeLevel);
        administrator.addAdministrationToCSV();
    }

    /**
     * The addModule method is used to add a module
     */
    public void addModule() {
        System.out.println("Input Module name: ");
        String name = InputUtils.scanString(scanner);
        System.out.println("Input Module code: ");
        String code = InputUtils.scanString(scanner);
        if (Modules.checkIfModuleExists(code)) {
            System.out.println("Module already exists");
            return;
        }

        System.out.println("Add students to module: ");
        ArrayList<Integer> students = new ArrayList<>();
        while(true) {
            System.out.println("Add student to module? (y/n)");
            String addStudent = InputUtils.scanString(scanner);
            if(addStudent.equals("y")) {
                System.out.println("Input Student id number: ");
                int id = InputUtils.scanInt(scanner);
                if(Student.checkStudentExists(id)) {
                    students.add(id);
                } else {
                    System.out.println("Student does not exist");
                }
            } else {
                break;
            }
        }
        int[] studentsArray = new int[students.size()];
        for(int i = 0; i < students.size(); i++) {
            studentsArray[i] = students.get(i);
        }

        System.out.println("Input Module teacher id number: ");
        int teacher;
        while(true) {
            teacher = InputUtils.scanInt(scanner);
            if(Teacher.checkIfTeacherExists(teacher)) {
                break;
            } else {
                System.out.println("Teacher does not exist");
            }
        }

        Modules module = new Modules(name, code, studentsArray, teacher);
        module.addToCsvFile();
    }

    /**
     * The addProgramme method is used to add a program
     */
    public void addProgramme() {
        System.out.println("Input Program name: ");
        String name = InputUtils.scanString(scanner);
        if (Programme.checkIfProgrammeExists(name)) {
            System.out.println("Program already exists");
            return;
        }

        System.out.println("Input Program duration: ");
        String duration = InputUtils.scanString(scanner);
        System.out.println("Input Program level (undergraduate, masters, phd): ");
        String level = InputUtils.scanString(scanner);
        System.out.println("Input Program type: ");
        String type = InputUtils.scanString(scanner);
        System.out.println("Passing QCA: ");
        double qca = InputUtils.scanDouble(scanner);

        Programme program = new Programme(name, duration, level, type, qca);
        
        System.out.println("Do you want to add modules to the program? (y/n)");
        String addModules = InputUtils.scanString(scanner);
        if(addModules.equals("y")) {
            while(true) {
                System.out.println("Input Module code: ");
                String code = InputUtils.scanString(scanner);
                if(Modules.checkIfModuleExists(code)) {
                    program.addModule(new Modules(code));
                } else {
                    System.out.println("Module does not exist");
                }
                System.out.println("Add another module? (y/n)");
                String addAnother = InputUtils.scanString(scanner);
                if(addAnother.equals("n")) {
                    break;
                }
            }
        }

        System.out.println("Do you want to add students to the program? (y/n)");
        String addStudents = InputUtils.scanString(scanner);
        if(addStudents.equals("y")) {
            while(true) {
                System.out.println("Input Student id number: ");
                int id = InputUtils.scanInt(scanner);
                if(Student.checkStudentExists(id)) {
                    program.addStudent(new Student(id));
                } else {
                    System.out.println("Student does not exist");
                }
                System.out.println("Add another student? (y/n)");
                String addAnother = InputUtils.scanString(scanner);
                if(addAnother.equals("n")) {
                    break;
                }
            }
        }

        program.addToCsvFile();
    }

    /**
     * The addDepartment method is used to add a department
     */
    public void addDepartment() {
        System.out.println("Input Department name: ");
        String name = InputUtils.scanString(scanner);
        System.out.println("Input Department id number: ");
        int id = InputUtils.scanInt(scanner);
        if (Department.checkIfDepartmentExists(id)) {
            System.out.println("Department already exists");
            return;
        }

        Department department = new Department(name, id);

        System.out.println("Do you want to add programs to the department? (y/n)");
        String addPrograms = InputUtils.scanString(scanner);
        if(addPrograms.equals("y")) {
            while(true) {
                System.out.println("Input Program name: ");
                String programName = InputUtils.scanString(scanner);
                if(Programme.checkIfProgrammeExists(programName)) {
                    department.addProgramme(new Programme(programName));
                } else {
                    System.out.println("Program does not exist");
                }
                System.out.println("Add another program? (y/n)");
                String addAnother = InputUtils.scanString(scanner);
                if(addAnother.equals("n")) {
                    break;
                }
            }
        }

        System.out.println("Do you want to add modules to the department? (y/n)");
        String addModules = InputUtils.scanString(scanner);
        if(addModules.equals("y")) {
            while(true) {
                System.out.println("Input Module code: ");
                String code = InputUtils.scanString(scanner);
                if(Modules.checkIfModuleExists(code)) {
                    department.addModule(new Modules(code));
                } else {
                    System.out.println("Module does not exist");
                }
                System.out.println("Add another module? (y/n)");
                String addAnother = InputUtils.scanString(scanner);
                if(addAnother.equals("n")) {
                    break;
                }
            }
        }

        department.addToCsvFile();
    }

    /**
     * The removeStudent method is used to remove a student
     */
    public void removeStudent() {
        System.out.println("Input Student id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Student.checkStudentExists(id)) {
            if (Student.removeStudentFromCsv(id) == 0) {
                System.out.println("Student removed");
            } else {
                System.out.println("Student could not be removed");
            }
        } else {
            System.out.println("Student does not exist");
        }
    }

    /**
     * The removeTeacher method is used to remove a teacher
     */
    public void removeTeacher() {
        System.out.println("Input Teacher id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Teacher.checkIfTeacherExists(id)) {
            if (Teacher.removeTeacherFromCsv(id) == 0) {
                System.out.println("Teacher removed");
            } else {
                System.out.println("Teacher could not be removed");
            }
        } else {
            System.out.println("Teacher does not exist");
        }
    }

    /**
     * The removeAdministrator method is used to remove an administrator
     */
    public void removeAdministrator() {
        System.out.println("Input Administrator id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Administrator.checkIfAdministratorExists(id)) {
            if (Administrator.removeAdministratorFromCsv(id) == 0) {
                System.out.println("Administrator removed");
            } else {
                System.out.println("Administrator could not be removed");
            }
        } else {
            System.out.println("Administrator does not exist");
        }
    }

    /**
     * The removeModule method is used to remove a module
     */
    public void removeModule() {
        System.out.println("Input Module code: ");
        String code = InputUtils.scanString(scanner);
        if(Modules.checkIfModuleExists(code)) {
            if (Modules.removeModulesFromCsv(code) == 0) {
                System.out.println("Module removed");
            } else {
                System.out.println("Module could not be removed");
            }
        } else {
            System.out.println("Module does not exist");
        }
    }

    /**
     * The removeProgramme method is used to remove a program
     */
    public void removeProgramme() {
        System.out.println("Input Program name: ");
        String name = InputUtils.scanString(scanner);
        if(Programme.checkIfProgrammeExists(name)) {
            if (Programme.removeProgrammeFromCsv(name) == 0) {
                System.out.println("Program removed");
            } else {
                System.out.println("Program could not be removed");
            }
        } else {
            System.out.println("Program does not exist");
        }
    }

    /**
     * The removeDepartment method is used to remove a department
     */
    public void removeDepartment() {
        System.out.println("Input Department id: ");
        int id = InputUtils.scanInt(scanner);
        if(Department.checkIfDepartmentExists(id)) {
            if (Department.removeDepartmentFromCsv(id) == 0) {
                System.out.println("Department removed");
            } else {
                System.out.println("Department could not be removed");
            }
        } else {
            System.out.println("Department does not exist");
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
     * The checkTeacher method is used to get the information of a teacher
     */
    public void checkTeacher() {
        System.out.println("Input Teacher id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Teacher.checkIfTeacherExists(id)) {
            Teacher teacher = new Teacher(id);
            System.out.println(teacher);
        } else {
            System.out.println("Teacher does not exist");
        }
    }

    /**
     * The checkAdministrator method is used to get the information of an administrator
     */
    public void checkAdministrator() {
        System.out.println("Input Administrator id number: ");
        int id = InputUtils.scanInt(scanner);
        if(Administrator.checkIfAdministratorExists(id)) {
            Administrator administrator = new Administrator(id);
            System.out.println(administrator);
        } else {
            System.out.println("Administrator does not exist");
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
