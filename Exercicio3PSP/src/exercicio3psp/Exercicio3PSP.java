
package exercicio3psp;

public class Exercicio3PSP extends Thread{
    public Exercicio3PSP(String str){
        super(str);
    }
    
    @Override
    public void run(){
        for (int i = 0; i<8; i++){
            System.out.println("Iteracción: " + i + " do Fio" + this.getName());
            
        }
    }
    
    public static void main(String[] args) {
        Thread fio1 = new Thread(new Exercicio3PSP("1") );
        
        fio1.start();

        System.out.println("O programa Principal rematou");
    }
    
}
