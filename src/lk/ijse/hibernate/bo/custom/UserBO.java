package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.UserLoginDTO;
import lk.ijse.hibernate.entity.UserLogin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    List<UserLoginDTO> getAllUser() throws IOException;

    boolean saveUser(UserLoginDTO dto) throws IOException;

    boolean updateUser(UserLoginDTO dto) throws IOException;

    boolean deleteUser(String id) throws IOException;

    UserLogin searchUser(String id) throws IOException, SQLException, ClassNotFoundException;
}

