package com.mounacheikhna.introalgo.chapter10;

import java.util.Arrays;
import java.util.EmptyStackException;

public class DoubleStack<T> {
    T[] stack;
    int idx1;
    int idx2;

    @SuppressWarnings("unchecked")
    public DoubleStack(int size) {
        stack = (T[]) new Object[size];
        idx1 = -1;
        idx2 = size - 1;
    }

    boolean push1(T object) {
        int nextIdx = idx1 + 1;
        if (nextIdx >= idx2 || nextIdx >= stack.length) return false;
        stack[++idx1] = object;
        return true;
    }

    T pop1() {
        if (idx1 < 0) throw new EmptyStackException();
        T popped = stack[idx1];
        return popped;
    }

    boolean push2(T object) {
        int nextIdx = idx2 - 1;
        if (nextIdx <= idx1 || nextIdx < 0) return false;
        stack[--idx2] = object;
        return true;
    }

    T pop2() {
        if (idx2 >= stack.length) throw new EmptyStackException();
        T popped = stack[idx2];
        stack[idx2++] = null;
        return popped;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    public static void main(String[] args) {
        System.out.println("init:");
        DoubleStack<Integer> doubleStack = new DoubleStack<>(5);
        System.out.println("  " + doubleStack);
        System.out.println("pop 7 elements from stack 1:");
        for (int i = 0; i < 7; ++i) {
            try {
                int popped = doubleStack.pop1();
                System.out.println("popped: " + popped);
            } catch (EmptyStackException e) {
                System.out.println("couldn't pop anymore");
                break;
            }
        }
        System.out.println("  " + doubleStack);
        System.out.println();

        System.out.println("pop 1 element from stack 2:");
        int popped = doubleStack.pop2();
        System.out.println("popped: " + popped);
        System.out.println("  " + doubleStack);
        System.out.println();
    }
}


