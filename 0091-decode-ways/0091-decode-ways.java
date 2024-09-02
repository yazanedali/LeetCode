class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int []dp = new int [s.length() +1];
        dp[s.length()] = 1; //end of the string, there is only one way to decode it(not the last number).

        for (int i= s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                dp[i] = 0;  // This position cannot be the beginning of a correct decoding
            else {
                dp[i] = dp[i + 1];

                if (i + 1 < s.length() && (s.charAt(i) == '1' ||
                        (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) 
                    //If we can use the current letter with the next letter to form a number between "10" and "26"
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}