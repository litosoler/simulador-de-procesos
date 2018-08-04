/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lito Soler Kelly Aguilar María Ramírez Orlando Durán Mario Gómez
 */
public class Formulario extends javax.swing.JFrame {

    //Colas de prioridad (5 TDA's) para los 5 estados del Modelo
    static PriorityQueue<Proceso> colaNuevos = new PriorityQueue<>();//Nuevos
    static PriorityQueue<Proceso> colaEjecutando = new PriorityQueue<>();//Ejecutando
    static PriorityQueue<Proceso> colaListos = new PriorityQueue<>();//Listos
    static PriorityQueue<Proceso> colaBloqueados = new PriorityQueue<>();//Bloqueados
    static PriorityQueue<Proceso> colaTerminados = new PriorityQueue<>();//Terminados
    static PriorityQueue<Proceso> colaImpresion = new PriorityQueue<>();//Cola utilizada para clonar otra de las colas principales y así evitar perder el contenido de estas.

    /**
     * Creates new form Formulario
     */
    public Formulario() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCantidad = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
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
        btnnueva = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCantidad.setText("Cantidad de Ciclos:");

        txtcola0.setColumns(20);
        txtcola0.setRows(5);
        jScrollPane1.setViewportView(txtcola0);

        txtcola1.setColumns(20);
        txtcola1.setRows(5);
        jScrollPane2.setViewportView(txtcola1);

        txtcola2.setColumns(20);
        txtcola2.setRows(5);
        jScrollPane3.setViewportView(txtcola2);

        txtcola3.setColumns(20);
        txtcola3.setRows(5);
        jScrollPane4.setViewportView(txtcola3);

        txtcola4.setColumns(20);
        txtcola4.setRows(5);
        jScrollPane5.setViewportView(txtcola4);

