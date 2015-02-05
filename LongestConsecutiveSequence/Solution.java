public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 0)	return 0;
        Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        int longest = 1;

        for (int i = 0; i < num.length; i ++)	{
            used.put(num[i], false);
        }
        for (int i : num)	{
            if (used.get(i).equals(true))	continue;
            int len = 1;
            used.put(i, true);
            for (int j = i - 1; used.containsKey(j); j --) {
                used.put(j, true);
                len ++;
            }
            for (int j = i + 1; used.containsKey(j); j ++) {
                used.put(j, true);
                len ++;
            }
            if (len > longest)	longest = len;
        }
        return longest;
    }
}
