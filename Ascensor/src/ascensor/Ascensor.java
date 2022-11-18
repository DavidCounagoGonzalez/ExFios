
package ascensor;

import java.util.ArrayList;


public class Ascensor extends Thread {
    private static int pActual;
    private static ArrayList<Integer> destino;
    private static boolean ocupado;
    private static int  peso;
    public Ascensor(String str){
        super(str);
    }
    public void run(){
        
    }
    
    public static void main(String[] args) {
        Thread vacio = new Thread(new Ascensor("vacio"));
        vacio.start();
        
        Thread nonVacio = new Thread(new Ascensor("nonVacio"));
        nonVacio.start();
    }
    
    public void uso(){
        destino.add(1);
        if (destino.size()!=0){
            ocupado=true;
            while(ocupado=true){
                pActual=destino.get(1);
            }
        }
    }
    
}
