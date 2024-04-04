package com.realityprogrammer.bigexercise;

import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.util.Map;
import java.util.function.Predicate;

public final class Common {
    private static final Map<StudentResult, String> RESULT_TEXT_MAPPER = Map.of(StudentResult.AVERAGE, "Trung bình", StudentResult.MODERATE, "Khá", StudentResult.EXCELLENT, "Xuất sắc");

    public static void RebuildStudentInformation(GridPane grid, StudentLinkedList studentList) {
        RebuildStudentInformation(grid, studentList, (x) -> true);
    }

    public static void RebuildStudentInformation(GridPane grid, StudentLinkedList studentList, Predicate<Student> filter) {
        var gridLine = grid.getChildren().getFirst();
        grid.getChildren().clear();
        grid.getChildren().add(gridLine);
        grid.getRowConstraints().clear();

        int i = 1;
        for (var current = studentList.getHeadNode(); current != null; current = current.getNext()) {
            var item = current.getValue();

            if (!filter.test(item)) {
                i++;
                continue;
            }

            Text c1 = new Text(String.valueOf(i)); // Index
            c1.setStyle("-fx-font-size: 15");

            Text c2 = new Text(item.getStudentID());
            c2.setStyle("-fx-font-size: 15");

            Text c3 = new Text(item.getFullName());
            c3.setStyle("-fx-font-size: 15");

            Text c4 = new Text(String.valueOf(item.getAverageScore()));
            c4.setStyle("-fx-font-size: 15");

            grid.addRow(grid.getRowCount(), c1, c2, c3, c4);
            grid.getRowConstraints().add(new RowConstraints(30, 30, 30, Priority.SOMETIMES, VPos.CENTER, true));

            i++;
        }
    }

    public static void RebuildStudentInformationWithResult(GridPane grid, StudentLinkedList studentList) {
        RebuildStudentInformationWithResult(grid, studentList, x -> true);
    }

    public static void RebuildStudentInformationWithResult(GridPane grid, StudentLinkedList studentList, Predicate<Student> filter) {
        var gridLine = grid.getChildren().getFirst();
        grid.getChildren().clear();
        grid.getChildren().add(gridLine);
        grid.getRowConstraints().clear();

        int i = 1;
        for (var current = studentList.getHeadNode(); current != null; current = current.getNext()) {
            var item = current.getValue();

            if (!filter.test(item)) {
                i++;
                continue;
            }

            Text c1 = new Text(String.valueOf(i)); // Index
            c1.setStyle("-fx-font-size: 15");

            Text c2 = new Text(item.getStudentID());
            c2.setStyle("-fx-font-size: 15");

            Text c3 = new Text(item.getFullName());
            c3.setStyle("-fx-font-size: 15");

            Text c4 = new Text(String.valueOf(item.getAverageScore()));
            c4.setStyle("-fx-font-size: 15");

            Text c5 = new Text(RESULT_TEXT_MAPPER.get(item.getResult()));
            c5.setStyle("-fx-font-size: 15");

            grid.addRow(grid.getRowCount(), c1, c2, c3, c4, c5);
            grid.getRowConstraints().add(new RowConstraints(30, 30, 30, Priority.SOMETIMES, VPos.CENTER, true));

            i++;
        }
    }
}
