package task6_tutorial_jdbc.dateobject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuleen on 2016/12/20.
 */
public class CourseDO extends StudentsDO {

    private String cname;

    private String sname;

    private Integer grade;

    @Override
    public String getSname() {
        return sname;
    }

    @Override
    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseDO={" +
                ", sname='" + sname + '\'' +
                '}';
    }

    public Object mapRow(ResultSet rs, int i) throws SQLException {
        CourseDO courseDO = new CourseDO();
        courseDO.setSname(rs.getString("sname"));
        courseDO.setCname(rs.getString("cname"));
        courseDO.setGrade(rs.getInt("grade"));
        return courseDO;
    }
}
