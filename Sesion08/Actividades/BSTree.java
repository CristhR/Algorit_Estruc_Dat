package Actividades;

public class BSTree<E extends Comparable<E>> {
    protected Node<E> root;

    public void insert(E data) {
        root = insertRec(root, data);
    }

    protected Node<E> insertRec(Node<E> node, E data) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.data) < 0)
            node.left = insertRec(node.left, data);
        else
            node.right = insertRec(node.right, data);
        return node;
    }
}
