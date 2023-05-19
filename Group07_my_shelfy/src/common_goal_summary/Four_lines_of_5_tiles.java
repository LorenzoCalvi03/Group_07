package common_goal_summary;

public class Four_lines_of_5_tiles {
    public boolean check_lines(String[][] matrix) {
        int sizeRows = matrix.length;
        int sizeCols = matrix[0].length;

        // Check for four lines with five tiles, each with a maximum of three different types
        for (int i = 0; i < sizeRows; i++) {
            for (int j = 0; j <= sizeCols - 5; j++) {
                // Check horizontal lines
                if (isLineValid(matrix, i, j, i, j + 4)) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= sizeRows - 5; i++) {
            for (int j = 0; j < sizeCols; j++) {
                // Check vertical lines
                if (isLineValid(matrix, i, j, i + 4, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isLineValid(String[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int tileTypes = 0;

        // Collect tile types within the line
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (matrix[i][j] != null && !matrix[i][j].isEmpty()) {
                    if (tileTypes == 0) {
                        tileTypes++;
                    } else if (!matrix[i][j].equals(matrix[startRow][startCol])) {
                        if (tileTypes == 1) {
                            tileTypes++;
                        } else if (!matrix[i][j].equals(matrix[startRow][startCol + 1])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
