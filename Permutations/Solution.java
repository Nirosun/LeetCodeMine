// another method: see Permutations II, use the Next Permutation method

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length == 0) {}
        else if (num.length == 1) {
            result.add(new ArrayList<Integer>(Arrays.asList(num[0])));
        }
        else {
            for (int i = 0; i < num.length; i ++) {
                for (List<Integer> l : permute(resetOf(num, i))) {
                    l.add(num[i]);
                    result.add(l);
                }
            }
        }

        return result;
    }

    // get the array that does not contain the number at index
    public int[] resetOf(int[] num, int index) {
        int[] result = new int[num.length - 1];
        int j = 0;
        for (int i = 0; i < num.length; i ++) {
            if (i != index) result[j ++] = num[i];
        }
        return result;
    }
}
