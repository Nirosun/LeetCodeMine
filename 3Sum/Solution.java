public class Solution {
  public List<List<Integer>> threeSum(int[] num) {
    int a, b, c;
    List<List<Integer>> res = new ArrayList();

    if (num.length < 3) {
      return res;
    }

    Arrays.sort(num);

    for (int i = 0; i < num.length - 2; i ++) {
      if (i > 0 && num[i] == num[i-1]) {
        continue;
      }
      int j = i + 1;
      int k = num.length - 1;
      a = num[i];

      while (j < k) {
        b = num[j];
        c = num[k];
        if (a + b + c < 0) {
          j ++;
          while (j < k && num[j] == num[j-1]) {
            j ++;
          }
        }
        else if (a + b + c > 0) {
          k --;
          while (j < k && num[k] == num[k+1]) {
            k --;
          }
        }
        else {
          res.add(Arrays.asList(a, b, c));
          j ++;
          k --;
          while (j < k && num[j] == num[j-1]) {
            j ++;
          }
          while (j < k && num[k] == num[k+1]) {
            k --;
          }
        }
      }
    }

    return res;
  }
}
