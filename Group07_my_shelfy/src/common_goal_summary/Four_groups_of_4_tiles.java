package Common_goals_summary;

public class Four_groups_of_4_tiles {
    public boolean check_matrix(String[][] in_matrix) {
        int size_rows = in_matrix.length;
        int size_cols = in_matrix[0].length;
        int groupCount = 0;

        // Check for four groups of four entities with the same tile type
        for (int i = 0; i <= size_rows - 4; i++) {
            for (int j = 0; j <= size_cols - 4; j++) {
                if (isGroupOfFour(in_matrix, i, j)) {
                    groupCount++;
                }
            }
        }

        return groupCount == 4; // Return true if there are exactly four groups
    }

    private boolean isGroupOfFour(String[][] matrix, int startRow, int startCol) {
        String tileType = matrix[startRow][startCol];
        
        // Check if the current group of four entities have the same tile type
        for (int i = startRow; i < startRow + 4; i++) {
            for (int j = startCol; j < startCol + 4; j++) {
                if (!matrix[i][j].equals(tileType)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
