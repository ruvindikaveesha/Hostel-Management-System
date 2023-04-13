package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.RoomDTO;

import java.io.IOException;
import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO> getAllRooms() throws IOException;

    boolean saveRoom(RoomDTO dto) throws IOException;

    boolean updateRoom(RoomDTO dto) throws IOException;

    boolean deleteRoom(String id) throws IOException;
}

