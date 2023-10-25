package com.learn.udemy.structure;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList(T value) {
        head = new Node<>(value);
        tail = head;
    }

    public void addToFront(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }

    public void addToEnd(T value) {
        Node<T> newNode = new Node<>(value);

        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void removeHead() {
        head = head.next;
        head.previous = null;
    }

    public void removeTail() {
        tail = tail.previous;
        tail.next = null;
    }


    public void printDoubleLinkedList() {
        Node<T> tempNode = head;
        do {
            System.out.println(tempNode.value.toString());
            tempNode = tempNode.next;
        } while (tempNode != null);
    }

    static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }
}
