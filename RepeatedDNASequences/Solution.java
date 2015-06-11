public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int SIZE = 10;
        
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        
        for (int i = 0; i <= s.length() - SIZE; i ++) {
            String sub = s.substring(i, i + SIZE);
            if (!map.containsKey(sub)) {
                map.put(sub, false);
            }
            else {
                map.put(sub, true);
            }
        }
        
        List<String> res = new ArrayList<String>(); 
        
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue().equals(true)) {
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
}