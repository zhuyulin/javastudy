package task6_tutorial_jdbc.dao;

import task6_tutorial_jdbc.dateobject.TutorialDO;
import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class TutorialDAO extends BaseDAO {
    public List<TutorialDO> findByName(String name){
        List<TutorialDO> studentDOList = getJdbcTemplate().query("select * from students where sname like ?"
                ,new TutorialDO(),new Object[]{"%"+name+"%"});
        return studentDOList;
    }
}