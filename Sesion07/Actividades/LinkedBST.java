package Actividades;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    
    class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    } 

    private Node root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null)
            return new Node(data);
        int comparacion = data.compareTo(node.data);
        if (comparacion == 0)
            throw new ItemDuplicated("Item duplicado: " + data);
        else if (comparacion < 0)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    @Override
    public E search(E data) throws ItemNotFound {
        return search(root, data);
    }

    private E search(Node node, E data) throws ItemNotFound {
        if (node == null)
            throw new ItemNotFound("Elemento no encontrado: " + data);
        int comparacion = data.compareTo(node.data);
        if (comparacion == 0)
            return node.data;
        else if (comparacion < 0)
            return search(node.left, data);
        else
            return search(node.right, data);
    }
    
    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Árbol vacío");
        root = delete(root, data);
    }

    private Node delete(Node node, E data) {
        if (node == null)
            return null;

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {

            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = findMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    @Override
    public String toString() {	
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data.toString()).append(" ");
            inOrder(node.right, sb);
        }
    }
    
    private void preOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data.toString()).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
    
    public String showPreOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void postOrder(Node node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data.toString()).append(" ");
        }
    }

    public String showPostOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    public E findMinNode() throws ItemNotFound {
        if (root == null) throw new ItemNotFound("Árbol vacío");
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return search(current.data);
    }

    public E findMaxNode() throws ItemNotFound {
        if (root == null) throw new ItemNotFound("Árbol vacío");
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return search(current.data);
    }
}