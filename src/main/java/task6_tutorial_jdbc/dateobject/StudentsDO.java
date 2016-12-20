package task6_tutorial_jdbc.dateobject;
import org.springframework.jdbc.core.RowMapper;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class StudentsDO implements RowMapper,Serializable{
    private Integer id;

    private String sno;

    private String sname;

    private Integer age;

    private String sex;

    private String bplace;

    private String cname;

    private Integer grade;

    @Override
    public String toString() {
        return "StudentDO={" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", bplace='" + bplace + '\'' +
                '}';
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBplace() { return bplace; }

    public void setBplace(String bplace) { this.bplace = bplace; }

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        StudentsDO studentsDO = new StudentsDO();
        studentsDO.setId(rs.getInt("id"));
        studentsDO.setSno(rs.getString("sno"));
        studentsDO.setSname(rs.getString("sname"));
        studentsDO.setAge(rs.getInt("age"));
        studentsDO.setSex(rs.getString("sex"));
        studentsDO.setBplace(rs.getString("bplace"));
        //studentsDO.setCname(rs.getString("cname"));
        //studentsDO.setGrade(rs.getInt("grade"));
        return studentsDO;
    }

}
