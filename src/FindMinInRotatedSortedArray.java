public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = new int[] {4, 5, 6, 7, 0, 1, 2};
        int minimum = findMinimum(arr);
        System.out.println(minimum);
    }

    public static int findMinimum(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high)/2;

//      check for sorted half

            if(arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
