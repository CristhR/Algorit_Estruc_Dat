package Actividades;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDeTarea<Tarea> gestor = new GestorDeTarea<>();
        GestorDeTarea<Tarea> tareasCompletadas = new GestorDeTarea<>();

        int opcion;

        do {
            System.out.println("\n===== GESTOR DE TAREAS =====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea por titulo y prioridad");
            System.out.println("3. Buscar tarea por titulo y prioridad");
            System.out.println("4. Imprimir tareas");
            System.out.println("5. Contar tareas");
            System.out.println("6. Obtener tarea mas prioritaria");
            System.out.println("7. Invertir lista de tareas");
            System.out.println("8. Ver tareas completadas");
            System.out.println("9. Agregar tarea completada");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Titulo de la tarea: ");
                    String titulo = sc.nextLine();
                    System.out.print("Prioridad (numero entero): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    Tarea nueva = new Tarea(titulo, prioridad);
                    gestor.agregarTarea(nueva);
                    System.out.println("Tarea agregada: " + nueva);
                }
                case 2 -> {
                    System.out.print("Titulo de la tarea a eliminar: ");
                    String titulo = sc.nextLine();
                    System.out.print("Prioridad de la tarea a eliminar: ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    boolean eliminado = gestor.eliminarTareaPorNombreYPrioridad(titulo, prioridad);
                    System.out.println(eliminado ? "Tarea eliminada: Titulo: " + titulo + ", Prioridad: " + prioridad : "No se encontro una tarea con ese nombre y prioridad");
                }
                case 3 -> {
                    System.out.print("Titulo de la tarea a buscar: ");
                    String titulo = sc.nextLine();
                    System.out.print("Prioridad de la tarea a buscar: ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Tareas encontradas:");
                    gestor.buscarTareasPorNombreYPrioridad(titulo, prioridad);
                }
                case 4 -> {
                    System.out.println("\nLista de tareas:");
                    gestor.imprimirTareas();
                }
                case 5 -> {
                    int total = gestor.contarTareas();
                    System.out.println("Total de tareas: " + total);
                }
                case 6 -> {
                    Tarea tarea = (Tarea) gestor.obtenerTareaMasPrioritaria();
                    System.out.println(tarea != null ? "Tarea mas prioritaria: " + tarea : "No hay tareas");
                }
                case 7 -> {
                    gestor.invertirTareas();
                    System.out.println("Lista de tareas invertida");
                }
                case 8 -> {
                    System.out.println("\nTareas completadas:");
                    tareasCompletadas.imprimirTareas();
                }
                case 9 -> {
                    System.out.print("Titulo de la tarea completada: ");
                    String titulo = sc.nextLine();
                    System.out.print("Prioridad: ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    Tarea completada = new Tarea(titulo, prioridad);
                    tareasCompletadas.agregarTarea(completada);
                    System.out.println("Tarea marcada como completada: " + completada);
                }
                case 0 -> System.out.println("Saliendo del gestor...");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

        sc.close();
    }
}
