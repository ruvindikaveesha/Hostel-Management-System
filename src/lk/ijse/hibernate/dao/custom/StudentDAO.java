package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    public List<String> getStudentIds() throws IOException;
}
