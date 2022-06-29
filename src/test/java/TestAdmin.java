import cn.zyj.bean.AdminInfo;
import cn.zyj.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAdmin {


    @Autowired
    AdminService adminService;

    @Test
    public void test(){


//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        AdminService adminService =(AdminService) context.getBean("adminService");

        AdminInfo admin = adminService.login("admin", "11111");

        System.out.println(admin);


    }



}
