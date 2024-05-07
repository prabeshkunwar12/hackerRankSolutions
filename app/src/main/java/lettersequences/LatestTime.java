package lettersequences;

import java.util.HashSet;

public class LatestTime {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[] { 0, 0, 1, 0 }));
    }

    public static String largestTimeFromDigits(int[] arr) {
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 2)
                continue;
            for (int j = 0; j < arr.length; j++) {
                if (i == j || (arr[i] == 2 && arr[j] > 3))
                    continue;
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j || arr[k] > 5)
                        continue;
                    for (int l = 0; l < arr.length; l++) {
                        if (l == k || l == j || l == i)
                            continue;
                        int digit = (arr[i] * 1000 + arr[j] * 100 + arr[k] * 10 + arr[l]);
                        last = last < digit ? digit : last;
                    }
                }
            }
        }

        if (last == -1)
            return "";
        return formatTime(last);
    }

    public static String formatTime(int n) {
        return String.format("%d%d:%d%d", n / 1000, (n % 1000) / 100, (n % 100) / 10, n % 10);
    }
}
