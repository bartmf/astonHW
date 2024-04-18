package org.example.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomArrayList <T extends Comparable<T>> implements List {
    private int size;
    private final T[] elements;

    public CustomArrayList (){
        elements = (T[]) new Object[16];
    }


//    public CustomArrayList(int startCount) {
//        elements = (T[]) new Object[startCount];
//    }
    public CustomArrayList (Collection<T> collection) {
        T[] array = (T[]) collection.toArray();
        elements = (T[]) new Object[collection.size()];
        for (int i = 0; i < collection.size(); i++){
            elements[i] = array[i];
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    } //Заглушка

    @Override
    public Iterator iterator() {
        return null;
    }//Заглушка

    @Override
    public Object[] toArray() {
        return elements.clone();
    }//Заглушка

    @Override
    public boolean add(Object o) {
        if(size == elements.length){
            T[] newElements = (T[])new Object[elements.length + (elements.length / 2)];

        }else{

        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i = size-1; i >= 0; i--){
            elements[i] = null;
        }
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        T oldElement = elements[index];
        elements[index] = (T) element;
        return oldElement;
    }//Заглушка

    @Override
    public void add(int index, Object element) {
        elements[index] = (T) element;
    }//in work

    @Override
    public Object remove(int index) {
        return null;
    }//in work

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    static public void sort(){

    }//залушка
}
