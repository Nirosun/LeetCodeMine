public class Solution {
  public int threeSumClosest(int[] num, int target) {
    int sum;
    int minDiff = Integer.MAX_VALUE, diff;
    List<List<Integer>> res = new ArrayList();

    if (num.length < 3) {
      return 0;
    }

    Arrays.sort(num);

    for (int i = 0; i < num.length - 2; i ++) {
      if (i > 0 && num[i] == num[i-1]) {
        continue;
      }
      int j = i + 1;
      int k = num.length - 1;
      //a = num[i];
      while (j < k) {
        //b = num[j];
        //c = num[k];
        sum = num[i] + num[j] + num[k];
        diff = sum - target;
        if (diff < 0) {
          if (-diff < abs(minDiff)) {
            minDiff = diff;
          }
          j ++;
          while (j < k && num[j] == num[j-1]) {
            j ++;
          }
        }
        else if (diff > 0) {
          if (diff < abs(minDiff)) {
            minDiff = diff;
          }
          k --;
          while (j < k && num[k] == num[k+1]) {
            k --;
          }
        }
        else {
          return target;
        }
      }
    }

    return target + minDiff;
  }

  private int abs(int a) {
    return (a >= 0) ? a : -a;
  }
}
