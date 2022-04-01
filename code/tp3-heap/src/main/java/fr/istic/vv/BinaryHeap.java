package fr.istic.vv;

import java.lang.reflect.Array;
import java.util.Comparator;

class BinaryHeap<T> {

    Comparator<T> comparator;
    private T[] heap;
    private int counter;
    private int maxCounter;

    public BinaryHeap(Comparator<T> comparator) {
        heap = (T[]) new Comparable[maxCounter];
        counter = 0;
        maxCounter = 20;
        this.comparator = comparator;
    }

    public T pop() throws Exception {
        if (counter == 0) throw new Exception("Empty heap");
        T min = heap[0];
        change(counter - 1, 0);
        heap[counter - 1] = null;
        counter--;
        reorderOnPop();
        return min;
    }

    public T peek() {
        return heap[0];
    }

    public void push(T element) {
        heap[counter] = element;
        counter++;
        reorderOnPush();
        if (counter == maxCounter) {
            maxCounter = maxCounter * 2;
            T[] tmp = (T[]) new Comparable[maxCounter];
            for (int i = 0; i < heap.length; i++) {
                tmp[i] = heap[i];
            }
            heap = tmp;
        }
    }

    public int count() {
        return counter;
    }

    private void change(int e1, int e2) {
        T tmp = heap[e1];
        heap[e2] = heap[e1];
        heap[e1] = tmp;
    }

    private void reorderOnPush() {
        int child = counter - 1;
        int parent = (child - 1) / 2;

        while (parent >= 0 && comparator.compare(heap[child], heap[parent]) < 0) {
            change(child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void reorderOnPop() {
        int parent = 0;
        int lChild = 2 * parent + 1;
        int rChild = 2 * parent + 2;


        int next = comparator.compare(heap[lChild],heap[rChild]);

        while (next != -1) {
            change(next, parent);
            parent = next;
            next = comparator.compare(heap[2*next + 1],heap[2 * rChild + 2]);
        }
    }
}