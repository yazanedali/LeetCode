class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums.length == 0) {
            return 0;
        }
    Set<Integer> set = new HashSet<Integer>();
        for (int x : nums)
            set.add(x);
        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int length = 1;
                int current=num;
                while (set.contains(current + 1)) {
                    length++;
                    current++;
                }

                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}