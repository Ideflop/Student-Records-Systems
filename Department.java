import java.util.ArrayList;
public class Department
{
    String name;
    int deptID;
    ExaminationBoard examBoard; // for each dpartment
    ArrayList<Programme> programmes;
    ArrayList<Modules> modules;
    public Department(String n, int ID) {
        
    }
    public void setName(String n) {this.name = n;}
    public void setID(int id) {this.deptID = id;}
    public void addProgramme(Programme prog) {
        if (!this.programmes.contains(prog)) {
            this.programmes.add(prog);
        }
    }
    // create exam board for all programmes
    
}
