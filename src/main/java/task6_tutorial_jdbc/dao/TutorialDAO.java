package task6_tutorial_jdbc.dao;

import task6_tutorial_jdbc.dateobject.CourseDO;
import task6_tutorial_jdbc.dateobject.TutorialDO;
import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class TutorialDAO extends BaseDAO {
    public List<TutorialDO> findByPlace(String place){
        List<TutorialDO> studentDOList1 = getJdbcTemplate().query("select * from students where bplace like ?"
                ,new TutorialDO(),new Object[]{"%"+place+"%"});
        return studentDOList1;
    }

    public List<TutorialDO> findByAge(Integer x, Integer y){
        List<TutorialDO> studentDOList =
                getJdbcTemplate().query("select * from students where  age between ? and ? order by age asc "
                ,new TutorialDO(),new Object[]{x,y});
        return studentDOList;
    }

    public List<TutorialDO> findByAgeAndPlace(Integer x,String y,String z){
        List<TutorialDO> studentDOList =
                getJdbcTemplate().query("select * from students where  age < ? and (bplace = ? or bplace = ?) "
                        ,new TutorialDO(),new Object[]{x,y,z});
        return studentDOList;
    }

    public List<TutorialDO> findByPlaceNull(){
        List<TutorialDO> studentDOList =
                getJdbcTemplate().query("select * from students where  bplace is null "
                        ,new TutorialDO());
        return studentDOList;
    }


}