package Ejercicios;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();
        
        try {
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            
            System.out.println("In-Order: " + bst);
            System.out.println("Pre-Order: " + bst.showPreOrder());
            System.out.println("Post-Order: " + bst.showPostOrder());
            
            System.out.println("Buscar 40: " + bst.search(40));
            
            System.out.println("Mínimo: " + bst.findMinNode());
            System.out.println("Máximo: " + bst.findMaxNode());
            
            System.out.println("Total de nodos: " + bst.countAllNodes());
            System.out.println("Cantidad de hojas (nodos no internos): " + bst.countNonNodes());
            
            System.out.println("Altura del nodo 30: " + bst.height(30));
            
            int nivel = 2;
            System.out.println("Amplitud del nivel " + nivel + ": " + bst.amplitud(nivel));
            
            System.out.println("Área del árbol: " + bst.areaBST());
            
            System.out.println("\nDibujo del BST:");
            bst.drawBST();
            
            LinkedBST<Integer> otroBST = new LinkedBST<>();
            otroBST.insert(100);
            otroBST.insert(90);
            otroBST.insert(110);
            
            System.out.println("\nOtro árbol:");
            otroBST.drawBST();
            System.out.println("Área del otro árbol: " + otroBST.areaBST());
            System.out.println("¿Tienen la misma área? " + bst.sameArea(otroBST));
            
            bst.delete(20);
            System.out.println("\nDespués de eliminar 20:");
            bst.drawBST();
            
            bst.destroyNodes();
            System.out.println("¿Árbol vacío después de destruir? " + bst.isEmpty());
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
