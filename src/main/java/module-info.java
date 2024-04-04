module com.realityprogrammer.bigexercise {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.realityprogrammer.bigexercise to javafx.fxml;
    exports com.realityprogrammer.bigexercise;
    exports com.realityprogrammer.bigexercise.forms;
    opens com.realityprogrammer.bigexercise.forms to javafx.fxml;
}