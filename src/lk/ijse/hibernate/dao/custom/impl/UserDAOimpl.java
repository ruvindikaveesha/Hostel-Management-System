package lk.ijse.hibernate.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hibernate.dao.custom.UserDAO;
import lk.ijse.hibernate.entity.Reservation;
import lk.ijse.hibernate.entity.UserLogin;
import lk.ijse.hibernate.util.FactoryConfiguration;
import lk.ijse.hibernate.view.tm.RemainKeyMnyTM;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO {
    @Override
    public List<UserLogin> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM userlogin ";
        Query query = session.createQuery(hql);
        List<UserLogin> userLogins = query.list();

        transaction.commit();
        session.close();
        return userLogins;
    }
//        return null;
//    }

    @Override
    public boolean save(UserLogin entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(UserLogin entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean delete(String s) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Reservation reservation = session.load(Reservation.class, s);

        session.delete(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean find(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String generateNewID() throws IOException {
        return null;

    }

    @Override
    public UserLogin search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();

        UserLogin user = session.find(UserLogin.class, s);

        session.close();
        return user;
    }
}




