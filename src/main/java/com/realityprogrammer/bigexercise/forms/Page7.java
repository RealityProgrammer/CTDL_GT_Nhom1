package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import com.realityprogrammer.bigexercise.StudentResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Page7 implements Initializable {
    @FXML private GridPane informationDisplayGrid;
    @FXML private MenuButton filterMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Common.RebuildStudentInformationWithResult(informationDisplayGrid, ApplicationData.getStudentList());
        filterMenu.setText("Tất cả");
    }

    public void displayAllStudents(ActionEvent event) {
        filterMenu.setText("Tất cả");
        Common.RebuildStudentInformationWithResult(informationDisplayGrid, ApplicationData.getStudentList());
    }

    public void displayAverageStudents(ActionEvent event) {
        Common.RebuildStudentInformationWithResult(informationDisplayGrid, ApplicationData.getStudentList(), x -> x.getResult() == StudentResult.AVERAGE);
        filterMenu.setText("Trung bình");
    }

    public void displayModerateStudents(ActionEvent event) {
        Common.RebuildStudentInformationWithResult(informationDisplayGrid, ApplicationData.getStudentList(), x -> x.getResult() == StudentResult.MODERATE);
        filterMenu.setText("Khá");
    }

    public void displayExcellentStudents(ActionEvent event) {
        Common.RebuildStudentInformationWithResult(informationDisplayGrid, ApplicationData.getStudentList(), x -> x.getResult() == StudentResult.EXCELLENT);
        filterMenu.setText("Xuất sắc");
    }
}
