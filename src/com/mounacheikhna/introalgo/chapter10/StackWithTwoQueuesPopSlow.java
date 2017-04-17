package com.mounacheikhna.introalgo.chapter10;

import java.util.NoSuchElementException;

/**
 * Created by m.cheikhna on 16/04/2017.
 */
public class StackWithTwoQueuesPopSlow<T> {
    Queue<T> q1;
    Queue<T> q2;

    public StackWithTwoQueuesPopSlow() {
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(T item) {
        q1.enqueue(item);
    }

    public T pop() {
        if(q1.isEmpty()) throw new NoSuchElementException();
        while (q1.size() > 1) {
            q2.enqueue(q1.dequeue());
        }
        final T item = q1.dequeue();
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
        return item;
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public int size() {
        return q1.size() + q2.size();
    }

}