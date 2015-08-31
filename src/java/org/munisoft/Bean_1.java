/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class Bean_1 implements Serializable {

    private List<XTab> tabs;
/*       <p:tabView id="mm" scrollable="true" value="#{bean_1.tabs}" var="tab">  
            <p:tab title="#{tab.title}" closable="true">
            #{tab.content}
            <p:commandButton value="Close" action="#{bean_1.remove(tab)}" update="@form:mm" />
        </p:tab>
    </p:tabView>  
    <p:commandButton value="Add Tab" action="#{bean_1.add}" update="@form:mm" />
        */
    @PostConstruct
    public void init() {
        tabs = new ArrayList();
    }

    public void add() {
        System.out.println("ttttt="+tabs.size());
        tabs.add(new XTab("tab" + tabs.size(), "some content"));
    }

    public void remove(XTab tab) {
        tabs.remove(tab);
    }

    public List<XTab> getTabs() {
        return tabs;
    }
    
    
    
}
