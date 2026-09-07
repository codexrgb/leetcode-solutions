class Solution {
    public int distinctSubseqII(String s) {
    
        int MOD = 1_000_000_007;
        int n = s.length();

        // dp[i] = number of distinct subsequences
        // including the empty subsequence using first i characters
        long[] dp = new long[n + 1];

        dp[0] = 1;

        // Last occurrence of each character
        int[] last = new int[26];

        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';

            // Each existing subsequence:
            // 1. Don't take current character
            // 2. Take current character
            dp[i] = (2 * dp[i - 1]) % MOD;

            // If character appeared before, remove duplicates
            if (last[ch] != 0) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + MOD) % MOD;
            }

            last[ch] = i;
        }

        // Remove the empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}
        
    