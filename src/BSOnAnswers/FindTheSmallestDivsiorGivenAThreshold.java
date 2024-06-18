package BSOnAnswers;

public class FindTheSmallestDivsiorGivenAThreshold {

    public static void main(String[] args) {

        int[] arr = new int[] {44, 22, 33, 11, 1};
        int threshold = 5;

        int smallestAns = smallestDivisor(arr, threshold);
        System.out.println(smallestAns);
    }

    public static int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int maxEle = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            maxEle = Math.max(maxEle, nums[i]);
        }

        int high = maxEle;

        while (low <= high) {

            int mid = (low + high) / 2;

            if(possible(nums, mid, threshold)){
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int[] nums, int divisor, int threshold) {

        int totalSum = 0;

        for(int i=0; i<nums.length; i++) {

            totalSum += (int) Math.ceil((double) nums[i] / (double) divisor);
        }
        return totalSum <= threshold;
    }
}
