package BSOnAnswers;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = new int[] {3, 6, 7, 11};
        int numHours = 8;

        int minRate = minEatingBananasRate(piles, numHours);
        System.out.println(minRate);

    }

    public static int minEatingBananasRate(int[] piles, int numHours) {
        int low = 1;

        int maximumRangeValue = Integer.MIN_VALUE;

        for(int i= 0; i<piles.length; i++){
            maximumRangeValue = Math.max(maximumRangeValue, piles[i]);
        }

        int high = maximumRangeValue;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {

            int mid = (low + high) / 2;
            int totalHours = computeTotalHours(piles, mid);

            if(totalHours <= numHours){
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int computeTotalHours(int[] piles, int rate) {
        int totalHours = 0;

        for(int i=0; i<piles.length; i++){
            totalHours += (int) Math.ceil((double)(piles[i]) / (double)rate);
        }
        return totalHours;
    }
}
