package com.mounacheikhna.introalgo.chapter10;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by m.cheikhna on 16/04/2017.
 */
public class LinkedStack<T> implements Iterable<T> {
    private int n;
    private Node<T> first;

    public LinkedStack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        final Node<T> node = new Node<>(item);
        Node<T> oldFirst = first;
        first = node;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        Node<T> popedFirst = first;
        first = popedFirst.next;
        n--;
        return popedFirst.item;
    }

    public T peek() {
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        return first.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            return current.next.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            throw new UnsupportedOperationException();
        }
    }

    public class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }


}
