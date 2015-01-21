public class Solution {
    public int[] twoSum(int[] numbers, int target) {
      HashMap<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();

      for (int i = 0; i < numbers.length; i ++) {
        int diff = target - numbers[i];
        if (numToIndex.containsKey(diff)) {
          int[] results = {numToIndex.get(diff) + 1, i + 1};
          return results;
        }

        numToIndex.put(numbers[i], i);
      }

      return null;
    }
}
