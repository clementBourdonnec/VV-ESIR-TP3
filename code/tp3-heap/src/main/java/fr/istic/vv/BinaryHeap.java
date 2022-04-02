package fr.istic.vv;

import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {
    Comparator<T> comparator;
    private T[] heap;
    private int counter;
    private int maxCounter;
    
    public BinaryHeap(Comparator<T> comparator) {    	
        counter = 0;
        maxCounter = 20;
        this.comparator = comparator;
        heap = (T[]) new Comparable[maxCounter];
    }
    
    private int RightChild(int i) {
    	return 2*i +2; 
    }
    
    private int LeftChild(int i) {
    	return 2*i +1; 
    }
    
    private int parent(int i) {
    	return (i-1)/2;
    }
    
    private void change(int e1, int e2) {
        T tmp = heap[e2];
        heap[e2] = heap[e1];
        heap[e1] = tmp;
    }
    
    public T pop() throws Exception {
    	if(count() <= 0) {
    		throw new NoSuchElementException("Heap is empty");
    	}
    	
    	if(counter == 1) {
    		counter = 0;
    		return heap[0];
    	}
    	
    	T min = heap[0];
    	heap[0] = heap[--counter];
    	reOrganise(0);

    	return min;
    }
    
    private void reOrganise(int i) {
    	int left = LeftChild(i);
    	int right = RightChild(i);
    	int min = i;
    	
    	if(left < counter && comparator.compare(heap[left], heap[i]) < 0) {
    		min = left;
    	}
    	
    	if(right < counter && comparator.compare(heap[right], heap[min]) < 0) {
    		min = right;
    	}
    	
    	if(min != i) {
    		change(min, i);
    		reOrganise(min);
    	}
	}

	public T peek() {
		if (counter == 0) throw new NoSuchElementException("Empty heap");
		
    	return heap[0];
    }
    
    public void push(T element) {
    	heap[counter] = element;
    	
    	int i=counter++;
    	
    	while(i !=0 && comparator.compare(heap[parent(i)], heap[i]) > 0) {
    		change(parent(i), i);
    		i=parent(i);
    	}
    }
    
    public int count() {
    	return counter;
    }
}

class IntComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}