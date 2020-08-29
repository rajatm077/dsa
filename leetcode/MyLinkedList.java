package leetcode;

class MyLinkedList {

    int val;
    MyLinkedList next;
    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    public MyLinkedList(int val) {
        this.val = val;
    }
    
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0) return -1;
        MyLinkedList node = this;
        while (index-- >= 0) {
            if (node == null) return -1;
            node = node.next;
        }
        if (node == null) return -1;
        else return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList(val);
        node.next = this.next;
        this.next = node;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyLinkedList node = this;
        while (node.next != null) node = node.next;
        node.next = new MyLinkedList(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        MyLinkedList node = this;
        while (index-- > 0) node = node.next;
        if (node == null) return;
        MyLinkedList newNode = new MyLinkedList(val);
        newNode.next = node.next;
        node.next = newNode;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        MyLinkedList node = this;
        while (index-- > 0) node = node.next;
        if (node == null) return;
        node.next = node.next.next;
        node.next.next = null;
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