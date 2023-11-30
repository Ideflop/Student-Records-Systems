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
    public ExaminationBoard() {}
    // check with Assessment class to get grade schema
    // check each student QCA against schema for that module
    // return pass or fail
    public double getQca(Student student) {return student.getQcaYear();}
    public boolean passFail() {
        boolean pass = false;
        return pass;
    }
}
