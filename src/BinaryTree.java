/**
 * Importación de clases necesarias.
 */
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.Node;
/**
 * Clase del árbol binario para el manejo de palabras dentro de archivos.
 * @author Mario
 */
public class BinaryTree {
    /**
     * Variables.
     */
    public BinaryNode root;
    private ArrayList<String> ocurrencias, direcciones;
    /**
     * Constructor de la clase.
     */
    public BinaryTree() {
        this.root = null;
    }
    /**
     * Método para saber si el árbol esta vacío.
     * @return 
     */
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Método para saber si el árbol contiene o no una palabra
     * @param palabra
     * @return 
     */
    public boolean contains(String palabra) {
        return this.contains(palabra, this.root);
    }
    
    private boolean contains(String palabra, BinaryNode BNode) {
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
     * Método para encontrar la mínima posición dentro del árbol.
     * @param BNode
     * @return 
     */
    public BinaryNode findMin(BinaryNode BNode) {
        if (BNode == null)
            return null;
        else if (BNode.left == null)
            return BNode;
        else
            return findMin(BNode.left);
    }
    /**
     * Método para encontrar una palabra dentro del árbol.
     * @param palabra
     * @return 
     */
    public BinaryNode find(String palabra) {
        return find(palabra, root);
    }

    private BinaryNode find(String palabra, BinaryNode current) {
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
     * Método para encontrar la máxima posición dentro del árbol.
     * @param BNode
     * @return 
     */
    public BinaryNode findMax(BinaryNode BNode) {
        if (BNode!= null)
            while (BNode.right != null) {
                BNode = BNode.right;
            }
        return BNode;
    }
    /**
     * Método para insertar elementos al árbol.
     * @param palabra
     * @param parrafo
     * @param direccion 
     */
    public void insert(String palabra, String parrafo, String direccion) {
        this.root = this.insert(palabra, parrafo, direccion, this.root);
    }

    private BinaryNode insert(String palabra, String parrafo, String direccion, BinaryNode current) {
        if (current == null){
            ocurrencias = new ArrayList<>();
            direcciones = new ArrayList<>();
            ocurrencias.add(parrafo);
            direcciones.add(direccion);
            return new BinaryNode(palabra, ocurrencias, direcciones, null, null);
        }

        int compareResult = palabra.compareTo(current.palabra);
        if (compareResult < 0)
            current.left = this.insert(palabra, parrafo, direccion, current.left);
        else if(compareResult == 0){
            current.ocurrencias.add(parrafo);
            current.direcciones.add(direccion);
            return current;
        }
        else if (compareResult > 0){
            current.right = this.insert(palabra, parrafo, direccion, current.right);
        }

        return current;
    }
    /**
     * Método para borrar elementos dentro del árbol.
     * @param palabra 
     */
    public void remove(String palabra) {
        this.root = this.remove(palabra, this.root);
    }

    private BinaryNode remove(String palabra, BinaryNode BNode) {
        if (BNode == null)
            return BNode;

        int compareResult = palabra.compareTo(BNode.palabra);

        if (compareResult < 0)
            BNode.left= remove(palabra, BNode.left);
        else if (compareResult > 0)
            BNode.right = remove(palabra, BNode.right);
        else if (BNode.left != null && BNode.right != null){
            BNode.palabra = findMin(BNode.right).palabra;
            BNode.right = remove(BNode.palabra, BNode.right);
        } else {
            BNode = BNode.left != null ? BNode.left : BNode.right;
        }
        return BNode;
    }
    
}

    
 