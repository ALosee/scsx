import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.service.AcademyService;
import cn.zyj.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAcademy {


    @Autowired
    private AcademyService academyService;


    @Test
    public void testSelectById(){


        int id = 6;

        AcademyInfo academyInfo = academyService.selectById(id);

        System.out.println(academyInfo);


    }

    @Test
    public void testUpdate(){


        AcademyInfo academyInfo = new AcademyInfo();

        academyInfo.setId(6);
        academyInfo.setAcademyName("家里蹲学院");
        academyInfo.setOperateTime(new Date());
        academyInfo.setOperator(1);

        int row = academyService.update(academyInfo);

        System.out.println(row);


    }

    @Test
    public void testList(){


//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        AdminService adminService =(AdminService) context.getBean("adminService");

        List<AcademyInfo> all = academyService.findAll();

        System.out.println(all);


    }

    @Test
    public void testSave(){


        AcademyInfo academyInfo = new AcademyInfo();

        academyInfo.setAcademyName("史莱克学院");
        academyInfo.setCreateTime(new Date());
        academyInfo.setCreator(6);

        int row = academyService.save(academyInfo);

        System.out.println(row);


    }



}
