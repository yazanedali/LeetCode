class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean []dp = new boolean[s.length() + 1];
        char []chars = s.toCharArray();
        Arrays.fill(dp, false);
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--){
            for (String w : wordDict){
                if (i + w.length() <= s.length() && w.contains(s.substring(i, i+ w.length())))
                    dp[i] = dp[i + w.length()];
                if (dp[i]) break;
            }
        }
        return dp[0];

    }//s = "leetcode"   ,   wordDict ={"leet", "code"}
}