package cn.zyj.controller;

import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/academy")
public class AcademyController {

    @Autowired
    private AcademyService academyService;


    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<AcademyInfo> all = academyService.findAll();
        model.addAttribute("academy_list",all);
        return "/jsp/admin/academy/academy_list.jsp";
    }



    //跳转到新增页面
    @RequestMapping("/add_page")
    public String addPage(){
        return "/jsp/admin/academy/academy_add.jsp";
    }

    //执行学院新增
    @RequestMapping("/add_save")
    public String addSave(AcademyInfo academyInfo, Model model, HttpSession session){

        academyInfo.setCreateTime(new Date());
        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        academyInfo.setCreator(adminInfo.getId());
        int row = academyService.save(academyInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行学院新增成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行学院新增操作失败");
            return "/result.jsp";
        }
    }

    //跳转到新增页面
    @RequestMapping("/update_page")
    public String updatePage(int id,Model model){
        AcademyInfo academyInfo = academyService.selectById(id);
        model.addAttribute("academy_info",academyInfo);
        return "/jsp/admin/academy/academy_edit.jsp";
    }

    //执行学院新增
    @RequestMapping("/update_save")
    public String updateSave(AcademyInfo academyInfo, Model model, HttpSession session){

        academyInfo.setOperateTime(new Date());
        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        academyInfo.setOperator(adminInfo.getId());
        int row = academyService.update(academyInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行学院修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行学院修改操作失败");
            return "/result.jsp";
        }
    }

    @RequestMapping("/delete")
    public String deleteById(int id,Model model){

        int row = academyService.deleteById(id);

        List<AcademyInfo> all = academyService.findAll();

        model.addAttribute("academy_list",all);

        if (row != 0){

            model.addAttribute("tip_info","执行学院删除成功");

            return "/jsp/admin/academy/academy_list.jsp";
        }else{
            model.addAttribute("tip_info","执行学院删除操作失败");

            return "/jsp/admin/academy/academy_list.jsp";

        }

    }

    @RequestMapping("/deleteByIds")
    public String deleteByIds(int[] ids,Model model, HttpServletRequest request){
        int row = academyService.deleteByIds(ids);
        List<AcademyInfo> all = academyService.findAll();
        model.addAttribute("academy_list",all);
        if (row != 0){
            model.addAttribute("tip_info","执行学院删除成功");
            return "/jsp/admin/academy/academy_list.jsp";
        }else{
            model.addAttribute("tip_info","执行学院删除操作失败");
            return "/jsp/admin/academy/academy_list.jsp";

        }


    }



}
