package Practice;

public class SearchInRotatedSortedArrayI {

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 9, 1, 2, 3, 4, 5};
        int target = 5;
        int index = searchInRotatedArray(arr, target);
        System.out.println(index);
    }

    public static int searchInRotatedArray(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] == target){
                return mid;
            }

//            check which half is sorted

            if(arr[low] <= arr[mid]) {
//                left half is sorted
                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
//                right half is sorted
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
