
package siplex;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        
        for (int i = 0; i < divisionRes.length; i++) {
           divisionRes[i] = 0;
        }
        
        for (int i = 1; i < matriz.length; i++) {
            if( matriz[i][posFil] <= 0 ){
                divisionRes[i-1] = matriz[i][ matriz[i].length-1 ];
            }else{
                divisionRes[i-1] = matriz[i][ matriz[i].length-1 ] / matriz[i][ posFil ];
            }
        }
        
        double menor = matriz[1][ matriz[0].length-1 ];
        double menorRes = divisionRes[0];
        
        for (int i = 0; i < matriz.length-1 ; i++) {
            if( matriz[(i+1)][posFil] > 0 ){
                if( divisionRes[i] <= menorRes ){
                    menorRes = divisionRes[i];
                    menor = matriz[(i+1)][matriz[0].length-1];
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
    
    
    
    
    public double[][] proceso (double[][] matriz, int fil,int col, double pivot) {
        
        
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
    
    
    
    
    public double[][] procesoRecursivo(int incognitas, int variables,int orguras, JTable tblMatriz,DefaultTableModel modeloMatriz,DefaultTableModel modeloData){
        
        
        double matriz[][] = matriz(variables, orguras, tblMatriz);
        
        
        int  posCol = postFilPivot(matriz);
        int posFil = posColPivot(matriz, posCol);
        double pivot = getPivot(matriz, posFil, posCol);
        double[][] pasar_uno = pasar_Uno(matriz, posFil, pivot);
        double[][] proceso = proceso(pasar_uno, posFil, posCol, pivot);
       
        
        
        String nombreVariable = modeloMatriz.getColumnName( posCol );
        modeloData.setValueAt(nombreVariable,posFil,0);
        
        ColorFila pn = new ColorFila();
        
        pn.setPintarFila(posFil);
        pn.setPintarCol(posCol);
        tblMatriz.setDefaultRenderer(Object.class, pn);
        
        
            
        return matriz;
       
    }
    
    
     
    
    
}
