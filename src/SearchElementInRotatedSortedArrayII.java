public class SearchElementInRotatedSortedArrayII {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        boolean isPresent = search(arr, target);
        System.out.println(isPresent);
    }

    public static boolean search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = (low + high)/2;

            if(arr[mid] == target)
                return true;

            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
            // Identify the left sorted half

            if(arr[low] <= arr[mid]){

                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                // identify the right sorted half
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
