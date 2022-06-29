import cn.zyj.bean.StudentInfo;
import cn.zyj.mapper.StudentMapper;
import cn.zyj.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xieYF
 * 2022/6/28 0:34
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentTest {


    @Autowired
    private StudentService studentService;

    @Test
    public void test01(){
        List<StudentInfo> studentInfos = studentService.selectAll();
        studentInfos.forEach(studentInfo -> System.out.println(studentInfo));
    }
}
