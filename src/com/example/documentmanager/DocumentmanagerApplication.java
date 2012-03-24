package com.example.documentmanager;

import java.io.File;

import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

public class DocumentmanagerApplication extends Application {

	static final String javaDocFolderPath = "/Users/phoenix/Desktop/docs";
	private FilesystemContainer docs = new FilesystemContainer(new File(
			javaDocFolderPath));
	private Table sel = new Table(null, docs);
	private Label doc = new Label("", Label.CONTENT_XHTML);

	@Override
	public void init() {
		Window mainWindow = new Window("Documentmanager Application", buildLayout());
		setMainWindow(mainWindow);		
		wireUp();
	}

	private void wireUp() {
		sel.setImmediate(true);
		sel.setSelectable(true);
		sel.addListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				doc.setPropertyDataSource(new TextFileProperty((File) sel.getValue()));
			}
		});
	}

	private ComponentContainer buildLayout() {
		VerticalSplitPanel split = new VerticalSplitPanel();
		split.addComponent(sel);
		split.addComponent(doc);
		sel.setSizeFull();
		return split;
	}

}
