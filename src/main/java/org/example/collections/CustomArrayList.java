package org.example.collections;

import java.util.*;

public class CustomArrayList <T> implements List {
    private int size;
    private T[] elements;

    public CustomArrayList (){
        elements = (T[]) new Object[16];
    }


//    public CustomArrayList(int startCount) {
//        elements = (T[]) new Object[startCount];
//    }
    public CustomArrayList (Collection<? extends T> collection) {
//        T[] array = (T[]) collection.toArray();
//        elements = (T[]) new Object[collection.size()];
//        for (int i = 0; i < collection.size(); i++){
//            elements[i] = array[i];
//            size++;
//        }
        this.elements = Arrays.copyOf((T[])collection.toArray(), collection.size());
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
            elements = Arrays.copyOf(elements, elements.length + (elements.length) >> 1);
        }
        try {
            elements[size] = (T) o;
            size++;
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public void add(int index, Object element) {
        if(checkIndex(index)){
            if (size == elements.length){
                elements = Arrays.copyOf(elements, elements.length +(elements.length >> 1));
            }
            for(int i = size; i > index; i--){
                elements[i] = elements[i - 1];
            }
            if (size - index >= 0){
                System.arraycopy(elements, index, elements, index + 1, size - index);
            }
            elements[index] = (T)element;
            size++;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }

    }//in work

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++){
            if(elements[i].equals(o)){
                swapArray(i);
                elements[size-1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] arr = c.toArray();
        for(Object o : arr){
            this.add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if(checkIndex(index)) {
            Object[] arr = c.toArray();
            for (int i = index; i < size; i++) {
                this.add(i, arr[i]);
            }
            return true;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        for(int i = size-1; i >= 0; i--){
            elements[i] = null;
        }
    }

    @Override
    public Object get(int index) {
        if(checkIndex(index)) {
            return elements[index];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        T oldElement = elements[index];
        elements[index] = (T) element;
        return oldElement;
    }

    @Override
    public Object remove(int index) {
        if(checkIndex(index)){
            Object oldElem = elements[index];
            System.arraycopy(elements, index + 1, elements, index,size - 1 - index);
            size--;
            return oldElem;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

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

    static public <T extends Comparable<T>>void sort(List<T> collection){
        for (int i = collection.size() - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if (collection.get(j).compareTo(collection.get(j + 1)) > 0){
                    T temp = collection.get(j);
                    collection.set(j, collection.get(j + 1));
                    collection.set(j + 1, temp);
                }
            }
        }
    }
    private void swapArray(int index){
        System.arraycopy(elements,index, elements, index - 1, size - index);
    }
    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }
}
