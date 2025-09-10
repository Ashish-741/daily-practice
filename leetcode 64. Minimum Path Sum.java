import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return min(grid, 0, 0, dp);
    }

    public int min(int[][] grid, int cr, int cc, int[][] dp) {
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc];
        }
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[cr][cc] != -1) return dp[cr][cc];

        int down = min(grid, cr + 1, cc, dp);
        int right = min(grid, cr, cc + 1, dp);

        return dp[cr][cc] = grid[cr][cc] + Math.min(down, right);
    }
}
