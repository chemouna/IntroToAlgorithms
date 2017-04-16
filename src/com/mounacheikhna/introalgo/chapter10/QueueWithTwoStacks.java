package com.mounacheikhna.introalgo.chapter10;

import java.util.NoSuchElementException;

/**
 * Created by m.cheikhna on 15/04/2017.
 */
public class QueueWithTwoStacks<T> {

    private LinkedStack<T> frontStack;
    private LinkedStack<T> backStack;

    public QueueWithTwoStacks() {
        frontStack = new LinkedStack<T>();
        backStack = new LinkedStack<T>();
    }

    //O(1)
    public int size() {
        return frontStack.size() + backStack.size();
    }

    //O(1)
    public boolean isEmpty() {
        return frontStack.isEmpty() && backStack.isEmpty();
    }

    //O(1)
    public void enqueue(T item) {
        frontStack.push(item);
    }

    //Amortized O(1) (occasional O(N))
    public T dequeue() {
        if (backStack.isEmpty()) throw new NoSuchElementException();
        if (backStack.isEmpty()) moveFrontToBack();
        return backStack.pop();
    }

    private void moveFrontToBack() {
        while (!frontStack.isEmpty()) {
            backStack.push(frontStack.pop());
        }
    }

}
