package simulador;
import java.util.PriorityQueue;

/**
 *@authores Lito Soler
 *          Kelly Aguilar
 *          María Ramírez
 *          Orlando Durán
 *          Mario Gómez
 */
public class main {
    //Colas de prioridad (5 TDA's) para los 5 estados del Modelo
    static PriorityQueue<Proceso> colaNuevos = new PriorityQueue<>();//Nuevos
    static PriorityQueue<Proceso> colaEjecutando= new PriorityQueue<>();//Ejecutando
    static PriorityQueue<Proceso> colaListos = new PriorityQueue<>();//Listos
    static PriorityQueue<Proceso> colaBloqueados = new PriorityQueue<>();//Bloqueados
    static PriorityQueue<Proceso> colaTerminados = new PriorityQueue<>();//Terminados
    static PriorityQueue<Proceso> colaImpresion = new PriorityQueue<>();//Cola utilizada para clonar otra de las colas principales y así evitar perder el contenido de estas.
    
    public static void main(String[] args) {
        
        long cantidadCiclos = 1000; //Aquí se debe almacenar la cantidad de ciclos que el usuario ingresa 
                         
        //Generando procesos nuevos aleatorios  SE DEBEN SUSTITURI POR LA LECTURA DESDE ARCHIVO
        System.out.println("-------------------PROCESOS A SIMULAR-----------------");
        for (int i = 0; i < 20; i++) {
            Proceso proceso = new Proceso(); 
            proceso.crearAleatorioBCP(); 
            proceso.validarProceso();
            colaNuevos.add(proceso);
             System.out.println(proceso+"      "+proceso.getMensaje());
        } 
        System.out.println("-------------------------------------------------------");
        
        
        //Verificando si hay nuevos procesos 
        if(colaNuevos.isEmpty()){
            System.out.println("No existen procesos nuevos");
            return;
        }
        
        //Cambiando a listos todos los 10 procesos de más alta prioridad correctamente validados
        for(int i =0;i<10;i++){
            if(colaNuevos.isEmpty()){ //Si no existen 10 procesos nuevos, solo toma los que existan
                break;
            }
            //Verifica si el proceso es válido
            if(colaNuevos.element().getValidez()){
                //Cambia el estado del proceso a listo
                colaNuevos.element().setEstado(1);
                //Mueve el proceso a la cola de listos
                colaListos.add(colaNuevos.remove());
            }else{
                //Si el proceso no es válido lo desecha de la cola.
                colaNuevos.remove();
            }            
        }
        
        
        //Comienzo de la estructura de iteración      
        for(int ciclos = 0; ciclos<cantidadCiclos; ciclos++){
            //En caso de haber procesos nuevos se verica la cantidad de procesos en las lista listos, bloqueados, ejecutando 
            //si la cant es menor de 10 se agrega un nuevo procesos a la lista de listos hasta que se alcancen los 10
            while(!colaNuevos.isEmpty()){
                if((colaListos.size()+colaEjecutando.size()+colaBloqueados.size())<10){
                    colaNuevos.element().setEstado(1);
                    colaListos.add(colaNuevos.remove());
                }else{
                    break;
                }
            }
            
            //Verificando si hay procesos en la cola de listos. Si la cola ejecutando está vacía, encola un proceso listo para ejecutarse.
            if(!colaListos.isEmpty()){
                if(colaEjecutando.isEmpty()){
                    colaListos.element().setEstado(2);
                    colaEjecutando.add(colaListos.remove());
                }
            }
            
            //Ejecución de procesos
            if(!colaEjecutando.isEmpty()){
                //Verificando si la cantidad de instrucciones ejecutadas es distinta a la cantidad de instrucciones del proceso
                if(colaEjecutando.element().getCantInstEjecutadas() != colaEjecutando.element().getCatidadInstruc()){
                    colaEjecutando.element().AumCantInstEjecutadas();
                    colaEjecutando.element().aumentarCiclosEjecu();//Se lleva un conteo de cuántos ciclos seguidos se ha ejecutado el proceso.
                    //Verificando si NO se ha llegado a la instrucción de bloqueo
                    if(colaEjecutando.element().getIntrucBloqueo() != colaEjecutando.element().getCantInstEjecutadas()){
                        //Verificando si el proceso se ejecutó durante 3 segmentos seguidos 
                        if(colaEjecutando.element().getCiclosEjecutando()==3){
                            //Si se ha ejecutado el proceso durante 3 segmentos seguidos, se comprueba que su prioridad pueda ser degradada
                            if(colaEjecutando.element().getPrioridad()<3){
                                colaEjecutando.element().setPrioridad(colaEjecutando.element().getPrioridad()+1);
                            }
                            //Se procede a mover el proceso a la cola de listos
                            colaEjecutando.element().setEstado(1);
                            colaEjecutando.element().limpiarCiclosEjecu();
                            colaListos.add(colaEjecutando.remove());
                        }
                    }else{//Si la instrucción de bloqueo es igual a la cantidad de instrucciones ejecutadas, se procede a bloquear el proceso
                        colaEjecutando.element().setEstado(3);
                        colaEjecutando.element().limpiarCiclosEjecu();
                        colaBloqueados.add(colaEjecutando.remove());
                    }
                }else{//Si la cantidad de instrucciones ejecutas es igual a la cantidad de instrucciones del proceso, este se da por terminado 
                    colaEjecutando.element().setEstado(4);
                    colaTerminados.add(colaEjecutando.remove());
                }
            }
            
            //Verifica que existan procesos bloqueados
            if(!colaBloqueados.isEmpty()){
                //Copiar la cola de bloqueados en la cola de impresion para poder manipularla
                colaImpresion.addAll(colaBloqueados);
                //Vaciar la cola de bloqueados para poder insertar nuevamente los procesos modificados
                colaBloqueados.clear();
                //Mientras la cola de impresión tenga elementos se aumentará la cantidad de instrucciones ejecutadas de los procesos  
                while(!colaImpresion.isEmpty()){
                    //Verifica si la cantidad de instrucciones ejecutadas es distinta la instruccion de bloqueo + la cantidad de instrucciones en la que debe permanecer bloqueado el proceso
                    if(colaImpresion.element().getCantInstEjecutadas() != (colaImpresion.element().getIntrucBloqueo()+colaImpresion.element().getCiclosBloqueo())){
                        //Aumentar la cantidad de instrucciones ejecutadas y retornar el proceso a la cola de bloqueados
                        colaImpresion.element().AumCantInstEjecutadas();
                        colaBloqueados.add(colaImpresion.remove());
                    }else{//Si se han ejecutado las instrucciones del evento de bloque, se procede a encolar el proceso a Listos.
                        colaImpresion.element().setEstado(1);
                        colaListos.add(colaImpresion.remove());
                    }
                    
                }
            } 
        }
        //Imprimir en consola el estado final de las colas
        imprimirColas();
        
    } 
    public static void imprimirColas(){
        //Imprimiendo la cola de nuevos
        System.out.println("");
        System.out.println("PROCESOS NUEVOS");
        colaImpresion.addAll(colaNuevos);        
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
        }
        
        //Imprimiendo la cola de listos
        System.out.println("");
        System.out.println("PROCESOS LISTOS");
        colaImpresion.addAll(colaListos);        
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
        }
        
        //Imprimiendo la cola de ejecutando
        System.out.println("");
        System.out.println("PROCESOS EJECUTANDO");
        colaImpresion.addAll(colaEjecutando);        
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
        }
        
        //Imprimiendo la cola de bloqueados
        System.out.println("");
        System.out.println("PROCESOS BLOQUEADOS");
        colaImpresion.addAll(colaBloqueados);        
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
        }
        
        //Imprimiendo la cola de terminados
        System.out.println("");
        System.out.println("PROCESOS TERMINADOS");
        colaImpresion.addAll(colaTerminados);        
        while (!colaImpresion.isEmpty()) {
            Proceso proceso = colaImpresion.remove();
            System.out.println(proceso);
        }
        
        
    }
}
