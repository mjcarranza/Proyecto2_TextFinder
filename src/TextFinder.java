/**
 * Importación de clases necesarias.
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

/**
 *Clase principal del proyecto Text Finder.
 * @author Mario
 */
public class TextFinder extends javax.swing.JFrame {
    private JLabel nombres, parrafos, tamano;
    private JPopupMenu popUp;
    private String BuscadorTexto;
    private Quicksort ordenN;
    private RadixSort ordenS;
    private int posY = 10;
    private JLabel label;
    private final JScrollPane scroll;
    private JButton eliminar;
    /**
     * Constructor de la clase.
     */
    public TextFinder() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelArchivos.requestFocus();
        this.setTitle("Biblioteca");
        scroll = new JScrollPane();
        scroll.setBounds(20, 60, 911, 406);
        PanelArchivos.setPreferredSize(new Dimension(890,2000));
        scroll.setViewportView(PanelArchivos);
        PanelPrincipal.add(scroll);
        
    }
    /**
    * Inicialización de los componentes de la clase con sus respectivos diseños.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        PanelPrincipal = new javax.swing.JPanel();
        busca = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        Ordenamiento = new javax.swing.JComboBox();
        PanelArchivos = new javax.swing.JPanel();
        Buscador = new javax.swing.JTextField();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(0, 153, 255));
        PanelPrincipal.setLayout(null);

        busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });
        PanelPrincipal.add(busca);
        busca.setBounds(620, 10, 50, 40);

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/biblio.png"))); // NOI18N
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(agregar);
        agregar.setBounds(850, 10, 60, 40);

        Ordenamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Fecha", "Tamaño" }));
        Ordenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenamientoActionPerformed(evt);
            }
        });
        PanelPrincipal.add(Ordenamiento);
        Ordenamiento.setBounds(710, 10, 100, 40);

        PanelArchivos.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelArchivosLayout = new javax.swing.GroupLayout(PanelArchivos);
        PanelArchivos.setLayout(PanelArchivosLayout);
        PanelArchivosLayout.setHorizontalGroup(
            PanelArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        PanelArchivosLayout.setVerticalGroup(
            PanelArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        PanelPrincipal.add(PanelArchivos);
        PanelArchivos.setBounds(20, 60, 890, 400);

        Buscador.setForeground(new java.awt.Color(204, 204, 204));
        Buscador.setText("Buscar en biblioteca");
        Buscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscadorFocusLost(evt);
            }
        });
        PanelPrincipal.add(Buscador);
        Buscador.setBounds(20, 10, 590, 40);

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
    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        /**
         * Llamamos al método BuscarArchivo.
         */
        PanelArchivos.removeAll();
        PanelArchivos.repaint();
        posY = 5;
        BuscarArchivo(BuscadorTexto, "Nombre");
        if(PanelArchivos.getComponentCount() == 0){
            label = new JLabel("Su busqueda no se encuentra en ningun archivo de la biblioteca.");
            label.setVisible(true);
            label.setForeground(Color.gray);
            PanelArchivos.add(label);
            label.setBounds(10, posY, 1000, 20);
        }
    }//GEN-LAST:event_buscaActionPerformed
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
     * Escuchador de eventos para la caja de texto de la biblioteca. Si se hace click, 
     * se limpia el texto que cotiene.
     * @param evt 
     */
    private void BuscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscadorFocusGained
        // TODO add your handling code here:
        Buscador.setText("");
        Buscador.setForeground(Color.BLACK);
    }//GEN-LAST:event_BuscadorFocusGained
    /**
     * Escuchador de eventos para la caja de texto de la biblioteca. Si se hace click, 
     * se agrega texto temporal.
     * @param evt // evento.
     */
    private void BuscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscadorFocusLost
        // TODO add your handling code here:
        BuscadorTexto = Buscador.getText();
        Buscador.setText("Buscar en biblioteca");
        Buscador.setForeground(Color.lightGray);
    }//GEN-LAST:event_BuscadorFocusLost
    /**
     * Escuchador de eventos para el panel de la biblioteca para que al hacer una nueva búsqueda,
     * se eliminen los elementos de la búsqueda anterior.
     * @param evt // evento.
     */
    private void OrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenamientoActionPerformed
        PanelArchivos.removeAll();
        PanelArchivos.repaint();
        posY = 5;
        
        //Ordenamos dependiendo de item seleccionado en el combo Box
        switch(Ordenamiento.getSelectedItem().toString()){
            case "Nombre":
                BuscarArchivo(BuscadorTexto, "Nombre");
                break;
            case "Fecha":
                BuscarArchivo(BuscadorTexto, "Fecha");
                break;
            case "Tamaño":
                BuscarArchivo(BuscadorTexto, "Tamaño");
                break;
        }
        
        if(PanelArchivos.getComponentCount() == 0){
            label = new JLabel("Su busqueda no se encuentra en ningun archivo de la biblioteca.");
            label.setVisible(true);
            label.setForeground(Color.gray);
            PanelArchivos.add(label);
            label.setBounds(10, posY, 1000, 20);
        }
    }//GEN-LAST:event_OrdenamientoActionPerformed

    /**
     * Método principal de la clase.
     * @param args // parámetro de clase principal.
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
    private javax.swing.JTextField Buscador;
    private javax.swing.JComboBox Ordenamiento;
    private javax.swing.JPanel PanelArchivos;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton agregar;
    private javax.swing.JButton busca;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables

    
    /**
     * método para buscar archivos detro de la biblioteca.
     * @param busqueda se pasa la palabra que se quiera buscar
     * @param orden se elige el metodo de ordenamiento
     */
    private void BuscarArchivo(String busqueda, String orden) {
        if(BinaryTree.contains(busqueda)){
            /**
             * Se crea un ArrayList para sacar cada ocurrencia de la palabra buscada.
             */
            ArrayList<String> ocurrencia = BinaryTree.find(busqueda).ocurrencias;
            
            /**
             * Se crean los arrays de ordenamiento.
             */
            String nombreArray[] = new String [ocurrencia.size()];
            String fechaArray[] = new String [ocurrencia.size()];
            int sizeArray[] = new int [ocurrencia.size()];
            
            /**
             * Si se encontro dentro del arbol se muestra la ocurrencia por pantalla.
             */
            for (int i = 0; i < ocurrencia.size(); i++) {
                //Se agregan los elementos a un array
                nombreArray[i] = BinaryTree.find(busqueda).nombres.get(i);
                fechaArray[i] = BinaryTree.find(busqueda).fechas.get(i);
                sizeArray[i] = BinaryTree.find(busqueda).sizes.get(i);
            }
            /**
             * Estructura switch para mostrar en pantalla los documentos buscados,
             * dependiendo de la opción de ordenamiento seleccionada.
             */
            switch(orden){
                case "Nombre":
                    muestraPantalla(ordenarNombre(nombreArray), null, busqueda, "Nombre");
                    break;
                case "Fecha":
                    muestraPantalla(ordenarFecha(fechaArray), null,  busqueda, "Fecha");
                    break;
                case "Tamaño":
                    muestraPantalla(null, ordenarSize(sizeArray), busqueda, "Tamaño");
                    break;
            }
        }
    }
    
    /**
     * Este metodo ordena la busqueda por el nombre del archivo
     * @param ArrayNombres // Lista que se desea ordenar
     * @return // retorna arreglo de strings ordenados
     */
    private String[] ordenarNombre(String[] ArrayNombres){
        ordenN = new Quicksort();
        return ordenN.ordenar(ArrayNombres);
    }
    /**
     * Método para ordenar los archivos de la búsqueda por fecha.
     * @param ArrayFechas // lista de fechas.
     * @return // retorna lista ordenada.
     */
    private String[] ordenarFecha(String[] ArrayFechas){
        return BubbleSort.bubble_srt(ArrayFechas);
    }
    /**
     * Método para ordenar los archivos de la búsqueda por tamaño.
     * @param ArraySize // lista de tamaños.
     * @return // retorna tista ordenada.
     */
    private int[] ordenarSize(int[] ArraySize){
        return RadixSort.radixsort(ArraySize, ArraySize.length);
    }
    /**
     * Método para mostrar los resultados de la búsqueda en la aplicación.
     * @param datos // lista de datos.
     * @param tamanos // lista de tamaños.
     * @param palabra // palabra buscada.
     * @param orden // orden seleccionado.
     */
    private void muestraPantalla(String[] datos, int [] tamanos, String palabra, String orden){
        int posiciones[];
        if(orden.equals("Tamaño"))
            posiciones = new int[tamanos.length];
        else
            posiciones = new int[datos.length];
        
        for (int i = 0; i < posiciones.length; i++) {
            /**
             * Estructura switch para el ordenamiento de llos documentos en la interfaz dependiendo de la opción seleccionada.
             */
            switch(orden){
                case "Nombre":
                    posiciones[i] = BinaryTree.find(palabra).nombres.indexOf(datos[i]);
                    break;
                case "Fecha":
                    posiciones[i] = BinaryTree.find(palabra).fechas.indexOf(datos[i]);
                    break;
                case "Tamaño":
                    posiciones[i] = BinaryTree.find(palabra).sizes.indexOf(tamanos[i]);
                    break;
            }
        }
        
        ArrayList<String> ocurrencia = BinaryTree.find(palabra).ocurrencias;
        for (int i = 0; i < posiciones.length; i++) {
            /**
             * Se toman los indices del principio y final para resaltar.
             */
            int indiceInicial = ocurrencia.get(posiciones[i]).indexOf(palabra);
            int indiceFinal = indiceInicial + palabra.length();

            /**
             * Se corta el parrafo para resaltar la palabra buscada.
             */
            String ocurBefore = ocurrencia.get(posiciones[i]).substring(0, indiceInicial);
            String ocur = "<span style= 'background-color: #FFFF00;'>"+ ocurrencia.get(posiciones[i]).substring(indiceInicial, indiceFinal) +"</span>";
            String ocurAfter = ocurrencia.get(posiciones[i]).substring(indiceFinal);

            /**
             * Se concatena el texto de nuevo.
             */
            String ocurrence = ocurBefore + ocur + ocurAfter;
            String nombreArchivo = "<FONT SIZE=5>" + BinaryTree.find(palabra).nombres.get(posiciones[i]) + "</font>";
            String fecha = BinaryTree.find(palabra).fechas.get(posiciones[i]);
            String direccion = BinaryTree.find(palabra).direcciones.get(posiciones[i]);
            int size = BinaryTree.find(palabra).sizes.get(posiciones[i]);

            /**
             * Se crea el texto del label del nombre y la fecha.
             */
            String textoNombre = "<html><body>" + nombreArchivo + "<br>" + "Fecha de creacion: " + fecha + "</body></html>";
            nombres = new JLabel(textoNombre);
            nombres.setVisible(true);
            PanelArchivos.add(nombres);
            nombres.setBounds(10, posY, 750, 70);
            
            /**
             * Se sombrea el texto con html para ser insertado en el label.
             */
            String texto = "<html><body>" + direccion + "<br>" + ocurrence + " <br></body></html>";
            parrafos = new JLabel(texto);
            parrafos.setVisible(true);
            PanelArchivos.add(parrafos);
            parrafos.setBounds(350, posY, 300, 70);
            
            String textoSize;
            if(size > 1000 && size < 1000000){
                textoSize = "<html><body> Tamaño: " + size/1000 + " KB <br></body></html>";
            }
            else if(size > 1000000 && size < 1000000000){
                textoSize = "<html><body> Tamaño: " + size/1000000 + " MB <br></body></html>";
            }
            else if(size > 1000000000){
                textoSize = "<html><body> Tamaño: " + size/1000000000 + " GB <br></body></html>";
            }
            else{
                textoSize = "<html><body> Tamaño: " + size + " Bytes <br></body></html>";
            }
            tamano = new JLabel(textoSize);
            tamano.setVisible(true);
            eliminar = new JButton(new ImageIcon("src/Imagenes/equis.jpg"));
            eliminar.setVisible(true);
            PanelArchivos.add(tamano);
            PanelArchivos.add(eliminar);
            eliminar.setBounds(760+textoSize.length(), posY+10, 30, 30);
            tamano.setBounds(700, posY, textoSize.length()+5, 70);
            eliminar.addActionListener(new ActionListener() {
                /**
                 * Método para la acción de eliminar de la biblioteca y el árbol.
                 * @param e // Evento.
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                   // String archivo = BinaryTree.find(BuscadorTexto).direcciones; ////////////////////////////////////////////////////////////////////
                    if (BinaryTree.contains(BuscadorTexto)){
                        BinaryTree.remove(BuscadorTexto);
                    }
                    //BinaryTree.remove();
                    
                }
            });
            
            posY += 70;//Aumentamos la posicion para que los labels salgan abajo
            AbrirArchivo(nombres, parrafos, tamano, direccion);//Metodo para abrir el archivo solicitado
        }
        
    }
    
    /**
     * Método encargado de abrir los archivos desde la biblioteca.
     * @param labelN // etiqueta para el nombre.
     * @param labelP // etiqueta para el párrafo de la ocurrencia.
     * @param labelT // etiqueta para el tamaño del archivo.
     * @param ruta // ruta del archivo.
     */
    private void AbrirArchivo(JLabel labelN, JLabel labelP, JLabel labelT, String ruta) {
        labelN.addMouseListener(new MouseAdapter() {
            /**
             * Método para el cursor del mouse y cambiar el color de la letra de las etiquetas cuando el mouse no está en contacto con ellas.
             * @param e // evento.
             */
            @Override
            public void mouseEntered(MouseEvent e){
                labelN.setCursor(new Cursor(Cursor.HAND_CURSOR));
                labelN.setForeground(Color.LIGHT_GRAY);
                labelP.setCursor(new Cursor(Cursor.HAND_CURSOR));
                labelP.setForeground(Color.LIGHT_GRAY);
                labelT.setCursor(new Cursor(Cursor.HAND_CURSOR));
                labelT.setForeground(Color.LIGHT_GRAY);
            }
            /**
             * Método para cambiar el color de la letra de las etiquetas cuando el mouse no está en contacto con ellas.
             * @param e // evento.
             */
            @Override
            public void mouseExited(MouseEvent e){
                labelN.setForeground(Color.BLACK);
                labelP.setForeground(Color.BLACK);
                labelT.setForeground(Color.BLACK);
            }
            /**
             * Método para que se mueste el menú.
             * @param e // Evento
             */
            @Override
            public void mouseReleased(MouseEvent e){
                popUp = new JPopupMenu();
                popUp.add(new AccionMenu2("Abrir", popUp, ruta));
                popUp.setLocation(e.getLocationOnScreen());
                popUp.setVisible(true);
            }
        });
    }
}
/**
 * Clase para las acciones del popup menú.
 * @author Mario
 */
class AccionMenu2 extends AbstractAction {

    JPopupMenu pop;
    String archivo;
    /**
     * Se le pasa el nombre que se quiere que se muestre.
     * @param textoOpcion // opción del menú.
     * @param pop // menú.
     * @param archivo // archivo al que se le aplica la acción de manú.
     */
    public AccionMenu2(String textoOpcion, JPopupMenu pop, String archivo) {
        this.pop = pop;
        this.archivo = archivo;
        this.putValue(Action.NAME, textoOpcion);
    }
    
    
    /**
     * Método para abrir archivos de texto.
     * @param direccion // dirección de archivo a abrir
     * @return 
     */
    public void abrirArchivo(String direccion){ //direccion del archivo
        try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

        }catch (IOException ex) {

            System.out.println(ex);

     }
    }

    /**
     * Botón para agregar documento a la biblioteca
     * @param e // Evento. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        pop.setVisible(false);
        abrirArchivo(archivo);
    }
}