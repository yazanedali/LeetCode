class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }


        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 ; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    if (index < k) {
                        res[index++] = num;
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }
}