package task5_jbdc_demo.dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class DAOTset {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring/spring-task5.xml");
        StudentDAO studentDAO = factory.getBean(StudentDAO.class);
        List<StudentDO> studentDOList = studentDAO.findByName("张");

        for(int i = 0; i < studentDOList.size(); i++){
            System.out.println(studentDOList.get(i).toString());
        }
    }
}
