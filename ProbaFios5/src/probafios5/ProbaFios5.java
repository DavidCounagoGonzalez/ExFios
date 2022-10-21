
package probafios5;

public class ProbaFios5 extends Thread{
    public ProbaFios5(String str){
        super(str);
    }
    
    public void run(){
        for(int i =0 ; i<5 ; i++)
        System.out.println("Ola, son o fio " + this.getName());
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread fio1 = new Thread ( new ProbaFios5("Numero 1"));
        //fio1.setPriority(1);
        Thread fio2 = new Thread ( new ProbaFios5("Numero 2"));
        //fio2.setPriority(10);
        
        fio2.start();
       
        fio2.join();
      
        fio1.start();
        
    }
    
}
