package com.lpa.elementaryds;

    // TODO: 2/4/2023
    /*
    Stack Implementation Using LinkedList
    Author - @LwinPhyoAung(cod-eCat)
    push - O(1)
    pop - O(1)
     */

import java.util.NoSuchElementException;

public class LinkedListStack <E>{

    private class StackNode{
        private E e;
        private StackNode next;
        private StackNode(E e, StackNode next){
            this.e = e;
            this.next = next;
        }
    }

    private int N;
    private StackNode top;

    public LinkedListStack(){

    }

    public void push(E e){
        if (isEmpty()){
            top = new StackNode(e, null);
            N++;
            return;
        }
        top = new StackNode(e, top);
        N++;
    }

    public E pop(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E res = top.e;
        top = top.next;
        N--;
        return res;
    }

    public E peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return top.e;
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
        for (StackNode n = top; n!=null; n=n.next){
            res+="[" + n.e + "]";
        }
        return res;
    }
}
