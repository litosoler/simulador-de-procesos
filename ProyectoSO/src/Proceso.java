
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *@authores Lito Soler
 *          Kelly Aguilar
 *          María Ramírez
 *          Orlando Durán
 *          Mario Gómez
 */
public class Proceso implements Comparable<Proceso>{//Implementa Comparable para poder sobreescribir el método compareTo() y usarlo en las colas de prioridad
    private int id = 0;//Id de proceso
    private int estado = 0;//El estado del proceso 0-Nuevo  1-Listo 2-Ejecutando 3-Bloqueado 4-Terminado
    private int prioridad = 0; //
    private int catidadInstruc = 0;
    private int intrucBloqueo = 0;
    private int tipoEvento = 0;
    private int cantInstEjecutadas = 0; //Cantidad de instrucciones ejecutadas
    private int ciclosBloqueo = 0; //Cantidad de ciclos que debe estar bloqueado el proceso
    private String mensaje; //Mensaje de validación de procesos.
    private boolean validez = true; //Booleano para catalogar un proceso como válido o no
    private int ciclosEjecutando=0; //Cantidad de ciclos consecutivos que se ejecuta un proceso
    static int ultimoId = 0; //Utilizado en la generación random de procesos, para evitar repitencia de Id de procesos
    static Random aleatorio = new Random();//Random para generar los procesos aleatorios
    static List<Integer> idProcesos = new ArrayList<Integer>();//En esta lista se almacenan todos los id's de los procesos que se van creando
    
    public Proceso() {} //Constructor
    
    //Iniciar el bloque de control de proceso con los valores recibidos desde la lectura del archivo
    public void crearBCP(int id, int estado, int prioridad, int catidadInstruc, int intrucBloqueo, int tipoEvento){
        this.id = id;
        this.estado = estado;
        this.prioridad = prioridad;
        this.catidadInstruc = catidadInstruc;
        this.intrucBloqueo = intrucBloqueo;
        this.tipoEvento = tipoEvento;
        switch(tipoEvento){//Dependiendo del tipo de instruccion de bloqueo, asigna el número de los ciclos que estará bloqueado el proceso 
            case 3:
                this.ciclosBloqueo = 13;
                break;
            case 5:
                this.ciclosBloqueo = 27;
                break;
        }         
    }
    
    //Verificacion de procesos, validando los atributos que conforman el proceso
    public boolean validarProceso(){  
        if(id<0 || id>9999){
            mensaje = "Proceso no válido: El id es incorrecto";
            validez = false;
        }else if(idProcesos.contains(id)){
            mensaje = "Proceso no válido: El id ya existe";
            validez = false;
        }else if(estado<0 || estado>4){
            mensaje = "Proceso no válido: Estado de proceso no reconocido.";
            validez = false;
        }else if(prioridad<1 || prioridad>3){
            mensaje = "Proceso no válido:Valor de prioridad incorrecto";
            validez = false;
        }else if(catidadInstruc<13 || catidadInstruc>999){ //13 es el menor valor porque el evento E/S produce un bloqueo de 13 ciclos
            mensaje = "Proceso no válido: Número de instrucciones fuera de rango";
            validez = false;
        }else if(tipoEvento!=3 && tipoEvento!=5){
            mensaje = "Proceso no válido: Tipo de evento desconocido";
            validez = false;
        }else if(intrucBloqueo<1 || intrucBloqueo>(catidadInstruc-ciclosBloqueo)){
            mensaje = "Proceso no válido: La instrucción de bloqueo está fuera del rango válido de instrucciones del proceso";
            validez = false;
        }  
        mensaje = "Proceso válido.";
        idProcesos.add(id);//Si el proceso es válido y el ID no existía con anterioridad, lo agrega a la lista del idProcesos
        validez = true;
        return validez;
    }
    
    //Generar tipo de evento de bloqueo. 3-E/S  5-Disco duro
    private int crearTipoEvento(){
        int evento = 4;
        while(evento == 4){
            evento = random(3,5);
        }
        return evento;
    }
    
    //Generar random entre 2 valores
    private int random(int min, int max){      
        return aleatorio.nextInt(max - min + 1) + min;
    }
    
