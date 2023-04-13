package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.impl.ResevationDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.RoomDAOimpl;
import lk.ijse.hibernate.dao.custom.impl.StudentDAOimpl;
import lk.ijse.hibernate.dao.custom.impl.UserDAOimpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }


    public <T extends SuperDAO>T getDAO(DAOType type){
        switch (type){
            case STUDENT:
                return (T) new StudentDAOimpl();
            case ROOM:
                return (T) new RoomDAOimpl();
            case RESERVATION:
                return (T) new ResevationDAOImpl();
            case USER:
                return (T) new UserDAOimpl();
            default:
                return null;
        }
    }

    }


