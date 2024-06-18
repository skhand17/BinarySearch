package BSOn2DArrays;

public class SearchInA2DMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {3, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29}
        };

        int target = 30;

        boolean isPresent = binarySearchOn2D(matrix, target);
        System.out.println(isPresent);
    }

    public static boolean binarySearchOn2D(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            int row = mid /m ;
            int col = mid % m;

            if(matrix[row][col] == target)
                return true;
            else if (target < matrix[row][col]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
