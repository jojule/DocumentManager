package com.example.documentmanager

import vaadin.scala._
import com.vaadin.data.util.FilesystemContainer
import com.vaadin.data.util.TextFileProperty
import com.vaadin.data.Property.ValueChangeEvent
import java.io.File

class DocumentmanagerApplication extends SimpleApplication(title = "Documentmanager Application") {
  override def main = new AbsoluteLayout {
    val doc = new Label { setContentMode(com.vaadin.ui.Label.CONTENT_XHTML) }
    add(new VerticalSplitPanel() {
      add(new Table(width = "100%", height = "100%", selectable = true, immediate = true) {
        setContainerDataSource(new FilesystemContainer(new File("/Users/phoenix/Desktop/docs")))
        addListener((e: ValueChangeEvent) => {
          doc.setPropertyDataSource(new TextFileProperty(getValue.asInstanceOf[File]))
        })
      })
      add(doc)
    }, "")
    add(new Button("Edit",
      _ => getMainWindow.addWindow(new Window(caption = "Editor", width = "90%", height = "90%", modal = true) {
        setContent(new Editor(doc))
      })),
      "bottom: 10px; right: 10px;")
  }
}