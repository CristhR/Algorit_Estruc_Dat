package Ejercicios;

public class Edge {
    public Vertex destination;
    public int weight;
    public Edge next;

    public Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.next = null;
    }
}
