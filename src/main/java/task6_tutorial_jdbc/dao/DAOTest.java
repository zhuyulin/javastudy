package task6_tutorial_jdbc.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task6_tutorial_jdbc.dateobject.AvgGradeDO;
import task6_tutorial_jdbc.dateobject.EnrollsDO;
import task6_tutorial_jdbc.dateobject.StudentsDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class DAOTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring/jdbc.xml");
        StudentsDAO studentsDAO = factory.getBean(StudentsDAO.class);


        /**
         * task1：找出籍贯为河北的男生的姓名和年龄。
         */

        List<StudentsDO> taskList1 = studentsDAO.findByPlace("河北");
        System.out.println("【1.找出籍贯为河北的男生的姓名和年龄。】");
        for (int i = 0; i < taskList1.size(); i++) {
            System.out.println("姓名：" + taskList1.get(i).getSname() + " " + "年龄：" + taskList1.get(i).getAge());
        }

        /**
         * task2：找出年龄在 20 ～ 23 岁之间的学生，并按年龄升序排序。
         */
        List<StudentsDO> taskList2 = studentsDAO.findByAge(20, 23);
        System.out.println("【2.找出年龄在 20 ～ 23 岁之间的学生，并按年龄升序排序。】");
        for (int i = 0; i < taskList2.size(); i++) {
            System.out.println(taskList2.get(i).toString());
        }
        /**
         * task3：找出年龄小于 23 岁、籍贯是河南或河北的学生。
         */
        List<StudentsDO> taskList3 = studentsDAO.findByAgeAndPlace(23, "河南", "河北");
        System.out.println("【3.找出年龄小于 23 岁、籍贯是河南或河北的学生。】");
        for (int i = 0; i < taskList3.size(); i++) {
            System.out.println(taskList3.get(i).toString());
        }

        /**
         * task4：找出学生表中籍贯是空值的学生.
         */
        List<StudentsDO> taskList4 = studentsDAO.findByPlaceNull();
        System.out.println("【4.找出学生表中籍贯是空值的学生】");
        for (int i = 0; i < taskList4.size(); i++) {
            System.out.println(taskList4.get(i).toString());
        }

        /**
         * task5：查出课程成绩在 80 分以上的女学生的姓名、课程名和成绩。（ FROM 子句中的子查询）
         */
        List<EnrollsDO> taskList5 = studentsDAO.findByGrade(80, "F");
        System.out.println("【5.查出课程成绩在 80 分以上的女学生的姓名、课程名和成绩。】");
        for (int i = 0; i < taskList5.size(); i++) {
            System.out.println("姓名：" + taskList5.get(i).getSname() + " " + "课程名：" + taskList5.get(i).getCname() +
                    " " + "成绩：" + taskList5.get(i).getGrade());
        }


        /**
         * task6：找出学生的平均成绩和所学课程门数。
         */
        List<AvgGradeDO> taskList6 = studentsDAO.sumAvgGrade();
        System.out.println("【6.找出学生的平均成绩和所学课程门数。】");
        for (int i = 0; i < taskList6.size(); i++) {
            System.out.println("姓名：" + taskList6.get(i).getSname() + " " + "平均成绩：" + taskList6.get(i).getAvggrade()
                    + " " +"课程数量：" + taskList6.get(i).getCoursenumber());
        }

        /**
         * task7：查询没有选任何课程的学生。
         */



    }
}

