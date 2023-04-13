package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.entity.Room;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOimpl implements RoomDAO {

    @Override
    public List<Room> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM room ";
            Query query = session.createQuery(hql);
            List<Room> rooms = query.list();

            transaction.commit();
            session.close();
            return rooms;
    }

    @Override
    public boolean save(Room entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws IOException {
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

        Student student = session.load(Student.class, s);

        session.delete(student);

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
    public Room search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room= session.get(Room.class,s);



        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public List getRoomIds() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("select room_type_id FROM room");
        List roomIds=query.list();
        transaction.commit();
        session.close();
        return roomIds;
    }
}
