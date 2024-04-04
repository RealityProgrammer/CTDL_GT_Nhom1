package com.realityprogrammer.bigexercise.forms;

import com.realityprogrammer.bigexercise.ApplicationData;
import com.realityprogrammer.bigexercise.Common;
import com.realityprogrammer.bigexercise.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Page1 implements Initializable {
    @FXML private FlowPane modificationButtonPane;
    @FXML private AnchorPane modificationFieldPane;
    @FXML private GridPane informationDisplayGrid;

    @FXML private TextField idInputField;
    @FXML private TextField nameInputField;
    @FXML private TextField avgScoreInputField;

    @FXML private Text dataErrorText;

    private Timeline parseErrorTimeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: Import data from file.

        parseErrorTimeline = new Timeline(
            new KeyFrame(Duration.seconds(0), e -> {
                dataErrorText.setVisible(true);
            }),
            new KeyFrame(Duration.seconds(3), e -> {
                dataErrorText.setVisible(false);
            })
        );

        informationDisplayGrid.getRowConstraints().clear();

        Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList());
    }

    public void initializeModification() {
        modificationButtonPane.setDisable(true);
        modificationFieldPane.setDisable(false);
    }

    public void removeAllStudentInformations() {
        ApplicationData.getStudentList().clear();
        var gridLine = informationDisplayGrid.getChildren().getFirst();
        informationDisplayGrid.getChildren().clear();
        informationDisplayGrid.getChildren().add(gridLine);
        informationDisplayGrid.getRowConstraints().clear();
    }

    public void addStudentInformation() {
        String id = idInputField.getText();

        if (id.isEmpty() || id.equals("0")) {
            modificationButtonPane.setDisable(false);
            modificationFieldPane.setDisable(true);

            idInputField.setText("");
            nameInputField.setText("");
            avgScoreInputField.setText("");
        } else {
            String name = nameInputField.getText();
            String avgScore = avgScoreInputField.getText();

            try {
                double avgStore = Double.parseDouble(avgScore);

                if (avgStore >= 0 && avgStore <= 10) {
                    ApplicationData.getStudentList().addLast(new Student(id, name, avgStore));

                    Common.RebuildStudentInformation(informationDisplayGrid, ApplicationData.getStudentList());

                    idInputField.setText("");
                    nameInputField.setText("");
                    avgScoreInputField.setText("");
                } else {
                    dataErrorText.setText("Điểm trung bình phải ở khoảng 0 đến 10.");

                    parseErrorTimeline.playFromStart();
                }
            } catch (NumberFormatException e) {
                dataErrorText.setText("Điểm trung bình phải ở dạng số.");

                parseErrorTimeline.playFromStart();
            }
        }
    }
}
