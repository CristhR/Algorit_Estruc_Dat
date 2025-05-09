package Actividad3;

public interface PriorityQueue<E, N extends Comparable<N>> {
    void enqueue(E data, N priority);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
    String toString();
}