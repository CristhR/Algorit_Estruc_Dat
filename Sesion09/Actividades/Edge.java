package Actividades;

public class Edge {
    Vertex destination;
    int weight;
    Edge next;

    public Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.next = null;
    }
}
