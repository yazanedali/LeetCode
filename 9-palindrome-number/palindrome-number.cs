public class Solution {
    public bool IsPalindrome(int x) {
           if (x < 0) return false;

   if (x == 0) return true;

   if (x % 10 == 0) return false;

   int orignal = x;
   int reversed = 0;
   while (x > 0)
   {
       int digit = x % 10;
       reversed = reversed * 10 + digit;
       x /= 10;
   }
   return orignal == reversed;
    }
}