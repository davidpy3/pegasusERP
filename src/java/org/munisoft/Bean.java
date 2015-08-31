/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class Bean implements Serializable {

    TabView tabs = new TabView();

    @PostConstruct
    public void init() {
        //tabs = new ArrayList();
    }

    public List<String> getTabList() {

        return tabList;
    }

    public void setTabList(List<String> tabList) {
        this.tabList = tabList;
    }

    public void setTabs(TabView tabs) {
        this.tabs = tabs;
    }
    private List<String> tabList = new ArrayList<String>();
    
    public String re2(String s){
        System.out.println("s="+s);
        return s;
   }
    
    public void foo(String ev){
        /*Tab t = new Tab();
        t.setTitle(">"+ev+"<");
        t.setClosable(true);*/
        tabList.add(ev);
        //tabs.getChildren().add(t);
        RequestContext.getCurrentInstance().update("myTabPanel");
    }
    
    public void remove(Tab tab) {
        //tabs.remove(tab);
    }

    public TabView getTabs() {
        return tabs;
    }
    
}
