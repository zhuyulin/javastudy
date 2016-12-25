package task5_jbdc_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task5_jbdc_demo.dao.StudentDAO;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/25.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public List<StudentDO> findByName(String name){
        return studentDAO.findByName(name);
    }
}
