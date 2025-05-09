package Actividad3;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    private static class EntryNode<E, N> {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        public String toString() {
            return "(" + data + ", " + priority + ")";
        }
    }

    private Node<EntryNode<E, N>> first;
    private Node<EntryNode<E, N>> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void enqueue(E data, N priority) {
        EntryNode<E, N> entry = new EntryNode<>(data, priority);
        Node<EntryNode<E, N>> newNode = new Node<>(entry);

        if (isEmpty() || priority.compareTo(first.getData().priority) < 0) {
            newNode.setNext(first);
            first = newNode;
            if (last == null) last = newNode;
        } else {
            Node<EntryNode<E, N>> current = first;
            while (current.getNext() != null &&
                   priority.compareTo(current.getNext().getData().priority) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) last = newNode;
        }
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cannot remove from an empty queue");
        E data = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return data;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return first.getData().data;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return last.getData().data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode<E, N>> current = first;
        while (current != null) {
            sb.append(current.getData().toString());
            if (current.getNext() != null) sb.append(" -> ");
            current = current.getNext();
        }
        return sb.toString();
    }
}