/**
 * Importación de clases necesarias.
 */
import java.util.ArrayList;

/**
 *Clase Nodo para el manejo de datos en la clase Arbol Binario.
 * @author Mario
 */
public class BinaryNode {
    /**
     * Variables.
     */
    public String palabra;
    public ArrayList<String> ocurrencias, direcciones;
    public BinaryNode left;
    public BinaryNode right;
    /**
     * Método constrctor de la clase.
     * @param palabra
     * @param ocurrencia
     * @param direcciones 
     */
    public BinaryNode(String palabra, ArrayList<String> ocurrencia, ArrayList<String> direcciones) {
        this(palabra, ocurrencia, direcciones, null, null);
    }
    
    public BinaryNode(String palabra, ArrayList<String> ocurrencias, ArrayList<String> direcciones, BinaryNode left, BinaryNode right) {
        this.palabra = palabra;
        this.ocurrencias = ocurrencias;
        this.direcciones = direcciones;
        this.left = left;
        this.right = right;
    }
    /**
     * Método para obtener las ocurrencias de un nodo.
     * @return 
     */
    public ArrayList<String> getOcurrencias() {
        return ocurrencias;
    }
    /**
     * Método para obtener la direcció de un archivo dentro de un nodo.
     * @return 
     */
    public ArrayList<String> getDireccion() {
        return direcciones;
    }
    /**
     * Método para establecer la lista de ocurrencias de una palabra dentro de un nodo.
     * @param ocurrencias 
     */
    public void setOcurrencias(ArrayList<String> ocurrencias) {
        this.ocurrencias = ocurrencias;
    }
    /**
     * Método para establecer la direccion del archivo donde se encuentra la palabra.
     * @param direcciones 
     */
    public void setDirecciones(ArrayList<String> direcciones) {
        this.direcciones = direcciones;
    }
    
    
}
