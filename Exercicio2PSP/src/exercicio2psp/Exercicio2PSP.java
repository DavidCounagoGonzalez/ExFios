
package exercicio2psp;

public class Exercicio2PSP extends Thread{
    public Exercicio2PSP(String str){
        super(str);
    }
    
    @Override
    public void run(){
        for (int i = 0; i<8; i++){
            System.out.println("Iteracción: " + i + " do Fio" + this.getName());
            
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread fio1 = new Thread(new Exercicio2PSP("1") );
        Thread fio2 = new Thread(new Exercicio2PSP("2") );
        Thread fio3 = new Thread(new Exercicio2PSP("3") );
        
        fio3.start();
        fio3.join();
        fio2.start();
        fio2.join();
        fio1.start();
        fio1.join();
        System.out.println("O programa Principal rematou");
    }
    
}
