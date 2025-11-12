class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        return dfs(m - 1, n - 1, obstacleGrid, dp);
    }

    private int dfs(int i, int j, int[][] grid, Integer[][] dp) {
        if (i < 0 || j < 0 || grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != null) return dp[i][j];
        return dp[i][j] = dfs(i - 1, j, grid, dp) + dfs(i, j - 1, grid, dp);
    }
}
