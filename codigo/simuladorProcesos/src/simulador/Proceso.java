/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.Random;

/**
 *
 * @author litosoler
 */
public class Proceso {
    private String id;
    private int estado;
    private int prioridad;
    private int catidadInstruc;
    private int intrucBloqueo;
    private int tipoEvento;
    private int PC; //ultimaIntruccionEjecutada: Program Counter(PC);
    static int ultimoId = 0;
    static Random aleatorio = new Random();

    public Proceso() {
        id = crearId(ultimoId++);
        estado = 0;
        prioridad = random(1,3);
        catidadInstruc = random(1,999);
        intrucBloqueo = random(1, catidadInstruc - 1 );
        PC = 0;
        tipoEvento = crearTipoEvento();
    }
    private String crearId(int id){
       return String.format("%04d", id);
    }
    private int crearTipoEvento(){
        int evento = 4;
        while(evento == 4){
            evento = random(3,5);
        }
        return evento;
    }
    private int random(int min, int max){      
        return aleatorio.nextInt(max - min + 1) + min;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCatidadInstruc() {
        return catidadInstruc;
    }
    
    public int getIntrucBloqueo() {
        return intrucBloqueo;
    }

    public int getTipoEvento() {
        return tipoEvento;
    }

    public int getPC() {
        return PC;
    }

    public void incrementarPC() {
        this.PC++;
    }
    

//    @Override
//    public String toString() {
//        return "Proceso{" + "id=" + id + "/estado=" + estado + "/prioridad=" + prioridad + "/catidadInstruc=" + catidadInstruc + "/intrucBloqueo=" + intrucBloqueo + "/tipoEvento=" + tipoEvento + '}';
//    }
    @Override
    public String toString() {
        return id + "/" + estado + "/" + prioridad + "/" + catidadInstruc + "/" + intrucBloqueo + "/" + tipoEvento;
    }
    
    
}
