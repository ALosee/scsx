package cn.zyj.controller;

import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.service.AdminService;
import cn.zyj.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    StudentService studentService;

    //登录功能
    @RequestMapping("/admin_login")
    public String login(String adminName, String adminPass,String verifiCode, Model model, HttpSession session){

        String  sessionVerifiCode = (String) session.getAttribute("verifiCode");
        if (!sessionVerifiCode.equalsIgnoreCase(verifiCode)){
            model.addAttribute("msg","验证码错误");
            return "forward:admin_login.jsp";
        }
        AdminInfo adminInfo = adminService.login(adminName, adminPass);

        if (adminInfo!=null){
            session.setAttribute("login_admin",adminInfo);
            return "redirect:index.jsp";
        }else{
            model.addAttribute("msg","用户名或者秘密错误");
            return "forward:admin_login.jsp";
        }
    }

    //注销功能
    @RequestMapping("/admin_logout")
    public String admin_logout(HttpSession session){

       session.invalidate();

       return "redirect:admin_login.jsp";
    }



    //http://localhost:8080/ssm/admin/personalcenter/detail
    @RequestMapping("/admin/personalcenter/detail")
    public String detail(HttpServletRequest request,Model model){

        AdminInfo admin = (AdminInfo) request.getSession().getAttribute("login_admin");
        model.addAttribute("admin_info",admin);

        return "/jsp/admin/personalcenter/admin_detail.jsp";

    }

    //http://localhost:8080/ssm/admin/personalcenter/updatePage
    @RequestMapping("/admin/personalcenter/updatePage")
    public String updatePage(){


        return "/jsp/admin/personalcenter/admin_edit.jsp";

    }

    //http://localhost:8080/ssm/admin/personalcenter/updateSave
    //执行管理员个人信息修改
    @RequestMapping("/admin/personalcenter/updateSave")
    public String updateSave(AdminInfo adminInfo, Model model, HttpSession session){

        adminInfo.setOperateTime(new Date());

        AdminInfo admin = (AdminInfo)session.getAttribute("login_admin");
        adminInfo.setAdminPass(admin.getAdminPass());
        adminInfo.setOperator(admin.getId());
        adminInfo.setId(admin.getId());

        int row = adminService.update(adminInfo);

        if (row != 0){

            session.setAttribute("login_admin",adminInfo);

            model.addAttribute("tip_info","恭喜你，修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，修改操作失败");
            return "/result.jsp";
        }

    }

    //http://localhost:8080/ssm/admin/personalcenter/enterModifyPassword
    //修改密码
    @RequestMapping("/admin/personalcenter/enterModifyPassword")
    public String enterModifyPassword(){


        return "/jsp/admin/personalcenter/modify_password.jsp";

    }

    //http://localhost:8080/ssm/admin/personalcenter/modifyPassword
    //original_pass: admin
    //new_pass: 111111
    //confirm_new_pass: 111111
    @RequestMapping("/admin/personalcenter/modifyPassword")
    public String modifyPassword(String original_pass,String new_pass,String confirm_new_pass,
                                 HttpServletRequest request,Model model) {

        AdminInfo admin = (AdminInfo) request.getSession().getAttribute("login_admin");

        AdminInfo adminInfo = adminService.login(admin.getAdminName(), original_pass);

        adminInfo.setOperateTime(new Date());
        adminInfo.setOperator(admin.getId());
        adminInfo.setId(admin.getId());

        if (adminInfo != null) {
            if(new_pass != null && new_pass.equals(confirm_new_pass)){
                adminInfo.setAdminPass(new_pass);
                adminService.update(adminInfo);
                model.addAttribute("error_info", "true");
            }else {
                model.addAttribute("error_info", "false");
            }
        } else {
            model.addAttribute("error_info", "false");
        }

        return "/jsp/admin/personalcenter/result_password.jsp";
    }

    //http://localhost:8080/ssm/admin/personalcenter/admin_logout
    //注销功能
    @RequestMapping("/admin/personalcenter/admin_logout")
    public String adminLogout(HttpSession session){
        session.invalidate();
        return "redirect:admin_login.jsp";
    }

    @RequestMapping("/admin/student/delete")
    public int deleteStudent(@Param("id")int id){
        return studentService.deleteStudent(id);
    }


}
