package lettersequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class minCostToHireWorkers {
    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1 }, new int[] { 4, 8, 2, 2, 7 }, 3));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        if (k == 0)
            return 0;

        HashMap<Double, ArrayList<Integer>> map = new HashMap<>();
        TreeSet<Double> set = new TreeSet<>();
        double minCost = 0;

        for (int i = 0; i < quality.length; i++) {
            double ratio = (wage[i] * 1.0) / quality[i];
            ArrayList<Integer> list = map.getOrDefault(ratio, new ArrayList<>());
            list.add(quality[i]);
            map.put(ratio, list);
            set.add(ratio);
        }

        int total = 0;
        double ratio = set.getFirst();

        ArrayList<Double> req = new ArrayList<>();
        for (double r : set) {
            total += map.get(r).size();
            req.add(r);
            if (total >= k) {
                ratio = r;
                break;
            }
        }

        total = 0;
        for (double r : req) {
            ArrayList<Integer> rw = map.getOrDefault(r, new ArrayList<>());
            Collections.sort(rw);
            for (int w : rw) {
                total++;
                minCost += w * ratio;
                if (total == k) {
                    return minCost;
                }
            }
        }

        return minCost;
    }
}
