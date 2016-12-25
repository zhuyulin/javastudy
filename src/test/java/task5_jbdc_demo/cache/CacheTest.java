package task5_jbdc_demo.cache;

import common.AbsSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import task5_jbdc_demo.dao.StudentDAO;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/25.
 */
@ContextConfiguration(locations = {"classpath:spring/spring-task5.xml"})
public class CacheTest extends AbsSpringTest {
    @Autowired
    private StudentCache studentCache;

    @Test
    public void findByNameTest(){
        List<StudentDO> studentDOS = studentCache.getStudentDOList();
        Assert.assertTrue(studentDOS.get(0).getSname().contains("张"));
    }

}
