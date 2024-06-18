package BSOn2DArrays;

public class SearchInARowAndColumnWiseSortedMartrix {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 23;

        int[] ans = searchBinary2D(matrix, target);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] searchBinary2D(int[][] matrix, int target) {

        int row = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int col = m - 1;

        while (row < n && col >= 0){

            if(matrix[row][col] == target){
                return new int[]{row, col};
            } else if(target < matrix[row][col]){
                col --;
            } else {
                row ++;
            }
        }
        return new int[]{-1, -1};
    }
}
