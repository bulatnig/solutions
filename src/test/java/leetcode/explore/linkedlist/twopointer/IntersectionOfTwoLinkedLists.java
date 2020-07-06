package leetcode.explore.linkedlist.twopointer;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class IntersectionOfTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // one or both lists are empty => no intersection
        }
        if (headA == headB) {
            return headA; // lists intersect starting from first node
        }
        Set<ListNode> visited = new HashSet<>(Arrays.asList(headA, headB));
        ListNode node = headA.next;
        while (node != null) {
            if (!visited.add(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        node = headB.next;
        while (node != null) {
            if (!visited.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // one or both lists are empty => no intersection
        }
        if (headA == headB) {
            return headA; // lists intersect starting from first node
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int sumA = sum(headA);
        int sumB = sum(headB);
        while ((sumA != sumB || nodeA != nodeB) && nodeA != null && nodeB != null) {
            if (sumA > sumB || (sumA == sumB && nodeA.val == 0)) {
                sumA -= nodeA.val;
                nodeA = nodeA.next;
            } else {
                sumB -= nodeB.val;
                nodeB = nodeB.next;
            }
        }
        return nodeA == nodeB ? nodeA : null;
    }

    private int sum(ListNode head) {
        int sum = head.val;
        ListNode node = head.next;
        while (node != null) {
            sum += node.val;
            node = node.next;
        }
        return sum;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // one or both lists are empty => no intersection
        }
        if (headA == headB) {
            return headA; // lists intersect starting from first node
        }
        ListNode nodeA = headA;
        boolean switchedA = false;
        ListNode nodeB = headB;
        boolean switchedB = false;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                if (switchedA) {
                    return null;
                } else {
                    nodeA = headB;
                    switchedA = true;
                }
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                if (switchedB) {
                    return null;
                } else {
                    nodeB = headA;
                    switchedB = true;
                }
            } else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }

    @Test
    public void test() {
        check(new int[]{4,1,8,4,5}, new int[] {5,0,1,8,4,5}, 2, 3);
        check(new int[]{0,9,1,2,4}, new int[] {3,2,4}, 3, 1);
        check(new int[]{2,6,4}, new int[] {1,5}, 3, 2);
    }

    private void check(int[] listA, int[] listB, int skipA, int skipB) {
        ListNode commonHead = buildCommonElements(listA, skipA);
        ListNode headA = buildList(listA, skipA, commonHead);
        ListNode headB = buildList(listB, skipB, commonHead);
        ListNode actual = getIntersectionNode(headA, headB);
        assertEquals(commonHead, actual);
    }
    
    private ListNode buildCommonElements(int[] listA, int skipA) {
        if (skipA >= listA.length) {
            return null;
        }
        ListNode head = new ListNode(listA[skipA]);
        ListNode prev = head;
        for (int i = skipA; i < listA.length; i++) {
            ListNode newNode = new ListNode(listA[i]);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }

    private ListNode buildList(int[] listA, int skipA, ListNode commonNodesHead) {
        if (skipA == 0) {
            return commonNodesHead;
        }
        ListNode head = new ListNode(listA[0]);
        ListNode prev = head;
        for (int i = 1; i < skipA; i++) {
            ListNode newNode = new ListNode(listA[i]);
            prev.next = newNode;
            prev = newNode;
        }
        if (skipA < listA.length) {
            prev.next = commonNodesHead;
        }
        return head;
    }

}
