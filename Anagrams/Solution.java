public class Solution {
  public List<String> anagrams(String[] strs) {

    List<String> result = new ArrayList<String>();

    if (strs.length == 0) return result;

    HashMap<String, List<String>> group = new HashMap();

    for (String s : strs) {
      if (s == null) continue;
      String sSorted = "";
      if (!("".equals(s))) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        //sSorted = ss.toString();  // This is WRONG!!!
        sSorted = new String(ss);
      }
      if (!group.containsKey(sSorted)) {
        group.put(sSorted, new ArrayList<String>());
      }
      group.get(sSorted).add(s);
    }

    for (String s : group.keySet()) {
      if (group.get(s).size() > 1) {
        //result.addAll(group.get(s));
        for (String tmp : group.get(s)) {
          result.add(tmp);
        }
      }
    }

    return result;

  }
}
