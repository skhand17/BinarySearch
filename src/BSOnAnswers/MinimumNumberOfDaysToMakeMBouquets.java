package BSOnAnswers;

public class MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {
        int[] bloomDay = new int[]{1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        int minDays = minDays(bloomDay, m, k);
        System.out.println(minDays);
    }

    public static int minDays(int[] bloomDay, int m, int k) {

//        if(bloomDay.length < m * k)
//            return -1;

        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) return -1;

        int minElement = Integer.MAX_VALUE;
        int maxiElement = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            minElement = Math.min(minElement, bloomDay[i]);
            maxiElement = Math.max(maxiElement, bloomDay[i]);
        }

        int low = minElement;
        int high = maxiElement;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean possible(int[] bloomDay, int day, int m, int k) {

        int numOfBouquets = 0;
        int counter = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                counter++;
            } else {
                numOfBouquets += counter / k;
                counter = 0;
            }
        }
        numOfBouquets += counter / k;

        return numOfBouquets >= m;
    }
}
