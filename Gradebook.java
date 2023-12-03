import java.util.ArrayList;
/**
 * Gradebook class is a class that stores the information of a gradebook
 */
public class Gradebook {
    // letterGrade = {"NG", "F", "D2", "D1", "C3", "C2", "C1", "B3", "B2", "B1", "A2", "A1"};
    private double[] testscores;

    /**
     * Constructor for objects of class Gradebook
     */
    public Gradebook() {
        testscores = new double[3];
    }

    /**
     * Constructor for objects of class Gradebook
     * @param numTests of the gradebook
     */
    public Gradebook(int numTests) {
        testscores = new double[numTests];
    }

    /**
     * Setter for the score of the gradebook
     * @param i the index of the score
     * @param value the value of the score
     */
    public void setScore(int i, double value) {
        testscores[i] = value;
    }

    /**
     * Getter for the score of the gradebook
     * @param i the index of the score
     * @return the score of the gradebook
     */
    public double getScore(int i) {
        return testscores[i];
    }

    /**
     * Getter for the total score of the gradebook
     * @return the total score of the gradebook
     */
    public double getTotal() {
        double result = 0;
        for (double score : testscores) {
            result += score;
        }
        return result;
    }

    /**
     * Getter for the average score of the gradebook
     * @return the average score of the gradebook
     */
    public double calculateAvgScore() {
        double testTotal = 0;

        for (double score : testscores) {
            testTotal += score;
        }

        return testTotal / testscores.length;
    }

    /**
     * Getter for the grade of the gradebook
     * @return the grade of the gradebook
     */
    public String getGrade() {
        double score = calculateAvgScore();

        if (score >= 80) {
            return "A1";
        } else if (score >= 72) {
            return "A2";
        } else if (score >= 64) {
            return "B1";
        } else if (score >= 60) {
            return "B2";
        } else if (score >= 56) {
            return "B3";
        } else if (score >= 52) {
            return "C1";
        } else if (score >= 48) {
            return "C2";
        } else if (score >= 40) {
            return "C3";
        } else if (score >= 35) {
            return "D1";
        } else if (score >= 30) {
            return "D2";
        } else if (score >= 1) {
            return "F";
        } else {
            return "NG";
        }
    }

    /**
     * Getter for the letter grades of the gradebook
     * @param student the student
     * @return the letter grades of the gradebook
     */
    public String[] getLetterGrades(Student student) {
        Programme programme = new Programme(student.getProgram());
        ArrayList<Modules> modules = programme.getModules();
        ArrayList<String> letterGrades = new ArrayList<>();
        for (Modules module : modules) {
            ArrayList<Double> AssignmentScores = new ArrayList<>();
            if (module.getAssignmentName() == null) {
                continue;
            }
            for (String assignmentName : module.getAssignmentName()) {
                String grade  = new Assignment(assignmentName).getStudentMark(student.getIdNumber());
                if (grade != null) {
                    AssignmentScores.add(Double.parseDouble(grade));
                }
                this.testscores = new double[AssignmentScores.size()];
                for (int i = 0; i < AssignmentScores.size(); i++) {
                    this.testscores[i] = AssignmentScores.get(i);
                }
                letterGrades.add(getGrade());
            }
        }
        String[] result = new String[letterGrades.size()];
        for (int i = 0; i < letterGrades.size(); i++) {
            result[i] = letterGrades.get(i);
        }
        return result;
    }

    /**
     * Getter for the string representation of the gradebook
     * @return the string representation of the gradebook
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (double score : testscores) {
            result.append(score);
            result.append(',');
        }
        result.append(getGrade());

        return result.toString();
    }
}
