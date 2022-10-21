
package fiosrecursivos;

class FiosRecursivos extends Thread{
    public FiosRecursivos (String str){
        super(str);
    }
    public void run(){
        System.out.println("Lanzando " + getName());
            
        

    }
    

    public static void main(String[] args) {
        for (int i = 1; i<6; i++){
        Thread fios = new Thread(new FiosRecursivos("Fio"+i));
            System.out.println(fios.getName() + "comezou a crear o seu fillo");
        fios.start();
        }
        
    }
    
}
