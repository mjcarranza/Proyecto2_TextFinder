/**
 * Importación de clases necesarias.
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;

/**
 *Clase principal del proyecto Text Finder.
 * @author Mario
 */
public class TextFinder extends javax.swing.JFrame {
    private JLabel label;
    private JPopupMenu popUp;
    /**
     * Constructor de la clase.
     */
    public TextFinder() {
        initComponents();
    }
    /**
    * Inicialización de los componentes de la clase con sus respectivos diseños.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        PanelPrincipal = new javax.swing.JPanel();
        busqueda = new javax.swing.JButton();
        Buscador = new java.awt.TextField();
        agregar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        Panel1 = new javax.swing.JPanel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(0, 153, 255));
        PanelPrincipal.setLayout(null);

        busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });
        PanelPrincipal.add(busqueda);
        busqueda.setBounds(620, 20, 40, 30);

        Buscador.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Buscador.setText("Buscar en biblioteca");
        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });
        PanelPrincipal.add(Buscador);
        Buscador.setBounds(20, 20, 590, 30);

        agregar.setText("AGREGAR");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(agregar);
        agregar.setBounds(823, 20, 90, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Fecha", "Tamaño" }));
        PanelPrincipal.add(jComboBox1);
        jComboBox1.setBounds(680, 20, 90, 30);

        Panel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        PanelPrincipal.add(Panel1);
        Panel1.setBounds(20, 60, 890, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * En este método se definen las funciones del botón buscar de esta interfaz,
     * identificado con la imagen de una lupa.
     * @param evt 
     */
    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        //codigo para que limpie el cuadro de texto.
        
        /**
         * Llamamos al méotodo BuscarArchivo.
         */
        BuscarArchivo(new File("src\\Biblioteca"));
    }//GEN-LAST:event_busquedaActionPerformed
    /**
     * En este método se definen las funciones del botón identificado como "Agregar",
     * el cual nos envía a una interfaz nueva donde es posible buscar y agregar 
     * archivos a nuestra biblioteca.
     * @param evt 
     */
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        Agregar ventana = new Agregar();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_agregarActionPerformed
    /**
     * En este método se definen las funciones de la caja de texto en la parte superior de esta interfaz,
     * que permite buscar palabras o frases dentro de todos los archivos disponibles en la biblioteca.
     * @param evt 
     */
    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // codigo para que desaparezca el texto de la caja al dar click
    }//GEN-LAST:event_BuscadorActionPerformed

    /**
     * Método principal de la clase.
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /**
         * Se crea y proyecta la interfaz.
         */
        java.awt.EventQueue.invokeLater(() -> {
            new TextFinder().setVisible(true);
        });
    }
    /**
     * Declaración de las variables necesarias.
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField Buscador;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton agregar;
    private javax.swing.JButton busqueda;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
    /**
     * Método para buscar archivos dentro de la biblioteca de documentos.
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
                    if(archivo.contains(Buscador.getText())){
                        label = new JLabel(archivo);
                        label.setVisible(true);
                        Panel1.add(label);
                        label.setBounds(10, posY, 1000, 20);
                        posY += 50;
                        AbrirArchivo(label, archivo);
                    }
                    
                }
            }catch(Exception e){
            }
        }
    }
    
    /**
     * Método que se encaarga de abrir los archivos que el usuario decea.
     * @param label
     * @param archivo 
     */
    private void AbrirArchivo(JLabel label, String archivo) {
    popUp = new JPopupMenu();
    popUp.add(new AccionMenu("Abrir", popUp, archivo));
    /**
     * Se agrega un Listener a la etiqueta que contiene el archivo.
     */
    label.addMouseListener(new MouseAdapter() {
        /**
         * Método para validar si el mouse está sobre una etiqueta, si es así,
         * el colo r del texto de la etiqueta cambia y también el cursor del mouse.
         * @param e 
         */
        @Override
        public void mouseEntered(MouseEvent e){
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setForeground(Color.BLUE);
        }
        /**
         * Método para validar si el mosuse se encuentra fuera de la etiqueta.
         * @param e 
         */
        @Override
        public void mouseExited(MouseEvent e){
            label.setForeground(Color.BLACK);
        }
        /**
         * Método que valida si el click derecho del mose es presionado.
         * @param e 
         */
        @Override
        public void mouseReleased(MouseEvent e){
            muestraMenu(e);
        }
        /**
         * Método para mostrar el menú al hacer click derecho sobre una etiqueta.
         * @param e 
         */
        private void muestraMenu(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popUp.setLocation(e.getLocationOnScreen());
                popUp.setVisible(true);
                }
        }
    });
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////       codigo para abrir documentos pdf, docx y txt desde java     ///////////////////////////////////////////////////////////////////
    
     /**
     * Botón para agregar documento a la biblioteca
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        popUp.setVisible(false);
        try {
            String direccion = "";// url
            ProcessBuilder abrir = new ProcessBuilder();
            abrir.command("cmd.exe","/c", direccion);
            abrir.start();
        } catch (Exception ex) {
            System.out.println("Error de ejcucion");
        }
        
    } 
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}