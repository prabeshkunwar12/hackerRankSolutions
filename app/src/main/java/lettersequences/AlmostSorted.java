package lettersequences;

import java.util.ArrayList;
import java.util.List;

public class AlmostSorted {
    public static void main(String[] args) {
        almostSorted(new ArrayList<>(List.of(1, 5, 4, 3, 2, 6)));
    }

    /**
     * @param arr
     *            gt is the list of unsorted positions
     *            there are 3 conditions according to the size of gt:
     *            if size of gt =:
     *            0, it is already sorted
     *            >0 and <=2, it is swappable.
     *            >2, it is sortable
     * 
     *            time complexity = O(n)
     *            space complexity = O(n)
     */
    public static void almostSorted(List<Integer> arr) {
        List<Integer> gt = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1))
                gt.add(i);
        }

        if (gt.isEmpty()) {
            System.out.println("yes");
        } else if (gt.size() == 1) {
            int lpos = gt.get(0);
            int rpos = lpos + 1;
            int l = arr.get(lpos);
            int prev = lpos > 0 ? arr.get(lpos - 1) : -1;
            int r = arr.get(rpos);
            int after = rpos == arr.size() - 1 ? Integer.MAX_VALUE : arr.get(rpos + 1);
            if (l <= after && r >= prev)
                System.out.printf("yes %nswap %d %d", lpos + 1, rpos + 1);
            else
                System.out.println("no");
        } else if (gt.size() == 2) {
            int lpos = gt.get(0);
            int rpos = gt.get(1) + 1;
            int lprev = lpos > 0 ? arr.get(lpos - 1) : -1;
            int l = arr.get(lpos);
            int lafter = arr.get(lpos + 1);
            int rprev = arr.get(rpos - 1);
            int r = arr.get(rpos);
            int rafter = rpos == arr.size() - 1 ? Integer.MAX_VALUE : arr.get(rpos + 1);
            if (r >= lprev && r <= lafter && l >= rprev && l <= rafter)
                System.out.printf("yes %nswap %d %d", lpos + 1, rpos + 1);
            else
                System.out.println("no");
        } else {
            boolean sortable = true;
            for (int i = 0; i < gt.size() - 1; i++) {
                if (gt.get(i + 1) - gt.get(i) != 1) {
                    sortable = false;
                    break;
                }
            }
            if (sortable) {
                int lpos = gt.get(0);
                int rpos = gt.get(gt.size() - 1) + 1;
                int lprev = lpos > 0 ? arr.get(lpos - 1) : -1;
                int l = arr.get(lpos);
                int lafter = arr.get(lpos + 1);
                int rprev = arr.get(rpos - 1);
                int r = arr.get(rpos);
                int rafter = rpos == arr.size() - 1 ? Integer.MAX_VALUE : arr.get(rpos + 1);
                if (r >= lprev && r <= lafter && l >= rprev && l <= rafter)
                    System.out.printf("yes %nreversed %d %d", lpos + 1, rpos + 1);
                else
                    System.out.println("no");
            } else {
                System.out.println("no");
            }
        }
    }
}
