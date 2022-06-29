import cn.zyj.bean.OptionInfo;
import cn.zyj.bean.PaperInfo;
import cn.zyj.service.OptionService;
import cn.zyj.service.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestPaper {


    @Autowired
    private PaperService paperService;




    @Test
    public void testSelectIdType(){


        List<PaperInfo> exam = paperService.findExam();

        System.out.println(exam);
    }


    @Test
    public void testFindPaperMes(){


        PaperInfo exam = paperService.findPaperMes(1);

        System.out.println(exam);
    }





}
