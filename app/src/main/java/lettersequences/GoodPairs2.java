package lettersequences;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs2 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[] { 1, 3, 4 },
                new int[] { 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4 }, 1));
    }

    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long count = 0;
        HashMap<Integer, Integer> nums2Map = new HashMap<>();

        for (int num : nums2) {
            nums2Map.put(num, nums2Map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> quoMap = new HashMap<>();
        for (int num : nums1) {
            if (quoMap.containsKey(num)) {
                count += quoMap.get(num);
                continue;
            }
            if (num % k == 0) {
                int tv = num / k;
                int nc = 0;
                for (int key : nums2Map.keySet()) {
                    if (tv % key == 0) {
                        nc += nums2Map.get(key);
                    }
                }
                count += nc;
                quoMap.put(num, nc);
            }
        }

        return count;
    }
}
