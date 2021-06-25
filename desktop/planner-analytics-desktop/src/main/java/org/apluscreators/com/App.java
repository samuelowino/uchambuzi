package org.apluscreators.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var application = SystemInfo.applicationName();

        var label = new Label("Hello, User Welcome to  " + application + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.setTitle(application);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}