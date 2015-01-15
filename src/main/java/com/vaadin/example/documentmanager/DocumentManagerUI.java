package com.vaadin.example.documentmanager;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

@Theme("valo")
public class DocumentManagerUI extends UI {

    FilesystemContainer dataSource = new FilesystemContainer(new File(
            "/tmp/docs"));
    Editor document = new Editor();
    Table list = new Table(null, dataSource) {
        {
            setSizeFull();
            setSelectable(true);
            setVisibleColumns(FilesystemContainer.PROPERTY_NAME,
                    FilesystemContainer.PROPERTY_SIZE);
            addValueChangeListener(e -> document
                    .setPropertyDataSource(new TextFileProperty(
                            (File) getValue())));
        }
    };

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new HorizontalSplitPanel(list, document));
    }

    @WebServlet(urlPatterns = "/*")
    public static class DocumentManagerUIServlet extends VaadinServlet {
    }
}
