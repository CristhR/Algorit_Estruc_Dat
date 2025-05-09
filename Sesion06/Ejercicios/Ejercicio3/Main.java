package Ejercicio3;

import Actividad3.ExceptionIsEmpty;
import Actividad3.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> pq = new PriorityQueueLinked<>(3);
            pq.enqueue("Tarea urgente", 0);
            pq.enqueue("Tarea normal", 1);
            pq.enqueue("Tarea baja", 2);

            System.out.println("Contenido de la cola de prioridad:");
            System.out.println(pq);

            System.out.println("Frente: " + pq.front());
            System.out.println("Último (back): " + pq.back());
            System.out.println("Eliminado: " + pq.dequeue());
            System.out.println("Cola actual:\n" + pq);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de prioridad: " + e.getMessage());
        }
    }
}
