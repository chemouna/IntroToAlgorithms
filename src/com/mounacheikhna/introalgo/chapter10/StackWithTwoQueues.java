package com.mounacheikhna.introalgo.chapter10;

/**
 * Created by m.cheikhna on 16/04/2017.
 */
public class StackWithTwoQueues<T> {
    Queue<T> q1;
    Queue<T> q2;

    public StackWithTwoQueues() {
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(T item) {
        q1.enqueue(item);
    }

    public T pop() {
        return q2.dequeue();
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public int size() {
        return q1.size() + q2.size();
    }

}