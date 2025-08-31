class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        HashSet <Integer> hashNums = new HashSet<>();
        for (int num : nums) {
            if (hashNums.contains(num)) return true;
            
            hashNums.add(num);
        }
        return false;

    }
}