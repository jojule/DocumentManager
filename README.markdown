Document Manager demo application for learning Vaadin

### Development tools used for this project

Install the following:

* Latest Eclipse for Java EE			http://eclipse.org/
* Latest Scala IDE plugin for Eclipse		http://www.scala-ide.org/


### How to import this project

Import this project to Eclipse with "Import project"

Download the following libraries and copy them to WebContent/WEB-INF/lib directory:

* vaadin-6.7.6.jar
* scala-library.jar
* scaladin_2.9.1-1.0.0.jar

(or any newer version available)

This application does not use a custom widgetset, if you are asked to recompile, you can just safely ignore the recompicaltion requests.


### How to run this project

* Choose Run on server for the project
* You can use any Servlet container. For example "J2EE Preview" works just fine.
* Please add ?restartApplication in the end of your URL to restart your application on each page reload 


### Speeding up development cycle

If you get bored for restarting the server to redeploy, you could install JRebel to automatically replace classes in a running server without restarts:

* Install JRebel from Eclipse Marketplace (Help -> Ecliplse Marketplace...)
* Get a free trial license from http://zeroturnaround.com. If you have Vaadin Pro Account subscription, a download full license from https://vaadin.com/jrebel
* From your server settings in Eclipse (double click "J2EE Preview" in Server panel) check "Enable JRebel Agent"
* From the project, choose JRebel -> Generate jrebel.xml in src
* Restart the server
