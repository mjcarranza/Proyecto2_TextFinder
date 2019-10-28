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
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

/**
 * Clase permite buscar documentos detro del equipo y agregarlos a la biblioteca.
 * @author alvgo
 */
public class Agregar extends javax.swing.JFrame {
    private JLabel label;
    private JPopupMenu popUp;
    int posY = 5;
    String BuscadorTexto;
    private JScrollPane scroll;

    /**
     * Creación de nuevo form "Agregar".
     */
    public Agregar() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelArchivos.requestFocus();
        this.setTitle("Buscador de Archivos");
        scroll = new JScrollPane(PanelArchivos);
        scroll.setBounds(20, 70, 811, 306);
        PanelArchivos.setPreferredSize(new Dimension(790,2000));
        scroll.setViewportView(PanelArchivos);
        jPanel1.add(scroll);
    }

    /**
    * Inicialización de los componentes de la clase con sus respectivos diseños.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Buscador = new javax.swing.JTextField();
        PanelArchivos = new javax.swing.JPanel();
        retroceder = new javax.swing.JButton();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);

        Buscador.setForeground(new java.awt.Color(204, 204, 204));
        Buscador.setText("Agregar a la biblioteca");
        Buscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscadorFocusLost(evt);
            }
        });
        jPanel1.add(Buscador);
        Buscador.setBounds(20, 10, 570, 40);

        PanelArchivos.setBackground(new java.awt.Color(255, 255, 255));
        PanelArchivos.setLayout(null);
        jPanel1.add(PanelArchivos);
        PanelArchivos.setBounds(20, 70, 790, 300);

        retroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrocederActionPerformed(evt);
            }
        });
        jPanel1.add(retroceder);
        retroceder.setBounds(750, 10, 60, 40);

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar);
        agregar.setBounds(600, 10, 50, 40);

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
     * Botón que permite regresar a la interfaz principal.
     * @param evt // Evento realizado por el botón.
     */
    private void retrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrocederActionPerformed
        TextFinder principal = new TextFinder();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retrocederActionPerformed
    /**
     * Escuchador de eventos para la caja de texto de la biblioteca. Si se hace click, 
     * se limpia el texto que cotiene.
     * @param evt // Evento realizado
     */
    private void BuscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscadorFocusGained
        // TODO add your handling code here:
        Buscador.setText("");
        Buscador.setForeground(Color.BLACK);
    }//GEN-LAST:event_BuscadorFocusGained
    /**
     * Escuchador de eventos para la caja de texto de la biblioteca. Si se hace click, 
     * se agrega texto temporal.
     * @param evt // Evento.
     */
    private void BuscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscadorFocusLost
        // TODO add your handling code here:
        BuscadorTexto = Buscador.getText();
        Buscador.setText("Agregar a la biblioteca");
        Buscador.setForeground(Color.lightGray);
    }//GEN-LAST:event_BuscadorFocusLost
    /**
     * Escuchador de eventos para el panel de la biblioteca para que al hacer una nueva búsqueda,
     * se eliminen los elementos de la búsqueda anterior.
     * @param evt // Evento.
     */
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        PanelArchivos.removeAll();
        PanelArchivos.repaint();
        posY = 5;
        if(!Buscador.getText().equals(""))
            BuscarArchivo(new File("C:\\Users\\Mario\\Desktop\\Administración"), BuscadorTexto);
        if(PanelArchivos.getComponentCount() == 0){
            label = new JLabel("No se encontraron archivos para su busqueda.");
            label.setVisible(true);
            label.setForeground(Color.gray);
            PanelArchivos.add(label);
            label.setBounds(10, posY, 1000, 20);
        }
    }//GEN-LAST:event_agregarActionPerformed

    /**
     * Método main de la clase.
     * @param args // parametro de la clase principal.
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
     * @param carpeta // folder donde se hace la búsqueda.
     */
    private void BuscarArchivo(File carpeta, String texto) {
        String archivo;
        for (int i = 0; i < carpeta.listFiles().length; i++) {
            try {
                /**
                 * Si el archivo pasado por parámetro es un directorio,
                 * se busca dentro de él, si no lo es, entonces se crea una etiqueta con la dirección del 
                 * archivo dentro del equipo
                 */
                File listFile = carpeta.listFiles()[i];
                if (listFile.isDirectory()) {
                   BuscarArchivo(listFile, texto);
                } else {
                    archivo = listFile.toString();
                    if(archivo.contains(texto) && listFile.getName().contains(".txt") || listFile.getName().contains(".docx") || listFile.getName().contains(".pdf")){
                        label = new JLabel(archivo);
                        label.setVisible(true);
                        PanelArchivos.add(label);
                        label.setBounds(10, posY, 1000, 20);
                        posY += 50;
                        AgregarArchivo(label);
                    }
                }
            }catch(Exception e){
            }
        }
        
    }
    
    /**
     * Método permite agregar archivos a la bibioteca.
     * @param label // Etiqueta que contiene la referencia del archivo.
     */
    private void AgregarArchivo(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            /**
             * Método para cambiar el cursr del mouse y el color del texto de la etiqueta, 
             * si este se ecuenta sobre una de las etiquetas con la referencia a algún archivo de texto.
             * @param e // Evento.
             */
            @Override
            public void mouseEntered(MouseEvent e){
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setForeground(Color.BLUE);
            }
            /**
             * Método para cambiar el cursr del mouse y el color del texto de la etiqueta, 
             * si este se ecuenta sobre una de las etiquetas con la referencia a algún archivo de texto.
             * @param e //Evento.
             */
            @Override
            public void mouseExited(MouseEvent e){
                label.setForeground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e){
                popUp = new JPopupMenu();
                popUp.add(new AccionMenu("Agregar", popUp, label.getText()));
                popUp.setLocation(e.getLocationOnScreen());
                popUp.setVisible(true);
            }
        });
    }
    /**
     * Declaaración de variables.
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JPanel PanelArchivos;
    private javax.swing.JButton agregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton retroceder;
    // End of variables declaration//GEN-END:variables

    
}

/**
 * Clase para el menú de acción.
 * @author alvgo
 */
