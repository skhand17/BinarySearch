package BSOnAnswers.Practice;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {

        int[] weights = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int minCap = minimumCapacity(weights, days);
        System.out.println(minCap);
    }

    public static int minimumCapacity(int[] weights, int days) {

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if(possibleToShip(weights, mid, days)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean possibleToShip(int[] weights, int mid, int days) {

        int noDaysReq = 1;
        int capacity = mid;
        int currentCapacity = capacity;
        for(int i=0; i<weights.length; i++) {
            if(weights[i] <= currentCapacity){
                currentCapacity -= weights[i];
            } else {
                noDaysReq++;
                currentCapacity = capacity - weights[i];
            }
        }
        return noDaysReq <= days;
    }
}
