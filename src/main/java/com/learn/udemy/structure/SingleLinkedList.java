package com.learn.udemy.structure;

public class SingleLinkedList<T> {

    private Node<T> head;

    public SingleLinkedList(T value) {
        this.head = new Node<>(value);
    }

    public void addToFrond(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
    }

    public void addToEnd(T value) {
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        Node<T> newNode = new Node<>(value);
        currentNode.setNext(newNode);
    }

    public void removeFront() {
        head = head.getNext();
    }

    public void printSingleList() {
        Node<T> tempNode = head;
        do {
            System.out.println(tempNode.getValue().toString());
            tempNode = tempNode.getNext();
        } while (tempNode != null);
    }


    static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

