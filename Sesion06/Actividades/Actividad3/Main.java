package Actividad3;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

        pq.enqueue("Tarea baja", 5);
        pq.enqueue("Tarea urgente", 1);
        pq.enqueue("Tarea media", 3);
        pq.enqueue("Tarea muy urgente", 0);

        System.out.println("Cola actual:");
        System.out.println(pq);

        try {
            System.out.println("\nElemento con mayor prioridad (front): " + pq.front());
            System.out.println("Elemento con menor prioridad (back): " + pq.back());

            System.out.println("\nQuitando elementos:");
            while (!pq.isEmpty()) {
                System.out.println("Eliminado: " + pq.dequeue());
                System.out.println("Cola ahora: " + pq);
            }
        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
