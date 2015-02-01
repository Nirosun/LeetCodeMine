public class Solution {

    List<List<Integer>> result;
    List<Integer> stack;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        stack = new ArrayList<Integer>();
        this.target = target;

        Arrays.sort(candidates);

        search(candidates, 0);

        return result;
    }

    void search(int[] candidates, int sum) {
        if (sum == target) {
            List<Integer> l = new ArrayList<Integer>(stack);

            result.add(l);
            return;
        }

        for (int i = 0; i < candidates.length; i ++) {
            if (sum + candidates[i] > target) return;
            stack.add(candidates[i]);

            // use part of the candidates array to avoid duplication
            search(Arrays.copyOfRange(candidates, i, candidates.length), sum + candidates[i]);

            stack.remove(stack.size() - 1);
        }

    }
}
