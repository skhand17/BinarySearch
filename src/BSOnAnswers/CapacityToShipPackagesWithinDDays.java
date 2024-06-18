package BSOnAnswers;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {

        int[] weights = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int leastWtCapacity = shipWithinDays(weights, days);
        System.out.println(leastWtCapacity);
    }

    public static int shipWithinDays(int[] weights, int days) {

        int minEle = Integer.MIN_VALUE;
        int totalSum = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<weights.length; i++){

            minEle = Math.max(minEle, weights[i]);
            totalSum += weights[i];
        }

        int low = minEle;
        int high = totalSum;

        while (low <= high){

            int mid = (low + high) / 2;
            if(possible(weights, mid, days)){
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int[] weights, int capacity, int days) {
        int currentCapacity = capacity;
        int daysRequired = 1;

        for (int i = 0; i < weights.length; i++) {
            if (currentCapacity >= weights[i]) {
                currentCapacity -= weights[i];
            } else {
                daysRequired++;
                currentCapacity = capacity - weights[i];
            }
        }
        return daysRequired <= days;
    }
}
