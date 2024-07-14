package BSOnAnswers.Practice;

import java.util.Arrays;

public class AggresiveCows {

    public static void main(String[] args) {
        int[] stalls = new int[]{0, 3, 4, 7, 10, 9};
        int cows = 4;

        int maxDistance = aggresiveCowsPlacement(stalls, cows);
        System.out.println(maxDistance);
    }

    public static int aggresiveCowsPlacement(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1];

        while(low <= high) {

            int mid = (low + high)/2;

            if (possibleToPlaceCows(stalls, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }

    public static boolean possibleToPlaceCows(int[] stalls, int cows, int mid) {
        int noOfCows = 1;
        int lastPlaced = stalls[0];

        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - lastPlaced >= mid){
                noOfCows++;
                lastPlaced = stalls[i];
            }
        }
        return noOfCows >= cows;
    }
}
