public class Solution {
  public List<List<Integer>> fourSum(int[] num, int target) {
    List<List<Integer>> res = new ArrayList();

    if (num.length < 4) {
      return res;
    }

    Arrays.sort(num);

    HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();

    for (int a = 0; a < num.length - 1; a ++) {
      for (int b = a + 1; b < num.length; b ++) {
        int twoSum = num[a] + num[b];
        if (!map.containsKey(twoSum)) {
          map.put(twoSum, new ArrayList<int[]>());
        }
        map.get(twoSum).add(new int[] {a, b});
      }
    }

    for (int c = 0; c < num.length - 1; c ++) {
      for (int d = c + 1; d < num.length; d ++) {
        int key = target - num[c] - num[d];
        if (!map.containsKey(key)) continue;
        List<int[]> list = map.get(key);
        for (int k = 0; k < list.size(); k ++) {
          if (c <= (list.get(k))[1]) {
            continue;
          }
          if (!res.contains(Arrays.asList(num[(list.get(k))[0]], num[(list.get(k))[1]], num[c], num[d]))) {
            res.add(Arrays.asList(num[(list.get(k))[0]], num[(list.get(k))[1]], num[c], num[d]));
          }

        }
      }
    }

    // delete duplicate results
    /*for (int i = res.size() - 1; i >= 1; i --) {
      for (int j = i - 1; j >= 0; j --) {
        if (res.get(i).get(0) == res.get(j).get(0)
            && res.get(i).get(1) == res.get(j).get(1)
            && res.get(i).get(2) == res.get(j).get(2)
            && res.get(i).get(3) == res.get(j).get(3)) {
          res.remove(j);
          i --;
        }
      }
    }*/

    return res;
  }
}
