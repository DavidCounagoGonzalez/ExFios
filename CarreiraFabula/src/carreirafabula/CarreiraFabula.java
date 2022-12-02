
package carreirafabula;

import java.util.Random;

public class CarreiraFabula extends Thread{
    private static int casillasT = 1;
    private static int casillasL = 1;
    public CarreiraFabula(String str){
        super(str);
    }
    
    public void run(){
        while(casillasT<70 && casillasL<70){
            if("Tartaruga".equals(this.getName())){
                try {
                    sucesosT();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            else if ( "Lebre".equals(this.getName())){
                try {
                    sucesosL();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
        
    }

    public static void main(String[] args) {
        Thread tartaruga = new Thread ( new CarreiraFabula("Tartaruga"));
        
        Thread lebre = new Thread ( new CarreiraFabula("Lebre"));
        
        lebre.start();
        tartaruga.start();
    }
    
    public void sucesosT () throws InterruptedException{
        int suceso=0;
        Random rd = new Random();
            suceso = rd.nextInt(100);
            if(suceso<=50){
                casillasT=casillasT+3;
            }
            else if(50<suceso && suceso<=70){
                casillasT=casillasT-6;
            }
            else if(70<suceso && suceso<=100){
                casillasT=casillasT+1;
            }
            if (casillasT<1){
                casillasT=1;
            }
            Thread.sleep(500);
            if(casillasT>=70){
                casillasT=70;
                System.out.println("A Tartaruga está na casilla: " + casillasT); 
                System.out.println("Gaña a Tartaruga");
            }
            else
                System.out.println("A Tartaruga está na casilla: " + casillasT);  
            
        
    }
    
    public void sucesosL() throws InterruptedException{
        int sucesoL=0;
        Random rdL = new Random();
            sucesoL = rdL.nextInt(100);
            if(sucesoL<=20){
            }
            else if (20<sucesoL && sucesoL<=40){
                casillasL=casillasL+9;
            }
            else if (40<sucesoL && sucesoL<=50){
                casillasL=casillasL-12;
            }
            else if (50<sucesoL && sucesoL<=80){
                casillasL=casillasL+1;
            }
            else if (80<sucesoL && sucesoL<=100){
                casillasL=casillasL-2;
            }
            if(casillasL<1){
                casillasL=1;
            }
            Thread.sleep(500);
            if (casillasL>=70){
                casillasL=70;
                System.out.println("A Lebre está na casilla: " + casillasL);
                System.out.println("Gaña a Lebre");
            }
            else
            System.out.println("A Lebre está na casilla: " + casillasL);
                    
    }
}
