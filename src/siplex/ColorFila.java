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
    
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col ){
    
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        
        
        return this;
    }
    
    
    
}
