package controllerFiles;

import Data.ReadFileXML;
import Data.WriteFileXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Student;
import model.StudentDK;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerThongTinTrangChu implements Initializable {

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
    TextField txFind;
    @FXML
    ToggleGroup findGroup;

    List<Student> list = new ArrayList<>();
    private ObservableList<StudentDK> studentList;

    // tro ve trang chu
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
            myTable.setItems(studentList);
            myTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findStudent(ActionEvent event) throws IOException {
        RadioButton selectedRadioButton = (RadioButton) findGroup.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        List<StudentDK> temp = new ArrayList<>();
        String find = txFind.getText();
        switch (toogleGroupValue) {
            case "By ID": {
                temp = getList();
                temp = temp.stream()
                        .filter(student -> student.getId() == Integer.parseInt(find))
                        .collect(Collectors.toList());
                studentList = FXCollections.observableArrayList(temp);
                myTable.setItems(studentList);
                myTable.refresh();
                break;
            }
            case "By Name": {
                temp = getList();
                temp = temp.stream()
                        .filter(student -> student.getTen().equals(find))
                        .collect(Collectors.toList());
                studentList = FXCollections.observableArrayList(temp);
                myTable.setItems(studentList);
                myTable.refresh();
                break;
            }
            case "By Class": {
                temp = getList();
                temp = temp.stream()
                        .filter(student -> student.getLop().equals(find))
                        .collect(Collectors.toList());
                studentList = FXCollections.observableArrayList(temp);
                myTable.setItems(studentList);
                myTable.refresh();
                break;
            }
            default:
                break;
        }
    }

    public void reloadList(ActionEvent event) throws IOException {
        List<StudentDK> temp = getList();
        studentList = FXCollections.observableArrayList(temp);
        myTable.setItems(studentList);
        myTable.refresh();
    }

    public void editStudent(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxmlFiles/EditForm.fxml"));
        Parent EditView;
        try {
            EditView = loader.load();
            Scene scene = new Scene(EditView);
            EditController controller = loader.getController();
            StudentDK selected = myTable.getSelectionModel().getSelectedItem();
            controller.setValue(selected, "edit");
            stage.setScene(scene);
            stage.setTitle("Add student");
            stage.showAndWait();
            myTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxmlFiles/EditForm.fxml"));
        Parent EditView;
        try {
            EditView = loader.load();
            Scene scene = new Scene(EditView);
            EditController controller = loader.getController();
            //controller.setAction("add");
            stage.setScene(scene);
            stage.show();
            myTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(ActionEvent event) throws IOException {
        List<Student> list = ReadFileXML.readListStudent();
        StudentDK selected = myTable.getSelectionModel().getSelectedItem();
        list.remove(selected.getStt() - 1);
        WriteFileXML.wrieData(list);
        List<StudentDK> temp = getList();
        studentList = FXCollections.observableArrayList(temp);
        myTable.setItems(studentList);
        myTable.refresh();
    }
}
