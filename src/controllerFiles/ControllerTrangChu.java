package controllerFiles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTrangChu implements Initializable {

    // thong tin sinh vien
    @FXML
    public void thongtin(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/ThongTinSinhTrangChu.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    public void Ketqua(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/KetQuaTrangChu.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    // dang xuat
    @FXML
    public void dangxuat(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/Login.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
