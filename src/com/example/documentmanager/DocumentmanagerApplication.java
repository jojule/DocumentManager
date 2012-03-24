package com.example.documentmanager;

import java.io.File;

import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class DocumentmanagerApplication extends Application {

	static final String javaDocFolderPath = "/Users/phoenix/Desktop/docs";
	private FilesystemContainer docs = new FilesystemContainer(new File(
			javaDocFolderPath));
	private ComboBox sel = new ComboBox("Choose a file", docs);
	private Label doc = new Label("", Label.CONTENT_XHTML);

	@Override
	public void init() {
		Window mainWindow = new Window("Documentmanager Application");
		setMainWindow(mainWindow);
		mainWindow.addComponent(sel);
		mainWindow.addComponent(doc);
		
		sel.setImmediate(true);
		sel.addListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				doc.setPropertyDataSource(new TextFileProperty((File) sel.getValue()));
			}
		});
	}

}
