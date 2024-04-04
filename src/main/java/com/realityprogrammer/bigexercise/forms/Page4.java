package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Page4 implements Initializable {
    @FXML private GridPane informationDisplayGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Common.RebuildStudentInformationWithResult(informationDisplayGrid, ApplicationData.getStudentList(), x -> true);
    }
}
