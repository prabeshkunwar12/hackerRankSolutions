package lettersequences;

public class kthSmallestprimeFraction {
    public static void main(String[] args) {
        int[] kth = kthSmallestPrimeFraction(
                new int[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
                        61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113 },
                3);
        System.out.printf("%n%d/%d", kth[0], kth[1]);
    }

    private static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        int[] res = new int[2];
        double l = 0, r = 1;
        while (l < r) {
            double mid = (l + r) / 2.0, maxF = 0;
            int num = 0, den = 0, j = 1, total = 0;

            for (int i = 0; i < len; ++i) {
                while (j < len && arr[i] >= mid * arr[j]) {
                    System.out.println(++j);
                }

                total += len - j;

                if (j < len && (arr[i] * 1.0) / arr[j] > maxF) {
                    maxF = (arr[i] * 1.0) / arr[j];
                    num = i;
                    den = j;
                }
            }

            if (total == k)
                return new int[] { arr[num], arr[den] };
            else if (total < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return res;
    }

}
