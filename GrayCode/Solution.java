public class Solution {
  public List<Integer> grayCode(int n) {
    ArrayList<Integer> gray = new ArrayList<Integer>();

    for (int i = 0; i < 1 << n; i ++) {
      gray.add(i ^ (i >> 1));
    }

    return gray;
  }
}
