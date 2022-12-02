
package exercicio1psp;

import java.util.Random;


public class Exercicio1PSP extends Thread{
    private static long tempo=100;
    public Exercicio1PSP(String str){
        super(str);
    }
    
    @Override
    public void run(){
        for (int i = 0; i<8; i++){
            tempoRand();
            System.out.println("Iteracción: " + i + " do Fio" + this.getName());
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void main(String[] args) {
        Thread fio1 = new Thread(new Exercicio1PSP("1") );
        Thread fio2 = new Thread(new Exercicio1PSP("2") );
        Thread fio3 = new Thread(new Exercicio1PSP("3") );
        
        fio1.start();
        fio2.start();
        fio3.start();
        System.out.println("O programa Principal rematou");
    }
    
    public void tempoRand(){
        Random rad;
        
        
    }
    
}
