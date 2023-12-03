import java.util.ArrayList;
/**
 * Held at the end of each review period by Department to:
 * review student progression
 *  Students may be requested to repeat a module,
 *  link-in to modules,
 *  repeat semester/year,
 *  etc.
 */
public class ExaminationBoard
{
    private Programme programme;
    private double passingQca = 1.2; // stand in variable
    private ArrayList<Student> students;

    /**
     * Constructor for objects of class ExaminationBoard
     * @param programme of the examination board
     */
    public ExaminationBoard(Programme programme) {
        this.programme = programme;
        this.passingQca = programme.getPassingQca();
        this.students = getStudents();
    }

    /**
     * Getter for the students of the examination board
     * @return the students of the examination board
     */
    public ArrayList<Student> getStudents() {return programme.getStudentsEnrolled();}
    /**
     * Getter for the Qca sem1 of the student
     * @param student to get the Qca sem1
     * @return the Qca sem1 of the student
     */
    public double getQcaSem1(Student student) {return student.getQcaSem1();}
    /**
     * Getter for the Qca sem2 of the student
     * @param student to get the Qca sem2 of
     * @return the Qca sem2 of the student
     */
    public double getQcaSem2(Student student) {return student.getQcaSem2();}
    /**
     * Getter for the Qca of the student
     * @param student to get the Qca of
     * @return the Qca of the student
     */
    public double getQca(Student student) {return student.getQcaYear();}
    
    /**
     * check if the student has passed or failed
     * @param qcaToCheck the Qca to check
     * @return true if the student has passed, false if the student has failed
     */
    public boolean passFail(double qcaToCheck) {
        return qcaToCheck >= passingQca;
    }
    
    /**
     * check the Qca of the student
     * @param assessmentPeriod the assessment period to check 1 for sem1, 2 for sem2, 3 for year
     * @param s the student to check the Qca of
     * @return the Qca of the student
     */
    public String checkQca(int assessmentPeriod, Student s){
        String output = "";
        if (assessmentPeriod < 0) {return "Please select Assessment Period";}
        else if (assessmentPeriod == 0) { // Only results, no formatting (for CSVs)
            output += String.format("%s,%s,%s", getQcaSem1(s), getQcaSem2(s), getQca(s));
        } else if (assessmentPeriod == 1) { // Semester 1
            if (passFail(getQcaSem1(s))) {
                output += String.format("%f - PASS", getQcaSem1(s));
            } else {
                output += String.format("%f - FAIL", getQcaSem1(s));
            }
        } else if (assessmentPeriod == 2) { // Semester 2
            if (passFail(getQcaSem2(s))) {
                output += String.format("%f - PASS", getQcaSem2(s));
            } else {
                output += String.format("%f - FAIL", getQcaSem2(s));
            }
        } else if (assessmentPeriod == 3) { // Year
            double qca = getQca(s);
            if (passFail(qca)) {
                output += String.format("%f - PASS", qca);
            }else {
                output += String.format("%f - FAIL", qca);
            }
        }
        return output;
    }
    
    /**
     * To String method for the examination board
     * @return the string of the examination board
     */
    @Override
    public String toString(){ // display results for entire programme
        String output = String.format("%s", programme.toString());
        for (Student s : students) {
            output += String.format("%d(%s)\n%s", s.getIdNumber(), s.getName());
            output += String.format("Sem 1: %s\nSem2: %s\nYear : %s\n",
                checkQca(1,s), checkQca(2,s), checkQca(3,s));
        }
        return output;
    }
}
