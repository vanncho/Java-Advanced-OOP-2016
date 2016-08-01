package pr09.models;

import pr09.interfaces.MyLinkedList;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedListImpl<T> implements MyLinkedList<T>, Iterable<T> {

    private class ListNode<T> {

        private T value;
        private ListNode<T> next;

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        public ListNode<T> getNext() {
            return this.next;
        }

        private void setNext(ListNode<T> next) {
            this.next = next;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public MyLinkedListImpl() {
        this.size = 0;
    }

    @Override
    public void add(T element) {

        if (this.size == 0) {
            this.head = this.tail = new ListNode<>(element);
        } else {
            ListNode<T> newNode = new ListNode<>(element);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    @Override
    public boolean remove(T element) {

        ListNode<T> prev = null;
        ListNode<T> current = this.head;
        while(current != null){
            if(current.getValue() == element){
                if(current == this.tail && current == this.head){
                    this.head = this.tail = null;
                }
                else if(current == this.tail){
                    this.tail = prev;
                    this.tail.setNext(null);
                }
                else if(current == this.head){
                    this.head = current.getNext();
                }
                else {
                    prev.setNext(current.getNext());
                }

                this.size--;
                return true;
            }

            prev = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {

        if(this.size == 0) {
            return Collections.emptyIterator();
        }

        return new Iterator<T>() {
            private ListNode<T> currentNode = null;
            @Override
            public boolean hasNext() {
                return currentNode != tail;
            }

            @Override
            public T next() {
                if (currentNode == null) {
                    currentNode = head;
                    return currentNode.getValue();
                }
                if (currentNode.getNext() == null) {
                    throw new NoSuchElementException();
                }
                currentNode = currentNode.getNext();
                return currentNode.value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {

        for (T item : this) {
            action.accept(item);
        }
    }
}
