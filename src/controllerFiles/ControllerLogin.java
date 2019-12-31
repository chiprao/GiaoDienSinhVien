package controllerFiles;

import Data.ReadFileXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    public static Stage rootStage;

    private static String pass;

    @FXML
    private TextField username;

    @FXML
    private  PasswordField password;

    @FXML
    private CheckBox display;

    //nut thoat
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    // nut huy
    @FXML
    public void cancel(ActionEvent event) {
        username.setText("");
        password.setText("");
    }

    // login
    public boolean testUser(User user) throws IOException {
        List<User> list = ReadFileXML.readListUser();
        for (User user2 : list) {
            if (user2.getName().equals(user.getName()) && user2.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void login(ActionEvent event) throws IOException {
        if (testUser(new User(username.getText(), password.getText()))) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/TrangChuGV.fxml"));
            Scene scene = new Scene(root);
            Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            Alert mess = new Alert(Alert.AlertType.ERROR);
            mess.setContentText("LogIn Failed, Try Again!");
            mess.showAndWait();
        }
    }

        @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
