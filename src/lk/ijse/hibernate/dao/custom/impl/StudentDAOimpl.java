package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOimpl implements StudentDAO {

    @Override
    public List<Student> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM student";
        Query query=session.createQuery(hql);
        List<Student> students=query.list();

        transaction.commit();
        session.close();
        return students;
    }

    @Override
    public boolean save(Student entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Student entity) throws IOException {
       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction=session.beginTransaction();

       session.update(entity);

       transaction.commit();
       session.close();
       return true;
    }

    @Override
    public boolean delete(String s) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student= session.load(Student.class, s);

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
    public Student search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student= session.get(Student.class,s);



        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public List<String> getStudentIds() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("select student_id FROM student");
        List studentIds=query.list();
        transaction.commit();
        session.close();
        return studentIds;
    }
}