        btnSimulacion.setText("Simulacion Aleatoria");
        btnSimulacion.setName("btnSimulacionAlea"); // NOI18N
        btnSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimulacionActionPerformed(evt);
            }
        });

        btnnueva.setText("Cargar Simulacion  ");
        btnnueva.setName("btnCargarSimulacion"); // NOI18N
        btnnueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevaActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar Simulacion");
        btnGuardar.setName("btnGuardarSimulacion"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("NUEVOS PROCESOS");

        jLabel2.setText("PROCESOS LISTOS");

        jLabel3.setText("PROCESOS EJECUTANDO");

        jLabel4.setText("PROCESOS BLOQUEADOS");

        jLabel5.setText("PROCESOS FINALIZADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnnueva, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCantidad)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel1)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(btnSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulacionActionPerformed
       //Verificando si el usuario ingresó los ciclos
        if (!verificarCantCiclos()) {
            return;
        }
        //Limpiando colas
        limpiarColas();
        //Generando procesos nuevos aleatorios 
        System.out.println("-------------------PROCESOS A SIMULAR-----------------");
        for (int i = 0; i < 20; i++) {
            Proceso proceso = new Proceso();
            proceso.crearAleatorioBCP();
            proceso.validarProceso();
            colaNuevos.add(proceso);
            System.out.println(proceso + "      " + proceso.getMensaje());
        }
        Proceso.ultimoId=0;
        System.out.println("-------------------------------------------------------");        
        ejecucion();
    }//GEN-LAST:event_btnSimulacionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        exportar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnnuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevaActionPerformed
        //Verificando si el usuario ingresó los ciclos
        if (!verificarCantCiclos()) {
            return;
        }
        //Limpiando colas
        limpiarColas();  //Este código solo debe ejecutarse una vez, para limpiar las colas antes de leer el archivo
        
        
        //Variables para crear el BCP
        int id=0;
        int estadoProceso=0;
        int prioridad=0;
        int canInst=0;
        int instBloqueo=0;
        int evento=0;        
        //Creando proceso a partir de los valores leídos desde el archivo
        Proceso proceso = new Proceso();
        proceso.crearBCP(id,estadoProceso, prioridad,canInst,instBloqueo,evento);  
        proceso.validarProceso();
        System.out.println(proceso.getMensaje());
        //Verificando si el proceso es válido, si no es válido es desechado
        if(proceso.getValidez()){
            //Verificando en qué estado se encuentra el proceso
            switch(estadoProceso){
                //Añadiendo a nuevos
                case 0:
                    colaNuevos.add(proceso);
                    break;  
                //Añadiendo a listos
                case 1:
                    colaListos.add(proceso);
                    break;
                //Añadiendo a Ejecutando
                case 2:
                    colaEjecutando.add(proceso);
                    break;   
                //Añadiendo a Bloqueados
                case 3:
                    colaBloqueados.add(proceso);
                    break;
                //Añadiendo a terminados
                case 4:
                    colaTerminados.add(proceso);
                    break;
            }
        }        
        
    }//GEN-LAST:event_btnnuevaActionPerformed

    private void exportar() {//procedimiento para guardar en un archivo de texto
        try {
            JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
            archivo.showSaveDialog(this);
            if (archivo.getSelectedFile() != null) {
                try (FileWriter guardado = new FileWriter(archivo.getSelectedFile())) {
                    guardado.write(txtcola0.getText() + txtcola1.getText() + txtcola2.getText() + txtcola3.getText() + txtcola4.getText());//guarda todas las colas en el archivo de texto
                    JOptionPane.showMessageDialog(rootPane, "El archivo fue guardado con éxito en la ruta establecida");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public boolean verificarCantCiclos() {
        try{
            if (Integer.parseInt(txtcantidad.getText()) > 0) {
                return true;
            }
        }catch(NumberFormatException e){
            
        }        
        return false;
    }

    public void ejecucion() {
        Integer cantidadCiclos = Integer.parseInt(txtcantidad.getText()); //Aquí se debe almacenar la cantidad de ciclos que el usuario ingresa 

        //Verificando si hay nuevos procesos 
        if (colaNuevos.isEmpty()) {
            System.out.println("No existen procesos nuevos");
            return;
        }

        //Comienzo de la estructura de iteración      
        for (int ciclos = 0; ciclos < cantidadCiclos; ciclos++) {

            //Cambiando a listos todos los 10 procesos de más alta prioridad correctamente validados
            for (int i = 0; i < 10; i++) {
                if (colaNuevos.isEmpty()) { //Si no existen 10 procesos nuevos, solo toma los que existan
                    break;
                }
                //Verifica si el proceso es válido
                if (colaNuevos.element().getValidez()) {
                    //Cambia el estado del proceso a listo
                    colaNuevos.element().setEstado(1);
                    //Mueve el proceso a la cola de listos
                    colaListos.add(colaNuevos.remove());
                } else {
                    //Si el proceso no es válido lo desecha de la cola.
                    colaNuevos.remove();
                }
            }
            //En caso de haber procesos nuevos se verica la cantidad de procesos en las lista listos, bloqueados, ejecutando 
            //si la cant es menor de 10 se agrega un nuevo procesos a la lista de listos hasta que se alcancen los 10
            while (!colaNuevos.isEmpty()) {
                if ((colaListos.size() + colaEjecutando.size() + colaBloqueados.size()) < 10) {
                    colaNuevos.element().setEstado(1);
                    colaListos.add(colaNuevos.remove());
                } else {
                    break;
                }
            }

            //Verificando si hay procesos en la cola de listos. Si la cola ejecutando está vacía, encola un proceso listo para ejecutarse.
            if (!colaListos.isEmpty()) {
                if (colaEjecutando.isEmpty()) {
                    colaListos.element().setEstado(2);
                    colaEjecutando.add(colaListos.remove());
                }
            }

            //Ejecución de procesos
            if (!colaEjecutando.isEmpty()) {
                //Verificando si la cantidad de instrucciones ejecutadas es distinta a la cantidad de instrucciones del proceso
                if (colaEjecutando.element().getCantInstEjecutadas() != colaEjecutando.element().getCatidadInstruc()) {
                    colaEjecutando.element().AumCantInstEjecutadas();
                    colaEjecutando.element().aumentarCiclosEjecu();//Se lleva un conteo de cuántos ciclos seguidos se ha ejecutado el proceso.
                    //Verificando si NO se ha llegado a la instrucción de bloqueo
                    if (colaEjecutando.element().getIntrucBloqueo() != colaEjecutando.element().getCantInstEjecutadas()) {
                        //Verificando si el proceso se ejecutó durante 3 segmentos seguidos 
                        if (colaEjecutando.element().getCiclosEjecutando() == 3) {
                            //Si se ha ejecutado el proceso durante 3 segmentos seguidos, se comprueba que su prioridad pueda ser degradada
                            if (colaEjecutando.element().getPrioridad() < 3) {
                                colaEjecutando.element().setPrioridad(colaEjecutando.element().getPrioridad() + 1);
                            }
                            //Se procede a mover el proceso a la cola de listos
                            colaEjecutando.element().setEstado(1);
                            colaEjecutando.element().limpiarCiclosEjecu();
                            colaListos.add(colaEjecutando.remove());
                        }
                    } else {//Si la instrucción de bloqueo es igual a la cantidad de instrucciones ejecutadas, se procede a bloquear el proceso
                        colaEjecutando.element().setEstado(3);
                        colaEjecutando.element().limpiarCiclosEjecu();
                        colaBloqueados.add(colaEjecutando.remove());
                    }
                } else {//Si la cantidad de instrucciones ejecutas es igual a la cantidad de instrucciones del proceso, este se da por terminado 
                    colaEjecutando.element().setEstado(4);
                    colaTerminados.add(colaEjecutando.remove());
                }
            }

            //Verifica que existan procesos bloqueados
            if (!colaBloqueados.isEmpty()) {
                //Copiar la cola de bloqueados en la cola de impresion para poder manipularla
                colaImpresion.addAll(colaBloqueados);
                //Vaciar la cola de bloqueados para poder insertar nuevamente los procesos modificados
                colaBloqueados.clear();
                //Mientras la cola de impresión tenga elementos se aumentará la cantidad de instrucciones ejecutadas de los procesos  
                while (!colaImpresion.isEmpty()) {
                    //Verifica si la cantidad de instrucciones ejecutadas es distinta la instruccion de bloqueo + la cantidad de instrucciones en la que debe permanecer bloqueado el proceso
                    if (colaImpresion.element().getCantInstEjecutadas() != (colaImpresion.element().getIntrucBloqueo() + colaImpresion.element().getCiclosBloqueo())) {
                        //Aumentar la cantidad de instrucciones ejecutadas y retornar el proceso a la cola de bloqueados
                        colaImpresion.element().AumCantInstEjecutadas();
                        colaBloqueados.add(colaImpresion.remove());
                    } else {//Si se han ejecutado las instrucciones del evento de bloque, se procede a encolar el proceso a Listos.
                        colaImpresion.element().setEstado(1);
                        colaListos.add(colaImpresion.remove());
                    }
                }
            }
        }
        imprimirColas();
    }

    public void limpiarColas() {
        //Limpiados los textBox de las colas
        txtcola0.setText("");
        txtcola1.setText("");
        txtcola2.setText("");
        txtcola3.setText("");
        txtcola4.setText("");
        //Limpiando las colas
        colaImpresion.clear();
        colaNuevos.clear();
        colaListos.clear();
        colaEjecutando.clear();
        colaBloqueados.clear();
        colaTerminados.clear();
    }

    public void imprimirColas() {
        //Imprimiendo la cola de nuevos
        System.out.println("");
        System.out.println("PROCESOS NUEVOS");
        colaImpresion.addAll(colaNuevos);
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();//procesos nuevos
            System.out.println(proceso);
            //Imprime en el textBox correspondiente todos los procesos nuevos
            txtcola0.append(String.valueOf(proceso) + "\n");
        }

        //Imprimiendo la cola de listos
        System.out.println("");
        System.out.println("PROCESOS LISTOS");
        colaImpresion.addAll(colaListos);
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
            //Imprime en el textBox correspondiente todos los procesos listos
            txtcola1.append(String.valueOf(proceso) + "\n");
        }

        //Imprimiendo la cola de ejecutando
        System.out.println("");
        System.out.println("PROCESOS EJECUTANDO");
        colaImpresion.addAll(colaEjecutando);
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
            //Imprime en el textBox correspondiente todos los procesos ejecutando
            txtcola2.append(String.valueOf(proceso) + "\n");
        }

        //Imprimiendo la cola de bloqueados
        System.out.println("");
        System.out.println("PROCESOS BLOQUEADOS");
        colaImpresion.addAll(colaBloqueados);
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
            //Imprime en el textBox correspondiente todos los procesos bloqueados
            txtcola3.append(String.valueOf(proceso) + "\n");
        }

        //Imprimiendo la cola de terminados
        System.out.println("");
        System.out.println("PROCESOS TERMINADOS");
        colaImpresion.addAll(colaTerminados);
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
            //Imprime en el textBox correspondiente todos los procesos terminados
            txtcola4.append(String.valueOf(proceso) + "\n");
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSimulacion;
    private javax.swing.JButton btnnueva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JTextField txtcantidad;
    private static javax.swing.JTextArea txtcola0;
    private static javax.swing.JTextArea txtcola1;
    private static javax.swing.JTextArea txtcola2;
    private static javax.swing.JTextArea txtcola3;
    private static javax.swing.JTextArea txtcola4;
    // End of variables declaration//GEN-END:variables

}
