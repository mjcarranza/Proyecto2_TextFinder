/**
 * Importación de clases necesarias.
 */
import java.util.ArrayList;
/**
 * Clase del árbol binario para el manejo de palabras dentro de archivos.
 * @author Mario
 */
public class BinaryTree {
    /**
     * Variables.
     */
    public static BinaryNode root;
    private static ArrayList<String> ocurrencias, direcciones, nombres, fechas;
    private static ArrayList<Integer> sizes;
    /**
     * Constructor de la clase.
     */
    public BinaryTree() {
        BinaryTree.root = null;
    }
    /**
     * Método para saber si el árbol esta vacío.
     * @return // Retorna si el árbol está vacío.
     */
    public static boolean isEmpty() {
        return BinaryTree.root == null;
    }
    
    /**
     * Método para saber si el árbol contiene o no una palabra
     * @param palabra
     * @return 
     */
    public static boolean contains(String palabra) {
        return BinaryTree.contains(palabra, BinaryTree.root);
    }
    
    private static boolean contains(String palabra, BinaryNode BNode) {
        if (BNode == null) {
            return false;
        } else {
            int compareResult = palabra.compareTo(BNode.palabra);

            if (compareResult < 0)
                return contains(palabra, BNode.left);
            else if (compareResult > 0)
                return contains(palabra, BNode.right);
            else
                return true;
        }
    }
    /**
     * Método para encontrar una palabra dentro del árbol.
     * @param palabra // String a ser buscada dentro del árbol.
     * @return // retorna true si se encuentra, o false si no se encuentra.
     */
    public static BinaryNode find(String palabra) {
        return BinaryTree.find(palabra, root);
    }

    private static BinaryNode find(String palabra, BinaryNode current) {
        if (current == null){
            return null;
        }
        int compareResult = palabra.compareTo(current.palabra);
        if (compareResult < 0)
            current = find(palabra, current.left);
        else if(compareResult == 0){
            return current;
        }
        else if (compareResult > 0){
            current = find(palabra, current.right);
        }
        return current;
    }
    /**
     * Método para insertar elementos al árbol.
     * @param palabra // palabra a insertar en el árbol.
     * @param parrafo // parrafo de ocurrencia de la palabra
     * @param direccion // dirección donde se encentra el archivo que contiene la palabra.
     * @param nombre // nombre del archivo que contiene la palabra.
     * @param fecha // fecha de creación del archivo que contiene la palabra.
     * @param size // tamaño del archivo que contiene la palabra.
     */
    public static void insert(String palabra, String parrafo, String direccion, String nombre, String fecha, int size) {
        BinaryTree.root = BinaryTree.insert(palabra, parrafo, direccion, nombre, fecha, size, BinaryTree.root);
    }

    private static BinaryNode insert(String palabra, String parrafo, String direccion, String nombre, String fecha, int size, BinaryNode current) {
        if (current == null){
            ocurrencias = new ArrayList<>();
            direcciones = new ArrayList<>();
            nombres = new ArrayList<>();
            fechas = new ArrayList<>();
            sizes = new ArrayList<>();
            ocurrencias.add(parrafo);
            direcciones.add(direccion);
            nombres.add(nombre);
            fechas.add(fecha);
            sizes.add(size);
            return new BinaryNode(palabra, ocurrencias, direcciones, nombres, fechas, sizes, null, null);
        }
        /**
         * Se compara para ordenar la palabra dentro del arbol.
         */
        int compareResult = palabra.compareTo(current.palabra);
        if (compareResult < 0)
            current.left = BinaryTree.insert(palabra, parrafo, direccion, nombre, fecha, size, current.left);
        else if(compareResult == 0){
            current.ocurrencias.add(parrafo);
            current.direcciones.add(direccion);
            current.nombres.add(nombre);
            current.fechas.add(fecha);
            current.sizes.add(size);
            return current;
        }
        else if (compareResult > 0){
            current.right = BinaryTree.insert(palabra, parrafo, direccion, nombre, fecha, size, current.right);
        }

        return current;
    }
    /**
     * Método para borrar elementos dentro del árbol.
     * @param palabra // palabra a ser eliminada.
     */
    public static void remove(String palabra) {
        BinaryTree.root = BinaryTree.remove(palabra, BinaryTree.root);
    }

    private static BinaryNode remove(String palabra, BinaryNode BNode) {
        if (BNode == null)
            return BNode;

        int compareResult = palabra.compareTo(BNode.palabra);

        if (compareResult < 0)
            BNode.left= BinaryTree.remove(palabra, BNode.left);
        else if (compareResult > 0)
            BNode.right = BinaryTree.remove(palabra, BNode.right);
        else if (BNode.left != null && BNode.right != null){
            BNode.palabra = BinaryTree.findMin(BNode.right).palabra;
            BNode.right = BinaryTree.remove(BNode.palabra, BNode.right);
        } else {
            BNode = BNode.left != null ? BNode.left : BNode.right;
        }
        return BNode;
    }
    
    /**
     * Método para encontrar la máxima posición dentro del árbol.
     * @param BNode
     * @return // retorna el nodo de la posición máxima.
     */
    public static BinaryNode findMax(BinaryNode BNode) {
        if (BNode!= null)
            while (BNode.right != null) {
                BNode = BNode.right;
            }
        return BNode;
    }
    /**
     * Método para encontrar la mínima posición dentro del árbol.
     * @param BNode
     * @return // retorna el nodo de la posición mínima.
     */
    public static BinaryNode findMin(BinaryNode BNode) {
        if (BNode == null)
            return null;
        else if (BNode.left == null)
            return BNode;
        else
            return findMin(BNode.left);
    }
}

    
 