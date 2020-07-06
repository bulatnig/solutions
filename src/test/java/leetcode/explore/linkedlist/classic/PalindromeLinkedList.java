package leetcode.explore.linkedlist.classic;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } else if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        prev.next = null;
        curr.next = prev;
        ListNode left = null;
        ListNode right = null;
        while (next != null) {
            if (prev.val == next.val) {
                left = prev;
                right = next;
                break;
            } else if (prev.val == curr.val) {
                left = prev;
                right = curr;
                right.next = next;
                break;
            }
            prev = curr;
            curr = next;
            next = curr.next;
            curr.next = prev;
        }
        if (left == null && right == null) {
            return false;
        }
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return left == null && right == null;
    }

    @Test
    public void test() {
        ListNode d = new ListNode(2, null);
        ListNode c = new ListNode(0, d);
        ListNode b = new ListNode(3, c);
        ListNode a = new ListNode(1, b);
        Assert.assertFalse(isPalindrome(a));
    }

}
