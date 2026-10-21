package Search2dMatrix;

public class Search2dMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int left = 0;
        int right = (column * row) - 1;
        
        while (left <= right ) {
            int mid = left + ((right - left) / 2);
            int rowIndex = Math.floorDiv(mid, column);
            int columnIndex = Math.floorMod(mid, column);

            if (matrix[rowIndex][columnIndex] == target) {
                return true;
            }

            if (matrix[rowIndex][columnIndex] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
