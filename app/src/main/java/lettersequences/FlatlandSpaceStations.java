package lettersequences;

import java.util.Arrays;

public class FlatlandSpaceStations {
    public static void main(String[] args) {
        System.out.println(flatlandSpaceStations(100, new int[] { 93, 41, 91, 61, 30, 6, 25, 90, 97 }));
    }

    static int flatlandSpaceStations(int n, int[] c) {
        if (n == 0 || n == 1)
            return 0;
        if (c.length == 1)
            return Math.max(c[0], n - c[0] - 1);
        Arrays.sort(c);
        int maxD = c[0];
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i + 1] - c[i] == 1)
                continue;
            int mean = (c[i + 1] + c[i]) / 2;
            int dis = Math.min(c[i + 1] - mean, mean - c[i]);
            System.out.printf("%d %d = %d %n", c[i], c[i + 1], dis);
            if (dis > maxD)
                maxD = dis;
        }
        maxD = Math.max(maxD, n - c[c.length - 1] - 1);
        return maxD;
    }
}
