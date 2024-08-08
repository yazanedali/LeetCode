public class Solution {
    public bool CanJump(int[] nums) {
        
            int goal = nums.Length-1;
            for(int i=nums.Length-1; i>=0;i--)
            {
                if (i + nums[i] >= goal)
                    goal = i;
            }
            if (goal==0)
                return true;
            else
                return false;
    }
}