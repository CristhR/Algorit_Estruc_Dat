package Actividades;

import java.util.*;

public class GraphLink {
    Vertex head;

    public GraphLink() {
        head = null;
    }

    public boolean insertVertex(String data) {
        if (searchVertex(data)) return false;
        Vertex newVertex = new Vertex(data);
        newVertex.next = head;
        head = newVertex;
        return true;
    }

    public boolean searchVertex(String data) {
        Vertex current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    public Vertex getVertex(String data) {
        Vertex current = head;
        while (current != null) {
            if (current.data.equals(data)) return current;
            current = current.next;
        }
        return null;
    }

    public boolean insertEdge(String from, String to, int weight) {
        Vertex origin = getVertex(from);
        Vertex dest = getVertex(to);
        if (origin == null || dest == null) return false;

        Edge newEdge = new Edge(dest, weight);
        newEdge.next = origin.adjacencyList;
        origin.adjacencyList = newEdge;

        // para grafo no dirigido, insertar también la inversa
        Edge newEdgeBack = new Edge(origin, weight);
        newEdgeBack.next = dest.adjacencyList;
        dest.adjacencyList = newEdgeBack;

        return true;
    }

    public boolean searchEdge(String from, String to) {
        Vertex origin = getVertex(from);
        if (origin == null) return false;
        Edge current = origin.adjacencyList;
        while (current != null) {
            if (current.destination.data.equals(to)) return true;
            current = current.next;
        }
        return false;
    }

    public boolean removeEdge(String from, String to) {
        Vertex origin = getVertex(from);
        Vertex dest = getVertex(to);
        if (origin == null || dest == null) return false;

        origin.adjacencyList = removeEdgeFromList(origin.adjacencyList, to);
        dest.adjacencyList = removeEdgeFromList(dest.adjacencyList, from);
        return true;
    }

    private Edge removeEdgeFromList(Edge head, String to) {
        if (head == null) return null;
        if (head.destination.data.equals(to)) return head.next;
        head.next = removeEdgeFromList(head.next, to);
        return head;
    }

    public boolean removeVertex(String data) {
        Vertex current = head, prev = null;
        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current == null) return false;

        if (prev == null) head = current.next;
        else prev.next = current.next;

        // eliminar aristas relacionadas
        Vertex temp = head;
        while (temp != null) {
            temp.adjacencyList = removeEdgeFromList(temp.adjacencyList, data);
            temp = temp.next;
        }
        return true;
    }

    public void dfs(String start) {
        Vertex v = getVertex(start);
        if (v == null) return;
        Set<String> visited = new HashSet<>();
        dfsRecursive(v, visited);
    }

    private void dfsRecursive(Vertex v, Set<String> visited) {
        if (visited.contains(v.data)) return;
        visited.add(v.data);
        System.out.print(v.data + " ");
        Edge current = v.adjacencyList;
        while (current != null) {
            dfsRecursive(current.destination, visited);
            current = current.next;
        }
    }

    public void bfs(String start) {
        Vertex startVertex = getVertex(start);
        if (startVertex == null) return;
        Set<String> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        visited.add(startVertex.data);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.data + " ");
            Edge edge = current.adjacencyList;
            while (edge != null) {
                if (!visited.contains(edge.destination.data)) {
                    visited.add(edge.destination.data);
                    queue.add(edge.destination);
                }
                edge = edge.next;
            }
        }
    }
}
