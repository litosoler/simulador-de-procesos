import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *@author Lito Soler
 *@author Kelly Aguilar
 *@author María Ramírez
 *@author Orlando Durán
 *@author Mario Gómez
 */
public class Formulario extends javax.swing.JFrame {
    //Variable utilizada para guardar los procesos que no están siendo simulados al final de la simulación y poder guardarlos
    static String procesosNoSimulados=""; 
    static String traza = "";
    //Listas (5 TDA's) para los 5 estados del Modelo
    static List<Proceso> todosProcesos = new ArrayList<>();//Todos los procesos que fueron leídos o creados serán almacenados en esta lista
    static List<Proceso> listaNuevos = new ArrayList();//Nuevos
    static List<Proceso> listaListos = new ArrayList();//Listos
    static List<Proceso> listaEjecutando = new ArrayList<>();//Ejecutando
    static List<Proceso> listaBloqueados = new ArrayList<>();//Bloqueados
    static List<Proceso> listaTerminados = new ArrayList<>();//Terminados
    static List<Proceso> listaImpresion = new ArrayList<>();//Lista utilizada para clonar otra de las colas principales y así evitar perder el contenido de estas.

   
    public Formulario() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtcola0 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcola1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtcola2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtcola3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtcola4 = new javax.swing.JTextArea();
        btnSimulacion = new javax.swing.JButton();
        btnAbrirArchivo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblHistorial = new javax.swing.JLabel();
        btnEjecutar = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblCantidad = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtHistorialEjecucion = new javax.swing.JTextArea();
        txtcantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de Procesos");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 1000));

        txtcola0.setEditable(false);
        txtcola0.setColumns(10);
        txtcola0.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtcola0.setRows(5);
        txtcola0.setBorder(null);
        jScrollPane1.setViewportView(txtcola0);

        txtcola1.setEditable(false);
        txtcola1.setColumns(10);
        txtcola1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtcola1.setRows(5);
        txtcola1.setBorder(null);
        jScrollPane2.setViewportView(txtcola1);

        txtcola2.setEditable(false);
        txtcola2.setColumns(10);
        txtcola2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtcola2.setRows(5);
        txtcola2.setBorder(null);
        jScrollPane3.setViewportView(txtcola2);

        txtcola3.setEditable(false);
        txtcola3.setColumns(10);
        txtcola3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtcola3.setRows(5);
        txtcola3.setBorder(null);
        jScrollPane4.setViewportView(txtcola3);

        txtcola4.setEditable(false);
        txtcola4.setColumns(10);
        txtcola4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtcola4.setRows(5);
        jScrollPane5.setViewportView(txtcola4);

