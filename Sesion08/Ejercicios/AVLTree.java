package Ejercicios;

import java.util.LinkedList;
import java.util.Queue;

class AVLTree {
    AVLNode root;

    // Método para obtener la altura de un nodo
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Obtener el máximo de dos enteros
    int max(int a, int b) {
        return Math.max(a, b);
    }

    // Rotación derecha
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Rotación
        x.right = y;
        y.left = T2;

        // Actualizar alturas
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Rotación izquierda
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Rotación
        y.left = x;
        x.right = T2;

        // Actualizar alturas
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Obtener el factor de balanceo de un nodo
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Insertar un nodo en el árbol AVL
    AVLNode insert(AVLNode node, int key) {
        // 1. Inserción normal
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        // 2. Actualizar la altura
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Verificar balance y hacer rotaciones si es necesario
        int balance = getBalance(node);

        // Rotaciones según el caso
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Recorrido por amplitud (BFS)
    void levelOrderTraversal() {
        if (root == null) return;

        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            AVLNode current = queue.poll();
            System.out.print(current.key + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    // Método para insertar más fácilmente desde main
    void insert(int key) {
        root = insert(root, key);
    }
}