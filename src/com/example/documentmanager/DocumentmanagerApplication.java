package com.example.documentmanager;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class DocumentmanagerApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Documentmanager Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
