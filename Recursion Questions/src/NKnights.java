import java.util.ArrayList;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n = 4; // Adjust the value of n as needed
        boolean[][] board = new boolean[n][n];
        int knights = 4; // Adjust the number of knights as needed
        List<List<String>> solutions = new ArrayList<>();
        knight(board, 0, 0, knights, solutions);

        // Convert List<List<String>> to String[][]
        String[][] resultArray = convertToArray(solutions);

        // Print or process the solutions as needed
        printArray(resultArray);
    }

    static void knight(boolean[][] board, int row, int col, int knights, List<List<String>> solutions) {
        if (knights == 0) {
            solutions.add(createSolution(board));
            return;
        }
        if (row == board.length - 1 && col == board.length)
            return;
        if (col == board.length) {
            knight(board, row + 1, 0, knights, solutions);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1, solutions);
            board[row][col] = false;
        }
        knight(board, row, col + 1, knights, solutions);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Add your logic to check if placing a knight at [row, col] is safe
        // You can use the isValid function to check if the cell is within the board boundaries
        // and add additional checks based on the knight's moves.
        return isValid(board, row, col) && !board[row][col];
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static List<String> createSolution(boolean[][] board) {
        // Convert the boolean board to a list of strings
        List<String> solution = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder rowString = new StringBuilder();
            for (boolean cell : row) {
                rowString.append(cell ? 'K' : '.');
            }
            solution.add(rowString.toString());
        }
        return solution;
    }

    private static String[][] convertToArray(List<List<String>> list) {
        // Convert List<List<String>> to a 2D String array
        String[][] array = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);
            array[i] = row.toArray(new String[0]);
        }
        return array;
    }

    private static void printArray(String[][] array) {
        // Print the 2D array in the specified format
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("\"" + array[i][j] + "\"");
                if (j < array[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");

    }
}
