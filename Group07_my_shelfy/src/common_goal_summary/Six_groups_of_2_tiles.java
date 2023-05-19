package common_goal_summary;

public class Six_groups_of_2_tiles {
    public boolean checkMatrix(String[][] inMatrix) {
        int rows = inMatrix.length;
        int cols = inMatrix[0].length;

        // Check for six groups of two tiles with the same type
        int groupCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isGroupOfTwo(inMatrix, i, j)) {
                    groupCount++;
                }
            }
        }

        return groupCount == 6; // Return true if there are exactly six groups
    }

    private boolean isGroupOfTwo(String[][] matrix, int startRow, int startCol) {
        String tileType = matrix[startRow][startCol];

        // Check if the current group of two tiles have the same type
        for (int i = startRow; i < startRow + 2; i++) {
            for (int j = startCol; j < startCol + 2; j++) {
                if (!matrix[i][j].equals(tileType)) {
                    return false;
                }
            }
        }

        return true;
    }
}
