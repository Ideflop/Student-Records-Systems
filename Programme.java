import java.util.ArrayList;
public class Programme
{
    String name;
    String duration;
    String level; //undergrad, postgrad
    String type; //taught, research
    double passingQca;
    ArrayList<Student> students;
    ArrayList<Modules> modules;
    public Programme(String name, String duration, String level, String type, double passingQca) {
        this.name = name;
        this.duration = duration;
        this.level = level;
        this.type = type;
        this.passingQca = passingQca;
    }
    public void setName(String n) {this.name = n;}
    public void setDuration(String d) {this.duration = d;}
    public void setLevel(String l) {this.level = l;}
    public void setType(String t) {this.type = t;}
    public void setPassingQca(double q) {this.passingQca = q;}
    
    public String getName() {return this.name;}
    public String getDuration() {return this.duration;}
    public String getLevel() {return this.level;}
    public String getType() {return this.type;}
    public double getPassingQca() {return this.passingQca;}
    
    public void addStudent(Student student) {
        if (!this.students.contains(student)){
            this.students.add(student);
        }
    }
    public void addModule(Modules module) {
        if (!this.modules.contains(module)) {
            this.modules.add(module);
        }
    }
    public ArrayList<Student> getStudentsEnrolled() {return this.students;}
    public ArrayList<Modules> getModules() {return this.modules;}
    
    @Override
    public String toString() {
        String output = String.format("%s (%s) - %s - %s\n", this.name, this.level, this.duration, this.type);
        return output;
    }
}
