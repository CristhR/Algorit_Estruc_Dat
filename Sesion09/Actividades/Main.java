package Actividades;

public class Main {
    public static void main(String[] args) {
        GraphLink graph = new GraphLink();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        graph.insertEdge("A", "B", 1);
        graph.insertEdge("A", "C", 1);
        graph.insertEdge("B", "D", 1);
        graph.insertEdge("C", "D", 1);

        System.out.println("DFS desde A:");
        graph.dfs("A");
        System.out.println("\nBFS desde A:");
        graph.bfs("A");
    }
}
