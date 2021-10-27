package gui.javafx.deleteStudent;

import gui.javafx.models.StudentBrowserModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DeleteStudentController {

    @FXML
    private ListView lstOfStudents;

    private StudentBrowserModel studentBrowserModel;

    public void setStudentBrowserModel(StudentBrowserModel studentBrowserModel) {
        this.studentBrowserModel = studentBrowserModel;
        lstOfStudents.setItems(studentBrowserModel.getAllStudents());
    }
}
