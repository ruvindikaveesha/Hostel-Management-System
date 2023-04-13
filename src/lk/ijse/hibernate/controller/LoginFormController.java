package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.UserBO;
import lk.ijse.hibernate.bo.custom.impl.UserBOimpl;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.UserDAO;
import lk.ijse.hibernate.entity.UserLogin;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane LoginContext;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public Button btnLogin;
    public Label lblLoginText;

//    public void LoginOnAction(ActionEvent actionEvent) {

    UserBO userBO = new UserBOimpl();

    public void LoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        String name = txtUserName.getText();
        String password = txtPassword.getText();

        UserLogin user = userBO.searchUser(name);
        // UserLogin password2=userBO.searchUser(password);

        if (user != null) {
            if (txtPassword.getText().equals(user.getPassword())) {
                setUI("DashBoardForm");
                //new Alert(Alert.AlertType.CONFIRMATION, "").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Incorrect Password..!").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Incorrect User Name!").show();

        }


    }



    private void setUI(String location) throws IOException {
        Stage stage = (Stage) LoginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}

