/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)   return null;
        Map<RandomListNode, RandomListNode> map =
            new HashMap<RandomListNode, RandomListNode>();
        RandomListNode ptr = head;

        while (ptr != null) {
            RandomListNode n = new RandomListNode(ptr.label);
            map.put(ptr, n);
            ptr = ptr.next;
        }

        ptr = head;

        while (ptr != null) {
            RandomListNode n = map.get(ptr);
            n.next = map.get(ptr.next);
            n.random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return map.get(head);
    }

}
