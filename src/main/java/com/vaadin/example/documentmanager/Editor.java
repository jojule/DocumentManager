package com.vaadin.example.documentmanager;

import com.vaadin.data.util.TextFileProperty;

public class Editor extends EditorDesign {

    public void setPropertyDataSource(TextFileProperty doc) {
        rich.setPropertyDataSource(doc);
        html.setPropertyDataSource(doc);
    }

}
