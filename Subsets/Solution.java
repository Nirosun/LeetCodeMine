public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (S.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(S);

        long ceil = (long) Math.pow(2, S.length);   //max(bitvector) + 1

        for (int i = 0; i < ceil; i ++) {   // generate every possible bitvector
            result.add(new ArrayList<Integer>());
            for (int j = 0; j < S.length; j ++) {
                long x = (long) Math.pow(2, j);
                if ((i & x) == x) {
                    result.get(i).add(S[j]);
                }
            }
        }
        return result;
    }
}
