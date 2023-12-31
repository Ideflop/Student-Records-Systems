import java.util.Scanner;
/**
 * QCAcalculator class is a class that calculates the QCA score of a student
 */
public class QCAcalculator {
    private int moduleNum;
    private double qcaScore;
    private double tempQca;
    private Scanner scanner;

    /**
     * Constructor for objects of class QCAcalculator
     */
    public QCAcalculator() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Getter for the qca score of the student
     * @return the qca score of the student
     */
    public double getQcaScore() {
        return qcaScore;
    }

    /**
     * Setter for the qca score of the student
     * @param qcaScore of the student
     */
    public void setQcaScore(double qcaScore) {
        this.qcaScore = qcaScore;
    }

    /** 
     * Calculates the QCA score of the student
     * @param student the student
     * @return the QCA score of the student
     */
    public double calculateQcaScore(Student student) {
        tempQca = 0.0;
        String[] letterGrades = new Gradebook().getLetterGrades(student);

        for (String grade : letterGrades) {
            switch (grade.toLowerCase()) {
                case "a1":
                    tempQca += 4.0;
                    break;
                case "a2":
                    tempQca += 3.6;
                    break;
                case "b1":
                    tempQca += 3.2;
                    break;
                case "b2":
                    tempQca += 3.0;
                    break;
                case "b3":
                    tempQca += 2.8;
                    break;
                case "c1":
                    tempQca += 2.6;
                    break;
                case "c2":
                    tempQca += 2.4;
                    break;
                case "c3":
                    tempQca += 2.0;
                    break;
                case "d1":
                    tempQca += 1.6;
                    break;
                case "d2":
                    tempQca += 1.2;
                    break;
                case "f":
                case "ng":
                    break;
                default:
            }
        }

        qcaScore = tempQca / letterGrades.length;
        return qcaScore;
    }
}
