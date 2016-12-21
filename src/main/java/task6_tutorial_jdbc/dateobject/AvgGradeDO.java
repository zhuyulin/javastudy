package task6_tutorial_jdbc.dateobject;

import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class AvgGradeDO implements RowMapper, Serializable {

    private String sname;

    private Double avggrade;

    private Integer coursenumber;


    public Integer getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(Integer coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getAvggrade() {
        return avggrade;
    }

    public void setAvggrade(Double avggrade) {
        this.avggrade = avggrade;
    }

    @Override
    public String toString() {
        return "AvgGradeDO{" +
                "sname='" + sname + '\'' +
                ", avggrade=" + avggrade +
                ", coursenumber='" + coursenumber + '\'' +
                '}';
    }

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        AvgGradeDO avggradeDO = new AvgGradeDO();
        avggradeDO.setSname(rs.getString("sname"));
        avggradeDO.setAvggrade(rs.getDouble("avggrade"));
        avggradeDO.setCoursenumber(rs.getInt("coursenumber"));
        return avggradeDO;
    }

}

