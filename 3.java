class Solution {
    int[][] dist = new int[26][26];
    Integer[][][] dp;
    public int minimumDistance(String word) {
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                dist[i][j] = calc(i, j);
        dp = new Integer[word.length()][27][27];
        return dfs(word, 0, 26, 26);
    }

    private int dfs(String w, int i, int l, int r) {
        if (i == w.length()) return 0;
        if (dp[i][l][r] != null) return dp[i][l][r];
        int c = w.charAt(i) - 'A';
        int useLeft = dist[l][c] + dfs(w, i + 1, c, r);
        int useRight = dist[r][c] + dfs(w, i + 1, l, c);
        return dp[i][l][r] = Math.min(useLeft, useRight);
    }

    private int calc(int a, int b) {
        if (a == 26 || b == 26) return 0;
        int ax = a / 6, ay = a % 6, bx = b / 6, by = b % 6;
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}
