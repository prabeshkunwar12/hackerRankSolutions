package lettersequences;

public class Triangulation {
    public static void main(String[] args) {
        int[] arr = {3,7,4,5};
        minScoreTriangulation(arr);
    }


    public static int minScoreTriangulation(int[] values) {
        int score = Integer.MAX_VALUE;
        for(int i=0; i<2; i++){
            int s = 0;
            int[] valueCopy = values.clone();
            
            while(valueCopy.length>3) {
                int[] valueReduced = new int[values.length/2];
                int pos = 0;
                for(int j=0; j<valueCopy.length; j += 2) {
                    s += valueCopy[j] * valueCopy[j+1] * valueCopy[j+2];
                    valueReduced[pos] = valueCopy[j];
                    pos++;
                }
                valueCopy = valueReduced.clone();
            }
            score = s<score ? s:score;
        }  
        return score;
    }

}
