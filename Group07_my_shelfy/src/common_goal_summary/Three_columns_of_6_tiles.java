package Common_goals_summary;

public class Three_columns_of_6_tiles {
    public boolean checkColumns(String[][] in_matrix) {
        int numRows = in_matrix.length;
        int numCols = in_matrix[0].length;

        if (numCols < 3) {
            return false; // Matrix should have at least 3 columns
        }

        // Check each column
        for (int col = 0; col < numCols; col++) {
            int typeCount = 0; // Count the number of different types in the column

            // Check each row in the current column
            for (int row = 0; row < numRows; row++) {
                String currentType = in_matrix[row][col];

                // Ignore null or empty cells
                if (currentType == null || currentType.isEmpty()) {
                    continue;
                }

                if (typeCount == 0) {
                    typeCount++;
                } else {
                    // If the current type is different from the types already encountered in the column
                    if (!hasTypeInPreviousColumns(in_matrix, row, col, currentType)) {
                        typeCount++;
                    }
                }

                // If more than three different types are found, return false
                if (typeCount > 3) {
                    return false;
                }
            }
        }

        return true; // All columns satisfy the criteria
    }

    private boolean hasTypeInPreviousColumns(String[][] matrix, int row, int col, String type) {
        // Check the previous columns for the presence of the given type in the same row
        for (int c = 0; c < col; c++) {
            if (matrix[row][c] != null && matrix[row][c].equals(type)) {
                return true;
            }
        }
        return false;
    }
}
