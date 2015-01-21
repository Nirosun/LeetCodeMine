public class Solution {
  public String getPermutation(int n, int k) {
    ArrayList<Character> chars = new ArrayList<Character>();

    for (int i = 0; i < n; i ++) {
      chars.add((char)('1' + i));
    }

    k --;   // change to zero-based

    char[] tmp = new char[n]; // store the permutation chars
    int id = 0; // index in tmp

    for (int i = n - 1; i >= 1; i --) {
      int f = fact(i);  // (n-1)!
      int c = k / f;    // index in chars
      tmp[id++] = chars.get(c);
      chars.remove(c);  // remove used char
      k = k % f;        // index for next step
    }

    tmp[id] = chars.get(0);

    return new String(tmp);

  }

  private int fact(int n) {
    if (n == 0 || n == 1)
      return 1;
    return n * fact(n - 1);
  }
}
