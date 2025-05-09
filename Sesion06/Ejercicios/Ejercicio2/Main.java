package Ejercicio2;

import Actividad2.ExceptionIsEmpty;
import Actividad2.Queue;

public class Main {
    public static void main(String[] args) {
        try {
            Queue<Integer> cola = new QueueArray<>(5);
            cola.enqueue(10);
            cola.enqueue(20);
            cola.enqueue(30);
            System.out.println("Cola actual: " + cola);
            System.out.println("Primero: " + cola.front());
            System.out.println("Último: " + cola.back());
            System.out.println("Eliminado: " + cola.dequeue());
            System.out.println("Cola actual: " + cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
