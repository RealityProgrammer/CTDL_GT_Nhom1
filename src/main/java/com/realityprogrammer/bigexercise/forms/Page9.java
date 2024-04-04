package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import com.realityprogrammer.bigexercise.StudentLinkedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Page9 implements Initializable {
    @FXML private GridPane informationDisplayGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StudentLinkedList list = (StudentLinkedList) ApplicationData.getStudentList().clone();

        int removeIndex = 0;
        for (var current = list.getHeadNode(); current != null; current = current.getNext()) {
            if (current.getValue().getAverageScore() < 5.0) {
                list.removeAt(removeIndex);
            } else {
                removeIndex++;
            }
        }

        Common.RebuildStudentInformationWithResult(informationDisplayGrid, list);
    }
}
