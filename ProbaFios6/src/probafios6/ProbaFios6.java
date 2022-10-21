
package probafios6;


public class ProbaFios6 extends Thread{
    private static int cap;
    private boolean dentro= false;
    public ProbaFios6(String str){
        super(str);
    }
    public void run(){
        if(this.getName()=="suma"){
            try {
                Suma();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        else{
            try {
                Resta();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    
        System.out.println(cap);
    }

    public static void main(String[] args){
        for(int c =0;c<10;c++){
        Thread compra = new Thread(new ProbaFios6("suma"));
        
        compra.start();
        }
        for(int p=0;p<5;p++){
        Thread pago = new Thread(new ProbaFios6("resta"));
        
        pago.start();
        }
  
    }
    
    public synchronized void Suma() throws InterruptedException{
        while(dentro){
            wait();
        }
        dentro = true;
        cap++;
        dentro = false;
        notify();
    }
    public synchronized void Resta() throws InterruptedException{
        while(dentro){
            wait();
        }
        dentro = true;
        cap--;
        dentro = false;
        notify();
    }
    
    
    
}

