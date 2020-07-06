package leetcode.explore.linkedlist.classic;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode node = head.next.next;
        boolean isNodeOdd = true;
        while (node != null) {
            if (isNodeOdd) {
                odd.next = node;
                odd = node;
            } else {
                even.next = node;
                even = node;
            }
            node = node.next;
            isNodeOdd = !isNodeOdd;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}
