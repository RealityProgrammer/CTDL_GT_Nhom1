package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Page5 implements Initializable {
    @FXML private GridPane informationDisplayGrid;
    @FXML private Slider minimumScoreSlider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList(), (x) -> x.getAverageScore() >= 7.0);

        minimumScoreSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList(), (x) -> x.getAverageScore() >= newValue.doubleValue());
        });
    }
}
