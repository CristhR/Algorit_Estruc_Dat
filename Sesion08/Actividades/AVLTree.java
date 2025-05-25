package Actividades;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    @Override
    public void insert(E data) {
        root = insertRec((NodeAVL<E>) root, data);
    }

    private NodeAVL<E> insertRec(NodeAVL<E> node, E data) {
        if (node == null) return new NodeAVL<>(data);

        if (data.compareTo(node.data) < 0) {
            node.left = insertRec((NodeAVL<E>) node.left, data);
            node.bf--;
        } else {
            node.right = insertRec((NodeAVL<E>) node.right, data);
            node.bf++;
        }

        // Rebalance if needed
        if (node.bf == -2) return balanceToRight(node);
        if (node.bf == 2) return balanceToLeft(node);

        return node;
    }

    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> child = (NodeAVL<E>) node.right;
        if (child.bf >= 0) {
            // RSL
            node.bf = 0;
            child.bf = 0;
            return rotateSL(node);
        } else {
            // RDL
            NodeAVL<E> grandchild = (NodeAVL<E>) child.left;
            switch (grandchild.bf) {
                case -1: node.bf = 0; child.bf = 1; break;
                case 0:  node.bf = 0; child.bf = 0; break;
                case 1:  node.bf = -1; child.bf = 0; break;
            }
            grandchild.bf = 0;
            node.right = rotateSR(child);
            return rotateSL(node);
        }
    }

    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> child = (NodeAVL<E>) node.left;
        if (child.bf <= 0) {
            // RSR
            node.bf = 0;
            child.bf = 0;
            return rotateSR(node);
        } else {
            // RDR
            NodeAVL<E> grandchild = (NodeAVL<E>) child.right;
            switch (grandchild.bf) {
                case 1: node.bf = 0; child.bf = -1; break;
                case 0: node.bf = 0; child.bf = 0; break;
                case -1: node.bf = 1; child.bf = 0; break;
            }
            grandchild.bf = 0;
            node.left = rotateSL(child);
            return rotateSR(node);
        }
    }

    private NodeAVL<E> rotateSL(NodeAVL<E> a) {
        NodeAVL<E> b = (NodeAVL<E>) a.right;
        a.right = b.left;
        b.left = a;
        return b;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> b) {
        NodeAVL<E> a = (NodeAVL<E>) b.left;
        b.left = a.right;
        a.right = b;
        return a;
    }
 // Recorrido inorden (izquierda, raíz, derecha)
    public void printInOrder() {
        System.out.print("InOrder: ");
        printInOrder((NodeAVL<E>) root);
        System.out.println();
    }

    private void printInOrder(NodeAVL<E> node) {
        if (node != null) {
            printInOrder((NodeAVL<E>) node.left);
            System.out.print(node.data + " ");
            printInOrder((NodeAVL<E>) node.right);
        }
    }

    // Recorrido preorden (raíz, izquierda, derecha)
    public void printPreOrder() {
        System.out.print("PreOrder: ");
        printPreOrder((NodeAVL<E>) root);
        System.out.println();
    }

    private void printPreOrder(NodeAVL<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder((NodeAVL<E>) node.left);
            printPreOrder((NodeAVL<E>) node.right);
        }
    }

    // Recorrido postorden (izquierda, derecha, raíz)
    public void printPostOrder() {
        System.out.print("PostOrder: ");
        printPostOrder((NodeAVL<E>) root);
        System.out.println();
    }

    private void printPostOrder(NodeAVL<E> node) {
        if (node != null) {
            printPostOrder((NodeAVL<E>) node.left);
            printPostOrder((NodeAVL<E>) node.right);
            System.out.print(node.data + " ");
        }
    }
}
