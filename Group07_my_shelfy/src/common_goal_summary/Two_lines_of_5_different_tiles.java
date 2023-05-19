package common_goal_summary;

public class Two_lines_of_5_different_tiles {
    public boolean checkLines(String[][] in_matrix) {
        int size_rows = in_matrix.length;
        int size_cols = in_matrix[0].length;

        // Check for two lines with five different tile types
        String[] line1 = new String[size_cols];
        String[] line2 = new String[size_cols];
        int count1 = 0;
        int count2 = 0;

        // Populate line1 with the first row and line2 with the second row
        for (int col = 0; col < size_cols; col++) {
            line1[col] = in_matrix[0][col];
            line2[col] = in_matrix[1][col];
        }

        // Count the number of different tile types in each line
        for (int col = 0; col < size_cols; col++) {
            if (!contains(line1, line1[col], col)) {
                count1++;
            }
            if (!contains(line2, line2[col], col)) {
                count2++;
            }
        }

        // Return true if both lines have five different tile types
        return count1 == 5 && count2 == 5;
    }

    private boolean contains(String[] array, String value, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
