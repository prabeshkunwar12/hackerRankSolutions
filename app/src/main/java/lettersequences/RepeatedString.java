package lettersequences;

public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString(
                "ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",
                685118368975L));
    }

    public static long repeatedString(String s, long n) {
        long numOfAs = 0;
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                a++;
        }
        long times = n / s.length();
        long rem = n % s.length();
        numOfAs = a * times;
        for (int i = 0; i < rem; i++) {
            if (s.charAt(i) == 'a')
                numOfAs++;
        }
        return numOfAs;
    }
}
