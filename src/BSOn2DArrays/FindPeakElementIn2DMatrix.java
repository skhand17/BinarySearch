package BSOn2DArrays;

public class FindPeakElementIn2DMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {4, 2, 5, 1, 4, 5},
                {2, 9, 3, 2, 3, 2},
                {1, 7, 6, 0, 1, 3},
                {3, 6, 2, 3, 7, 2}
        };

        int[] peakEleCoordinates = findPeakEle(matrix);
        for(int i: peakEleCoordinates){
            System.out.print(i + " ");
        }
    }

    public static int[] findPeakEle(int[][] matrix) {

        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int high = m - 1;

        while (low <= high) {

            int mid = (low + high)/2;
            int row = maxElement(matrix, n, m, mid);

            int left = mid - 1 >=0 ? matrix[row][mid - 1] : -1;
            int right = mid + 1 < m ? matrix[row][mid + 1] : -1;

            if(matrix[row][mid] > left && matrix[row][mid] > right){
                return new int[]{row, mid};
            } else if (matrix[row][mid] < left){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static int maxElement(int[][] matrix, int n, int m, int mid) {
        int maxEle = Integer.MIN_VALUE;
        int maxRow = -1;

        for(int i=0; i<n; i++){

            if(matrix[i][mid] >= maxEle){
                maxRow = i;
                maxEle = matrix[i][mid];
            }
        }

        return maxRow;
    }
}
