package common_goal_summary;

public class Five_columns_of_increasing_or_decreasing {
    public boolean checkColumns(String[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Check for five columns of increasing height
        for (int col = 0; col < numCols - 4; col++) {
            boolean increasing = true;
            int prevHeight = getColHeight(matrix, col);

            for (int nextCol = col + 1; nextCol < col + 5; nextCol++) {
                int nextHeight = getColHeight(matrix, nextCol);

                if (nextHeight != prevHeight + 1) {
                    increasing = false;
                    break;
                }

                prevHeight = nextHeight;
            }

            if (increasing) {
                return true;
            }
        }

        // Check for five columns of decreasing height
        for (int col = numCols - 1; col >= 4; col--) {
            boolean decreasing = true;
            int prevHeight = getColHeight(matrix, col);

            for (int nextCol = col - 1; nextCol > col - 5; nextCol--) {
                int nextHeight = getColHeight(matrix, nextCol);

                if (nextHeight != prevHeight + 1) {
                    decreasing = false;
                    break;
                }

                prevHeight = nextHeight;
            }

            if (decreasing) {
                return true;
            }
        }

        return false;
    }

    private int getColHeight(String[][] matrix, int col) {
        int height = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] != null) {
                height++;
            }
        }

        return height;
    }
}
