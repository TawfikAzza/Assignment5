package gui.javafx.studentBrowser;

import gui.javafx.deleteStudent.DeleteStudentController;
import gui.javafx.models.StudentBrowserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentBrowserController implements Initializable {



    @FXML
    private ListView lstAllStudents;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtName;

    private StudentBrowserModel studentBrowserModel;

    public StudentBrowserController(){
        studentBrowserModel= new StudentBrowserModel();
    }
    @FXML
    void handleCreateStudent(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String email = txtMail.getText();

        studentBrowserModel.createStudent(id,name,email);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lstAllStudents.setItems(studentBrowserModel.getAllStudents());
    }

    public void handleDeleteStudent(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/javafx/deleteStudent/DeleteStudentView.fxml"));
        Parent root = loader.load();
        DeleteStudentController studentController = loader.getController();
       studentController.setStudentBrowserModel(studentBrowserModel);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
