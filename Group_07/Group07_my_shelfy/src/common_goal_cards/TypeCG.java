package common_goal_cards;

public enum TypeCG {
	A, B, C, D, E, F, G, H, I, L, M, N;

	private int getColHeight(String[][] matrix, int col) { // method used in case: A
		int height = 0;

		for (int row = 0; row < matrix.length; row++) {
			if (matrix[row][col] != null) {
				height++;
			}
		}

		return height;
	}

	private boolean isDiagonal(String[][] matrix, int startRow, int startCol) {// method used in case: B
		String tileType = matrix[startRow][startCol];

		// Check if the current diagonal has five tiles of the same type
		for (int i = 0; i < 5; i++) {
			if (!matrix[startRow + i][startCol + i].equals(tileType)) {
				return false;
			}
		}

		return true; // Diagonal of five same tiles found
	}

	private boolean isFormingX(String[][] matrix, int centerRow, int centerCol) {// method used in case: C
		String tileType = matrix[centerRow][centerCol];
		// Check if five tiles form an X pattern with the same tile type
		if (matrix[centerRow - 2][centerCol - 2].equals(tileType)
				&& matrix[centerRow - 1][centerCol - 1].equals(tileType)
				&& matrix[centerRow + 1][centerCol + 1].equals(tileType)
				&& matrix[centerRow + 2][centerCol + 2].equals(tileType)
				&& matrix[centerRow - 2][centerCol + 2].equals(tileType)
				&& matrix[centerRow - 1][centerCol + 1].equals(tileType)
				&& matrix[centerRow + 1][centerCol - 1].equals(tileType)
				&& matrix[centerRow + 2][centerCol - 2].equals(tileType)) {
			return true;
		}

		return false;
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

	private boolean checkCornerGroup(String[][] matrix, String tileType, int startRow, int startCol) {
		// Check if all four corners have the same tile type
		return matrix[startRow][startCol].equals(tileType) && matrix[startRow][startCol + 1].equals(tileType)
				&& matrix[startRow + 1][startCol].equals(tileType)
				&& matrix[startRow + 1][startCol + 1].equals(tileType);
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

	private boolean hasTypeInPreviousColumns(String[][] matrix, int row, int col, String type) {
		// Check the previous columns for the presence of the given type in the same row
		for (int c = 0; c < col; c++) {
			if (matrix[row][c] != null && matrix[row][c].equals(type)) {
				return true;
			}
		}
		return false;
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

	private boolean contains(String[] array, String value, int endIndex) {
		for (int i = 0; i < endIndex; i++) {
			if (array[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		switch (this) {
			case A:
				return "5 colonne con altezza crescente o decrescente";
			case B:
				return "diagonale con tessere dello stesso tipo";
			case C:
				return "cinque tessere dello stesso tipo che formano una X";
			case D:
				return "4 gruppi separati di 4 tessere dello stesso tipo";
			case E:
				return "4 righe formate da 5 tessere di massimo 3 tipi differenti";
			case F:
				return "4 tessere dello stesso tipo nei 4 angoli";
			case G:
				return "6 gruppi di 2 tessere dello stesso tipo";
			case H:
				return "3 colonne formate da 6 tessere di massimo 3 tipi differenti";
			case I:
				return "2 colonne formate ciascuna da 6 tipi diversi di tessere";
			case L:
				return "2 quadrati separati di dimensione 2x2 di tessere dello stesso tipo";
			case M:
				return "2 righe formate da 5 tipi diversi di tessere";
			case N:
				return "8 tessere dello stesso tipo (in qualunque posizione)";
			default:
				return "non valido";
		}
	}

	public boolean isReached(String[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int groupCount = 0;
		switch (this) {
		case A:
			// Check for five columns of increasing height
			for (int col = 0; col < cols - 4; col++) {
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
			for (int col = cols - 1; col >= 4; col--) {
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

		case B:
			// Check for five tiles of the same type forming a diagonal
			for (int i = 0; i <= rows - 5; i++) {
				for (int j = 0; j <= cols - 5; j++) {
					if (isDiagonal(matrix, i, j)) {
						return true;
					}
				}
			}
			return false; // No diagonal of five same tiles found

		case C:
			// Check for five tiles forming an X
			for (int row = 2; row < rows - 2; row++) {
				for (int col = 2; col < cols - 2; col++) {
					if (isFormingX(matrix, row, col)) {
						return true;
					}
				}
			}
			return false; // X pattern not found

		case D:
			groupCount = 0;

			// Check for four groups of four entities with the same tile type
			for (int i = 0; i <= rows - 4; i++) {
				for (int j = 0; j <= cols - 4; j++) {
					if (isGroupOfFour(matrix, i, j)) {
						groupCount++;
					}
				}
			}
			return groupCount == 4; // Return true if there are exactly four groups

		case E:
			// Check for four lines with five tiles, each with a maximum of three different
			// types
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j <= cols - 5; j++) {
					// Check horizontal lines
					if (isLineValid(matrix, i, j, i, j + 4)) {
						return true;
					}
				}
			}

			for (int i = 0; i <= rows - 5; i++) {
				for (int j = 0; j < cols; j++) {
					// Check vertical lines
					if (isLineValid(matrix, i, j, i + 4, j)) {
						return true;
					}
				}
			}
			return false;

		case F:
			// Check the top-left corner
			String topLeft = matrix[0][0];
			if (topLeft != null && checkCornerGroup(matrix, topLeft, 0, 0)) {
				return true;
			}

			// Check the top-right corner
			String topRight = matrix[0][cols - 1];
			if (topRight != null && checkCornerGroup(matrix, topRight, 0, cols - 1)) {
				return true;
			}

			// Check the bottom-left corner
			String bottomLeft = matrix[rows - 1][0];
			if (bottomLeft != null && checkCornerGroup(matrix, bottomLeft, rows - 1, 0)) {
				return true;
			}

			// Check the bottom-right corner
			String bottomRight = matrix[rows - 1][cols - 1];
			if (bottomRight != null && checkCornerGroup(matrix, bottomRight, rows - 1, cols - 1)) {
				return true;
			}
			return false;

		case G:
			// Check for six groups of two tiles with the same type
			groupCount = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (isGroupOfTwo(matrix, i, j)) {
						groupCount++;
					}
				}
			}
			return groupCount == 6; // Return true if there are exactly six groups

		case H:
			if (cols < 3) {
				return false; // Matrix should have at least 3 columns
			}

			// Check each column
			for (int col = 0; col < cols; col++) {
				int typeCount = 0; // Count the number of different types in the column

				// Check each row in the current column
				for (int row = 0; row < rows; row++) {
					String currentType = matrix[row][col];

					// Ignore null or empty cells
					if (currentType == null || currentType.isEmpty()) {
						continue;
					}

					if (typeCount == 0) {
						typeCount++;
					} else {
						// If the current type is different from the types already encountered in the
						// column
						if (!hasTypeInPreviousColumns(matrix, row, col, currentType)) {
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

		case I:
			// Check for two columns with six different types of tiles
			for (int col = 0; col < cols; col++) {
				int count = 0;
				boolean[] tileTypes = new boolean[6]; // Array to track tile types

				for (int row = 0; row < rows; row++) {
					String tile = matrix[row][col];

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

		case L:
			String firstQuad = null;

			// Iterate through the matrix to find the first 2x2 square
			for (int i = 0; i < rows - 1; i++) {
				for (int j = 0; j < cols - 1; j++) {
					String currentQuad = getQuadAsString(matrix, i, j);
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

		case M:
			// Check for two lines with five different tile types
			String[] line1 = new String[cols];
			String[] line2 = new String[cols];
			int count1 = 0;
			int count2 = 0;

			// Populate line1 with the first row and line2 with the second row
			for (int col = 0; col < cols; col++) {
				line1[col] = matrix[0][col];
				line2[col] = matrix[1][col];
			}

			// Count the number of different tile types in each line
			for (int col = 0; col < cols; col++) {
				if (!contains(line1, line1[col], col)) {
					count1++;
				}
				if (!contains(line2, line2[col], col)) {
					count2++;
				}
			}

			// Return true if both lines have five different tile types
			return count1 == 5 && count2 == 5;

		case N:
			int[] tileCounts = new int [10];
			// Count the number of tiles of each type
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					String tile = matrix[row][col];
					tileCounts [tile.charAt (0) ]++;
				}
			}
			// Check if any tile type has a count of eight
			for (int count : tileCounts) {
				if (count == 8){
					return true;
					}
				}

		default:
			return false;
		}
	}
}
