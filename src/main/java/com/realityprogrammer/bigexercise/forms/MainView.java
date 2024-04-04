package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.Application;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable {
    @FXML private Button _navmenuButton1;
    @FXML private Button _navmenuButton2;
    @FXML private Button _navmenuButton3;
    @FXML private Button _navmenuButton4;
    @FXML private Button _navmenuButton5;
    @FXML private Button _navmenuButton6;
    @FXML private Button _navmenuButton7;
    @FXML private Button _navmenuButton8;
    @FXML private Button _navmenuButton9;

    @FXML private AnchorPane _contentContainer;

    private Button _previousButton;

    private void UpdateSelection(Button button, String pageResource) {
        if (button == _previousButton) return;

        if (_previousButton != null) _previousButton.setStyle("-fx-background-color: transparent");
        button.setStyle("-fx-background-color: #3F33AF");
        _previousButton = button;

        try {
            Parent pane = FXMLLoader.load(MainView.class.getResource(pageResource));
            _contentContainer.getChildren().removeAll();
            _contentContainer.getChildren().setAll(pane);

            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
        } catch (IOException e) {
            // TODO: Error Handling.
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        _navmenuButton1.setOnAction((e) -> UpdateSelection(_navmenuButton1, "page1.fxml"));
        _navmenuButton2.setOnAction((e) -> UpdateSelection(_navmenuButton2, "page2.fxml"));
        _navmenuButton3.setOnAction((e) -> UpdateSelection(_navmenuButton3, "page3.fxml"));
        _navmenuButton4.setOnAction((e) -> UpdateSelection(_navmenuButton4, "page4.fxml"));
        _navmenuButton5.setOnAction((e) -> UpdateSelection(_navmenuButton5, "page5.fxml"));
        _navmenuButton6.setOnAction((e) -> UpdateSelection(_navmenuButton6, "page6.fxml"));
        _navmenuButton7.setOnAction((e) -> UpdateSelection(_navmenuButton7, "page7.fxml"));
        _navmenuButton8.setOnAction((e) -> UpdateSelection(_navmenuButton8, "page8.fxml"));
        _navmenuButton9.setOnAction((e) -> UpdateSelection(_navmenuButton9, "page9.fxml"));
    }
}
