package com.example.documentmanager;

import java.io.File;

import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
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
	private Button editButton = new Button("Edit");

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
		editButton.addListener(new ClickListener() {			
			@Override
			public void buttonClick(ClickEvent event) {
				Window dialog = new Window("Editor", new Editor(doc));
				editButton.getWindow().addWindow(dialog);
				dialog.setModal(true);
				dialog.setWidth("90%");
				dialog.setHeight("90%");
			}
		});
	}

	private ComponentContainer buildLayout() {
		AbsoluteLayout abs = new AbsoluteLayout();
		VerticalSplitPanel split = new VerticalSplitPanel();
		split.addComponent(sel);
		split.addComponent(doc);
		sel.setSizeFull();
		abs.addComponent(split);
		abs.addComponent(editButton, "bottom: 10px; right: 10px;");
		return abs;
	}

}
