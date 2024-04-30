package lettersequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ClimbingTheLeaderBoard {
    public static void main(String[] args) {
        ArrayList<Integer> ranked = new ArrayList<>();
        ArrayList<Integer> player = new ArrayList<>();
        ranked.addAll(Arrays.asList(100, 90, 90, 80, 75, 60));
        player.addAll(Arrays.asList(50, 65, 77, 90, 102));
        System.out.println(climbingLeaderboard(ranked, player));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Stack<Integer> uniqueRanked = new Stack<>();
        for (int num : ranked) {
            if (uniqueRanked.size() == 0 || uniqueRanked.peek() != num) {
                uniqueRanked.push(num);
            }
        }
        List<Integer> returnList = new Stack<>();
        for (int score : player) {
            while (uniqueRanked.size() > 0 && uniqueRanked.peek() <= score) {
                uniqueRanked.pop();
            }
            returnList.add(uniqueRanked.size() + 1);
        }
        return returnList;
    }
}
