import cn.zyj.bean.PaperInfo;
import cn.zyj.service.PaperService;
import cn.zyj.service.StudentAnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestStudent {


    @Autowired
    private StudentAnswerService studentAnswerService;


    @Test
    public void testSelectIdType(){


        int examFlag = studentAnswerService.registerExam(1903);

        System.out.println(examFlag);
    }






}
