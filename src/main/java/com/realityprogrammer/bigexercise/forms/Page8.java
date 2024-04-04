package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import com.realityprogrammer.bigexercise.StudentLinkedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Page8 implements Initializable {
    @FXML private GridPane informationDisplayGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StudentLinkedList list = (StudentLinkedList) ApplicationData.getStudentList().clone();

        list.sort((a, b) -> Double.compare(b.getAverageScore(), a.getAverageScore()));

        Common.RebuildStudentInformationWithResult(informationDisplayGrid, list);
    }
}
