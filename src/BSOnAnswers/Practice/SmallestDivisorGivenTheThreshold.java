package BSOnAnswers.Practice;

public class SmallestDivisorGivenTheThreshold {

    public static void main(String[] args) {

        int[] num = new int[] {1, 2, 5, 9};
        int threshold = 6;

        int minDivisor = minimumDivisor(num, threshold);
        System.out.println(minDivisor);
    }

    public static int minimumDivisor(int[] num, int threshold) {

        int low = 1;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<num.length; i++) {
            maxValue = Math.max(maxValue, num[i]);
        }
        int high = maxValue;
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(isPossibleWithinThreshold(num, threshold, mid)) {
                ans =  Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    private static boolean isPossibleWithinThreshold(int[] num, int threshold, int mid) {
        int result = 0;
        for(int i=0; i<num.length; i++) {
            result += (int) Math.ceil((double) num[i] / (double) mid);
        }
        return result <= threshold;
    }
}
