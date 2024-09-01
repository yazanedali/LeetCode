class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int max1 = helper(Arrays.copyOfRange(nums, 1, nums.length)); //skip the first house
        int max2 = helper(Arrays.copyOfRange(nums, 0, nums.length-1)); //skip the last house
        
        return Math.max(max1, max2);   
    }


    private int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        //[rob1, rob2, num, num+1, num+2,...]
        for (int num : nums){
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }


}