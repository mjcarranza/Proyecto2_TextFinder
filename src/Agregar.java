/**
 * Importación de clases necesarias.
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javax.swing.*;

/**
 * Clase permite buscar documentos detro del equipo y agregarlos a la biblioteca.
 * @author alvgo
 */
public class Agregar extends javax.swing.JFrame {
    private JLabel label;
    private JPopupMenu popUp;

    /**
     * Creacion de nuevo form "Agregar".
     */
    public Agregar() {
        initComponents();
    }

    /**
    * Inicialización de los componentes de la clase con sus respectivos diseños.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Buscador = new javax.swing.JTextField();
        busqueda = new javax.swing.JButton();
        PanelArchivos = new javax.swing.JPanel();
        retroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);
        jPanel1.add(Buscador);
        Buscador.setBounds(20, 20, 570, 30);

        busqueda.setText("BUSCAR");
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });
        jPanel1.add(busqueda);
        busqueda.setBounds(610, 20, 80, 30);

        PanelArchivos.setBackground(new java.awt.Color(255, 255, 255));
        PanelArchivos.setLayout(null);
        jPanel1.add(PanelArchivos);
        PanelArchivos.setBounds(20, 70, 790, 300);

        retroceder.setText("ATRÁS");
        retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrocederActionPerformed(evt);
            }
        });
        jPanel1.add(retroceder);
        retroceder.setBounds(715, 20, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método permite que al accionar el botón se puedan buscar archivos dentro 
     * del equipo y mostrarlos en pantalla.
     * @param evt 
     */
    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        /**
         * Se llama al método para buscar archivos.
         */
        BuscarArchivo(new File("C:/Users/Mario/Desktop/Administración"));
    }//GEN-LAST:event_busquedaActionPerformed
    /**
     * Botón que permite regresar a la interfaz principal.
     * @param evt 
     */
    private void retrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrocederActionPerformed
        TextFinder principal = new TextFinder();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retrocederActionPerformed

    /**
     * Método main de la clase.
     * @param args
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /**
         * Se crea y proyecta la interfaz.
         */
        java.awt.EventQueue.invokeLater(() -> {
            new Agregar().setVisible(true);
        });
    }
    
    /**
     * método para buscar archivos detro del equipo.
     * @param carpeta 
     */
    private void BuscarArchivo(File carpeta) {
        String archivo;
        int posY = 5;
        for (File listFile : carpeta.listFiles()) {
            try {
                /**
                 * Si el archivo pasado por parámetro es un directorio,
                 * se busca dentro de él, si no lo es, entonces se crea una etiqueta con la dirección del 
                 * archivo dentro del equipo
                 */
                if (listFile.isDirectory()) {
                   BuscarArchivo(listFile);
                } else {
                    archivo = listFile.toString();
                    if(archivo.contains(Buscador.getText()) && (archivo.contains(".docx") || archivo.contains(".txt") || archivo.contains(".pdf"))){
                        label = new JLabel(archivo);
                        label.setVisible(true);
                        PanelArchivos.add(label);
                        label.setBounds(10, posY, 1000, 20);
                        posY += 50;
                        AgregarArchivo(label, archivo);
                    }
                    
                }
            }catch(Exception e){
            }
        }
    }
    
    /**
     * Método permite agregar archivos a la bibioteca.
     * @param label
     * @param archivo 
     */
    private void AgregarArchivo(JLabel label, String archivo) {
        popUp = new JPopupMenu();
	popUp.add(new AccionMenu("Agregar", popUp, archivo));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setForeground(Color.BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e){
                label.setForeground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e){
                muestraMenu(e);
            }
            private void muestraMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popUp.setLocation(e.getLocationOnScreen());
                    popUp.setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JPanel PanelArchivos;
    private javax.swing.JButton busqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton retroceder;
    // End of variables declaration//GEN-END:variables

    
}

class AccionMenu extends AbstractAction {

    JPopupMenu pop;
    String archivo;
    /**
     * Se le pasa el nombre que se quiere que se muestre
     * 
     * @param textoOpcion
     */
    public AccionMenu(String textoOpcion, JPopupMenu pop, String archivo) {
        this.pop = pop;
        this.archivo = archivo;
        this.putValue(Action.NAME, textoOpcion);
    }
    
    
    /**
     * para leer archivos de texto
     * @param direccion
     * @return 
     */
    public void leerArchivo(String direccion){ //direccion del archivo
        BinaryTree tree = new BinaryTree();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(direccion));
            String tempText = ""; // texto temporal
            String bufferRead;
            String[] pal;
            ArrayList<String> linea = new ArrayList<>();
            /**
             * Se hace el ciclo mientras bfRead tiene texto.
             */
            while((bufferRead = buffer.readLine()) != null){
                tempText = tempText + bufferRead; //guardado del el texto del archivo
                linea.add(bufferRead);
            }
            pal = tempText.split(" "); // Se divide el texto en palabras
            for (String linea1 : linea) {
                for (String palabra1 : pal) {
                    if (linea1.contains(palabra1) && !palabra1.contains(" ")) {
                        tree.insert(palabra1, linea1, direccion);
                    }
                }
            }
            for (String linea1 : linea) {
                for (String pal1 : pal) {
                    if (linea1.contains(pal1) && !pal1.contains(" ")) {
                        System.out.println(tree.find(pal1).palabra + " esta contenida en: " + tree.find(pal1).ocurrencias);
                    }
                }
            }
        }catch(IOException e){ 
            System.err.println();
        }
        
    }

    /**
     * Botón para agregar documento a la biblioteca
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        pop.setVisible(false);
        Biblioteca biblio = new Biblioteca();
        biblio.crear(archivo.substring(37));
        try {
            biblio.copiarArchivo(archivo);
            leerArchivo(biblio.getArchivo());
        } catch (IOException ex) {
            
        }
        
    }
}