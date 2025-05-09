package Ejercicio1;

import Ejercicio1.*;
import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            Stack<String> pila = new StackLink<>();
            pila.push("Uno");
            pila.push("Dos");
            pila.push("Tres");
            System.out.println("Contenido de la pila:");
            System.out.println(pila);
            System.out.println("Elemento tope: " + pila.top());
            System.out.println("Elemento extraído: " + pila.pop());
            System.out.println("Pila después del pop:");
            System.out.println(pila);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
