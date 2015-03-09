cd public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int i;
        for (i = 0; i < strs1.length && i < strs2.length; i ++) {
            int num1 = Integer.parseInt(strs1[i]);
            int num2 = Integer.parseInt(strs2[i]);
            if (num1 < num2) {
                return -1;
            }
            else if (num1 > num2) {
                return 1;
            }
        }
        for (int tmp = i; tmp < strs1.length; tmp ++) {
            if ((Integer.parseInt(strs1[tmp])) != 0)
                return 1;
        }
        for (int tmp = i; tmp < strs2.length; tmp ++) {
            if ((Integer.parseInt(strs2[tmp])) != 0)
                return -1;
        }
        return 0;
    }
}
