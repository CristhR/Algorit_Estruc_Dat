package Actividad1;

public class Test {
    public static void main(String[] args) {
        try {
            Stack<Integer> pila = new StackArray<>(5);
            
            pila.push(10);
            pila.push(20);
            pila.push(30);
            pila.push(60);
            pila.push(50);
            
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
