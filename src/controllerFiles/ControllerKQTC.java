package controllerFiles;

import Data.ReadFileXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.StudenrKQ;
import model.Student;
import model.StudentDK;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerKQTC implements Initializable {

    @FXML
    TableView<StudentDK> myTable;

    @FXML
    TableColumn<StudentDK, Integer> sttColum;

    @FXML
    TableColumn<StudentDK, Integer> idColum;
    @FXML

    TableColumn<StudentDK, String> nameColum;

    @FXML
    TableColumn<StudentDK, Integer> ageColum;

    @FXML
    TableColumn<StudentDK, String> birthdayColum;

    @FXML
    TableColumn<StudentDK, String> gtColum;

    @FXML
    TableColumn<StudentDK, String> classColum;

    @FXML
    TableColumn<StudentDK, String> addressColum;

    @FXML
    TableColumn<StudenrKQ, String> gkColum;

    @FXML
    TableColumn<StudenrKQ, String> ckColum;

    @FXML
    TableColumn<StudenrKQ, String> tkColum;

    @FXML
    TableColumn<StudenrKQ, String> xlColum;

    @FXML
    TextField txFind;

    @FXML
    ToggleGroup findGroup;

    List<Student> list = new ArrayList<>();
    private ObservableList<StudentDK> studentList;

    @FXML
    public void trangchu(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/TrangChuGV.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    public List<StudentDK> getList() throws IOException {
        list = ReadFileXML.readListStudent();
        List<StudentDK> li = new ArrayList<>();
        for (Student student : list) {
            li.add(new StudentDK(student.getStt(),
                    student.getId(),
                    student.getTen(),
                    student.getTuoi(),
                    student.getNgaysinh()
                    , student.getGioitinh(),
                    student.getLop(),
                    student.getDiachi()));
        }
        return li;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            studentList = FXCollections.observableArrayList(getList());
            sttColum.setCellValueFactory(new PropertyValueFactory<StudentDK, Integer>("stt"));
            idColum.setCellValueFactory(new PropertyValueFactory<StudentDK, Integer>("id"));
            nameColum.setCellValueFactory(new PropertyValueFactory<StudentDK, String>("ten"));
            ageColum.setCellValueFactory(new PropertyValueFactory<StudentDK, Integer>("tuoi"));
            birthdayColum.setCellValueFactory(new PropertyValueFactory<StudentDK, String>("ngaysinh"));
            gtColum.setCellValueFactory(new PropertyValueFactory<StudentDK, String>("gioitinh"));
            classColum.setCellValueFactory(new PropertyValueFactory<StudentDK, String>("lop"));
            addressColum.setCellValueFactory(new PropertyValueFactory<StudentDK, String>("diachi"));
            gkColum.setCellValueFactory(new PropertyValueFactory<StudenrKQ, String>("ngaysinh"));
            ckColum.setCellValueFactory(new PropertyValueFactory<StudenrKQ, String>("gioitinh"));
            tkColum.setCellValueFactory(new PropertyValueFactory<StudenrKQ, String>("lop"));
            xlColum.setCellValueFactory(new PropertyValueFactory<StudenrKQ, String>("diachi"));
            myTable.setItems(studentList);
            myTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
