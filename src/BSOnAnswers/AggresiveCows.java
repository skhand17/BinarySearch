package BSOnAnswers;

import java.util.Arrays;

public class AggresiveCows {

    public static void main(String[] args) {
        int[] stalls = new int[] {0, 3, 4, 7, 10, 9};
        int cows = 4;

        int maximumPossibleMinDistance = aggresiveCows(stalls, cows);
        System.out.println(maximumPossibleMinDistance);
    }

    public static int aggresiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {

            int mid = (low + high) / 2;
            if(canWePlace(stalls, mid, cows)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }

    public static boolean canWePlace(int[] stalls, int distance, int cows) {
        int numCows = 1;
        int lastPlaced = stalls[0];

        for(int i=1; i<stalls.length; i++){
            if(stalls[i] - lastPlaced >= distance){
                numCows++;
                lastPlaced = stalls[i];
            }
        }
        return numCows >= cows;
    }
}
