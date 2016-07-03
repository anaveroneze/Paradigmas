/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.controller;

import fbsearch.model.MyFBSearch;
import fbsearch.model.MyFBSearchModel;
import fbsearch.view.MyFBSearchView;

/**
 *
 * @author ana
 */
public class MyFBSearchController {

    private MyFBSearchModel model;
    private MyFBSearchView view;
    
    public MyFBSearchController(MyFBSearchModel model, MyFBSearchView view){
        this.model = model;
        this.view = view;
    }  
    
    public void setListInfo() {
        MyFBSearch MyFBSearch = new MyFBSearch(view.getTokenField().getText(), view.getUserField().getText());
        model.add(MyFBSearch);
    }
    
}
