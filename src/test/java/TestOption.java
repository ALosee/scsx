import cn.zyj.bean.MajorInfo;
import cn.zyj.bean.OptionInfo;
import cn.zyj.service.MajorService;
import cn.zyj.service.OptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOption {


    @Autowired
    private OptionService optionService;




    @Test
    public void testSelectIdType(){


        OptionInfo optionInfo = optionService.selectIdType(1, "A");

        System.out.println(optionInfo);
    }






}
