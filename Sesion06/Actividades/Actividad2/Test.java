package Actividad2;

public class Test {
    public static void main(String[] args) {
        try {
            Queue<String> cola = new QueueLink<>();
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            System.out.println("Contenido de la cola:");
            System.out.println(cola);
            System.out.println("Primero: " + cola.front());
            System.out.println("Último: " + cola.back());
            System.out.println("Elemento eliminado: " + cola.dequeue());
            System.out.println("Cola luego del dequeue:");
            System.out.println(cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
