class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        Integer[][] dp = new Integer[m][n];
        return Math.max(1, dfs(0, 0, dungeon, dp));
    }

    private int dfs(int i, int j, int[][] d, Integer[][] dp) {
        int m = d.length, n = d[0].length;
        if (i == m - 1 && j == n - 1) return 1 - Math.min(0, d[i][j]);
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        if (dp[i][j] != null) return dp[i][j];
        int down = dfs(i + 1, j, d, dp), right = dfs(i, j + 1, d, dp);
        int need = Math.min(down, right) - d[i][j];
        return dp[i][j] = Math.max(1, need);
    }
}
