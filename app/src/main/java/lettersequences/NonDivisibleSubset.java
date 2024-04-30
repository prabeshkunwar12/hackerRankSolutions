package lettersequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        int k = 4;
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(19, 10, 12, 10, 24, 25, 22));
        System.out.println(maxSubsetSize(k, list));
    }

    public static int maxSubsetSize(int k, List<Integer> s) {
        int[] arr = new int[k];
        for (int num : s) {
            arr[num % k] += 1;
        }
        System.out.println(Arrays.toString(arr));
        int maxSize = 0;
        if (k % 2 == 0) {
            for (int i = 0; i <= k / 2; i++) {
                if (i == 0 || i == k / 2) {
                    maxSize += Math.min(arr[i], 1);
                } else {
                    maxSize += Math.max(arr[i], arr[k - i]);
                }
            }
        } else {
            for (int i = 0; i <= k / 2; i++) {
                if (i == 0) {
                    maxSize += Math.min(arr[i], 1);
                } else {
                    maxSize += Math.max(arr[i], arr[k - i]);
                }
            }
        }

        return maxSize;
    }
}
