package cn.zyj.controller;

import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.MajorInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.service.AcademyService;
import cn.zyj.service.MajorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private MajorService majorService;
    @Autowired
    private AcademyService academyService;

    @RequestMapping("/findByPage")
    public String findByPage(@RequestParam(defaultValue = "1")int pageNum,Model model){

        int pageSize = 5;//定义每页显示几条数据
        PageHelper.startPage(pageNum,pageSize);
        List<MajorInfo> all = majorService.findAll();
        PageInfo<MajorInfo> pageInfo = new PageInfo<>(all);
        model.addAttribute("majors",all);
        model.addAttribute("pageInfo",pageInfo);
        return "/jsp/admin/major/major_list.jsp";

    }


    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<MajorInfo> all = majorService.findAll();
        model.addAttribute("majors",all);
        return "/jsp/admin/major/major_list.jsp";
    }

    //跳转到新增页面
    @RequestMapping("/add_page")
    public String addPage(Model model){
        List<AcademyInfo> all = academyService.findAll();
        model.addAttribute("academy_list",all);
        return "/jsp/admin/major/major_add.jsp";
    }

    //执行学院新增
    @RequestMapping("/add_save")
    public String addSave(MajorInfo academyInfo, Model model, HttpSession session){

        academyInfo.setCreateTime(new Date());
        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        academyInfo.setCreator(adminInfo.getId());
        int row = majorService.save(academyInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行学院新增成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行学院新增操作失败");
            return "/result.jsp";
        }
    }

    //跳转到新增页面
    @RequestMapping("/updatePage")
    public String updatePage(int id,Model model){

        MajorInfo academyInfo = majorService.selectById(id);

        model.addAttribute("academy_info",academyInfo);

        return "/jsp/admin/academy/academy_edit.jsp";

    }

    //执行学院新增
    @RequestMapping("/update_save")
    public String updateSave(MajorInfo academyInfo, Model model, HttpSession session){
        academyInfo.setOperateTime(new Date());
        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        academyInfo.setOperator(adminInfo.getId());
        int row = majorService.update(academyInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行学院修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行学院修改操作失败");
            return "/result.jsp";
        }

    }

    @RequestMapping("/deleteByIds")
    public String deleteByIds(int[] ids, Model model){
        int row = majorService.deleteByIds(ids);
        List<MajorInfo> all = majorService.findAll();
        model.addAttribute("major_list",all);
        if (row != 0){
            model.addAttribute("tip_info","执行学院删除成功");
            return "/jsp/admin/major/major_list.jsp";
        }else{
            model.addAttribute("tip_info","执行学院删除操作失败");
            return "/jsp/admin/major/major_list.jsp";
        }
    }

}
