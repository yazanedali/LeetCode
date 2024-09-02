class Solution {

        public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;


        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) 
                    dp[j] = true; 
            }
        }
        return dp[nums.length - 1];
    }
}