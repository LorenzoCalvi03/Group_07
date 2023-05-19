package Common_goals_summary;

public class Five_tiles_in_diagonal {
    public boolean check_diagonal(String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check for five tiles of the same type forming a diagonal
        for (int i = 0; i <= rows - 5; i++) {
            for (int j = 0; j <= cols - 5; j++) {
                if (isDiagonal(matrix, i, j)) {
                    return true;
                }
            }
        }

        return false; // No diagonal of five same tiles found
    }

    private boolean isDiagonal(String[][] matrix, int startRow, int startCol) {
        String tileType = matrix[startRow][startCol];
        
        // Check if the current diagonal has five tiles of the same type
        for (int i = 0; i < 5; i++) {
            if (!matrix[startRow + i][startCol + i].equals(tileType)) {
                return false;
            }
        }

        return true; // Diagonal of five same tiles found
    }
}
