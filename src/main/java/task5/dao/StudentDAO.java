package task5.dao;
import task5.dateobject.StudentDO;
import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class StudentDAO extends BaseDAO {
    public Integer countStudent(){
        Integer count = getJdbcTemplate().queryForObject("select count(*) from students",Integer.class);
        return count;
    }
    public List<StudentDO> findByName(String name){
        List<StudentDO> studentDOList = getJdbcTemplate().query("select * from students where sname like ?"
                ,new StudentDO(),new Object[]{"%"+name+"%"});
        return studentDOList;
    }
}