/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.main;

import fbsearch.view.MyFBSearchView;
import javax.swing.SwingUtilities;

/**
 *
 * @author ana
 */
public class Main {
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
	    public void run() {
		new MyFBSearchView().setVisible(true);
	    }
	});
    }
}
