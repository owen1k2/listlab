package edu.grinnell.csc207.listlab;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {
    
    private int size;
    private static final int INIT_SIZE = 1000;
    private int[] list  = new int[INIT_SIZE];
    
    public void ArrayList() {
        this.size = 0;
        this.list = new int[INIT_SIZE];
    }
    
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        list[size] = value;
        size++;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        return list[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int temp = list[index];
        for(int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        return temp;
    }
}
