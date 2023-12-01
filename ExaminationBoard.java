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
    // what data types do i need?
    Programme programme;
    double passingQca = 1.2; // stand in variable
    ArrayList<Student> students;
    public ExaminationBoard(Programme programme, double passingQca) {
        this.programme = programme;
        this.passingQca = passingQca;
        this.students = getStudents();
    }
    public ArrayList<Student> getStudents() {return programme.getStudentsEnrolled();}
    public double getQcaSem1(Student student) {return student.getQcaSem1();}
    public double getQcaSem2(Student student) {return student.getQcaSem2();}
    public double getQca(Student student) {return student.getQcaYear();}
    public boolean passFail(double qcaToCheck) {
        boolean pass = false;
        if (qcaToCheck >= passingQca) {
            pass = true;
        }
        return pass;
    }
    // // 1 for sem1, 2 for sem2, 3 for year
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
            if (passFail(getQca(s))) {
                output += String.format("%f - PASS", getQca(s));
            }else {
                output += String.format("%f - FAIL", getQca(s));
            }
        }
        return output;
    }
    
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
