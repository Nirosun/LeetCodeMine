public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> appeared = new HashSet<Integer>();
        
        for (int n : nums) {
            if (appeared.contains(n)) {
                return true;
            }
            else {
                appeared.add(n);
            }
        }
        return false;
    }
}