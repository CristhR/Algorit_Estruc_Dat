package Actividades;

public class Vertex {
    String data;
    Vertex next;
    Edge adjacencyList;

    public Vertex(String data) {
        this.data = data;
        this.next = null;
        this.adjacencyList = null;
    }
}
