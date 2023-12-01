import java.util.ArrayList;
public class Department
{
    String name;
    int deptID;
    ExaminationBoard examBoard; // for each dpartment
    ArrayList<Programme> programmes;
    public Department(String n, int ID) {
        setName(n);
        setID(ID);
    }
    public void setName(String n) {this.name = n;}
    public void setID(int id) {this.deptID = id;}
    public void addProgramme(Programme prog) {
        if (!this.programmes.contains(prog)) {
            this.programmes.add(prog);
        }
    }
    public void examTime() {
        for (Programme p : programmes) {
            ExaminationBoard examBoard = new ExaminationBoard(p, p.passingQca); 
            
        }
    }
    // What should this return?
    @Override
    public String toString() {
        String output = "";
        return output;
    }
}
