public class Solution {
    List<String> result;
    String[] stack;
    String s;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<String>();
        stack = new String[4];
        this.s = s;

        search(0, 0);

        return result;
    }

    void search(int id, int idStack) {
        if (idStack == 4) {
            if (id == s.length()) {
                result.add(stack[0] + "." + stack[1] + "." + stack[2] + "." + stack[3]);
            }
            return;
        }

        // add 1~3 characters
        for (int i = 1; i <= 3; i ++) {
            if (id + i > s.length())    return;
            String tmp = s.substring(id, id + i);
            if (i != 1 && tmp.charAt(0) == '0')    break;

            if (Integer.parseInt(tmp) <= 255) {
                stack[idStack] = s.substring(id, id + i);
                search(id + i, idStack + 1);
            }

        }
    }
}
