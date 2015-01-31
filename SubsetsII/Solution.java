public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();

        if (num.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(num);

        //long ceil = (long) Math.pow(2, S.length);   //max(bitvector) + 1
        int ceil = 1 << num.length;

        for (int i = 0; i < ceil; i ++) {   // generate every possible bitvector
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < num.length; j ++) {
                //long x = (long) Math.pow(2, j);
                int x = 1 << j;
                if ((i & x) == x) {
                    sub.add(num[j]);
                }
            }
            set.add(sub);
        }
        result.addAll(set);

        return result;
    }

}
