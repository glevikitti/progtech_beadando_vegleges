package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Myapplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Myapplication.class.getResource("/fxml/Orarend_grafikusfelulet.fxml"));
        stage.setTitle("Orarendtervezo");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

    }
}
