package lk.ijse.hibernate.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Reservation;
import lk.ijse.hibernate.view.tm.RemainKeyMnyTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO extends CrudDAO<Reservation,String> {
    public ArrayList<Reservation> searchReservation(String enteredText) throws SQLException, ClassNotFoundException;

    public ObservableList<RemainKeyMnyTM> getRemainKeyMoney() throws SQLException, ClassNotFoundException, IOException;

}



