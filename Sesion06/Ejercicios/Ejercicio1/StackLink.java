package Ejercicio1;

import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;
import Actividad2.Node;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    public void push(E x) {
        Node<E> aux = new Node<>(x);
        aux.setNext(top);
        top = aux;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        E data = top.getData();
        top = top.getNext();
        return data;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = top;
        while (current != null) {
            sb.append(current.getData()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}
