package task_11_tutorial_multithread.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import task_11_tutorial_multithread.dateobject.StudentDO;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yuleen on 2016/12/17.
 */
@ContextConfiguration(locations = {"classpath:spring/spring-task5.xml"})
public class CallableThreadTest{
    public static class ThreadTest implements Callable{
        @Autowired StudentDO studentDAO;
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }
        @Override
        public String call() throws Exception {
            StudentDAO studentDAO= new StudentDAO();
            List<StudentDO> studentDOList = studentDAO.findByName(name);
            return "name=" + name +";id="+studentDOList.get(0).getSno();

        }
    }
        public static void main(String[] args) {
            // 创建一个执行任务的服务
            ExecutorService pool = Executors.newFixedThreadPool(3);
            Callable c1 = new ThreadTest("张三");
            Callable c2 = new ThreadTest("李四");
            Callable c3 = new ThreadTest("王五");
            pool.submit(c1);
            pool.submit(c2);
            pool.submit(c3);
            // 停止任务执行服务
            pool.shutdownNow();
        }
}