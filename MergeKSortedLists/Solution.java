/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

  public ListNode mergeKLists(List<ListNode> lists) {
    final int size = lists.size();

    if (size == 0) return null;
    if (size == 1) return lists.get(0);
    if (size == 2) return mergeTwoLists(lists.get(0), lists.get(1));

    return mergeTwoLists(mergeKLists(lists.subList(0, size / 2)),
      mergeKLists(lists.subList(size / 2, size)));

  }

  // TLE
  /*public ListNode mergeKLists(List<ListNode> lists) {
    if (lists.isEmpty()) return null;

    ListNode l = lists.get(0);

    for (int i = 0; i < lists.size() - 1; i ++) {
      l = mergeTwoLists(l, lists.get(i + 1));
    }

    return l;
  }*/

  /*
  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);

    dummy.next = l1;
    l1 = dummy;

    ListNode n1, n2;

    while (l1.next != null && l2 != null) {
      n1 = l1.next;
      n2 = l2.next;
      if (l1.next.val > l2.val) {
        l1.next = l2;
        l2.next = n1;
        l2 = n2;
      }
      else {
        l1 = n1;
      }
    }

    if (l2 != null) {
      l1.next = l2;
    }

    return dummy.next;
  }*/

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0);
    ListNode dummy = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        l.next = l1;
        l1 = l1.next;
      }
      else {
        l.next = l2;
        l2 = l2.next;
      }
      l = l.next;
    }

    if (l1 != null) l.next = l1;
    else  l.next = l2;

    return dummy.next;
  }
}
