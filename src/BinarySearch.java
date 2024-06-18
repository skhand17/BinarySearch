public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 4, 6, 7, 9, 12, 16, 17};

        int n = arr.length;
        int target = 16;

        int indexOfSearchedElement = binarySearch(arr, n, target);
        System.out.println(indexOfSearchedElement);
    }

    public static int binarySearch(int[] arr, int n, int target) {

        int low = 0;
        int high = n - 1;

        while (low <=  high) {

            int mid = (low + high)/2;

            if(arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
