package leetcode.explore.linkedlist.twopointer;

public class RemoveNthNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        if (node == null) {
            return head.next;
        }
        ListNode nNode = head;
        while (node.next != null) {
            node = node.next;
            nNode = nNode.next;
        }
        nNode.next = nNode.next.next;
        return head;
    }
}
