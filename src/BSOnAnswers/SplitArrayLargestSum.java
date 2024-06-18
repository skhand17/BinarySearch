package BSOnAnswers;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = new int[] {7, 2, 5, 10, 8};
        int k = 2;

        int ans = splitArray(nums, k);
        System.out.println(ans);
    }
    public static int splitArray(int[] nums, int k) {

        int maxEle = Integer.MIN_VALUE;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEle = Math.max(maxEle, nums[i]);
            totalSum += maxEle;
        }

        int low = maxEle;
        int high = totalSum;

        while (low <= high) {

            int mid = (low + high) / 2;
            int split = splitArr(nums, mid);
            if (split > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int splitArr(int[] nums, int spt) {
        int c = 1;
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (p + nums[i] <= spt) {
                p += nums[i];
            } else {
                c++;
                p = nums[i];
            }
        }
        return c;
    }
}
