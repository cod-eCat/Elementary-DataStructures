package com.lpa.elementaryds;

    // TODO: 2/18/2023
    /*
    List Implementation Using Doubly Linked List
    Author - @LwinPhyoAung(cod-eCat)
    add - O(N)
    insert - O(N) //N/2
    insertAtFirst - O(1)
    remove - O(N) //N/2
    removeAtFirst - O(1)
    removeAtLast - O(1)
    get - O(N) //N/2
     */

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    private class Node{
        private Node next;
        private Node pre;
        private E e;
        private Node(E e){
            this.e = e;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){

    }

    public void add(E e){
        Node node = new Node(e);
        if (size==0){
            head=node;
            tail=node;
            size++;
            return;
        }
        node.pre = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int index, E e){
        if (index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0){
            insertAtFirst(e);
            return;
        } else if (index == size) {
            add(e);
            return;
        }
        int mid = size/2;
        if (index<mid){
            //from head
            Node cur = head;
            for (int i = 1; i<index; i++){
                cur = cur.next;
            }
            Node node = new Node(e);
            node.next = cur.next;
            node.pre = cur;
            cur.next = node;
            if (node.next!=null){
                node.next.pre = node;
            }
            size++;
            return;
        }else {
            //from tail
            Node cur = tail;
            for (int i = size-1; i>index; i--){
                cur = cur.pre;
            }
            Node node = new Node(e);
            node.next = cur;
            node.pre = cur.pre;
            cur.pre = node;
            if (node.pre!=null){
                node.pre.next = node;
            }
            size++;
        }
    }

    public void insertAtFirst(E e){
        if (size==0){
            throw new NoSuchElementException();
        }
        Node node = new Node(e);
        node.next = head;
        if (head!=null) {
            head.pre = node;
        }
        head = node;
        size++;
    }

    public E remove(int index){
        Node remN = getNode(index);
        if (index==0){
            return removeAtFirst();
        } else if (index == size - 1) {
            return removeAtLast();
        }
        remN.next.pre = remN.pre;
        remN.pre.next = remN.next;
        E remE = remN.e;
        remN = null;
        size--;
        return remE;
    }

    public E removeAtFirst(){
        if (size==0)
            throw new NoSuchElementException();
        Node remN = head;
        head = head.next;
        if (head != null){
            head.pre = null;
        }
        size--;
        return remN.e;
    }

    public E removeAtLast(){
        if (size==0)
            throw new NoSuchElementException();
        Node remN = tail;
        tail = tail.pre;
        if (tail!=null){
            tail.next = null;
        }
        size--;
        return remN.e;
    }

    public E get(int index){
        return getNode(index).e;
    }

    private Node getNode(int index){
        if (index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        int mid = size/2;
        if (index < mid){
            //from head
            Node cur = head;
            for (int i = 0; i<index; i++){
                cur=cur.next;
            }
            return cur;
        } else {
            //from tail
            Node cur = tail;
            for (int i = size-1; i>index; i--){
                cur = cur.pre;
            }
            return cur;
        }
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
