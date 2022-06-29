import cn.zyj.bean.MajorInfo;
import cn.zyj.service.MajorService;
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
public class TestMajor {


    @Autowired
    private MajorService majorService;


    @Test
    public void testPage(){



        PageHelper.startPage(1,2);
        List<MajorInfo> all = majorService.findAll();

        for (MajorInfo majorInfo : all) {
            System.out.println(majorInfo);
        }

        PageInfo<MajorInfo> pageInfo = new PageInfo<MajorInfo>(all);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());

    }

    @Test
    public void testSelectById(){


    }

    @Test
    public void testUpdate(){


    }

    @Test
    public void testList(){

        List<MajorInfo> all = majorService.findAll();

        System.out.println(all);
    }

    @Test
    public void testSave(){



    }

    @Test
    public void deleteById(){





    }




}
