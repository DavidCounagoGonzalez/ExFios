
package probafios4;

public class ProbaFios4 extends Thread{
    public ProbaFios4(String str){
        super(str);
    }
    
    public void run(){
        String var = this.getName();
        int resultado = 0;
        if(var=="par"){
            for(int x = 0; x<=1000;x++){
                if ((x%2)==0){
                    resultado=resultado+x;
                }
            }
            System.out.println("Resultado da suma par = " + resultado);
        }
        else if(var=="imp"){
            for(int x = 0; x<=1000;x++){
                if((x%2)!=0)
                resultado=resultado+x;
            }
            System.out.println("Resultado da suma impar = " + resultado);
        }
        else{
           for(int x = 0;x<=1000;x++){
               if(x%10==2 || x%10==3){
                   resultado=resultado+x;
               }
           }
           System.out.println("Resultado da suma = " + resultado);
        }
        
    }

    public static void main(String[] args) {
        Thread sumaPar = new Thread(new ProbaFios4("par"));
        Thread sumaImp = new Thread(new ProbaFios4("imp"));
        Thread suma = new Thread(new ProbaFios4("dostres"));
        
        sumaPar.start();
        sumaImp.start();
        suma.start(); 
}
}
