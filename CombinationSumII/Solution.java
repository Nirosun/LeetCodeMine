public class Solution {

    List<List<Integer>> result;
    List<Integer> stack;
    Set<String> used;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        stack = new ArrayList<Integer>();
        used = new HashSet<String>();
        this.target = target;

        Arrays.sort(candidates);

        search(candidates, 0);

        return result;
    }

    void search(int[] candidates, int sum) {
        if (sum == target) {
            List<Integer> l = new ArrayList<Integer>(stack);
            String uid = l.toString();
            if (!used.contains(uid)) {
                result.add(l);
                used.add(uid);
            }
            return;
        }

        if (candidates == null) return;

        for (int i = 0; i < candidates.length; i ++) {
            if (sum + candidates[i] > target) return;
            stack.add(candidates[i]);

            if (i + 1 < candidates.length) {
                // use part of the candidates array to avoid duplication
                search(Arrays.copyOfRange(candidates, i + 1, candidates.length), sum + candidates[i]);
            }
            else {
                search(null, sum + candidates[i]);
            }

            stack.remove(stack.size() - 1);
        }

    }
}
