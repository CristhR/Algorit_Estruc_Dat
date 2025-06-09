package Ejercicios;

import java.util.*;

public class GraphLink {
    private Vertex head;

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
        Vertex temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) return true;
            temp = temp.next;
        }
        return false;
    }

    public Vertex getVertex(String data) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean insertEdgeWeight(String from, String to, int weight) {
        Vertex v1 = getVertex(from);
        Vertex v2 = getVertex(to);
        if (v1 == null || v2 == null) return false;

        Edge e1 = new Edge(v2, weight);
        e1.next = v1.adjacencyList;
        v1.adjacencyList = e1;

        Edge e2 = new Edge(v1, weight);
        e2.next = v2.adjacencyList;
        v2.adjacencyList = e2;

        return true;
    }

    public void dfs(String start) {
        Vertex v = getVertex(start);
        if (v == null) return;
        Set<String> visited = new HashSet<>();
        dfsRecursive(v, visited);
        System.out.println();
    }

    private void dfsRecursive(Vertex v, Set<String> visited) {
        if (visited.contains(v.data)) return;
        System.out.print(v.data + " ");
        visited.add(v.data);
        Edge e = v.adjacencyList;
        while (e != null) {
            dfsRecursive(e.destination, visited);
            e = e.next;
        }
    }

    public void bfs(String start) {
        Vertex v = getVertex(start);
        if (v == null) return;
        Set<String> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        visited.add(v.data);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.data + " ");
            Edge e = current.adjacencyList;
            while (e != null) {
                if (!visited.contains(e.destination.data)) {
                    visited.add(e.destination.data);
                    queue.add(e.destination);
                }
                e = e.next;
            }
        }
        System.out.println();
    }

    public boolean isConexo() {
        if (head == null) return true;
        Set<String> visited = new HashSet<>();
        dfsRecursive(head, visited);

        int count = 0;
        Vertex temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return visited.size() == count;
    }

    public ArrayList<String> bfsPath(String start, String end) {
        Map<String, String> prev = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        Vertex vStart = getVertex(start);
        if (vStart == null || getVertex(end) == null) return null;

        queue.add(vStart);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            Edge e = curr.adjacencyList;
            while (e != null) {
                String neighbor = e.destination.data;
                if (!visited.contains(neighbor)) {
                    queue.add(e.destination);
                    visited.add(neighbor);
                    prev.put(neighbor, curr.data);
                }
                e = e.next;
            }
        }

        ArrayList<String> path = new ArrayList<>();
        String at = end;
        while (at != null) {
            path.add(0, at);
            at = prev.get(at);
        }

        if (!path.get(0).equals(start)) return new ArrayList<>();
        return path;
    }

    public ArrayList<String> shortPath(String start, String end) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));

        Vertex temp = head;
        while (temp != null) {
            dist.put(temp.data, Integer.MAX_VALUE);
            prev.put(temp.data, null);
            temp = temp.next;
        }

        dist.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.name.equals(end)) break;

            Vertex u = getVertex(current.name);
            Edge e = u.adjacencyList;
            while (e != null) {
                String neighbor = e.destination.data;
                int alt = dist.get(current.name) + e.weight;
                if (alt < dist.get(neighbor)) {
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current.name);
                    pq.add(new Node(neighbor, alt));
                }
                e = e.next;
            }
        }

        ArrayList<String> path = new ArrayList<>();
        String step = end;
        while (step != null) {
            path.add(0, step);
            step = prev.get(step);
        }

        if (!path.get(0).equals(start)) return new ArrayList<>();
        return path;
    }

    public Stack<String> Dijkstra(String start, String end) {
        ArrayList<String> path = shortPath(start, end);
        Stack<String> stack = new Stack<>();
        for (String s : path) stack.push(s);
        return stack;
    }

    private static class Node {
        String name;
        int dist;

        Node(String name, int dist) {
            this.name = name;
            this.dist = dist;
        }
    }
}
