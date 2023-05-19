package Common_goals_summary;

public class Four_tiles_in_the_four_corners {
    public boolean checkMatrix(String[][] in_matrix) {
        int sizeRows = in_matrix.length;
        int sizeCols = in_matrix[0].length;

        // Check the top-left corner
        String topLeft = in_matrix[0][0];
        if (topLeft != null && checkCornerGroup(in_matrix, topLeft, 0, 0)) {
            return true;
        }

        // Check the top-right corner
        String topRight = in_matrix[0][sizeCols - 1];
        if (topRight != null && checkCornerGroup(in_matrix, topRight, 0, sizeCols - 1)) {
            return true;
        }

        // Check the bottom-left corner
        String bottomLeft = in_matrix[sizeRows - 1][0];
        if (bottomLeft != null && checkCornerGroup(in_matrix, bottomLeft, sizeRows - 1, 0)) {
            return true;
        }

        // Check the bottom-right corner
        String bottomRight = in_matrix[sizeRows - 1][sizeCols - 1];
        if (bottomRight != null && checkCornerGroup(in_matrix, bottomRight, sizeRows - 1, sizeCols - 1)) {
            return true;
        }

        return false;
    }

    private boolean checkCornerGroup(String[][] matrix, String tileType, int startRow, int startCol) {
        // Check if all four corners have the same tile type
        return matrix[startRow][startCol].equals(tileType)
                && matrix[startRow][startCol + 1].equals(tileType)
                && matrix[startRow + 1][startCol].equals(tileType)
                && matrix[startRow + 1][startCol + 1].equals(tileType);
    }
}
