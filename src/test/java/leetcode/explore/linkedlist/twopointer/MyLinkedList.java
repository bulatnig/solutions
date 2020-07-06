package leetcode.explore.linkedlist.twopointer;

class MyLinkedList {

    private SinglyListNode head;
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        SinglyListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        SinglyListNode newNode = new SinglyListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        SinglyListNode newNode = new SinglyListNode(val);
        size++;
        if (head == null) {
            head = newNode;
        } else {
            SinglyListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            SinglyListNode node = head;
            int i = 0;
            for (; i < index - 1; i++) {
                node = node.next;
            }
            SinglyListNode newNode = new SinglyListNode(val);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
        } else {
            SinglyListNode node = head;
            int i = 0;
            for (; i < index - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
        }
    }

    static class SinglyListNode {
        private final int val;
        SinglyListNode next;

        SinglyListNode(int x) {
            val = x;
        }
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */