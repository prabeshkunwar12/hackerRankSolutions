package lettersequences;

import java.util.HashMap;
import java.util.TreeSet;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = new int[] { 5, 4, 3, 2, 1 };
        String[] ranks = findRelativeRanks(score);
        for (String rank : ranks) {
            System.out.println(rank);
        }
    }

    public static String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < score.length; i++) {
            scoreMap.put(score[i], i);
            set.add(score[i]);
        }
        int rank = score.length;
        String[] ranks = new String[score.length];
        for (int el : set) {
            if (rank == 1) {
                ranks[scoreMap.get(el)] = "Gold Medal";
            } else if (rank == 2) {
                ranks[scoreMap.get(el)] = "Silver Medal";
            } else if (rank == 3) {
                ranks[scoreMap.get(el)] = "bronze Medal";
            } else {
                ranks[scoreMap.get(el)] = Integer.toString(rank);
            }
            rank--;
        }
        return ranks;
    }
}
