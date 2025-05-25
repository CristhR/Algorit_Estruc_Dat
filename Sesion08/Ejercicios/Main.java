package Ejercicios;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insertar los nodos del ejemplo de la figura
        int[] keys = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};
        for (int key : keys) {
            tree.insert(key);
        }

        System.out.println("Recorrido por amplitud (BFS):");
        tree.levelOrderTraversal();
    }
}