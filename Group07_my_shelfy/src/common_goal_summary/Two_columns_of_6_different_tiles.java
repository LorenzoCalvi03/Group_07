package Common_goals_summary;

public class Two_columns_of_6_different_tiles {
    public boolean checkColumns(String[][] in_matrix) {
        int rows = in_matrix.length;
        int cols = in_matrix[0].length;

        // Check for two columns with six different types of tiles
        for (int col = 0; col < cols; col++) {
            int count = 0;
            boolean[] tileTypes = new boolean[6]; // Array to track tile types

            for (int row = 0; row < rows; row++) {
                String tile = in_matrix[row][col];

                if (tile != null && !tile.isEmpty()) {
                    int tileType = getTileType(tile);

                    if (tileType >= 0 && tileType < 6 && !tileTypes[tileType]) {
                        tileTypes[tileType] = true;
                        count++;
                    }
                }
            }

            if (count == 6) {
                return true; // Found a column with six different tile types
            }
        }

        return false; // No column with six different tile types found
    }

    private int getTileType(String tile) {
        // Define your tile types and their corresponding indices here
        if (tile.equals("TypeA")) {
            return 0;
        } else if (tile.equals("TypeB")) {
            return 1;
        } else if (tile.equals("TypeC")) {
            return 2;
        } else if (tile.equals("TypeD")) {
            return 3;
        } else if (tile.equals("TypeE")) {
            return 4;
        } else if (tile.equals("TypeF")) {
            return 5;
        }

        return -1; // Invalid tile type
    }
}
