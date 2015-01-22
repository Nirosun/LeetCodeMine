public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0;
    int j = -1;

    for (int i = 0, sum = 0; i < gas.length; i ++) {
      total += gas[i] - cost[i];
      sum += gas[i] - cost[i];

      if (sum < 0) {
        j = i;
        sum = 0;
      }
    }

    return total >= 0 ? j + 1 : -1;
  }
}
