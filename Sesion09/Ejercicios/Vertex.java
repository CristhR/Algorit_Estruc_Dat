package Ejercicios;

public class Vertex {
    public String data;
    public Edge adjacencyList;
    public Vertex next;

    public Vertex(String data) {
        this.data = data;
        this.adjacencyList = null;
        this.next = null;
    }
}
