import java.util.Scanner;
public class QCAcalculator {

    private int moduleNum = 0;
    private double qcaScore = 0.00;
    private double tempQca = 0.0;
    private int i = 0; 
    private Scanner scanner;

    // get calculateavgscore for each module

    // create tempQca

    public QCAcalculator() {
        this.scanner = new Scanner(System.in);
    }


    public double qcaS( int moduleNum ) {

        int i = 0; 
        while (i < moduleNum) {
            String grade = InputUtils.scanString(scanner);


            if (grade.equals("A1") || grade.equals("a1")) {
                tempQca += 4.0;

                i++;
            } else if (grade.equals("A2") || grade.equals("a2")) {
                tempQca += 3.6;

                i++;
            } else if (grade.equals("B1") || grade.equals("b1")) {
                tempQca += 3.2;

                i++;
            } else if (grade.equals("B2") || grade.equals("b2")) {
                tempQca += 3.0;

                i++;
            } else if (grade.equals("B3") || grade.equals("b3")) {
                tempQca += 2.8;

                i++;
            } else if (grade.equals("C1") || grade.equals("c1")) {
                tempQca += 2.6;

                i++;
            } else if (grade.equals("C2") || grade.equals("c2")) {
                tempQca += 2.4;

                i++;
            } else if (grade.equals("C3") || grade.equals("c3")) {
                tempQca += 2.0;

                i++;
            } else if (grade.equals("D1") || grade.equals("d1")) {
                tempQca += 1.6;

                i++;
            } else if (grade.equals("D2") || grade.equals("d2")) {
                tempQca += 1.2;

                i++;
            } else if (grade.equals("F") || grade.equals("f")) {
                tempQca += 0.00;

                i++;
            } else if (grade.equals("NG") || grade.equals("ng")) {
                tempQca += 0.00;

                i++;
            } else {
                tempQca += 0.00;;
            }

        }

        qcaScore = tempQca / moduleNum;
        return qcaScore;
    }

}
