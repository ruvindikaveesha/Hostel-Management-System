package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Room;

import java.io.IOException;
import java.util.List;

public interface RoomDAO extends CrudDAO <Room,String >{
    public List getRoomIds() throws IOException;
}
