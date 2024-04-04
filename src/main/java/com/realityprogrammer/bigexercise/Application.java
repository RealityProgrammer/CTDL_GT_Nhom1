package com.realityprogrammer.bigexercise;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Application instance;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        instance = this;
        this.stage = stage;

        stage.setTitle("Sản phẩm nhóm 1");
        stage.setMaximized(true);

        Scene scene = new Scene(FXMLLoader.load(Application.class.getResource("forms/main-view.fxml")), 800, 600);
        stage.setScene(scene);

        stage.show();
    }

    public static Application getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }

    public static void main() { launch(); }
}