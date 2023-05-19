package common_goal_summary;

public class Five_tiles_of_the_same_type_forming_an_X {
    public boolean checkMatrix(String[][] matrix) {
        int sizeRows = matrix.length;
        int sizeCols = matrix[0].length;

        // Check for five tiles forming an X
        for (int row = 2; row < sizeRows - 2; row++) {
            for (int col = 2; col < sizeCols - 2; col++) {
                if (isFormingX(matrix, row, col)) {
                    return true;
                }
            }
        }

        return false; // X pattern not found
    }

    private boolean isFormingX(String[][] matrix, int centerRow, int centerCol) {
        String tileType = matrix[centerRow][centerCol];
        int size = matrix.length;

        // Check if five tiles form an X pattern with the same tile type
        if (matrix[centerRow - 2][centerCol - 2].equals(tileType) &&
                matrix[centerRow - 1][centerCol - 1].equals(tileType) &&
                matrix[centerRow + 1][centerCol + 1].equals(tileType) &&
                matrix[centerRow + 2][centerCol + 2].equals(tileType) &&
                matrix[centerRow - 2][centerCol + 2].equals(tileType) &&
                matrix[centerRow - 1][centerCol + 1].equals(tileType) &&
                matrix[centerRow + 1][centerCol - 1].equals(tileType) &&
                matrix[centerRow + 2][centerCol - 2].equals(tileType)) {
            return true;
        }

        return false;
    }
}
