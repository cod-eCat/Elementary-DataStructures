package com.lpa.elementaryds;

import java.util.NoSuchElementException;

    // TODO: 2/5/2023
    /*
    * Stack Implementation Using Resizing Array
    * Author - @LwinPhyoAung
    * push - O(N)
    * pop - O(N)
    */

public class ResizingArrayStack <E>{

    private static int INITIAL_CAPACITY = 10;
    private E[] stack;
    private int N;
    private int top;

    public ResizingArrayStack(){
        this(INITIAL_CAPACITY);
    }

    public ResizingArrayStack(int capacity){
        if (capacity<INITIAL_CAPACITY){
            capacity = INITIAL_CAPACITY;
        }
        stack = (E[]) new Object[capacity];
    }

    public void push(E e){
        if (N==stack.length){
            resize(stack.length*2);
        }
        stack[top++] = e;
        N++;
    }

    public E pop(){
        if (isEmpty()) throw new NoSuchElementException();
        E res = stack[--top];
        stack[top] = null;
        N--;
        if (N <= (stack.length/3) && (stack.length/2)>=INITIAL_CAPACITY){
            resize(stack.length/2);
        }
        return res;
    }

    public E peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return stack[top-1];
    }

    private void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i<N; i++){
            temp[i] = stack[i];
        }
        stack = temp;
    }



    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public int length(){
        return stack.length;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i<stack.length; i++){
            res+=" [" + stack[i] + "] ";
        }
        return res;
    }
}
