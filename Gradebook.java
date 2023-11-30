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

    //Calculate average test score
    public double calculateavgscore( double[] testscores ) {
        double testTotal = 0;
        double avgTestScore = 0;

        for (int i = 0; i < testscores.length; i++) {
            testTotal =+ testscores[i];
        }

        // alternative
        //for (double score : testscores) {
        //    testTotal += score;
        //}

        avgTestScore = testTotal / testscores.length; 
        return avgTestScore;

    }

    public String getGrade() {
        double score = calculateavgscore(testscores);
        String result = "NG";

        
        if(score >= 80)
        {
            result = "A1";
            System.out.print("A1");
        }
        else if( score >= 72 && score < 80)
        {
           result = "A2";
            System.out.print("A2");
        } 
        else if( score>=64 && score<72)
        {
            result = "B1";
            System.out.print("B1");
        }
        else if( score>=60 && score < 64)
        {
            result = "B2";
            System.out.print("B2");
        }
        else if( score>=56 && score < 60)
        {
            result = "B3";
            System.out.print("B3");
        }
         else if( score>=52 && score < 56)
        {
            result = "C1";
            System.out.print("C1");
        }
         else if( score>=48 && score < 52)
        {
            result = "C2";
            System.out.print("C2");
        }
         else if( score>=40 && score < 48)
        {
            result = "C3";
            System.out.print("C3");
        }
         else if( score>=35 && score < 40)
        {
            result = "D1";
            System.out.print("D1");
        }
         else if( score>=30 && score < 35)
        {
            result = "D2";
            System.out.print("D2");
        }
         else if( score>=1 && score < 30)
        {
            result = "F";
            System.out.print("F");
        }
        else
        {
            System.out.print("NG");
        }

        return result;
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
