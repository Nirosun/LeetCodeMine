public class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int n = digits.length;
    //int[] tmp = new int[n];

    for (int i = n - 1; i >= 0; i --) {
      int sum = digits[i] + carry;
      if (sum > 9) {
        digits[i] = 0;
        carry = 1;
      }
      else{
        digits[i] = sum;
        carry = 0;
        break;
      }
    }

    if (carry == 1) {
      int[] res = new int[n+1];
      for (int i = n; i >= 1; i --) {
        res[i] = digits[i - 1];
      }
      res[0] = 1;
      return res;
    }
    return digits;
  }
}

/*
public class Solution {
  public int[] plusOne(int[] digits) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    int[] result = new int[digits.length + 1];
    digits[digits.length - 1] += 1;
    for(int i = digits.length - 1; i >=0 ; i--){
      result[ i + 1 ] += digits[i];
      result[ i ] += result[ i + 1 ] / 10;
      result[ i + 1 ] %= 10;
    }

    if(result[0] == 0) return Arrays.copyOfRange(result, 1 , result.length);
    else
    return result;
  }
}
*/
