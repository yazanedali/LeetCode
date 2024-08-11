class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        Set<Character> s1 = new HashSet<Character>();
        Set<Character> s2 = new HashSet<Character>();

        for (char c : word1.toCharArray()){
            c1[c-'a']++;
            s1.add(c);
        }
        for (char c : word2.toCharArray()){
            c2[c-'a']++;
            s2.add(c);
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        return s1.equals(s2) && Arrays.equals(c1,c2);
    }
}