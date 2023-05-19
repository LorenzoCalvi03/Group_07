package common_goal_summary;

public class Two_groups_of_4_tiles {
    public boolean check_matrix(String[][] in_matrix) {
        int size_rows = in_matrix.length;
        int size_cols = in_matrix[0].length;
        String firstQuad = null;
        
        // Iterate through the matrix to find the first 2x2 square
        for (int i = 0; i < size_rows - 1; i++) {
            for (int j = 0; j < size_cols - 1; j++) {
                String currentQuad = getQuadAsString(in_matrix, i, j);
                if (currentQuad != null) {
                    // Save the first quad
                    if (firstQuad == null) {
                        firstQuad = currentQuad;
                    } else if (currentQuad.equals(firstQuad)) {
                        // Found a second quad matching the first quad
                        return true;
                    }
                }
            }
        }
        
        return false; // No two groups of 4 tiles found
    }
    
    private String getQuadAsString(String[][] matrix, int startRow, int startCol) {
        StringBuilder quadBuilder = new StringBuilder();
        
        // Construct the string representation of the 2x2 square
        for (int i = startRow; i < startRow + 2; i++) {
            for (int j = startCol; j < startCol + 2; j++) {
                if (matrix[i][j] == null) {
                    return null; // If any element is null, return null
                }
                quadBuilder.append(matrix[i][j]);
            }
        }
        
        return quadBuilder.toString();
    }
}
