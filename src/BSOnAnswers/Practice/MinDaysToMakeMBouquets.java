package BSOnAnswers.Practice;

public class MinDaysToMakeMBouquets {

    public static void main(String[] args) {

        int[] bloom = new int[] {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2;
        int k = 3;

        int minDay = minimumDaysToBloom(bloom, m, k);
        System.out.println(minDay);
    }

    public static int minimumDaysToBloom(int[] bloom, int m, int k) {
        int n = bloom.length;
        if(n < m*k)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0; i<bloom.length; i++) {
            low = Math.min(low, bloom[i]);
            high = Math.max(high, bloom[i]);
        }
        while(low <= high) {
            int mid = (low + high)/2;
            if(isPossible(bloom, mid, m , k)){
             high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isPossible(int[] bloom, int mid, int m, int k) {
        int counter = 0;
        int numBouqets = 0;

        for(int i=0; i< bloom.length; i++) {
            if(bloom[i] <= mid){
                counter++;
            } else {
                numBouqets += counter / k;
                counter = 0;
            }
        }
        numBouqets += counter / k;

        return numBouqets >= m;
    }

}
