package fr.istic.vv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    BinaryHeap<Integer> heap;

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

    @Test
    public void testPeakEmptyHeap() {
    	Assertions.assertThrows(NoSuchElementException.class, () -> heap.peek());
    }
    
    @Test
    public void testPeakSingleValue() {
    	heap.push(10);
    	assertEquals(10, heap.peek());
    }
    
    @Test
    public void testPeakTwoValue1() {
    	heap.push(5);
    	heap.push(10);
    	assertEquals(5, heap.peek());
    }
    
    @Test
    public void testPeakTwoValue2() {
    	heap.push(10);
    	heap.push(5);
    	assertEquals(5, heap.peek());
    }
    
    @Test
    public void testPeakRandom() {
    	int min = 1000;
    	Random rand = new Random(1234679);
    	
    	for(int i=0; i<10; i++) {
    		int randInt = (int) ((Math.random() * (50)));
    		if(randInt < min) {
    			min = randInt;
    		}
    		heap.push(randInt);
    	}
    	
    	assertEquals(min, heap.peek());
    }
    
    @Test
    public void testPopEmpty() {
    	Assertions.assertThrows(NoSuchElementException.class, () -> heap.pop());
    }
    
    @Test
    public void testPopRemoveElements() throws Exception {
    	heap.push(10);
    	heap.push(5);
    	heap.pop();
    	heap.pop();
    	
    	Assertions.assertThrows(NoSuchElementException.class, () -> heap.pop());
    }
    
    @Test
    public void testPop() throws Exception {
    	Random rand = new Random(789456123);
    	List<Integer> sorted = new LinkedList<>();
    	List<Integer> result = new LinkedList<>();
    	
    	for(int i=0; i<100; i++) {
    		int randInt = rand.nextInt();
    		sorted.add(randInt);
    		heap.push(randInt);
    	}
    	
    	Collections.sort(sorted);
    	
    	for(int i=0; i<100; i++) {
    		result.add(heap.pop());
    	}
    	
    	assertTrue(sorted.equals(result));
    }
}