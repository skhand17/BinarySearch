package Practice;

public class FindMinRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,7,1,2};

        int findMin = findMin(arr);
        System.out.println(findMin);
    }

    public static int findMin(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int minNo = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;


            if(arr[low] <= arr[mid]) {
                minNo = Math.min(minNo, arr[low]);
                low = mid + 1;
            } else {
                minNo = Math.min(minNo, arr[mid]);
                high = mid - 1;
            }
        }

        return minNo;
    }
}
