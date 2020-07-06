package leetcode.explore.linkedlist.twopointer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {

    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        assertEquals(2, linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        assertEquals(3, linkedList.get(1));            // returns 3
    }
}
