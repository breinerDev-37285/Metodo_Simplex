/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siplex;

/**
 *
 * @author gt37285
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
//        double[][] matriz = {{1,-300,-400,0,0,0,0},{0,1,0,1,0,0,300},{0,0,1,0,1,0,200},{0,2,3,0,0,1,900}};
        double[][] matriz = {{1,-500,-1000,0,0,0,0},{0,2.5,5.5,1,0,0,1200},{0,1,0,0,1,0,200},{0,1,1,0,0,1,500}};
//        double[][] matriz = {{1,-1.5,-1.2,0,0,0,0},{0,1,0,1,0,0,6000},{0,1,1,0,1,0,800},{0,1,2,0,0,1,700}};
//        double[][] matriz = {{1,-50,-80,0,0,0},{0,1,2,1,0,120},{0,1,1,0,1,90}};
        
        logica l = new logica();
        
        int  posCol = l.postFilPivot(matriz);
        int posFil = l.posColPivot(matriz, posCol);
        double pivot = l.getPivot(matriz, posFil, posCol);
        double[][] pasar_uno = l.pasar_Uno(matriz, posFil, pivot);
//        double[][] proceso = l.proceso(pasar_uno, posFil, posCol, pivot);
//      
        String res = "";
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                res+=matriz[i][j]+"\t\t";
            }
            res+="\n";
        }
        
        System.out.print(res);
        
        
        
    }
    
}
