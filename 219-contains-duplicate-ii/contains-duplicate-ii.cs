public class Solution {
    public bool ContainsNearbyDuplicate(int[] nums, int k) {
        Dictionary<int,int> indexmap = new Dictionary<int,int>();
for(int i = 0; i < nums.Length; i++)
{
    if (indexmap.ContainsKey(nums[i]))
        if(i-indexmap[nums[i]] <= k)
            return true;
    indexmap[nums[i]] = i;
}
return false;
    }
}