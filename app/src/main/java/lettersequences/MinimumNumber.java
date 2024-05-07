package lettersequences;

public class MinimumNumber {
    public static void main(String[] args) {
        System.out.println(minimumNumber(8, "AAAAAAAA"));
    }

    public static int minimumNumber(int n, String password) {
        boolean hasD = false, hasUC = false, hasLC = false, hasS = false;
        int blank = n >= 6 ? 0 : 6 - n;
        int wr = 4;
        char[] ca = password.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] >= 'a' && ca[i] <= 'z') {
                if (!hasLC) {
                    hasLC = true;
                    wr--;
                }
            } else if (ca[i] >= 'A' && ca[i] <= 'Z') {
                if (!hasUC) {
                    hasUC = true;
                    wr--;
                }
            } else if (ca[i] >= '0' && ca[i] <= '9') {
                if (!hasD) {
                    hasD = true;
                    wr--;
                }
            } else {
                if (!hasS) {
                    hasS = true;
                    wr--;
                }
            }
            if (wr == 0)
                return blank;
        }
        return blank > wr ? blank : wr;
    }
}
