package lettersequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MaximumTotalDamageWithSpellCasting {
    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[] { 5, 58, 45, 54, 60, 6, 34, 26, 3, 64, 47, 58, 13, 31, 41, 32,
                49, 10, 51, 27, 12, 24, 37, 15, 11, 29, 6, 41, 10, 61, 17, 6, 23, 36, 63, 58, 50, 64, 55, 52, 46, 13,
                33, 64, 27, 41, 65, 27, 11, 27, 59, 53, 60, 37, 66, 10, 28, 32, 38, 26, 9, 45, 55, 9, 48, 22, 22, 61,
                62, 8, 41, 14, 23, 61, 40, 40, 5, 42, 60, 4, 55, 50, 30, 3, 58, 33, 27, 25, 6, 32, 8, 33, 16, 34, 20,
                14, 7, 19, 22 }));
    }

    public static long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        System.out.println(Arrays.toString(power));

        Map<Integer, Long> dp = new HashMap<>();

        long maxDamage = 0;

        TreeSet<Integer> prev = new TreeSet<>();

        for (int p : power) {
            long currentMax = p;

            if (!prev.isEmpty() && p == prev.last()) {
                currentMax = p + dp.get(p);
            } else {
                for (int pre : prev) {
                    if (pre < p - 2 && pre != 0)
                        currentMax = Math.max(currentMax, p + dp.get(pre));
                }
                prev.add(p);
                if (prev.size() > 10) {
                    prev.remove(prev.first());
                }
            }

            dp.put(p, currentMax);
            maxDamage = Math.max(maxDamage, currentMax);
        }

        return maxDamage;
    }
}
