/**
 * Importación de clases necesarias.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

/**
 * Clase para la manipulación de la biblioteca de documentos.
 * @author Mario
 */
public class Biblioteca {
    /**
     * Variables
     */
    String nombre;
    /**
     * Método para crear la carpeta de la biblioteca.
     * @param NombreArchivo // archivo que se va a crear
     */
    public void crear(){ 
        /**
         * variables
         */
        String Library = "src\\Biblioteca";
        String Archivo = "\\" + this.nombre;
        File creaCarpet = new File(Library);
        File creaArchivo = new File(Library + Archivo);
        int seleccion;
        
        /**
         * Condicion para validar si el archivo que se decea agregar a la lista ya existe o no.
         * Si el archivo existe, se envía un mensaje por si se decea reemplazarlo.
         */
        if(creaArchivo.exists()){
            seleccion = JOptionPane.showConfirmDialog(null, "El archivo ya existe. Decea reemplazarlo?");
                if(seleccion == 0) {
                    creaCarpet.mkdirs();
                    JOptionPane.showMessageDialog(null, "Se ha creado el archivo con éxito");
                }
	/**
         * Si el archivo no existe todavía dentro de la biblioteca, se procede a su creación.
         */		
        }else{
            JOptionPane.showMessageDialog(null, "Se ha creado el archivo con éxito");
            creaCarpet.mkdirs();
            try {
                if(creaArchivo.createNewFile()){
                    JOptionPane.showMessageDialog(null, "Archivo creado.");
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo no creado.");
                }
            } catch (Exception e) {
                System.out.println("Error de ejecucion");
            }
        }
    }
    
    /**
     * Método que se encarga de copiar el archivo desde donde fue buscado y pegarlo dentro de la biblioteca.
     * @param FileArchivo archivo a ser copiado dentro de la biblioteca.
     * @throws IOException 
     */
    public void copiarArchivo(String FileArchivo) throws IOException{
        String file = FileArchivo;
        Path origen = Paths.get(file);
        Path destino = Paths.get("src\\Biblioteca\\" + this.nombre);
        Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
    }
    /**
     * Método para obtener el archivo.
     * @return retorna el archivo obtenido.
     */
    public String getArchivo(){
        return "src\\Biblioteca\\"+this.nombre;
    }
    /**
     * Método para poner nombre al archivo.
     * @param nombreArchivo // nombre a insertar.
     */
    public void setNombre(String nombreArchivo){
        this.nombre = nombreArchivo;
    }
}