package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> getAllStudent() throws IOException;

    boolean saveStudent(StudentDTO dto) throws IOException;

    boolean updateStudent(StudentDTO dto) throws IOException;

    boolean deleteStudent(String id) throws IOException;
}
