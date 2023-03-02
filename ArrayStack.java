package com.lpa.elementaryds;

    // TODO: 2/4/2023
    /*
    Stack Implementation Using Array
    Author - @LwinPhyoAung(cod-eCat)
    push - O(1)
    pop - O(1)
     */

import java.util.NoSuchElementException;

public class ArrayStack <E>{

    private static final int INITIAL_CAPACITY = 10;

    private E[] stack;
    private int top;
    private int N;

    public ArrayStack(){
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity){
        if (capacity<INITIAL_CAPACITY){
            capacity = INITIAL_CAPACITY;
        }
        stack = (E[]) new Object[capacity];
    }

    public void push(E e){
        stack[top++] = e;
        N++;
    }

    public E pop(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E res = stack[top-1];
        stack[--top] = null;
        N--;
        return res;
    }

    public E peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return stack[top-1];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i<N; i++){
            res+="[" + stack[i] + "]";
        }
        return res;
    }
}
