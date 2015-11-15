/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.util;

import org.primefaces.component.tabview.Tab;

/**
 *
 * @author TOSHIBA
 */
public class XTab extends Tab{

    private String title;
    private String content;

    public XTab(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


    
}
