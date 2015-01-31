public class Solution {
    int k;
    Integer[] num;
    Integer[] stack;
    List<List<Integer>> combos;

    public List<List<Integer>> combine(int n, int k) {
        // initialize
        this.combos = new ArrayList<List<Integer>>();
        this.k = k;
        this.num = new Integer[n];
        this.stack = new Integer[k];

        for (int i = 0; i < n; i ++)
            num[i] = i + 1;

        search(0);

        return combos;
    }

    // dfs
    public void search(int step) {
        if (step == k) {
            this.combos.add(new ArrayList<Integer>(Arrays.asList(stack)));
            return;
        }

        for (Integer n : num) {
            if (step > 0 && n <= stack[step - 1])   continue;
            stack[step] = n;
            search(step + 1);
        }

    }
}
