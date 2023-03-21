package com.example.proyecto1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 400);
        stage.setTitle("Calculadora y Recorridos del árbol ");
        stage.setScene(scene);
        stage.show(); 
    }

    public static void main(String[] args) {
        launch();


    }
}