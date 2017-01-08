package task5_jbdc_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import task5_jbdc_demo.dao.StudentDAO;
import task5_jbdc_demo.dateobject.StudentDO;

import java.util.List;

/**
 * Created by Yuleen on 2016/12/25.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public List<StudentDO> findByName(String name){
        return studentDAO.findByName(name);
    }

    public void update2StudentNoTrans(Integer id, Integer id2, Integer age, boolean isOk){
        studentDAO.updateAge(id,age);
        if(!isOk) throw new RuntimeException("error");
        studentDAO.updateAge(id2,age);
    }

    //注解方式事物
    @Transactional
    public void update2Student(Integer id, Integer id2, Integer age, boolean isOk){
        studentDAO.updateAge(id,age);
        if(!isOk) throw new RuntimeException("error");
        studentDAO.updateAge(id2,age);
    }

    //编程事物
    public void update2Student2(final Integer id, final Integer id2, final Integer age, final boolean isOk){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                studentDAO.updateAge(id,age);
                if(!isOk) throw new RuntimeException("error");
                studentDAO.updateAge(id2,age);
            }
        });
    }
}
