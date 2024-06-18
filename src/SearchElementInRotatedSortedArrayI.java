public class SearchElementInRotatedSortedArrayI {
    public static void main(String[] args) {

        int[] arr = new int[] {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 5;

        int index = searchInRotatedArray(arr, target);
        System.out.println(index);
    }

    public static int searchInRotatedArray(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = (low + high)/2;

            if(arr[mid] == target)
                return mid;

//            left sorted half

            if(arr[low] <= arr[mid]){

                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
//                right sorted half
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
