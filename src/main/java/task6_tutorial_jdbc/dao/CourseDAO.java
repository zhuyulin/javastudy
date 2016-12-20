package task6_tutorial_jdbc.dao;

import task6_tutorial_jdbc.dateobject.CourseDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/20.
 */
public class CourseDAO extends StudentsDAO {

    public List<CourseDO> findByGrade(Integer grade, String sex){
        List<CourseDO> courseDOList =
                getJdbcTemplate().query("select\n" +
                                "st.sname AS sname,\n" +
                                "c.cname AS cname,\n" +
                                "e.grade AS grade\n" +
                                "from\n" +
                                "students st\n" +
                                "LEFT JOIN\n" +
                                "enrolls e on e.sno=st.sno\n" +
                                "LEFT JOIN\n" +
                                "courses c on c.cno=e.cno\n" +
                                "where \n" +
                                "e.grade > ? and st.sex = ?",
                        new CourseDO(),new Object[]{grade,sex});
        return courseDOList;
    }
}
