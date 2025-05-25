package Actividades;

public class Main {
	public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] elementos = {30, 15, 20, 50, 40, 60, 70, 10, 25, 45, 55, 65, 75};

        for (int x : elementos) {
            System.out.println("Insertando: " + x);
            avl.insert(x);
        }

        System.out.println("\n--- Recorridos ---");
        avl.printInOrder();
        avl.printPreOrder();
        avl.printPostOrder();
    }	
}
