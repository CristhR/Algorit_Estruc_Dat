package Actividades;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        try {
            bst.insert(8);
            bst.insert(3);
            bst.insert(1);
            bst.insert(20);
            bst.insert(10);
            bst.insert(5);
            bst.insert(4);

            System.out.println("InOrder: " + bst.toString());
            System.out.println("PreOrder: " + bst.showPreOrder());
            System.out.println("PostOrder: " + bst.showPostOrder());

            System.out.println("Mínimo: " + bst.findMinNode());
            System.out.println("Máximo: " + bst.findMaxNode());

            bst.delete(5);
            bst.delete(1);
            bst.delete(20);
            
            System.out.println("Mínimo: " + bst.findMinNode());
            System.out.println("Máximo: " + bst.findMaxNode());
            System.out.println("Después de eliminar 5 (inOrden): " + bst.toString());

        } catch (ItemDuplicated | ItemNotFound | ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
