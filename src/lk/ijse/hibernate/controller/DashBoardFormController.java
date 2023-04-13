package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DashBoardFormController {
    public AnchorPane DashBoardFormContext;
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnLogOut;
    public AnchorPane DashBoard2Context;
    static LocalDate date;


    public void initialize() throws SQLException, ClassNotFoundException {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            lblTime.setText(LocalDateTime.now().format(formatter));
            lblDate.setText(LocalDateTime.now().format(formatter1));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }


    public void ManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/ManageStudentForm.fxml"));
        DashBoard2Context.getChildren().clear();
        DashBoard2Context.getChildren().add(parent);
    }


    public void ManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/ManageRoomForm.fxml"));
        DashBoard2Context.getChildren().clear();
        DashBoard2Context.getChildren().add(parent);
    }


    public void ReservationOnAction(ActionEvent actionEvent) throws IOException {
        DashBoard2Context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"));
        DashBoard2Context.getChildren().add(parent);
    }

    public void LOGOUTOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to log out", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.YES)) {
            URL resource = getClass().getResource("../view/LoginForm.fxml");
            Parent load = FXMLLoader.load(resource);
            DashBoardFormContext.getChildren().clear();
            DashBoardFormContext.getChildren().add(load);
        }
    }

    public void LogInDetailOnAction(ActionEvent actionEvent) throws IOException {
        DashBoard2Context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LoginDetailForm.fxml"));
        DashBoard2Context.getChildren().add(parent);

    }

    public void RemainKeyMoneyOnAction(ActionEvent actionEvent) throws IOException {
        DashBoard2Context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/RemainKeyMoneyForm.fxml"));
        DashBoard2Context.getChildren().add(parent);
    }



}