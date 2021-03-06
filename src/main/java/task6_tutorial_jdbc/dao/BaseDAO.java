package task6_tutorial_jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Yuleen on 2016/12/17.
 */
public abstract class BaseDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
