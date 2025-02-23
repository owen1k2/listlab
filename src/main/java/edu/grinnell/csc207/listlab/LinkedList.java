package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {
    
    private static class Node {
        int value;
        Node next;
        
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    private Node first;
    
    public LinkedList() {
        this.first = null;
    }
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        if (this.first == null) {
            this.first = new Node(value, null);
        } else {
            Node temp = first;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        if(first == null) {
            return 0;
        }
        int size = 1;
        Node temp = first;
            while (temp.next != null){
                size++;
                temp = temp.next;
            } 
        return size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        Node temp = first;
        while(size() < index) {
            temp = temp.next;
        }
        return temp.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        Node temp = first;
        int value;
        while(size() < (index-1)) {
            temp = temp.next;
        }
        value = temp.next.value;
        temp.next = null;
        return value;
    }
}
