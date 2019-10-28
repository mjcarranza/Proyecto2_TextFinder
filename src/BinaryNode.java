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
    public ArrayList<String> ocurrencias, direcciones, nombres, fechas;
    public ArrayList<Integer> sizes;
    public BinaryNode left;
    public BinaryNode right;
    
    /**
     * Método constrctor de la clase.
     * @param palabra // Palabra a insertar.
     * @param ocurrencia // lista de ocurrencias.
     * @param direcciones // lista de direcciones de aerchivos.
     * @param fechas // lista de fechas de cada archivo.
     * @param nombres // lista de nombres de cada archivo.
     * @param sizes // lista de los tamaños de cada archivo.
     */
    public BinaryNode(String palabra, ArrayList<String> ocurrencia, ArrayList<String> direcciones, ArrayList<String> nombres, ArrayList<String> fechas, ArrayList<Integer> sizes) {
        this(palabra, ocurrencia, direcciones, nombres, fechas, sizes, null, null);
    }

    public BinaryNode(String palabra, ArrayList<String> ocurrencias, ArrayList<String> direcciones, ArrayList<String> nombres, ArrayList<String> fechas, ArrayList<Integer> sizes, BinaryNode left, BinaryNode right) {
        this.palabra = palabra;
        this.ocurrencias = ocurrencias;
        this.direcciones = direcciones;
        this.nombres = nombres;
        this.fechas = fechas;
        this.sizes = sizes;
        this.left = left;
        this.right = right;
    }
    
}
