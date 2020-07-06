package leetcode.explore.linkedlist.classic;

public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode node = head;
        ListNode newHead = null;
        while (node != null) {
            if (node.val != val) {
                newHead = node;
                break;
            }
            node = node.next;
        }
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return newHead;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode surplusNode = new ListNode(0, head);
        ListNode node = surplusNode;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return surplusNode.next;
    }
}
