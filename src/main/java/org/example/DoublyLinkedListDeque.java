package org.example;

import java.util.Comparator;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
    first = null;
    last = null;
    size = 0;
    }

    @Override
    public void prepend(T value) {
         DequeNode nuevo = new DequeNode<>(value, null, null);
        if (first == null){
            first = nuevo;
            last = nuevo;
        } else {
            first.setPrevious(nuevo);
            nuevo.setNext(first);
            first = nuevo;
        }
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode nuevo = new DequeNode<>(value, null, null);
        if (first == null){
            first = nuevo;
            last = nuevo;
        } else {
            last.setNext(nuevo);
            nuevo.setPrevious(last);
            last = nuevo;
        }
        size++;
    }

    @Override
    public void deleteFirst() throws Exception {
        if (size==0){
            throw new DoubleEndedQueueException("No hay primero");
        } else if (size ==1 ){
            first = null;
            last = null;
            size--;
        }else{
                first.getNext().setPrevious(null);
                first = first.getNext();
                size--;
            }
        }
        ;


    @Override
    public void deleteLast() throws Exception {
        if (size==0){
            throw new DoubleEndedQueueException("No hay ultimo");
        }else if (size == 1){
            first = null;
            last = null;
            size--;
        }else{
            last.getPrevious().setNext(null);
            last = last.getPrevious();
            size--;
        }
    }
    ;

    @Override
    public T first() {

        return first.getItem();
    }

    @Override
    public T last() {

        return last.getItem();
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public T get(int index) {
        if(size > 0) {
            DequeNode<T> a = first;
            for (int i = 0; i < index; i++) {
                a = a.getNext();
            }
            return a.getItem();
        }else{
            throw new DoubleEndedQueueException("Lista vacia");
        }
    }

    @Override
    public boolean contains(T value) {
        DequeNode a = first;
        boolean aux = false;
        if(size != 0){
            while(!aux && a != null){
                if(a.getItem().equals(value)){
                    aux = true;
                }
                a = a.getNext();
            }
        }
        return aux;
    }

    @Override
    public void remove(T value) throws Exception {
        DequeNode a = first;
        boolean encontrado = false;
        if(size != 0){
            while(!encontrado && a != null){
                if(a.getItem().equals(value)){
                    encontrado = true;
                }else{
                    a = a.getNext();
                }
            }
        }else{
            throw new DoubleEndedQueueException("Lista vacia");
        }
        if(encontrado && a.isNotATerminalNode()){
            a.getPrevious().setNext(a.getNext());
            a.getNext().setPrevious(a.getPrevious());
        }else if (encontrado && a == first) {
            deleteFirst();
        }else if (encontrado) {
            deleteLast();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if(size <= 1) {
            return;
        }
        boolean ordenado = false;
        while(!ordenado) {
            ordenado = true;
            DequeNode<T> a = first;
            while(a.getNext() != null) {
                if(comparator.compare(a.getItem(), a.getNext().getItem()) > 0) {
                    DequeNode<T> next = a.getNext();
                    DequeNode<T> prev = a.getPrevious();
                    if(prev != null) {
                        prev.setNext(next);
                    } else {
                        first = next;
                    }
                    next.setPrevious(prev);
                    a.setPrevious(next);
                    a.setNext(next.getNext());
                    if(next.getNext() != null) {
                        next.getNext().setPrevious(a);
                    } else {
                        last = a;
                    }
                    next.setNext(a);
                    ordenado = false;
                } else {
                    a = a.getNext();
                }
            }
        }
    }
}
