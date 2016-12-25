package task5_jbdc_demo.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import task5_jbdc_demo.dateobject.StudentDO;
import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
@Repository
public class StudentDAO  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentDO> findByName(String name){
        List<StudentDO> studentDOList = jdbcTemplate.query("select * from students where sname like ?"
                ,new StudentDO(),new Object[]{"%"+name+"%"});
        return studentDOList;
    }
}