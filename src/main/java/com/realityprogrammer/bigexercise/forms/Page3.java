package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.Application;
import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import com.realityprogrammer.bigexercise.StudentLinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;

public class Page3 implements Initializable {
    @FXML private MenuButton sortingCandidateButton;
    @FXML private GridPane informationDisplayGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList());
    }

    public void selectDefaultSortingCandidate(ActionEvent e) {
        sortingCandidateButton.setText(((MenuItem)e.getSource()).getText());
        Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList());
    }

    public void setLastNameSortingCandidate(ActionEvent e) {
        sortingCandidateButton.setText(((MenuItem)e.getSource()).getText());

        StudentLinkedList list = (StudentLinkedList)ApplicationData.getStudentList().clone();

        list.sort((a, b) -> {
            var nameA = a.getFullName();
            var nameB = b.getFullName();

            int idxA = nameA.lastIndexOf(' ');
            int idxB = nameB.lastIndexOf(' ');

            String sliceA = idxA == -1 ? nameA : nameA.substring(idxA + 1);
            String sliceB = idxB == -1 ? nameB : nameB.substring(idxB + 1);

            return sliceA.compareTo(sliceB);
        });

        Common.RebuildStudentInformation(informationDisplayGrid, list);
    }

    public void setFullNameSortingCandidate(ActionEvent e) {
        sortingCandidateButton.setText(((MenuItem)e.getSource()).getText());

        StudentLinkedList list = (StudentLinkedList)ApplicationData.getStudentList().clone();

        list.sort((a, b) -> a.getFullName().compareToIgnoreCase(b.getFullName()));

        Common.RebuildStudentInformation(informationDisplayGrid, list);
    }
}
