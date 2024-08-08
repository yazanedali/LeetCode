public class Solution {
    public string Convert(string s, int numRows) {
         if (numRows == 1)
     return s;
 string result = "";
 int increment = 2 * (numRows - 1);

 for (int r = 0 ; r < numRows; r++)
 {
     int i = r;
     while (i < s.Length)
     {
         result += s[i];
         if (r > 0 && r < numRows - 1)
         {
             int secondIndex = i + increment - 2 * r;
             if (secondIndex < s.Length)
             {
                 result += s[secondIndex];
             }
         }
         i += increment;
     }
 }
 return result;

    }
}