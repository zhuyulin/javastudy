package task6_tutorial_jdbc.dao;

import task6_tutorial_jdbc.dateobject.AvgGradeDO;
import task6_tutorial_jdbc.dateobject.EnrollsDO;
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

    public List<EnrollsDO> findByGrade(Integer grade, String sex){
        StringBuilder sbstr = new StringBuilder("select\n" +
                "*\n" +
                "from\n" +
                "students st\n" +
                "LEFT JOIN\n" +
                "enrolls e on e.sno=st.sno\n" +
                "LEFT JOIN\n" +
                "courses c on c.cno=e.cno\n" +
                "where \n" +
                "e.grade > ? and st.sex = ?");

        List<EnrollsDO> studentDOList =
                getJdbcTemplate().query(sbstr.toString(),
                        new EnrollsDO(),new Object[]{grade,sex});
        return studentDOList;
    }


    public List<AvgGradeDO> sumAvgGrade(){
        StringBuilder sbstr = new StringBuilder("SELECT\n" +
                "stu.sname as sname,\n" +
                "sum(e.grade)/count(distinct e.cno) as avggrade,\n" +
                "count(distinct e.cno) as coursenumber\n" +
                "FROM\n" +
                "students stu\n" +
                "LEFT JOIN\n" +
                "enrolls e on e.sno=stu.sno\n" +
                "group by stu.sname");

        List<AvgGradeDO> studentDOList =
                getJdbcTemplate().query(sbstr.toString(),
                        new AvgGradeDO(),null);
        return studentDOList;
    }


    public List<EnrollsDO> noCourseStudent(){
        StringBuilder sbstr = new StringBuilder("select \n" +
                "*" +
                "from \n" +
                "students s\n" +
                "left join\n" +
                "enrolls e on e.sno=s.sno\n" +
                "left join \n" +
                "courses c on c.cno=e.cno\n" +
                "where\n" +
                "c.cno is null");

        List<EnrollsDO> studentDOList =
                getJdbcTemplate().query(sbstr.toString(),
                        new EnrollsDO(),null);
        return studentDOList;
    }


    public List<StudentsDO> allCourseStudent(){
        StringBuilder sbstr = new StringBuilder("select * from students\n" +
                "where sno IN\n" +
                "(select sno from enrolls\n" +
                "group by sno\n" +
                "having count(*) = (select count(*) from courses ))");
        List<StudentsDO> studentDOList =
                getJdbcTemplate().query(sbstr.toString(),
                        new StudentsDO(),null);
        return studentDOList;
    }

}