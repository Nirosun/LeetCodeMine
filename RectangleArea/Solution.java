public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = ( C - A ) * ( D - B );
        int area2 = ( G - E ) * ( H- F );
        
        int total = area1 + area2;
        
        if ( C <= E || G <= A || B >= H || D <= F ) {
            return total;
        }
        
        int left = Math.max( A, E );
        int right = Math.min( C, G );
        int top = Math.min( D, H );
        int bottom = Math.max( B, F );
        
        return total - ( right - left ) * ( top - bottom );
    }
}