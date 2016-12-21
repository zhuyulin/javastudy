package task5_jbdc_demo.dao;
import task5_jbdc_demo.dateobject.StudentDO;
import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class StudentDAO extends BaseDAO {
    public List<StudentDO> findByName(String name){
        List<StudentDO> studentDOList = getJdbcTemplate().query("select * from students where sname like ?"
                ,new StudentDO(),new Object[]{"%"+name+"%"});
        return studentDOList;
    }
}