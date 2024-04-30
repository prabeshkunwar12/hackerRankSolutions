package lettersequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(1, 5)),
                new ArrayList<>(List.of(4, 1, 2)),
                new ArrayList<>(List.of(4, 1, 2, 3)),
                new ArrayList<>(List.of(1, 7, 7, 5, 6))));
        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        return minimumTotal(triangle, dp, 1);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int[] dp, int lvlidx) {

        List<Integer> list = triangle.get(lvlidx);
        int pre = dp[0], temp;
        dp[0] += list.get(0);
        for (int i = 1; i < lvlidx; i++) {
            temp = dp[i];
            dp[i] = list.get(i) + Math.min(pre, dp[i]);
            pre = temp;
        }
        dp[lvlidx] = pre + list.get(lvlidx);

        if (lvlidx + 1 == triangle.size()) {
            int res = dp[0];
            for (int i = 1; i <= lvlidx; i++)
                res = Math.min(res, dp[i]);
            System.out.println(Arrays.toString(dp));
            return res;
        }

        return minimumTotal(triangle, dp, lvlidx + 1);
    }

    public static int minimum(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        List<List<Integer>> dp = new ArrayList<>();

        dp.add(triangle.get(triangle.size() - 1));

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(triangle.get(i).get(j)
                        + Math.min(dp.get(triangle.size() - i - 2).get(j), dp.get(triangle.size() - i - 2).get(j + 1)));
            }
            dp.add(row);
        }

        return dp.get(dp.size() - 1).get(0);
    }
}
