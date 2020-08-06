package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Only one match.
 * Numbers can be negative.
 */
public class N0002_Add_Two_Numbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     * Time: O(max(N,K))
     * Space: O(max(N,K))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int overflow = 0;
        while (n1 != null || n2 != null) {
            int v1 = n1 != null ? n1.val : 0;
            int v2 = n2 != null ? n2.val : 0;
            int sum = v1 + v2 + overflow;
            overflow = sum > 9 ? 1 : 0;
            ListNode next = new ListNode(sum % 10);
            prev.next = next;
            prev = next;
            n1 = n1 != null ? n1.next : null;
            n2 = n2 != null ? n2.next : null;
        }
        if (overflow > 0) {
            prev.next = new ListNode(1);
        }
        return fakeHead.next;
    }
}
