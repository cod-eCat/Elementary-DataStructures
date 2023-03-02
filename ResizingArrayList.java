package com.lpa.elementaryds;

    // TODO: 3/2/2023
    /*
    List Implementation Using Resizing Array
    Author - @LwinPhyoAung(cod-eCat)
    add - O(N)
    remove - O(N)
    isContains - O(N)
    get - O(1)
     */

public class ResizingArrayList <E>{

    private static final int INITIAL_CAPACITY = 10;
    private E[] list;
    private int pointer;
    private int size;

    public ResizingArrayList(){
        this(INITIAL_CAPACITY);
    }

    public ResizingArrayList(int capacity){
        if (capacity<INITIAL_CAPACITY){
            capacity = INITIAL_CAPACITY;
        }
        list = (E[]) new Object[capacity];
    }

    public void add(E e){
        grow();
        list[pointer++] = e;
        size++;
    }

    public E get(int index){
        if (index<0 || index>=list.length)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E re = list[index];
        srink();
        shiftBackward(index);
        size--;
        pointer--;
        return re;
    }

    private void shiftBackward(int index){
        for (int i = index; i<size-1; i++){
            list[i] = list[i+1];
        }
        list[size-1] = null;
    }

    public boolean isContains(E e){
        for (E re:list){
            if (re==e)
                return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    //
    public int length(){
        return list.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void grow(){
        if (pointer>=list.length){
            resize(list.length*2);
        }
    }

    private void srink(){
        if (pointer<=list.length/4 && list.length/2>=INITIAL_CAPACITY)
            resize(list.length/2);
    }

    private void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i<size; i++){
            temp[i] = list[i];
        }
        list = temp;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i<list.length; i++){
            result+=" [" + list[i] + "] ";
        }
        return result;
    }
}
