public class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> strs = new ArrayList<String>();
        
        for (int i = 0; i < nums.length; i ++) {
            strs.add("" + nums[i]);
        }
        
        Collections.sort(strs, new Comparator<String>() {
            public int compare (String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);    // reversed order
            }
        });
        
        if (strs.get(0).equals("0"))    return "0";
        
        String res = "";
        for (String s : strs) {
            res += s;
        }
        
        return res;
    }
}