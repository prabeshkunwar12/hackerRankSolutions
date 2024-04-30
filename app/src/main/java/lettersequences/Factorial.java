package lettersequences;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(countNumberOfSequences1Common(5));
    }
    
    public static double countNumberOfSequences(double n) {
        double totalSequences = 0;
        for(double i=1; i<=n; i++){
            totalSequences += (factorial(n))/(factorial(n-i));
        }
        return totalSequences;
    }
    public static double countNumberOfSequences1Common(double n) {
        double totalSequences = 0;
        for(double i=1; i<=n; i++){
            double seqMinus = (n-(i-1))*i-1;
            totalSequences += (factorial(n))/(factorial(n-i))-seqMinus;
        }
        return totalSequences;
    }

    public static double factorial(double n) {
        double factorial = 1;
        for (double i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    

}
