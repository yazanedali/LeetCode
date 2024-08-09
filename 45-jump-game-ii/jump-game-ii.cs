public class Solution {
    public int Jump(int[] nums) {
        int resulte = 0;
int left = 0, right = 0;
while (right < nums.Length - 1)
{
    int newright = 0;
    for(int i = left; i <= right; i++)
    {
        newright = Math.Max(newright, i + nums[i]);
    }
    left = right + 1;
    right = newright;
    resulte++;
}
return resulte;
    }
}