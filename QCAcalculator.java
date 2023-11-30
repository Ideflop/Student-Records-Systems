import java.util.Scanner;

public class QCAcalculator {

    int moduleNum = 0;
    double qcaScore = 0.00;
    double tempQca = 0.0;

    private Scanner scanner;

    public QCAcalculator() {
        this.scanner = new Scanner(System.in);
    }

    public double getQcaScore() {
        return qcaScore;
    }

    public void setQcaScore(double qcaScore) {
        this.qcaScore = qcaScore;
    }

    // get calculateavgscore for each module?

    
    public double calculateQcaScore( int moduleNum ) {

    for (int i = 0; i < moduleNum; i++) {
		String grade = scanner.next();


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
		System.out.println(qcaScore);

    }

    


}



// should i use this
/* switch (grade.toUpperCase()) {
                case "A1":
                    tempQca += 4.0;
                    break;
                case "A2":
                    tempQca += 3.6;
                    break; */


