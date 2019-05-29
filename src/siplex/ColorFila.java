/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siplex;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author breiner
 */
public class ColorFila extends DefaultTableCellRenderer {
    public int pintarFila,pintarCol;

    public int getPintarFila() {
        return pintarFila;
    }

    public void setPintarFila(int pintarFila) {
        this.pintarFila = pintarFila;
    }

    public int getPintarCol() {
        return pintarCol;
    }

    public void setPintarCol(int pintarCol) {
        this.pintarCol = pintarCol;
    }
    
            
            
            
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col ){
    
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        
       
        if( getPintarFila() == row ){
            setBackground(Color.cyan);
        }
        
        if(getPintarFila() != row && getPintarCol() != col){
            setBackground(Color.WHITE);
        }
        
        
        if(getPintarCol()==col){
            setBackground(Color.YELLOW);
        }
        
         if( hasFocus ){
            setBackground(Color.WHITE);
        }
        
        if( Selected ){
            setBackground(Color.WHITE);
        }
        
        return this;
    }
    
    
    
}
