package lettersequences;

public class HighestPalandromicValue {
    public static void main(String[] args) {
        System.out.println(highestValuePalindrome("12321", 5, 5));
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        if (n == 0)
            return "";
        if (n == 1 && k == 0)
            return s;
        if (n == 1 && k > 0)
            return "9";

        char[] w = s.toCharArray();
        int pos = 0;
        int[] changed = new int[w.length];
        int min = 0;

        // find out which positions need change
        while (pos <= (n / 2) - 1) {
            int comp = n - pos - 1;
            if (w[pos] != w[comp]) {
                if (w[pos] < w[comp]) {
                    w[pos] = w[comp];
                    changed[pos] = 1;
                    min++;
                } else {
                    w[comp] = w[pos];
                    changed[comp] = 1;
                    min++;
                }
            }

            // if min change is not met
            if (k < min)
                return ("-1");

            pos++;
        }

        // we have to change 2 at a time
        pos = 0;
        while (pos <= (n - 1) / 2 && k - min > 0) {
            if (w[pos] == '9') {
                pos++;
                continue;
            }
            int comp = n - pos - 1;
            if (k - min == 1) {
                if (changed[pos] == 1 || changed[comp] == 1) {
                    w[pos] = '9';
                    w[comp] = '9';
                    min++;
                } else if (n % 2 == 1 && n / 2 != '9') {
                    w[n / 2] = '9';
                    min++;
                }
            } else {
                w[pos] = '9';
                w[comp] = '9';
                if (changed[pos] == 1 || changed[comp] == 1)
                    min++;
                else
                    min += 2;
            }
            pos++;
        }

        return new String(w);
    }
}
