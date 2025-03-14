package edu.grinnell.csc207.listlab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void listAddSize10() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }
    
    @Test
    public void listGet() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(0, list.get(1));
    }

    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }
}
