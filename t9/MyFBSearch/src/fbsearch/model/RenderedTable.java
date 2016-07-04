/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.model;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ana
 */
public class RenderedTable extends DefaultTableCellRenderer {
    
    public RenderedTable(){
        super();
    }
    
    @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
             boolean hasFocus, int row, int column){
        
        this.setHorizontalAlignment(CENTER);
        JLabel l = (JLabel)super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column
        );
        if (value instanceof Icon)
        {
            l.setText(null);
            l.setIcon((Icon)value);
        }
        
        this.setHorizontalAlignment(CENTER);
        
        return l;
    }
}
