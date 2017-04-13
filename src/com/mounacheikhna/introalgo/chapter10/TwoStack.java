package com.mounacheikhna.introalgo.chapter10;

import java.util.Arrays;
import java.util.EmptyStackException;

public class TwoStack<T> {
    T[] stack;
    int idx1;
    int idx2;

    @SuppressWarnings("unchecked")
    public TwoStack(int size) {
        stack = (T[]) new Object[size];
        idx1 = -1;
        idx2 = size - 1;
    }

    boolean push1(T object) {
        int nextIdx = idx1 + 1;
        if (idx2 <= nextIdx || nextIdx >= stack.length) return false;
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
        TwoStack<Integer> twoStack = new TwoStack<>(5);
        System.out.println("  " + twoStack);
        System.out.println();
        System.out.println("push 3 values to stack 1:");
        for (int i = 0; i < 3; ++i) {
            twoStack.push1(i);
        }
        System.out.println("  " + twoStack);
        System.out.println();
        System.out.println("push 5 values to stack 2:");
        for (int i = 0; i < 5; ++i) {
            twoStack.push2(i);
        }
        System.out.println("  " + twoStack);
        System.out.println("(some elements couldn't fit)");
        System.out.println();

        System.out.println("pop 7 elements from stack 1:");
        for (int i = 0; i < 7; ++i) {
            try {
                int popped = twoStack.pop1();
                System.out.println("popped: " + popped);
            } catch (EmptyStackException e) {
                System.out.println("couldn't pop anymore");
                break;
            }
        }
        System.out.println("  " + twoStack);
        System.out.println();

        System.out.println("pop 1 element from stack 2:");
        int popped = twoStack.pop2();
        System.out.println("popped: " + popped);
        System.out.println("  " + twoStack);
        System.out.println();
    }
}


