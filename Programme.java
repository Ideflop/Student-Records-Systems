import java.util.ArrayList;
public class Programme
{
    String name;
    String duration;
    String level; //undergrad, postgrad
    String type; //taught, research
    ArrayList<Student> students;
    ArrayList<Modules> modules;
    public Programme(String name, String duration, String level, String type) {
        this.name = name;
        this.duration = duration;
        this.level = level;
        this.type = type;
    }
    public void setName(String n) {this.name = n;}
    public void setDuration(String d) {this.duration = d;}
    public void setLevel(String l) {this.level = l;}
    public void setType(String t) {this.type = t;}
    
    public String getName() {return this.name;}
    public String getDuration() {return this.duration;}
    public String getLevel() {return this.level;}
    public String getType() {return this.type;}
    
    public void addStudent(Student student) {
        if (!this.students.contains(student)){
            this.students.add(student);
        }
    }
    public ArrayList<Student> getStudentsEnrolled() {return this.students;}
    public void addModule(Modules module) {
        if (!this.modules.contains(module)) {
            this.modules.add(module);
        }
    }
    
}
