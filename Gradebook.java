public class Gradebook {
    // letterGrade = {"NG", "F", "D2", "D1", "C3", "C2", "C1", "B3", "B2", "B1", "A2", "A1"};
    private double[] testscores;

    public Gradebook() {
        testscores = new double[3];
    }

    public Gradebook(int numTests) {
        testscores = new double[numTests];
    }

    public void setScore(int i, double value) {
        testscores[i] = value;
    }

    public double getScore(int i) {
        return testscores[i];
    }

    public double getTotal() {
        double result = 0;
        for (double score : testscores) {
            result += score;
        }
        return result;
    }

    // Calculate average test score
    public double calculateAvgScore() {
        double testTotal = 0;

        for (double score : testscores) {
            testTotal += score;
        }

        return testTotal / testscores.length;
    }

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
