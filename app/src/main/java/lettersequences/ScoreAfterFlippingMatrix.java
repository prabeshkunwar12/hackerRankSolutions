package lettersequences;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                new int[] { 0, 0, 1, 1 },
                new int[] { 1, 0, 1, 0 },
                new int[] { 1, 1, 0, 0 }
        };
        System.out.println(matrixScore(grid));
    }

    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] values = new int[m];

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0)
                changeRow(grid, i);
        }

        for (int i = 0; i < m; i++) {
            int pow = n - 1;
            values[i] = (int) Math.pow(2, pow);
        }

        for (int i = 1; i < n; i++) {
            int ones = 0;
            int pow = n - i - 1;
            for (int j = 0; j < m; j++) {
                ones += grid[j][i];
            }
            if (ones < m - ones)
                changeColumn(grid, i, values, pow);
            else
                calculateValue(grid, i, values, pow);
        }

        int total = 0;

        for (int i = 0; i < m; i++) {
            total += values[i];
        }

        return total;
    }

    public static void changeRow(int[][] grid, int row) {
        for (int i = 0; i < grid[row].length; i++) {
            grid[row][i] = Math.abs(grid[row][i] - 1);
        }
    }

    public static void changeColumn(int[][] grid, int column, int[] values, int pow) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][column] = Math.abs(grid[i][column] - 1);
            values[i] += (int) grid[i][column] * Math.pow(2, pow);
        }
    }

    public static void calculateValue(int[][] grid, int column, int[] values, int pow) {
        for (int i = 0; i < grid.length; i++) {
            values[i] += (int) grid[i][column] * Math.pow(2, pow);
        }
    }
}
