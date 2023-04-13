package lk.ijse.hibernate.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.custom.ReservationBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.custom.ReservationDAO;
import lk.ijse.hibernate.dto.ReservationDTO;
import lk.ijse.hibernate.view.tm.RemainKeyMnyTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOimpl implements ReservationBO {
    ReservationDAO reservationDAO=DAOFactory.getInstance().getDAO(DAOType.RESERVATION);

    @Override
    public ArrayList<ReservationDTO> getAllReserveDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ReservationDTO> searchReserveDetails(String enteredText) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<RemainKeyMnyTM> getRemainKeyMnyStudent() throws SQLException, ClassNotFoundException, IOException {
        return reservationDAO.getRemainKeyMoney();
    }
}
