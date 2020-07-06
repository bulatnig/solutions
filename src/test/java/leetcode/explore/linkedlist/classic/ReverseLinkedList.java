package leetcode.explore.linkedlist.classic;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = head;
        ListNode readNode = head.next;
        resultHead.next = null;
        ListNode node;
        while (readNode != null) {
            node = readNode;
            readNode = readNode.next;
            node.next = resultHead;
            resultHead = node;
        }
        return resultHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head, null);
    }

    private ListNode reverse(ListNode read, ListNode result) {
        ListNode current = read;
        ListNode next = current.next;
        current.next = result;
        result = current;
        if (next == null) {
            return result;
        } else {
            return reverse(next, result);
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
