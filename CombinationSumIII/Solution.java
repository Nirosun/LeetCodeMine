public class Solution {
    Integer[] nums;
    List<List<Integer>> combos;
    
    public void search(int k, int n, int currId, int currSum, int minNum) {
        if ( currId == k ) {
            if ( currSum == n ) {
                combos.add(new ArrayList<Integer>(Arrays.asList(nums)));
            }
            
            return;
        }
        
        if ( currSum + 9 * (k - currId) < n) {
            return;
        }
        if ( currSum + minNum * (k - currId) > n) {
            return;
        }
        
        for (int i = minNum; i <= 9; i ++) {
            if (currSum + i <= n) {
                nums[currId] = i;
                search(k, n, currId + 1, currSum + i, i + 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        nums = new Integer[k];
        combos = new ArrayList<List<Integer>>();
        
        search(k, n, 0, 0, 1);
        
        return combos;
    }
}