        btnSimulacion.setBackground(new java.awt.Color(0, 153, 204));
        btnSimulacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSimulacion.setForeground(new java.awt.Color(255, 255, 255));
        btnSimulacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/random.png"))); // NOI18N
        btnSimulacion.setToolTipText("Crear procesos Aleatorios");
        btnSimulacion.setBorder(null);
        btnSimulacion.setName("btnSimulacionAlea"); // NOI18N
        btnSimulacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimulacionMouseClicked(evt);
            }
        });
        btnSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimulacionActionPerformed(evt);
            }
        });

        btnAbrirArchivo.setBackground(new java.awt.Color(0, 153, 255));
        btnAbrirArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAbrirArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N
        btnAbrirArchivo.setToolTipText("Cargar procesos");
        btnAbrirArchivo.setBorder(null);
        btnAbrirArchivo.setName("btnCargarSimulacion"); // NOI18N
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(102, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar estado de Procesos");
        btnGuardar.setBorder(null);
        btnGuardar.setName("btnGuardarSimulacion"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/estados.png"))); // NOI18N

        btnEjecutar.setBackground(new java.awt.Color(153, 204, 255));
        btnEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        btnEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/run.png"))); // NOI18N
        btnEjecutar.setToolTipText("Comenzar Simulación");
        btnEjecutar.setBorder(null);
        btnEjecutar.setEnabled(false);
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(226, 226, 226));

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ciclos.png"))); // NOI18N

        txtHistorialEjecucion.setEditable(false);
        txtHistorialEjecucion.setColumns(10);
        txtHistorialEjecucion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtHistorialEjecucion.setRows(5);
        txtHistorialEjecucion.setBorder(null);
        txtHistorialEjecucion.setName("txtHistorialEjecucion"); // NOI18N
        jScrollPane6.setViewportView(txtHistorialEjecucion);

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/historial.png"))); // NOI18N

        jDesktopPane1.setLayer(lblCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtcantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCantidad)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcantidad)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblHistorial, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblHistorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDesktopPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BOTON QUE SIMULA ALEATORIAMENTE
    private void btnSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulacionActionPerformed
       //Limpiando colas
        limpiarListas();
        //Generando procesos nuevos aleatorios 
        for (int i = 0; i < 20; i++) {
            Proceso proceso = new Proceso();
            proceso.crearAleatorioBCP();
            proceso.validarProceso();            
            if(i<10){
                listaNuevos.add(proceso);
            }else{
               todosProcesos.add(proceso); 
            }
        }
        ordenarListas();
        Proceso.ultimoId=0;    
        imprimirColas();
        btnEjecutar.setEnabled(true);
    }//GEN-LAST:event_btnSimulacionActionPerformed

    private void ordenarListas(){
        listaNuevos.sort(Comparator.comparing(Proceso::getPrioridad));
        listaListos.sort(Comparator.comparing(Proceso::getPrioridad));
        listaImpresion.sort(Comparator.comparing(Proceso::getPrioridad));
        todosProcesos.sort(Comparator.comparing(Proceso::getPrioridad));
    }
    //BOTON PARA GUARDAR
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        exportar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        try {            
            //Limpiando listas
            limpiarListas();  //Este código solo debe ejecutarse una vez, para limpiar las listas antes de leer el archivo            
            obtenerProcesos("./procesos.txt");    
            
            while(!todosProcesos.isEmpty()) {  
                if((listaNuevos.size() + listaListos.size() + listaEjecutando.size() + listaBloqueados.size())>9){
                    break;
                }    
                Proceso proceso = todosProcesos.remove(0);
                //Verificando si el proceso es válido, si no es válido es desechado
                if(proceso.getValidez()){
                    //Verificando en qué estado se encuentra el proceso
                    switch(proceso.getEstado()){
                        //Añadiendo a nuevos
                        case 0:
                            listaNuevos.add(proceso);
                            break;
                            //Añadiendo a listos
                        case 1:
                            listaListos.add(proceso);
                            break;
                            //Añadiendo a Ejecutando
                        case 2:
                            listaEjecutando.add(proceso);
                            break;
                            //Añadiendo a Bloqueados
                        case 3:
                            listaBloqueados.add(proceso);
                            break;
                            //Añadiendo a terminados
                        case 4:
                            listaTerminados.add(proceso);
                            break;
                    }
                }
            }
            
            
        } catch (IOException ex) {        
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ordenarListas();
        imprimirColas();
        btnEjecutar.setEnabled(true);
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void btnSimulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimulacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimulacionMouseClicked

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        //Verificando si el usuario ingresó los ciclos
        if (!verificarCantCiclos()) {
            return;
        }
        //Comenzar ejecución
        if(listaListos.isEmpty() && listaNuevos.isEmpty() && listaEjecutando.isEmpty() && listaBloqueados.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Todos los procesos han terminado.");
            return;
        }
        ejecucion();
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void exportar() {//procedimiento para guardar en un archivo de texto
        try {
//            JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
//            archivo.showSaveDialog(this);
            String ruta = "./procesos.txt";
            File archivo = new File(ruta);
            if (archivo.exists()) {
                try (FileWriter guardado = new FileWriter(archivo)) {
                    guardado.write(txtcola4.getText() + txtcola1.getText() + txtcola2.getText() + txtcola3.getText() + txtcola0.getText() + procesosNoSimulados);//guarda todas las colas en el archivo de texto
                    JOptionPane.showMessageDialog(rootPane, "El archivo fue guardado con éxito");
                    guardado.close();
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
   
   //obtiene todos los procesos guardados en un archivo y lo guarda en una String
   private void obtenerProcesos(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      String acumulador = "";
      FileReader f = new FileReader(archivo);//abre un archivo para su lectura
      BufferedReader b = new BufferedReader(f); //lee el archivo
      //obtiene fila a fila el archivo y lo guarda en un string
      while((cadena = b.readLine())!=null) {
          acumulador += cadena;
      }
      b.close();
      crearProcesos(acumulador);
    }   
    //recibe una String con todos los procesos guardados en un archivo, lo formatea
   // y crea un objeto para cada proceso para poder rellenar las listas.
    public void crearProcesos(String cadena) {
        String[] procesos = cadena.split(";");//crea un array de string de procesos
        //para cada indixe indexa la cadena y crea el proceso objeto
        for(int i = 0; i <procesos.length; i++){
            String proceso = procesos[i];
            String[] partesProceso = proceso.split("/");//crea un array con cada parte de un proceso
            int id = Integer.parseInt(partesProceso[0]);
            int estado = Integer.parseInt(partesProceso[1]);
            int prioridad = Integer.parseInt(partesProceso[2]);
            int cantidadInstruc = Integer.parseInt(partesProceso[3]);
            int intrucBloqueo = Integer.parseInt(partesProceso[4]);
            int evento = Integer.parseInt(partesProceso[5]);
            
            Proceso procesoCreado = new Proceso();
            procesoCreado.crearBCP(id,estado, prioridad,cantidadInstruc,intrucBloqueo,evento);  
            procesoCreado.validarProceso();
            if(procesoCreado.getValidez()){
                todosProcesos.add(procesoCreado);  
            }            
        }
    }
    //guarda el orden de ejecucion de los procesos simulados
    private void guardarOrdenEjecucionProcesos(String traza){
       try {
            String ruta = "./ordenEjecucion.txt";//la ruta donde se guardara
            File archivo = new File(ruta);
           //guarda la info si existe el archivo,  esto sobreescribe el archivo
            if (archivo.exists()) {
                try (FileWriter guardado = new FileWriter(archivo)) {
                    guardado.write(traza);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
       //muestra el historial de ejecucion en pantalla
       txtHistorialEjecucion.setText(traza);
    }
    
    //si el campo cantidad de ciclos esta vacio muestra un mensaje de error al tratar de empezar la simulacion
    public boolean verificarCantCiclos() {
        try{
            if (Integer.parseInt(txtcantidad.getText()) > 0) {
                return true;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad de ciclos");
        }        
        return false;
    }

    public void ejecucion() {
        ordenarListas();
        Integer cantidadCiclos = Integer.parseInt(txtcantidad.getText()) + 1; //Aquí se debe almacenar la cantidad de ciclos que el usuario ingresa 
        
        //Comienzo de la estructura de iteración      
        for (int ciclos = 1; ciclos < cantidadCiclos; ciclos++) {   
            //Verificando si se están simulando menos de 10 procesos, en ese caso, se añaden más procesos
            while(!todosProcesos.isEmpty()){
                 if ((listaNuevos.size() + listaListos.size() + listaEjecutando.size() + listaBloqueados.size()) < 10) {
                    switch(todosProcesos.get(0).getEstado()){
                        //Añadiendo a nuevos
                        case 0:
                            listaNuevos.add(todosProcesos.remove(0));
                            break;
                            //Añadiendo a listos
                        case 1:
                            listaListos.add(todosProcesos.remove(0));
                            break;
                            //Añadiendo a Ejecutando
                        case 2:
                            listaEjecutando.add(todosProcesos.remove(0));
                            break;
                            //Añadiendo a Bloqueados
                        case 3:
                            listaBloqueados.add(todosProcesos.remove(0));
                            break;
                            //Añadiendo a terminados
                        case 4:
                            listaTerminados.add(todosProcesos.remove(0));
                            break;
                    }
                } else {
                    break;
                } 
            }
            
            ordenarListas();
            
            if(!listaNuevos.isEmpty()){
                listaNuevos.get(0).setEstado(1);
                listaListos.add(listaNuevos.remove(0));
            }
            
            //Verificando si hay procesos en la cola de listos. Si la cola ejecutando está vacía, encola un proceso listo para ejecutarse.
            if (!listaListos.isEmpty()) {
                if (listaEjecutando.isEmpty()) {
                    listaListos.get(0).setEstado(2);
                    listaEjecutando.add(listaListos.remove(0));
                }
            }

            //Ejecución de procesos
            if (!listaEjecutando.isEmpty()) {
                //Verificando si la cantidad de instrucciones ejecutadas es distinta a la cantidad de instrucciones del proceso
                if (listaEjecutando.get(0).getCantInstEjecutadas() != listaEjecutando.get(0).getCatidadInstruc()) {
                    listaEjecutando.get(0).AumCantInstEjecutadas();
                    traza = traza +  listaEjecutando.get(0).toString() + "\n";
                    listaEjecutando.get(0).aumentarCiclosEjecu();//Se lleva un conteo de cuántos ciclos seguidos se ha ejecutado el proceso.
                    //Verificando si NO se ha llegado a la instrucción de bloqueo
                    if (listaEjecutando.get(0).getIntrucBloqueo() != listaEjecutando.get(0).getCantInstEjecutadas()) {
                        
                        //Verificando si el proceso se ejecutó durante 3 segmentos seguidos 
                        if (listaEjecutando.get(0).getCiclosEjecutando() == 3) {
                            //Si se ha ejecutado el proceso durante 3 segmentos seguidos, se comprueba que su prioridad pueda ser degradada
                            if (listaEjecutando.get(0).getPrioridad() < 3) {
                                listaEjecutando.get(0).setPrioridad(listaEjecutando.get(0).getPrioridad() + 1);
                            }
                            //Se procede a mover el proceso a la cola de listos
                            listaEjecutando.get(0).setEstado(1);
                            listaEjecutando.get(0).limpiarCiclosEjecu();
                            listaListos.add(listaEjecutando.remove(0));
                        }
                        //Verificando el temporizador del procesador
                        else if((ciclos%5) == 0){
                           listaEjecutando.get(0).setEstado(1);
                           listaListos.add(listaEjecutando.remove(0)); 
                        }
                    } else {//Si la instrucción de bloqueo es igual a la cantidad de instrucciones ejecutadas, se procede a bloquear el proceso
                        listaEjecutando.get(0).setEstado(3);
                        listaEjecutando.get(0).limpiarCiclosEjecu();
                        listaBloqueados.add(listaEjecutando.remove(0));
                    }
                } else  {//Si la cantidad de instrucciones ejecutas es igual a la cantidad de instrucciones del proceso, este se da por terminado 
                    listaEjecutando.get(0).setEstado(4);
                    listaTerminados.add(listaEjecutando.remove(0));
                }
            }

            //Verifica que existan procesos bloqueados
            if (!listaBloqueados.isEmpty()) {
                //Copiar la cola de bloqueados en la cola de impresion para poder manipularla
                listaImpresion.addAll(listaBloqueados);
                //Vaciar la cola de bloqueados para poder insertar nuevamente los procesos modificados
                listaBloqueados.clear();
                //Mientras la cola de impresión tenga elementos se aumentará la cantidad de instrucciones ejecutadas de los procesos  
                while (!listaImpresion.isEmpty()) {
                    //Verifica si la cantidad de instrucciones ejecutadas es distinta la instruccion de bloqueo + la cantidad de instrucciones en la que debe permanecer bloqueado el proceso
                    if (listaImpresion.get(0).getCantInstEjecutadas() != (listaImpresion.get(0).getIntrucBloqueo() + listaImpresion.get(0).getCiclosBloqueo())) {
                        //Aumentar la cantidad de instrucciones ejecutadas y retornar el proceso a la cola de bloqueados
                        listaImpresion.get(0).AumCantInstEjecutadas();
                        listaBloqueados.add(listaImpresion.remove(0));
                    } else {//Si se han ejecutado las instrucciones del evento de bloque, se procede a encolar el proceso a Listos.
                        listaImpresion.get(0).setEstado(1);
                        listaListos.add(listaImpresion.remove(0));
                    }
                }
            }
          
        }
        ordenarListas();
        imprimirColas();
        guardarOrdenEjecucionProcesos(traza);
    }

    public void limpiarListas() {
        traza = "";
        //Limpiados los textBox de las lista
        txtcola0.setText("");
        txtcola1.setText("");
        txtcola2.setText("");
        txtcola3.setText("");
        txtcola4.setText("");
        txtHistorialEjecucion.setText("");        
        procesosNoSimulados = "";
        //Limpiando las lista
        todosProcesos.clear();
        listaImpresion.clear();
        listaNuevos.clear();
        listaListos.clear();
        listaEjecutando.clear();
        listaBloqueados.clear();
        listaTerminados.clear();
    }

    public void imprimirColas() {
        ordenarListas();
        txtcola0.setText("");
        txtcola1.setText("");
        txtcola2.setText("");
        txtcola3.setText("");
        txtcola4.setText("");
        procesosNoSimulados = "";
        //Imprimiendo la lista de nuevos
        listaImpresion.addAll(listaNuevos);
        while (!listaImpresion.isEmpty()) {
            Proceso proceso = listaImpresion.remove(0);//procesos nuevos
            //Imprime en el textBox correspondiente todos los procesos nuevos
            txtcola0.append(String.valueOf(proceso) + "\n");
        }
        //Imprimiendo la lista de listos
        listaImpresion.addAll(listaListos);
        while (!listaImpresion.isEmpty()) {
            Proceso proceso = listaImpresion.remove(0);
            //Imprime en el textBox correspondiente todos los procesos listos
            txtcola1.append(String.valueOf(proceso) + "\n");
        }

        //Imprimiendo la lista de ejecutando
        if(!listaEjecutando.isEmpty()){
            txtcola2.append(String.valueOf(listaEjecutando.get(0)));
        }       
        
        //Imprimiendo la lista de bloqueados
        listaImpresion.addAll(listaBloqueados);
        while (!listaImpresion.isEmpty()) {
            Proceso proceso = listaImpresion.remove(0);
            //Imprime en el textBox correspondiente todos los procesos bloqueados
            txtcola3.append(String.valueOf(proceso) + "\n");
        }

        //Imprimiendo la lista de terminados
        listaImpresion.addAll(listaTerminados);
        while (!listaImpresion.isEmpty()) {
            Proceso proceso = listaImpresion.remove(0);
            //Imprime en el textBox correspondiente todos los procesos terminados
            txtcola4.append(String.valueOf(proceso) + "\n");
        }
        
        //Imprimiendo la lista de terminados        
        listaImpresion.addAll(todosProcesos);
        while (!listaImpresion.isEmpty()) {
            procesosNoSimulados += listaImpresion.remove(0);
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSimulacion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JTextArea txtHistorialEjecucion;
    private javax.swing.JTextField txtcantidad;
    private static javax.swing.JTextArea txtcola0;
    private static javax.swing.JTextArea txtcola1;
    private static javax.swing.JTextArea txtcola2;
    private static javax.swing.JTextArea txtcola3;
    private static javax.swing.JTextArea txtcola4;
    // End of variables declaration//GEN-END:variables

}
