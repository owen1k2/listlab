package edu.grinnell.csc207.listlab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class ArrayListTests {
    @Test
    public void emptyListTest() {
        ArrayList list = new ArrayList();
        assertEquals(0, list.size());
    }

    @Test
    public void listAddSize10() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }
    
    @Test
    public void listGet() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(9, list.get(9));
    }
    
    @Test
    public void listRemove() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(9);
        assertEquals('\0', list.get(9));
    }

    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }
    
    @Property
    public boolean listCheckAll(@ForAll @IntRange(min = 101, max = 1000) int sz,
                                @ForAll @IntRange(min = 0, max = 100) int index) {
        ArrayList list = new ArrayList();
        int j = 1;
        for (int i = 0; i < sz; i++) {
            list.add(j);
        }
        return list.get(index) == 1;
    }
    
    @Property
    public boolean listCheckAdd(@ForAll @IntRange(min = 0, max = 100) int index) {
        ArrayList list = new ArrayList();
        int sz = list.size();
        for (int i = 0; i < sz; i++) {
            list.add(index);
        }
        return list.get(index) == sz;
    }
    
}
