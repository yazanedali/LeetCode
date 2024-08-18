public class Solution {
    public int[] TwoSum(int[] nums, int target) {
         Dictionary<int, int> hashmap = new Dictionary<int,int>(); //key -> value ----- value -> index
 int complement;

 for (int i = 0; i < nums.Length; i++)
 {
     complement = target - nums[i];
     if (hashmap.ContainsKey(complement))
         return new[] { hashmap[complement], i };

     hashmap[nums[i]] = i;

 }
 return null;
    }
}