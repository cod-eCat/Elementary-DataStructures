package com.lpa.elementaryds;

    // TODO: 2/4/2023
    /*
    Queue Implementation Using LinkedList
    Author - @LwinPhyoAung(cod-eCat)
    enqueue - O(1)
    dequeue - O(1)
     */

import java.util.NoSuchElementException;

public class LinkedListQueue <E>{

    private class QueueNode{
        private E e;
        private QueueNode next;
        private QueueNode(E e){
            this.e = e;
        }
    }

    private QueueNode front;
    private QueueNode back;
    private int N;

    public LinkedListQueue(){

    }

    public void enqueue(E e){
        QueueNode queueNode = new QueueNode(e);
        if (isEmpty()){
            front = queueNode;
            back = queueNode;
            N++;
            return;
        }
        back.next = queueNode;
        back = queueNode;
        N++;
    }

    public E dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E res = front.e;
        front = front.next;
        N--;
        return res;
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
        for (QueueNode n = front; n!=null; n=n.next){
            res += "[" + n.e + "]";
        }
        return res;
    }
}
