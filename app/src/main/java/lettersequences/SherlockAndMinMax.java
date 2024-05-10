package lettersequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SherlockAndMinMax {
    public static void main(String[] args) {
        System.out.println(sherlockAndMinimax(new ArrayList<Integer>() {
            {
                add(38);
                add(40);
                add(50);
                add(30);
                add(48);
            }
        }, 23, 69));
    }

    public static int sherlockAndMinimax(List<Integer> arr, int p, int q) {
        int maxValue = Integer.MIN_VALUE;
        int max = p;
        int l = arr.size();
        int pos = 0;
        int diff = 0;
        Collections.sort(arr);
        for (int i = p; i <= q; i++) {
            while (pos < l && arr.get(pos) < i) {
                pos++;
            }

            if (pos == 0) {
                diff = arr.get(pos) - i;
            } else if (pos >= l) {
                diff = q - arr.get(l - 1);
                if (diff > maxValue) {
                    return q;
                }
            } else {
                diff = Math.min(arr.get(pos) - i, i - arr.get(pos - 1));
            }
            if (diff > maxValue) {
                max = i;
                maxValue = diff;
            }
        }
        return max;
    }
}
