
package probafios2;


public class ProbaFios2 extends Thread {
    public ProbaFios2(String str){
        super(str);
        }
    
    public void run(){
        for ( int i = 0; i < 5; i++){
            System.out.println(i+ " " + getName());
            /*try {          
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               
            }*/
        }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread pepe = new Thread(new ProbaFios2("Pepe"));
        pepe.setPriority(MAX_PRIORITY);
        Thread juan = new Thread(new ProbaFios2("Juan"));
        juan.setPriority(8);
        Thread anxo = new Thread(new ProbaFios2("Anxo"));
        anxo.setPriority(4);
        Thread maria = new Thread(new ProbaFios2("Maria"));
        maria.setPriority(MIN_PRIORITY);
        pepe.start();
        
        juan.start();
                
        anxo.start();
                
        maria.start();
        
        System.out.println("Termina thread main");
    }
    
}
