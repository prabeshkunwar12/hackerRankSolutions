package lettersequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {4,3,5,6,2,4,6,2,4,6};
        int[] arr2 = {2,3,4};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sorted = new int[arr1.length];
        int index = 0;

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            for (int i = 0; i < map.getOrDefault(num, 0); i++) {
                sorted[index++] = num;
            }
            map.remove(num);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sorted[index++] = num;
            }
        }

        return sorted;
    }
}
