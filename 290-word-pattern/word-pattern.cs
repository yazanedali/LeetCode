public class Solution {
    public bool WordPattern(string pattern, string s) {
                    string[] words = s.Split(' ');
            if (words.Length != pattern.Length)
                return false;
            Dictionary<char, string> chartoword = new Dictionary<char, string>();
            Dictionary<string, char> wordtochar = new Dictionary<string, char>();

            for (int i = 0; i < pattern.Length; i++)
            {
                char c = pattern[i];
                string word = words[i];
                if (chartoword.ContainsKey(c))
                {
                    if (chartoword[c] != word)
                        return false;
                }
                else
                {
                    if (wordtochar.ContainsKey(word))
                        return false;
                }
                chartoword[c] = word;
                wordtochar[word] = c;
            }
            return true;
    }
}