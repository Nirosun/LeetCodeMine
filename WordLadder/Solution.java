public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {

        Queue<String> queue = new LinkedList<String>();

        Set<String> visited = new HashSet<String>();

        String END_LEVEL = new String();

        queue.add(start);
        queue.add(END_LEVEL);

        int level = 0;

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            // differentiate different levels
            if (cur == END_LEVEL) {
                level ++;
                if (!queue.isEmpty())   queue.add(END_LEVEL);
            }
            else {
                if (cur.equals(end))    return ++level; // plus the start one

                char[] word = cur.toCharArray();

                // examine all possible transformations by a character
                for (int i = 0; i < word.length; i ++) {
                    char old = word[i];

                    for (char c = 'a'; c <= 'z'; c ++) {
                        if (c == old)   continue;
                        word[i] = c;
                        String s = new String(word);
                        if (dict.contains(s) && !visited.contains(s)) {
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                    word[i] = old;
                }
            }

        }

        return 0;

    }
}
