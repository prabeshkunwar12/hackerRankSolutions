package lettersequences;

public class LargestLocalValuesInAMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                new int[] { 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 2, 1, 1 },
                new int[] { 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1 }
        };
        int[][] largestLocal = largestLocal(arr);

        for (int i = 0; i < largestLocal.length; i++) {
            for (int j = 0; j < largestLocal.length; j++) {
                System.out.print(largestLocal[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] largestLocal(int[][] grid) {
        int ol = grid.length;
        int ml = ol - 2;
        int[][] result = new int[ml][ml];

        for (int i = -1; i < ol - 1; i++) {

            for (int j = -1; j < ol - 1; j++) {
                int num = grid[i + 1][j + 1];

                for (int k = i - 1; k <= i + 1 && k < ml; k++) {
                    if (k < 0)
                        continue;

                    for (int l = j - 1; l <= j + 1 && l < ml; l++) {
                        if (l < 0)
                            continue;

                        if (result[k][l] < num)
                            result[k][l] = num;
                    }
                }
            }
        }
        return result;
    }
}
