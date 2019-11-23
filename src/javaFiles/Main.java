package javaFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage rootStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        rootStage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/Login.fxml"));
            rootStage.setTitle("Login");
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            //primaryStage.show();
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        rootStage.setHeight(550);
        rootStage.setWidth(825);
        rootStage.getScene().setRoot(pane);
    }
}