class AccionMenu extends AbstractAction {
    /**
     * Variables.
     */
    JPopupMenu pop;
    String archivo;
    /**
     * Método para el menú emergente al dar click sobre un etiqueta.
     * @param textoOpcion
     * @param pop
     * @param archivo 
     */
    public AccionMenu(String textoOpcion, JPopupMenu pop, String archivo) {
        this.pop = pop;
        this.archivo = archivo;
        this.putValue(Action.NAME, textoOpcion);
    }
    
    
    /**
     * para leer archivos de texto
     * @param direccion 
     * @param fecha
     * @param direccionOriginal 
     */
    public void leerArchivo(String direccion, String fecha, String direccionOriginal){ //direccion del archivo
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
                if (tempText.equals("")){
                    tempText = tempText + bufferRead;
                }
                else{
                    /**
                     * Guardado del el texto del archivo.
                     */
                    tempText = tempText + " " + bufferRead; 
                }
                linea.add(bufferRead);
            }
            /**
             * Se divide el texto en palabras.
             */
            pal = tempText.split(" "); 
            
            for (String linea1 : linea) {
                for (String palabra1 : pal) {
                    if (linea1.contains(palabra1)) {
                        File agregaArchivo = new File(direccion);
                        if(BinaryTree.contains(palabra1)){
                            /**
                             * Para no repetir las ocurrencias.
                             */
                            if(!BinaryTree.find(palabra1).ocurrencias.contains(linea1.trim())){
                                BinaryTree.insert(palabra1, linea1.trim(), direccionOriginal, agregaArchivo.getName(), fecha, (int)agregaArchivo.length());
                            }
                        }
                        else{
                            BinaryTree.insert(palabra1, linea1.trim(), direccionOriginal, agregaArchivo.getName(), fecha, (int)agregaArchivo.length());
                        }
                    }
                }
            }
        }catch(IOException e){ 
            System.err.println();
        }
        
    }

    /**
     * Botón para agregar documento a la biblioteca
     * @param e // Evento.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            pop.setVisible(false);
            File f = new File(archivo);
            BasicFileAttributes atributo = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
            /**
             * Formato de fecha.
             */
            FileTime time = atributo.creationTime();
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pattern);
            String fecha = formato.format(new Date(time.toMillis()));
            /**
             * Instancia de la clase biblioteca.
             */
            Biblioteca biblio = new Biblioteca();
            biblio.setNombre(f.getName());
            biblio.crear();
            biblio.copiarArchivo(archivo);
            leerArchivo(biblio.getArchivo(), fecha, archivo);
        } catch (IOException ex) {
            
        }
        
    }
}