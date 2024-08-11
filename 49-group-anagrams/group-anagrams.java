class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chararray = s.toCharArray();
            Arrays.sort(chararray);
            String ss = new String(chararray);
            if (!map.containsKey(ss)) {
                map.put(ss, new ArrayList<>());
            }
            map.get(ss).add(s);
        }
        return new ArrayList<>(map.values());
        
    }
}