package leetcode.explore.linkedlist.twopointer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListCycle {
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode node = head;
        do {
            if (!visitedNodes.add(node)) {
                return true;
            }
            node = node.next;
        } while (node != null);
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode stopper = new ListNode(0);
        ListNode prevNode;
        ListNode currentNode = head;
        do {
            if (currentNode.next == stopper) {
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
            prevNode.next = stopper;
        } while (currentNode != null);
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void test() {
        assertTrue(hasCycle(buildLinkedList(new int[]{3, 2, 0, -4}, 1)));
        assertTrue(hasCycle(buildLinkedList(new int[]{1, 2}, 0)));
        assertFalse(hasCycle(buildLinkedList(new int[]{1}, -1)));
    }

    private ListNode buildLinkedList(int[] elements, int pos) {
        ListNode head = new ListNode(elements[0]);
        ListNode posNode = null;
        if (pos == 0) {
            posNode = head;
        }
        ListNode prev = head;
        for (int i = 1; i < elements.length; i++) {
            ListNode newNode = new ListNode(elements[i]);
            prev.next = newNode;
            prev = newNode;
            if (i == pos) {
                posNode = newNode;
            }
        }
        if (pos >= 0) {
            prev.next = posNode;
        }
        return head;
    }
}
