// get modules from programme student is on
// get results for each module
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class StudentResults
{
    Student student;
    Map<String, Double> moduleResults;
    StudentResults() {
        moduleResults = new HashMap<>();
    }
    StudentResults(Student s) {
        this.student = s;
        moduleResults = new HashMap<>();
    }
    
    public void setResult(String moduleCode, double score) {
        moduleResults.put(moduleCode, score);
    }
    public double getResult(String moduleCode) {return moduleResults.get(moduleCode);}
    
    String output;
    @Override
    public String toString() { // student name, id and programme and module id and result
        output = String.format("%d(%s) - %s\n", student.getIdNumber(), student.getName(), student.getProgram());
        moduleResults.forEach((key, value) -> {
            String addToOutput = String.format("%s: %.2f, ", key, value);
            output += addToOutput;
        });
        return output.substring(0, output.length() - 2);//removes  last comma and whitespace;
    }
}
