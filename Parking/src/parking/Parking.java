
package parking;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parking extends Thread{
    private static boolean dentro;
    private static final int plazas[] = {0,0,0,0,0,0};
    private static int libres;
    private static long tiempo;
    public Parking(String str){
        super(str);
    }
    
    public void run(){
        RandomTime();

        if(dentro){
            Salida();
            dentro = false;
        }
        else{
            Entrada();
            dentro=true;
        }
    }
    

    public static void main(String[] args) {
        for (int i = 0; i<5; i++){
        Thread coche1 = new Thread(new Parking("1"));
        Thread coche2 = new Thread(new Parking("2"));
        Thread coche3 = new Thread(new Parking("3"));
        Thread coche4 = new Thread(new Parking("4"));
        Thread coche5 = new Thread(new Parking("5"));
        
        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();
        }
    }
    
    public void plazaLibre(){
        libres = 0;
        for (int i = 0; i<plazas.length; i++){
            if (plazas[i]==0){
                libres++;
            }      
        }
    }
    
    public void RandomTime(){
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    
    public synchronized void Entrada(){
        plazaLibre();
        while(libres==0){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            dentro=true;
            for(int p = 0; p<plazas.length; p++){
                if(plazas[p]==0){
                    plazas[p]=Integer.parseInt(this.getName());
                    plazaLibre();
                    System.out.println("Coche" + this.getName() + " aparca en la plaza " + p);
                    System.out.println("Prazas libres: " + libres);
                    System.out.println("Parking: " + Arrays.toString(plazas) + "\n");
                    break;
                }
            }
    }
    
    public synchronized void Salida(){
        plazaLibre();
        int auxPlaza = Integer.parseInt(this.getName());
            for (int l = 0; l<plazas.length; l++){
                if(plazas[l]==auxPlaza){
                    plazas[l]=0;
                    plazaLibre();
                    System.out.println("Coche"+this.getName() + " saliendo.");
                    System.out.println("Prazas libres: " + libres);
                    System.out.println("Parking: " + Arrays.toString(plazas) + "\n");
                    dentro=false;
                    notify();
                }
            }
    }
    
}
