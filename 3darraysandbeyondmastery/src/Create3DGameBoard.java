class Create3DGameBoard {
    public static String create3DGameBoard(int levels, int rows, int cols) {
        // Check for valid dimensions
        if (levels <= 0 || rows <= 0 || cols <= 0) {
            return "";
        }

        // Create and fill 3D array
        int[][][] board = new int[levels][rows][cols];

        for (int l = 0; l < levels; l++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {

                    int base = (l + 1) + (r + 1) + (c + 1);

                    boolean isEdge =
                            (l == 0 || l == levels - 1) ||
                                    (r == 0 || r == rows - 1) ||
                                    (c == 0 || c == cols - 1);

                    int value;
                    if (isEdge) {
                        value = base * 10;
                    } else {
                        value = base;
                    }

                    board[l][r][c] = value;
                }
            }
        }


        String result = "";
        for (int l = 0; l < levels; l++) {
            result += "Level " + l + ":\n";
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    result += board[l][r][c];
                    if (c < cols - 1) result += " ";
                }
                result += "\n";
            }
            if (l < levels - 1) result += "\n";
        }

        return result;
    }
}