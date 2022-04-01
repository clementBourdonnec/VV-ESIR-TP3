package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    BinaryHeap heap;

    @BeforeEach
    protected void setUp()throws Exception{
        heap = new BinaryHeap<Integer>((Comparator<Integer>) new IntComparator());
    }

    @Test
    public void testCountEmptyHeap(){
        assertEquals(heap.count(),0);
    }

    @Test
    public void testCountNotEmptyHeap(){
        heap.push(0);
        heap.push(5);
        assertEquals(heap.count(),2);
    }

}