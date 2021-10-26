package gui.javafx.studentBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentBrowserController {

    private StudentBrowserModel studentBrowserModel;


    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtName;

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
}
