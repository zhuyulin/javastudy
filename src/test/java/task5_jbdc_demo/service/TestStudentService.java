package task5_jbdc_demo.service;

import common.AbsSpringMockTest;
import common.AbsSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import task5_jbdc_demo.dao.StudentDAO;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Yuleen on 2016/12/25.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-task5.xml"})
public class TestStudentService extends AbsSpringMockTest {
    @InjectMocks
    @Autowired
    private StudentService studentService;

    @Mock
    private StudentDAO studentDAO = new StudentDAO();

    @Test
    public void findByName(){
        List<StudentDO> studentDOS = new ArrayList<StudentDO>();
        StudentDO studentDO = new StudentDO();
        studentDO.setSno("1123");
        studentDO.setSname("张三");
        studentDOS.add(studentDO);
        when(studentDAO.findByName(any(String.class))).thenReturn(studentDOS);
        List<StudentDO> dos = studentService.findByName("abc");
        Assert.assertEquals(dos.get(0).getSno(),"1123");
    }

    @Test
    public void testTransactional(){
        studentService.update2Student(1,2,20,true);
        try {
            studentService.update2Student(1, 2, 16, false);
        }catch (Exception e){
            System.out.println("error");
        }
    }

    @Test
    public void testNoTransactional(){
        studentService.update2Student(1,2,20,true);
        try {
            studentService.update2StudentNoTrans(1, 2, 16, false);
        }catch (Exception e){
            System.out.println("error");
        }
    }

    @Test
    public void testTransactional2(){
        studentService.update2Student(1,2,20,true);
        try {
            studentService.update2Student2(1, 2, 16, false);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
