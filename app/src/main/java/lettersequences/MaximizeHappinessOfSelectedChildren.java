package lettersequences;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[] { 12, 1, 42 }, 3));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {

        int left = 0, right = k;
        while (left < right) {
            int mid = left + right >> 1;
            if (check(happiness, mid))
                left = mid + 1;
            else
                right = mid;
        }

        k = left;
        int n = happiness.length;
        quickSort(happiness, 0, n - 1, n - k);
        long sum = -(long) k * (k - 1) >> 1;
        for (int i = n - 1; k-- > 0; --i)
            sum += happiness[i];

        return sum;
    }

    public static boolean check(int[] happiness, int mid) {
        int count = 0;
        for (int x : happiness) {
            if (x < mid)
                continue;
            if (++count > mid)
                return true;
        }

        return false;
    }

    private static void quickSort(int nums[], int low, int high, int k) {
        if (low == high)
            return;

        int left = low - 1, right = high + 1, mid = low + high >> 1;
        int x = nums[mid];
        while (left < right) {
            while (nums[++left] < x)
                continue;
            while (nums[--right] > x)
                continue;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        if (right < k)
            quickSort(nums, right + 1, high, k);
        else
            quickSort(nums, low, right, k);
    }
}
