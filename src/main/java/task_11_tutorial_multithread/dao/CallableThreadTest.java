package task_11_tutorial_multithread.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import task_11_tutorial_multithread.dateobject.StudentDO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Yuleen on 2016/12/17.
 */

public class CallableThreadTest {
    public static class ThreadTest implements Callable{
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }
        @Override
        public String call() throws Exception {
            StudentDAO studentDAO=new StudentDAO();
            List<StudentDO> studentDOList = studentDAO.findByName(name);
            return "name=" + name +";id="+studentDOList.get(0).getSno();

        }
    }
        public static void main(String[] args) {
            ThreadTest task1 = new ThreadTest("张三");
            ThreadTest task2 = new ThreadTest("李四");
            ThreadTest task3 = new ThreadTest("王五");
            // 创建一个执行任务的服务
            ExecutorService es = Executors.newFixedThreadPool(3);
            try {
                // 提交并执行任务，任务启动时返回了一个 Future对象，
                // 如果想得到任务执行的结果或者是异常可对这个Future对象进行操作
                Future future1 = es.submit(task1);
                // 获得第一个任务的结果，如果调用get方法，当前线程会等待任务执行完毕后才往下执行
                System.out.println(future1.get());
                Future future2 = es.submit(task2);
                System.out.println(future2.get());

                Future future3 = es.submit(task3);
                System.out.println(future3.get());
            } catch (Exception e){
                System.out.println(e.toString());
            }
            // 停止任务执行服务
            es.shutdownNow();
        }
}