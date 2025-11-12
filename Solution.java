class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dfs(0, j, grid, dp));
        return ans;
    }

    private int dfs(int i, int j, int[][] g, Integer[][] dp) {
        int m = g.length, n = g[0].length;
        if (i == m - 1) return g[i][j];
        if (dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++)
            if (k != j) min = Math.min(min, dfs(i + 1, k, g, dp));
        return dp[i][j] = g[i][j] + min;
    }
}
