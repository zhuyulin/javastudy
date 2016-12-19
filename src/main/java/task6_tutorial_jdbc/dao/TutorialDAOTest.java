package task6_tutorial_jdbc.dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task6_tutorial_jdbc.dateobject.TutorialDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class TutorialDAOTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring/jdbc.xml");
        TutorialDAO studentDAO = factory.getBean(TutorialDAO.class);
        List<TutorialDO> studentDOList = studentDAO.findByName("张");

        for(int i = 0; i < studentDOList.size(); i++){
            System.out.println(studentDOList.get(i).toString());
        }
    }
}
