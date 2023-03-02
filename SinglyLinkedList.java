package com.lpa.elementaryds;

    // TODO: 2/4/2023
    /*
    List Implementation Using Singly LinkedList
    Author - @LwinPhyoAung(cod-eCat)
    add - O(1)
    remove - O(N)
    get - O(N)
    removeAtFirst - O(1)
    insertAtFirst - O(1)
    isContains - O(N)
     */

import java.util.NoSuchElementException;

public class SinglyLinkedList <E>{

    private class Node{
        private E e;
        private Node next;
        private Node (E e){
            this.e = e;
        }
    }

    private Node head;
    private Node tail;

    private int size;

    public SinglyLinkedList(){

    }

    public void add(E e){
        Node node = new Node(e);
        if (size==0){
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int index, E e){

        if (index < 0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        if (index==0){
            insertAtFirst(e);
            return;
        } else if (index == size) {
            add(e);
            return;
        }
        Node cur = head;
        for (int i = 1; i<index; i++){
            cur = cur.next;
        }
        Node node = new Node(e);
        node.next = cur.next;
        cur.next = node;
        size++;

    }

    public E remove(int index){
        if (index==0){
            return removeAtFirst();
        }

        E e = get(index);
        Node cur = head;
        for (int i = 1; i<index; i++){
            cur=cur.next;
        }
        cur.next = cur.next.next;
        size--;
        return e;

    }

    public void insertAtFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtLast(E e){
        insertAt(size-1, e);
    }

    public E removeAtFirst(){
        if (size==0){
            throw new NoSuchElementException();
        }
        E e = head.e;
        head = head.next;
        size--;
        return e;
    }

    public E get(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node cur = head;
        for (int i = 0; i<index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public boolean isContains(E e){
        for (Node cur = head; cur!=null; cur=cur.next){
            if (cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String re = "";
        for (Node cur = head; cur!=null; cur=cur.next){
            re += " [" + cur.e + "] ";
        }
        return re;
    }
}
