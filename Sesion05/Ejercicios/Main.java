package Ejercicios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Nodo<Integer> lista = new Nodo<>(1);
        lista.siguiente = new Nodo<>(2);
        lista.siguiente.siguiente = new Nodo<>(3);

        while (true) {
            System.out.println("\n------ Menú ------");
            System.out.println("1. Buscar elemento");
            System.out.println("2. Invertir lista");
            System.out.println("3. Insertar al final");
            System.out.println("4. Contar nodos");
            System.out.println("5. Comparar listas");
            System.out.println("6. Concatenar listas");
            System.out.println("7. Imprimir lista");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    if (MetodosListas.buscarElemento(lista, valorBuscar)) {
                        System.out.println("Elemento encontrado.");
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;

                case 2:
                    lista = MetodosListas.invertirLista(lista);
                    System.out.println("Lista invertida.");
                    break;

                case 3:
                    System.out.print("Ingresa el valor a insertar: ");
                    int valorInsertar = scanner.nextInt();
                    lista = MetodosListas.insertarAlFinal(lista, valorInsertar);
                    System.out.println("Valor insertado al final.");
                    break;

                case 4:
                    int cantidadNodos = MetodosListas.contarNodos(lista);
                    System.out.println("Cantidad de nodos: " + cantidadNodos);
                    break;

                case 5:
                    System.out.println("Comparando listas...");
                    Nodo<Integer> lista2 = null;
                    lista2 = MetodosListas.insertarAlFinal(lista2, 1);
                    lista2 = MetodosListas.insertarAlFinal(lista2, 2);
                    lista2 = MetodosListas.insertarAlFinal(lista2, 3);
                    if (MetodosListas.sonIguales(lista, lista2)) {
                        System.out.println("Las listas son iguales.");
                    } else {
                        System.out.println("Las listas no son iguales.");
                    }
                    break;

                case 6:
                    System.out.println("Concatenando listas...");
                    Nodo<Integer> lista3 = null;
                    lista3 = MetodosListas.insertarAlFinal(lista3, 4);
                    lista3 = MetodosListas.insertarAlFinal(lista3, 5);
                    lista = MetodosListas.concatenarListas(lista, lista3);
                    System.out.println("Listas concatenadas.");
                    break;

                case 7:
                    System.out.println("Lista actual:");
                    MetodosListas.imprimirLista(lista);
                    break;

                case 8:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}
