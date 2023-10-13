import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        List<List<String>> solutions = new ArrayList<>();
        Queens(board, 0, solutions);

        // Convert List<List<String>> to String[][]
        String[][] resultArray = convertToArray(solutions);

        // Print or process the solutions as needed
        printArray(resultArray);
    }

    private static void Queens(boolean[][] board, int row, List<List<String>> solutions) {
        // Base case: if all queens are placed, add the current solution to the list
        if (row == board.length) {
            solutions.add(createSolution(board));
            return;
        }

        // Try placing the queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Place the queen
                Queens(board, row + 1, solutions); // Recur for the next row
                board[row][col] = false; // Backtrack to explore other possibilities
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if there is no queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }

        // Check if there is no queen in the left diagonal
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i])
                return false;
        }

        // Check if there is no queen in the right diagonal
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - i][col + i])
                return false;
        }

        // If all conditions are met, it's safe to place the queen
        return true;
    }

    private static List<String> createSolution(boolean[][] board) {
        // Convert the boolean board to a list of strings
        List<String> solution = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder rowString = new StringBuilder();
            for (boolean cell : row) {
                rowString.append(cell ? 'Q' : '.');
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
