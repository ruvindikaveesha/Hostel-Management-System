package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.UserBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.custom.UserDAO;
import lk.ijse.hibernate.dto.UserLoginDTO;
import lk.ijse.hibernate.entity.UserLogin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOimpl implements UserBO {
    UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public List<UserLoginDTO> getAllUser() throws IOException {
        List<UserLogin> all = userDAO.getAll();
        ArrayList<UserLoginDTO> allUser = new ArrayList<>();

        for(UserLogin u: all){
            allUser.add(new UserLoginDTO(
                    u.getUser_id(),
                    u.getUser_name(),
                    u.getPassword()
            ));
        }

        return allUser;
    }




    @Override
    public boolean saveUser(UserLoginDTO dto) throws IOException {
        return userDAO.save(new UserLogin(
                dto.getUserID(),
                dto.getUserName(),
                dto.getPassword()


        ));

    }

    @Override
    public boolean updateUser(UserLoginDTO dto) throws IOException {
        return userDAO.update(new UserLogin(
                dto.getUserID(),
                dto.getUserName(),
                dto.getPassword()


        ));
    }




    @Override
    public boolean deleteUser(String id) throws IOException {
        return userDAO.delete(id);
    }

    @Override
    public UserLogin searchUser(String id) throws IOException, SQLException, ClassNotFoundException {
       return userDAO.search(id);
    }
}