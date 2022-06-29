package cn.zyj.controller;

import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.bean.ClassInfo;
import cn.zyj.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<ClassInfo> all = classService.findAll();
        model.addAttribute("class_list",all);
        return "/jsp/admin/class/class_list.jsp";
    }



    //跳转到新增页面
    @RequestMapping("/addPage")
    public String addPage(){

        return "/jsp/admin/class/class_add.jsp";

    }


    //http://localhost:8080/ssm/admin/class/addSave
    //post
    //执行班级新增
    @RequestMapping("/addSave")
    public String addSave(ClassInfo classInfo, Model model, HttpSession session){

        classInfo.setCreateTime(new Date());

        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        classInfo.setCreator(adminInfo.getId());
        int row = classService.save(classInfo);

        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行班级新增成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行班级新增操作失败");
            return "/result.jsp";
        }
    }


    //http://localhost:8080/ssm/admin/class/updatePage?id=4
    //跳转到修改
    @RequestMapping("/updatePage")
    public String updatePage(int id,Model model){

        ClassInfo classInfo = classService.selectById(id);

        model.addAttribute("class_info",classInfo);

        return "/jsp/admin/class/class_edit.jsp";

    }

    //执行班级修改
    @RequestMapping("/updateSave")
    public String updateSave(ClassInfo classInfo, Model model, HttpSession session){

        classInfo.setOperateTime(new Date());

        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        classInfo.setOperator(adminInfo.getId());
        int row = classService.updateSave(classInfo);

        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行班级修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行班级修改操作失败");
            return "/result.jsp";
        }

    }



    //http://localhost:8080/ssm/admin/class/delete?id=4
    //跳转到删除
    @RequestMapping("/delete")
    public String deleteById(int id,Model model){

        int row = classService.deleteById(id);
        List<ClassInfo> all = classService.findAll();
        model.addAttribute("class_list",all);

        if (row != 0){
            model.addAttribute("tip_info","执行班级删除成功");
            return "/jsp/admin/class/class_list.jsp";
        }else{
            model.addAttribute("tip_info","执行班级删除操作失败");
            return "/jsp/admin/class/class_list.jsp";
        }

    }

}