    //Obtener el estado del proceso
    public int getEstado() {
        return estado;
    }
    
    //Establecer el estado del proceso
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //Obtener el número de segmentos que el proceso se ha ejecutado consecutivamente
    public int getCiclosEjecutando() {
        return ciclosEjecutando;
    }
    
    //Aumentar la cantidad de segmentos de ejecución consecutivos
    public void aumentarCiclosEjecu() {
        this.ciclosEjecutando++;
    }
    
    //Reiniciar la cantidad de segmentos de ejecución consecutivos
    public void limpiarCiclosEjecu() {
        this.ciclosEjecutando = 0;
    }
    
    //Obtener la cantidad de ciclos que debe estar bloqueado el proceso al llegar a la instrucción de bloqueo
    public int getCiclosBloqueo() {
        return ciclosBloqueo;
    }
    
    //Establecer la cantidad de ciclos que debe estar bloqueado el proceso al llegar a la instrucción de bloqueo
    public void setCiclosBloqueo(int ciclosBloqueo) {
        this.ciclosBloqueo = ciclosBloqueo;
    }
    
    //Obtener un booleano sobre la validez del proceso. True-Poceso Correcto    False-Proceso incorrecto
    public boolean getValidez() {
        return validez;
    }
    
    //Establecer la validez del proceso
    public void setValidez(boolean validez) {
        this.validez = validez;
    }
    
    //Obener el id del proceso
    public int getID() {
        return id;
    }
    
    //Establecer el id del prceso
    public void setID(int id) {
        this.id = id;
    }
    
    //Obtener la prioridad del proceso
    public int getPrioridad() {
        return prioridad;
    }
    
    //Establecer la prioridad del proceso
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    //Obtener la cantidad de instrucciones que debe ejecutar el proceso
    public int getCatidadInstruc() {
        return catidadInstruc;
    }
    
    //Obtener el número de  instrucción en la que se debe de bloquear el proceso.
    public int getIntrucBloqueo() {
        return intrucBloqueo;
    }
    
    //Obtener el tipo de evento de bloqueo del proceso
    public int getTipoEvento() {
        return tipoEvento;
    }
    
    //Obtener la cantidad de instrucciones del proceso que han sido ejecutadas 
    public int getCantInstEjecutadas() {
        return cantInstEjecutadas;
    }
    
    //Obtener el mensaje de validez del proceso
    public String getMensaje() {
        return mensaje;
    }
    
    //Establecer el mensaje de validez del proceso
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //Aumentar en 1 la cantidad de instrucciones del proceso que han sido ejecutadas
    public void AumCantInstEjecutadas() {
        this.cantInstEjecutadas++;
    }
    
    //Se genera un bloque de control de proceso válido aleatorio
    public void crearAleatorioBCP(){ //Iniciar el bloque de control de proceso con valores aleatorios pero congruentes. 
        id = ultimoId++;
        estado = 0;
        prioridad = random(1,3);
        tipoEvento = crearTipoEvento();  
        switch(tipoEvento){
            case 3:
                this.ciclosBloqueo = 13;
                break;
            case 5:
                this.ciclosBloqueo = 27;
                break;
        } 
        catidadInstruc = random(ciclosBloqueo,999);
        intrucBloqueo = random(1, catidadInstruc - ciclosBloqueo);      
        cantInstEjecutadas = 0;    
    }  
    
    //Sobreescribe la funcion toString con el formato de impresión de proceso solicitado
    @Override
    public String toString() {        
        return String.format("%04d", id) + "/" + estado + "/" + prioridad + "/" + String.format("%03d", catidadInstruc)+ "/" + String.format("%03d", intrucBloqueo) + "/" + tipoEvento + ";";
    } 
    
     //Método para sobre-escribir la función compare() de la librería Comparator y que ordene por prioridad en las colas
    @Override
    public int compareTo(Proceso proceso) {
        if(this.getPrioridad()> proceso.getPrioridad()) {
            return 1;
        } else if (this.getPrioridad() < proceso.getPrioridad()) {
            return -1;
        } else {
            return 0;
        }
    }
    
}