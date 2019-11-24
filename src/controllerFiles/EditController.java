package controllerFiles;

import Data.ReadFileXML;
import Data.WriteFileXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;
import model.StudentDK;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    @FXML
    TextField id;

    @FXML
    TextField name;

    @FXML
    TextField age;

    @FXML
    TextField lop;

    @FXML
    TextField diachi;

    @FXML
    DatePicker birthday;

    @FXML
    TextField gt;

    @FXML
    Label myLabel;

    @FXML
    Button closeButton;

    StudentDK temp;

    String ac = "add";


    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    public void setValue(StudentDK student, String action) {
        temp = student;
        id.setText(Integer.toString(student.getId()));
        name.setText(student.getTen());
        age.setText(Integer.toString(student.getTuoi()));
        lop.setText(student.getLop());
        diachi.setText(student.getDiachi());
        gt.setText(student.getGioitinh());
        birthday.setValue(LOCAL_DATE(student.getNgaysinh()));
        ac = action;
    }

    public void edit() throws IOException {
        LocalDate localDate = birthday.getValue();
        List<Student> list = ReadFileXML.readListStudent();
        String[] date = localDate.toString().split("-");
        Student s = new Student(temp.getStt()
                , Integer.parseInt(id.getText()),
                name.getText(),
                Integer.parseInt(age.getText()),
                gt.getText(),
                lop.getText(),
                diachi.getText(),
                new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]), Integer.parseInt(date[2])));
        list.remove(temp.getStt() - 1);
        list.add(temp.getStt() - 1, s);
        WriteFileXML.wrieData(list);
    }

    public void add() throws IOException {
        LocalDate localDate = birthday.getValue();
        List<Student> list = ReadFileXML.readListStudent();
        String[] date = localDate.toString().split("-");
        Student s = new Student(list.size() + 1
                , Integer.parseInt(id.getText()),
                name.getText(),
                Integer.parseInt(age.getText()),
                lop.getText(),
                diachi.getText(),
                gt.getText(),
                new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) - 1, Integer.parseInt(date[2])));
        list.add(s);
        WriteFileXML.wrieData(list);
    }

    public void submitEdit(ActionEvent event) throws IOException {
        if (ac.equals("edit")) {
            edit();
        } else {
            add();
        }
//        Main main = new Main();
//        main.changeScene("/fxmlFiles/ThongTinSinhTrangChu.fxml");
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/ThongTinSinhTrangChu.fxml"));
        Scene scene = new Scene(root);
//        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        NewStage.setScene(scene);
//        NewStage.show();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }


    public void cancelEdit(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


}