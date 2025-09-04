// top down apporach

class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return count(s, t, 0, 0);
    }

    private int count(String s, String t, int i, int j) {
        if (j == t.length()) return 1; // formed full t
        if (i == s.length()) return 0; // s exhausted but t not finished

        if (dp[i][j] != -1) return dp[i][j];

        long ans; // can overflow int for large input, but LeetCode constraints fit int
        if (s.charAt(i) == t.charAt(j)) {
            ans = (long)count(s, t, i + 1, j + 1) + count(s, t, i + 1, j);
        } else {
            ans = count(s, t, i + 1, j);
        }

        return dp[i][j] = (int)ans;
    }
}




// bottom up apporach

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        long[][] dp = new long[m + 1][n + 1];

        // base case: empty t can always be formed once
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        // fill from bottom to top
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return (int)dp[0][0];
    }
}




