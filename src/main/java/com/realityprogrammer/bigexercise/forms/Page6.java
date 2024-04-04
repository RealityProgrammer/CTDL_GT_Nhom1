package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Page6 implements Initializable {
    @FXML private GridPane informationDisplayGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList());
    }

    public void onSearchboxApplied(ActionEvent event) {
        var gridLine = informationDisplayGrid.getChildren().getFirst();
        informationDisplayGrid.getChildren().clear();
        informationDisplayGrid.getChildren().add(gridLine);
        informationDisplayGrid.getRowConstraints().clear();

        var search = ((TextField)event.getTarget()).getText();

        Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList(), x -> search.isEmpty() || x.getStudentID().startsWith(search));
    }
}
