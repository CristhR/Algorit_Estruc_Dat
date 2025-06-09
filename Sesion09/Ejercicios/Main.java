package Ejercicios;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        GraphLink graph = new GraphLink();

        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        // Insertar aristas ponderadas
        graph.insertEdgeWeight("A", "B", 4);
        graph.insertEdgeWeight("A", "C", 2);
        graph.insertEdgeWeight("B", "D", 3);
        graph.insertEdgeWeight("C", "D", 1);

        System.out.println("DFS desde A:");
        graph.dfs("A");

        System.out.println("BFS desde A:");
        graph.bfs("A");

        System.out.println("¿Es conexo?: " + graph.isConexo());

        System.out.println("Camino más corto (Dijkstra) de A a D:");
        Stack<String> stackPath = graph.Dijkstra("A", "D");
        while (!stackPath.isEmpty()) {
            System.out.print(stackPath.pop() + " ");
        }

        System.out.println("\nCamino más corto (BFS) de A a D:");
        ArrayList<String> pathBFS = graph.bfsPath("A", "D");
        System.out.println(pathBFS);
    }
}
