/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.controller;

import fbsearch.model.MyFBSearchModel;
import fbsearch.view.MyFBSearchView;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class MyFBSearchController{

    private MyFBSearchModel model;
    private MyFBSearchView view;
    public Thread t;
    
    public MyFBSearchController(MyFBSearchModel model, MyFBSearchView view){
        this.model = model;
        this.view = view;
    }  
    
    public void setListInfo() {
        model.setAccessToken(view.getTokenField().getText());
        model.setNameToSearch(view.getUserField().getText());
        t = new Thread(model);
        t.start();
    }
    
    public void saveImages(int [] selectedRows) throws IOException{
        model.saveImages(selectedRows);
    }
    
    public void cancelSearch() {
        t.interrupt();
    }
}
