package com.test;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        JFXTextField text = new JFXTextField();
        text.setValidators(new MinNumberValidator(5));
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            text.validate();
        });
        root.getChildren().add(text);
        primaryStage.setScene(scene);
        primaryStage.setWidth(200);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
