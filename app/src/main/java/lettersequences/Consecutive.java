package lettersequences;

import java.util.Arrays;
import java.util.HashSet;

public class Consecutive {
    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int days = 100000000;
        System.out.println(Arrays.toString(prisonAfterNDays(cells, days)));    
    }

    public static int[] prisonAfterNDays(int[] cells, int n) {
        if(n==0) {
            return cells;
        }
        boolean hasCycle = false;
        HashSet<String> seen = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            int[] nextDay = modify(cells);
            String key = Arrays.toString(nextDay);

            if(seen.contains(key)) {
                hasCycle = true;
                break;
            } else {
                seen.add(key);
            }
            cells = nextDay;
        }

        if(hasCycle) {
            n %= seen.size();
            for(int i=0; i<n; i++) {
                cells = modify(cells);
            }
        }

        return cells;
    }
    

    public static int[] modify(int[] cells) {
        int[] changed = new int[8];
        for (int cell = 1; cell < 7; cell++) {
            if ((cells[cell - 1] == 0 && cells[cell + 1] == 0) || (cells[cell - 1] == 1 && cells[cell + 1] == 1)) {
                changed[cell] = 1;
            } else {
                changed[cell] = 0;
            }
        }
        return changed;
    }
}
