package com.mounacheikhna.introalgo.chapter10;

import java.util.NoSuchElementException;

/**
 * Created by m.cheikhna on 17/04/2017.
 */
public class StackWithTwoQueuesPushSlow<T> {

    Queue<T> q1;
    Queue<T> q2;

    public StackWithTwoQueuesPushSlow() {
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(T item) {
        q2.enqueue(item);
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public T pop() {
        if (q1.isEmpty()) throw new NoSuchElementException();
        return q1.dequeue();
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public int size() {
        return q1.size() + q2.size();
    }
}
