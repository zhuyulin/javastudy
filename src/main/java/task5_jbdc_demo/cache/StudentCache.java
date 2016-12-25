package task5_jbdc_demo.cache;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import task5_jbdc_demo.dao.StudentDAO;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/25.
 */
@Component
public class StudentCache implements InitializingBean{
    @Autowired
    private StudentDAO studentDAO;

    private List<StudentDO> studentDOList;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("start cache");
        studentDOList = studentDAO.findByName("张");
    }

    public List<StudentDO> getStudentDOList() {
        return studentDOList;
    }

    public void setStudentDOList(List<StudentDO> studentDOList) {
        this.studentDOList = studentDOList;
    }
}
