public class Solution {
    
    public int next(int num) {
        int res = 0;
        
        while (num > 0) {
            int tmp = num % 10;
            res += tmp * tmp;
            num /= 10;
        }
        
        return res;
    }
    
    public boolean isHappy(int n) {
        HashSet<Integer> appeared = new HashSet<Integer>();
        
        while (true) {
            if (n == 1) return true;
            
            if (appeared.contains(n))   return false;
            
            appeared.add(n);
            n = next(n);
        }
    }
}