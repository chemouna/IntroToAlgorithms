package com.mounacheikhna.introalgo.chapter10;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by m.cheikhna on 16/04/2017.
 */
public class FixedCapacityStack<T> implements Iterable<T> {
    private T[] items;
    private int n;

    public FixedCapacityStack(int capacity) {
        items = (T[]) new Object[capacity];
        n = 0;
    }

    public boolean isEmpty(){
        return items.length == 0;
    }

    public int size() {
        return items.length;
    }

    public void push(T item) {
        items[n++] = item;
    }

    public T pop() {
        return items[--n];
    }

    public T peek() {
        return items[n - 1];
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = n - 1; //current index

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return items[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
