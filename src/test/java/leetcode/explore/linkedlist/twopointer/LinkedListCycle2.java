package leetcode.explore.linkedlist.twopointer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LinkedListCycle2 {
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode node = head;
        do {
            if (!visitedNodes.add(node)) {
                return node;
            }
            node = node.next;
        } while (node != null);
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    @Test
    public void test() {
        check(new int[]{3, 2, 0,-4}, 1);
        check(new int[]{1, 2}, 0);
        check(new int[]{1}, -1);
    }

    private void check(int[] elements, int pos) {
        ListNode[] headAndCycleStart = buildLinkedList(elements, pos);
        ListNode actual = detectCycle(headAndCycleStart[0]);
        assertEquals(headAndCycleStart[1], actual);
    }

    private ListNode[] buildLinkedList(int[] elements, int pos) {
        ListNode headNode = new ListNode(elements[0]);
        ListNode cycleStartNode = null;
        if (pos == 0) {
            cycleStartNode = headNode;
        }
        ListNode prev = headNode;
        for (int i = 1; i < elements.length; i++) {
            ListNode newNode = new ListNode(elements[i]);
            prev.next = newNode;
            prev = newNode;
            if (i == pos) {
                cycleStartNode = newNode;
            }
        }
        if (pos >= 0) {
            prev.next = cycleStartNode;
        }
        return new ListNode[] {headNode, cycleStartNode};
    }
}
