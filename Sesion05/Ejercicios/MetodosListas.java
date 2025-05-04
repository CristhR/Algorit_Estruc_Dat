package Ejercicios;

public class MetodosListas {

    public static <T> boolean buscarElemento(Nodo<T> head, T valor) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (actual.dato.equals(valor)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public static <T> Nodo<T> invertirLista(Nodo<T> head) {
        Nodo<T> anterior = null;
        Nodo<T> actual = head;
        Nodo<T> siguiente;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        return anterior;
    }

    public static <T> Nodo<T> insertarAlFinal(Nodo<T> head, T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (head == null) {
            return nuevo;
        }

        Nodo<T> actual = head;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
        return head;
    }

    public static <T> int contarNodos(Nodo<T> head) {
        int contador = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public static <T> boolean sonIguales(Nodo<T> l1, Nodo<T> l2) {
        while (l1 != null && l2 != null) {
            if (!l1.dato.equals(l2.dato)) {
                return false;
            }
            l1 = l1.siguiente;
            l2 = l2.siguiente;
        }
        return l1 == null && l2 == null;
    }

    public static <T> Nodo<T> concatenarListas(Nodo<T> l1, Nodo<T> l2) {
        if (l1 == null) return l2;

        Nodo<T> actual = l1;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = l2;
        return l1;
    }

    public static <T> void imprimirLista(Nodo<T> head) {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
