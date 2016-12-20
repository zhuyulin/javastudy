package task6_tutorial_jdbc.dateobject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuleen on 2016/12/20.
 */
public class TutorialDO2 extends TutorialDO {

    private String cname;

    private Integer grade;

    @Override
    public String getCname() {
        return cname;
    }

    @Override
    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public Integer getGrade() {
        return grade;
    }

    @Override
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Object mapRow(ResultSet rs, int i) throws SQLException {
        TutorialDO2 tutorialDO = new TutorialDO2();
        tutorialDO.setCname(rs.getString("cname"));
        tutorialDO.setGrade(rs.getInt("grade"));
        return tutorialDO;
    }
}
