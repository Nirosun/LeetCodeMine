public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i ++) {
            for (int j = i - 1; j > 0; j --) {
                l.set(j, l.get(j - 1) + l.get(j));
            }
            l.add(1);
        }
        return l;
    }
}
