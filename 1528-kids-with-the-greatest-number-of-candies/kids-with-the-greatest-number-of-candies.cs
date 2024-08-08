public class Solution
{
    public IList<bool> KidsWithCandies(int[] candies, int extraCandies)
    {
        int max = 0;
        foreach (int cand in candies)
        {
            if (cand > max)
                max = cand;
        }
        bool[] resulte = new bool[candies.Length];
        for (int i = 0; i < candies.Length; i++)
        {
            if (extraCandies+candies[i] >= max)
                resulte[i] = true;
            else
                resulte[i] = false;
        }

        return resulte;

    }
}