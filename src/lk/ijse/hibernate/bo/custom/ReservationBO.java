package lk.ijse.hibernate.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.ReservationDTO;
import lk.ijse.hibernate.view.tm.RemainKeyMnyTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    ArrayList<ReservationDTO> getAllReserveDetails() throws SQLException, ClassNotFoundException;

    public ArrayList<ReservationDTO> searchReserveDetails(String enteredText) throws SQLException, ClassNotFoundException;

    ObservableList<RemainKeyMnyTM> getRemainKeyMnyStudent() throws SQLException, ClassNotFoundException, IOException;

}
