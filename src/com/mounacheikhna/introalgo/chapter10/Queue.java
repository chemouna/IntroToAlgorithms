package com.mounacheikhna.introalgo.chapter10;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by m.cheikhna on 16/04/2017.
 */
public class Queue<T> implements Iterable<T> {

    Node<T> first;
    Node<T> last;
    private int n;

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(T item) {
        Node<T> oldLast = last;
        Node<T> node = new Node<>(item);
        last = node;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public T dequeue() {
        final T item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }

    private class ListIterator implements Iterator<T> {
        Node<T> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return current.next.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
