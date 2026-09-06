class Solution {
    int[][] memo;

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        memo = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(0, 0, s, t);
    }

    private int solve(int i, int j, String s, String t) {

        // t is completely matched
        if(j == t.length()) {
            return 1;
        }

        // s is finished
        if(i == s.length()) {
            return 0;
        }

        // Already calculated
        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        // Character does not match
        if(s.charAt(i) != t.charAt(j)) {
            memo[i][j] = solve(i + 1, j, s, t);
        }

        // Character matches
        else {
            int take = solve(i + 1, j + 1, s, t);
            int skip = solve(i + 1, j, s, t);

            memo[i][j] = take + skip;
        }

        return memo[i][j];
    }
}