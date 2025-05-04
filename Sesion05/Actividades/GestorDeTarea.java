package Actividades;

public class GestorDeTarea<T> {
    Node<T> cabeza;

    public void agregarTarea(T dato) {
        Node<T> nuevo = new Node<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Node<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public boolean eliminarTareaPorNombreYPrioridad(String titulo, int prioridad) {
        Node<T> actual = cabeza;
        Node<T> anterior = null;

        while (actual != null) {
            T dato = actual.dato;
            if (dato instanceof Tarea tarea) {
                if (tarea.getTitulo().equalsIgnoreCase(titulo) && tarea.getPrioridad() == prioridad) {
                    if (anterior == null) {
                        cabeza = actual.siguiente;
                    } else {
                        anterior.siguiente = actual.siguiente;
                    }
                    return true;
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public void buscarTareasPorNombreYPrioridad(String titulo, int prioridad) {
        Node<T> actual = cabeza;
        boolean encontrado = false;

        while (actual != null) {
            T dato = actual.dato;
            if (dato instanceof Tarea tarea) {
                if (tarea.getTitulo().equalsIgnoreCase(titulo) && tarea.getPrioridad() == prioridad) {
                    System.out.println(tarea);
                    encontrado = true;
                }
            }
            actual = actual.siguiente;
        }

        if (!encontrado) {
            System.out.println("No se encontro ninguna tarea con ese nombre y prioridad");
        }
    }

    public void imprimirTareas() {
        Node<T> actual = cabeza;
        if (actual == null) {
            System.out.println("No hay tareas registradas");
        }
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public int contarTareas() {
        int contador = 0;
        Node<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public T obtenerTareaMasPrioritaria() {
        if (cabeza == null) return null;

        Node<T> actual = cabeza;
        Tarea tareaMasPrioritaria = null;

        while (actual != null) {
            if (actual.dato instanceof Tarea tarea) {
                if (tareaMasPrioritaria == null || tarea.getPrioridad() < tareaMasPrioritaria.getPrioridad()) {
                    tareaMasPrioritaria = tarea;
                }
            }
            actual = actual.siguiente;
        }

        return (T)tareaMasPrioritaria;
    }

    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = cabeza;
        Node<T> siguiente;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }
}
