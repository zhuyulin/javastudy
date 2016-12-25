package task5_jbdc_demo.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import common.AbsSpringTest;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/25.
 */
@ContextConfiguration(locations = {"classpath:spring/spring-task5.xml"})
public class TestStudentDAO extends AbsSpringTest{
    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void findByNameTest(){
        List<StudentDO> studentDOList = studentDAO.findByName("张");
        System.out.println(studentDOList.size());
        Assert.assertTrue(studentDOList.size() > 0);
    }
}
