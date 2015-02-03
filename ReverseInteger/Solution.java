public class Solution {
    public int reverse(int x) {
        int y = 0;
        if (x == Integer.MIN_VALUE)	return 0;
        if (x < 0)	return -reverse(-x);

        do {
            if (y > (Integer.MAX_VALUE - x % 10) / 10)
                return 0;
            y  = 10 * y + x % 10;
        } while ((x /= 10) > 0);

        return y;
    }
}
