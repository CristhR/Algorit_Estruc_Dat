package Ejercicio3;

import Actividad2.Queue;
import Actividad2.QueueLink;
import Actividad3.ExceptionIsEmpty;
import Actividad3.PriorityQueue;

@SuppressWarnings("unchecked")
public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {
    private Queue<E>[] queues;
    private int levels;

    public PriorityQueueLinked(int levels) {
        if (levels <= 0) {
            throw new IllegalArgumentException("El número de niveles debe ser mayor a 0.");
        }

        this.levels = levels;
        this.queues = (Queue<E>[]) new Queue[levels];  // Cast seguro con supresión de advertencia
        for (int i = 0; i < levels; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E x, Integer pr) {
        if (pr == null || pr < 0 || pr >= levels) {
            throw new IllegalArgumentException("Prioridad inválida: " + pr);
        }
        queues[pr].enqueue(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < levels; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < levels; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    @Override
    public boolean isEmpty() {
        for (Queue<E> q : queues) {
            if (!q.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < levels; i++) {
            sb.append("P").append(i).append(": ").append(queues[i]).append("\n");
        }
        return sb.toString();
    }
}
