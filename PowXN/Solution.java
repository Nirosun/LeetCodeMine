public class Solution {
    public double pow(double x, int n) {
        if (n >= 0)
            return power(x, n);
        else
            return 1.0 / power(x, -n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1;

        double half = power(x, n / 2);

        if (n % 2 == 0) return half * half;
        else    return half * half * x;
    }
}
