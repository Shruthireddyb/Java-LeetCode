import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] grid = new int[matrix.length][matrix[0].length];
        buildHistogram(matrix, grid);
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, maxRec(grid, i, matrix[i].length));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                grid[i][j] += matrix[i][j] == '0' ? 0 : grid[i - 1][j] + 1;
            }
        }
    }

    private int maxRec(int[][] grid, int bottom, int n) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < n) {
            while (stack.peek() != -1 && grid[bottom][curIndex] <= grid[bottom][stack.peek()]) {
                max = Math.max(max, grid[bottom][stack.pop()] *
                  (curIndex - stack.peek() - 1));
            }

            stack.push(curIndex++);
        }

        while (stack.peek() != -1) {
          max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
        }

        return max;
    }
}