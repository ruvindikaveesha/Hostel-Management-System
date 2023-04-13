package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOType;
import lk.ijse.hibernate.bo.custom.StudentBO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.view.tm.StudentTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ManageStudentFormController {
    public AnchorPane ManageStudentContext;
    public JFXButton btnAddNewStudent;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtConNo;
    public JFXComboBox<String> cmbGender;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public TableView <StudentTM> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colConNo;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXDatePicker txtDOB;


//    public void AddNewStudentOnAction(ActionEvent actionEvent) {
//    }
//
//    public void SaveStudentOnAction(ActionEvent actionEvent) {
//    }
//
//    public void DeleteOnAction(ActionEvent actionEvent) {
//    }
//}

    StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    // StudentBO studentBO=new StudentBOImpl();

    public void initialize() throws IOException {

        cmbGender.getItems().addAll("Male","Female");

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));

        initUI();

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnDelete.setDisable(false);

            if(newValue != null){
                txtStudentId.setText(newValue.getStudentID());
                txtStudentName.setText(newValue.getStudentName());
                txtAddress.setText(newValue.getAddress());
                txtConNo.setText(newValue.getContactNo());
                txtDOB.setValue(newValue.getDob());
                cmbGender.setValue(newValue.getGender());

                txtStudentId.setDisable(false);
                txtStudentName.setDisable(false);
                txtAddress.setDisable(false);
                txtConNo.setDisable(false);
                txtDOB.setDisable(false);
                cmbGender.setDisable(false);

                btnSave.setDisable(false);
            }
        });

        loadAllStudents();
    }



    private void loadAllStudents(){
        tblStudent.getItems().clear();
        try {
            List<StudentDTO> allStudents = studentBO.getAllStudent();
            for(StudentDTO s : allStudents) {
                tblStudent.getItems().add(new StudentTM(
                        s.getStudentID(),
                        s.getStudentName(),
                        s.getAddress(),
                        s.getContactNo(),
                        s.getDob(),
                        s.getGender()));
            }
        } catch (Exception e) {
            // System.out.println(e);
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
            e.printStackTrace();
        }
    }
    private void clearFields(){
        txtStudentId.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtConNo.clear();
        txtDOB.setValue(null);
        cmbGender.setValue(null);
    }

    private void initUI() {
        txtStudentId.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtConNo.clear();
        // txtDOB.clear();
        txtStudentId.setDisable(true);
        txtStudentName.setDisable(true);
        txtAddress.setDisable(true);
        txtConNo.setDisable(true);
        txtDOB.setDisable(true);
        cmbGender.setDisable(true);
        txtStudentId.setEditable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }

    public void AddNewStudentOnAction(ActionEvent actionEvent) {
        txtStudentId.setDisable(false);
        txtStudentName.setDisable(false);
        txtAddress.setDisable(false);
        txtConNo.setDisable(false);
        txtDOB.setDisable(false);
        cmbGender.setDisable(false);
        txtStudentId.clear();
        // txtItemCode.setText(generateNewId());
        txtStudentName.clear();
        txtAddress.clear();
        txtConNo.clear();
        // txtDOB.clear();
        txtStudentId.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblStudent.getSelectionModel().clearSelection();
    }

    public void SaveStudentOnAction(ActionEvent actionEvent) throws IOException {


        String id = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtAddress.getText();
        String contact_no = txtConNo.getText();
        LocalDate dob = txtDOB.getValue();
        String gender = cmbGender.getValue();

        if (!id.matches("^(S00)[0-9]{1,5}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid ID").show();
            txtStudentId.requestFocus();
            return;

        }else if (!name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtStudentName.requestFocus();
            return;
        } else if (!address.matches("^[A-z0-9 ,/]{4,20}$")) {
            new Alert(Alert.AlertType.ERROR, "Address should be at least 3 characters long").show();
            txtAddress.requestFocus();
            return;
        }else if (!contact_no.matches("^07(7|6|8|1|2|5|0|4)-[0-9]{7}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Number").show();
            txtConNo.requestFocus();
            return;
        }
        if (btnSave.getText().equalsIgnoreCase("Save")) {


            if (studentBO.saveStudent(new StudentDTO(id, name, address, contact_no, dob, gender)))
            {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                tblStudent.getItems().add(new StudentTM(id, name, address, contact_no, dob, gender));
                clearFields();
            }else{
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();

            }


        } else {
            try {
                if (studentBO.updateStudent(new StudentDTO(id, name, address, contact_no, dob, gender))) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
                    loadAllStudents();
                    clearFields();
                }
            } catch (Exception e) {
                // System.out.println("Exception 2");
                //System.out.println(e);
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
            }
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws IOException {
        StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();
        // System.out.println(selectedItem.get);
        if (studentBO.deleteStudent(selectedItem.getStudentID())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted SuccessFully").show();
            initUI();
            loadAllStudents();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Went Wrong !!").show();

        }

    }


}


