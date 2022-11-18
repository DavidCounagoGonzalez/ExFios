
package probafios;

import java.util.Random;

public class ProbaFios extends Thread {    
    public ProbaFios(String str){
        super(str);
    }
    public void run(){
        for ( int i = 0; i < 10; i++)
            System.out.println(i+ " " + getName());
        try{
            Thread.sleep(2000);
            }
        catch(InterruptedException e){
                
            }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) {
        new ProbaFios("Pepe").start();
        new ProbaFios("Juan").start();
        System.out.println("Termina thread main");
    }
    
}
