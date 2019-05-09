
package siplex;

import javax.swing.JTable;

/**
 * 
 * @author breiner
 */

public class logica {
  
    public double[][] matriz (int fila, int col, JTable tblMatriz ){
        
        double[][] matriz = new double[fila][col]; //genera la matriz
        
        /* recorre toda la matriz llenandola con los datos de la tabla*/

        for (int i = 0; i < fila; i++) {       
            for (int j = 0; j < col; j++) {
                matriz[i][j] = Double.parseDouble(String.valueOf( tblMatriz.getValueAt(i, j) ));
            }
        }
        
        return matriz;
    }
    
    
    public int postFilPivot (double matriz[][]){
        /*Se busca el elemento pivot en las columnas */ 

        double menor = matriz[0][0];
        int pos = 0;
        
        for (int j = 0; j < matriz[0].length-1; j++) {
            if(matriz[0][j] < menor ){
                menor = matriz[0][j];
                pos = j;
            }
        }
        
        return pos;
    }
    
    public int posColPivot (double matriz[][],int posFil){
        /*Se busca el elemento pivot en las columnas */ 

        
        int pos = 0;
        double[] divisionRes = new double [ matriz.length-1 ];
        
        String res = "";
        
        
        for (int i = 1; i < matriz.length; i++) {
            if( matriz[i][posFil] > 0 ){
                divisionRes[i-1] = matriz[i][ matriz[i].length-1 ] / matriz[i][ posFil ];
            }else{
                divisionRes[i-1] = 0;
            }
        }
        
        double menor = divisionRes[ 0 ];
        
        for (int i = 0; i < divisionRes.length ; i++) {
            
            if( divisionRes[i] > 0 ){
                if( divisionRes[i] <= menor ){
                    menor = divisionRes[i];
                    pos = (i+1);
                }
            }
        }
        
        return pos;
    }
    
    public double getPivot (double[][] matriz,int fil, int col) {
        return matriz[fil][col];
    }
    
    
    public double[][] pasar_Uno (double[][] matriz, int fil,double pivot) {
        
        for (int j = 0; j < matriz[0].length; j++) {
            
            if( matriz[ fil ][j] != 0 ){
                 matriz[ fil ][j] = matriz[ fil ][j] / pivot;
            }
        }
        
        return matriz;
    }
    
    public double[][] proceso (double[][] matrizx, int fil,int col, double pivot) {
        
        
        double[][] matriz = pasar_Uno(matrizx, fil, pivot);
        
        double[] colPivot = new double[ matriz.length ];
        
        
        for (int i = 0; i < matriz.length; i++) {
            colPivot[i] = matriz[i][col];
        }
        
        
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if( i != fil ){
                    matriz[i][j] =  matriz[i][j] - (  matriz[ fil ][ j ] * colPivot[i] ) ;
                }
            }
        }
        

        return matriz;
    }
    
    
    public double[][] procesoRecursivo(int incognitas, int variables,int orguras, JTable tblMatriz){
        
        
       double matriz[][] = matriz(variables, orguras, tblMatriz);
       int cont = 0;
        
            while( cont <= ( incognitas - 1 ) ){
                
                int col = postFilPivot(matriz);
                int fil = posColPivot(matriz, col);
                double pivot = getPivot(matriz, fil, col);
                
                matriz = proceso(matriz, fil, col, pivot);
                cont++;
            }
            
        return matriz;
       
    }
     
    
    
}
