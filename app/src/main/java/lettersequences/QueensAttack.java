package lettersequences;

public class QueensAttack {
    public static void main(String[] args) {
        System.out.println(queensAttack(0, 0, 0, 0, null), 0, 0, 0, null));
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // all the attacking squares
        int right = n - c_q;
        int left = c_q - 1;
        int up = n - r_q;
        int down = r_q - 1;
        int right_up = Math.min(right, up);
        int left_up = Math.min(left, up);
        int right_down = Math.min(right, down);
        int left_down = Math.min(left, down);

        for (List<Integer> obstacle : obstacles) {
            if (obstacle.get(0) == r_q && obstacle.get(1) > c_q) {
                right = obstacle.get(1) - c_q - 1;
            } else if (obstacle.get(0) == r_q && obstacle.get(1) < c_q) {
                left = c_q - obstacle.get(1) - 1;
            } else if (obstacle.get(1) == c_q && obstacle.get(0) > r_q) {
                up = obstacle.get(0) - r_q - 1;
            } else if (obstacle.get(1) == c_q && obstacle.get(0) < r_q) {
                down = r_q - obstacle.get(0) - 1;
            } else if (obstacle.get(0) - r_q == obstacle.get(1) - c_q && obstacle.get(1) > r_q) {
                right_up = obstacle.get(1) - c_q - 1;
            } else if (obstacle.get(0) - r_q == obstacle.get(1) - c_q && obstacle.get(1) < r_q) {
                left_down = c_q - obstacle.get(1) - 1;
            } else if (obstacle.get(0) - r_q == -(obstacle.get(1) - c_q) && obstacle.get(1) < r_q) {
                left_up = obstacle.get(0) - r_q - 1;
            } else if (obstacle.get(0) - r_q == -(obstacle.get(1) - c_q) && obstacle.get(1) > r_q) {
                right_down = r_q - obstacle.get(0) - 1;
            }
        }

        return right + left + up + down + right_up + right_down + left_up + left_down;
    }
}
