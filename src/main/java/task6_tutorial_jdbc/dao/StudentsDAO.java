package task6_tutorial_jdbc.dao;

import task6_tutorial_jdbc.dateobject.StudentsDO;
import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class StudentsDAO extends BaseDAO {
    public List<StudentsDO> findByPlace(String place){
        List<StudentsDO> studentDOList1 = getJdbcTemplate().query("select * from students where bplace like ?"
                ,new StudentsDO(),new Object[]{"%"+place+"%"});
        return studentDOList1;
    }

    public List<StudentsDO> findByAge(Integer x, Integer y){
        List<StudentsDO> studentDOList =
                getJdbcTemplate().query("select * from students where  age between ? and ? order by age asc "
                ,new StudentsDO(),new Object[]{x,y});
        return studentDOList;
    }

    public List<StudentsDO> findByAgeAndPlace(Integer x, String y, String z){
        List<StudentsDO> studentDOList =
                getJdbcTemplate().query("select * from students where  age < ? and (bplace = ? or bplace = ?) "
                        ,new StudentsDO(),new Object[]{x,y,z});
        return studentDOList;
    }

    public List<StudentsDO> findByPlaceNull(){
        List<StudentsDO> studentDOList =
                getJdbcTemplate().query("select * from students where  bplace is null "
                        ,new StudentsDO());
        return studentDOList;
    }


}