package lk.ijse.hibernate.controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOType;
import lk.ijse.hibernate.bo.custom.ReservationBO;
import lk.ijse.hibernate.view.tm.RemainKeyMnyTM;

import java.io.IOException;
import java.sql.SQLException;

public class RemainKeyMoneyFormController {

    public AnchorPane RemainKeyMoneyFormContext;
    public TableView<RemainKeyMnyTM> tblRemainKeyMoney;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStatus;

    ReservationBO reservationBO = BOFactory.getInstance().getBO(BOType.RESERVATION);

    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        tblRemainKeyMoney.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tblRemainKeyMoney.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        tblRemainKeyMoney.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("status"));

        loadRemainKeyMoneyStudent();
    }

    private void loadRemainKeyMoneyStudent() throws SQLException, IOException, ClassNotFoundException {

        ObservableList<RemainKeyMnyTM> remainKeyMnyStudent = reservationBO.getRemainKeyMnyStudent();
        tblRemainKeyMoney.setItems(remainKeyMnyStudent);
    }
}




