package com.mounacheikhna.introalgo.chapter10;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by m.cheikhna on 16/04/2017.
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] items;
    private int n;

    public ResizingArrayStack() {
        items = (T[]) new Object[2];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        if(n == items.length) resize(2 * items.length);
        items[n++] = item;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T poppedItem = items[n - 1];
        items[n - 1] = null;
        //shrink if needed
        if(n > 0 && n >= (items.length / 4)) {
            resize(items.length / 4);
        }
        return poppedItem;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return items[n - 1];
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        int i = n - 1; //current index
        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return items[n--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
