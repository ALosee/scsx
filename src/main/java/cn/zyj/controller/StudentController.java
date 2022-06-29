package cn.zyj.controller;

import cn.zyj.bean.*;
import cn.zyj.service.MajorService;
import cn.zyj.service.StudentAnswerService;
import cn.zyj.service.StudentService;
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
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    MajorService majorService;

    @Autowired
    StudentAnswerService studentAnswerService;


    //登录功能
    @RequestMapping("/student_login")
    public String login(String studentNum, String studentPassword,String verifiCode, Model model, HttpSession session){
        String sessionVerifiCode = (String) session.getAttribute("verifiCode");
        if (!sessionVerifiCode.equalsIgnoreCase(verifiCode)){
            model.addAttribute("msg","验证码错误");
            return "forward:student_login.jsp";
        }
        StudentInfo studentInfo = studentService.login(studentNum, studentPassword);
        if (studentInfo!=null){
            session.setAttribute("login_student",studentInfo);
            return "redirect:index.jsp";
        }else{
            model.addAttribute("tip_info","用户名或者密码错误");
            return "forward:student_login.jsp";
        }
    }

    //注销功能
    @RequestMapping("/student_logout")
    public String student_logout(HttpSession session){

       session.invalidate();

       return "redirect:student_login.jsp";
    }


    //查询学生整体考试信息
    @RequestMapping("/student/queryinfo")
    public String queryStudentExamInfo(HttpSession session,Model model){

        StudentInfo login_student =(StudentInfo)session.getAttribute("login_student");

        StudentInfo studentInfo = studentService.queryStudentExamInfo(login_student.getStudentNum());

        model.addAttribute("studentExam",studentInfo);
        return "/jsp/student/info/query_info.jsp";

    }


    //http://localhost:8080/ssm/admin/student/search?pageNum=1
    @RequestMapping("/admin/student/search")
    public String findByPage(@RequestParam(defaultValue = "1")int pageNum, Model model){

        int pageSize = 5;//定义每页显示几条数据
        PageHelper.startPage(pageNum,pageSize);
        List<StudentInfo> all = studentService.selectAll();
        PageInfo<StudentInfo> pageInfo = new PageInfo<>(all);
        model.addAttribute("StudentInfos",all);
        model.addAttribute("StudentInfo",pageInfo);
        return "/jsp/admin/student/student_list.jsp";
    }

    //http://localhost:8080/ssm/admin/student/addPage
    //跳转到新增页面
    @RequestMapping("/admin/student/addPage")
    public String addPage(Model model){

        List<MajorInfo> list = majorService.findAll();
        model.addAttribute("major_list",list);
        return "/jsp/admin/student/student_add.jsp";
    }

    //执行班级新增
    @RequestMapping("/admin/student/addSave")
    public String addSave(StudentInfo studentInfo, Model model, HttpSession session){

        studentInfo.setCreateTime(new Date());

        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        studentInfo.setCreator(adminInfo.getId());

        int row = studentService.save(studentInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行班级新增成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行班级新增操作失败");
            return "/result.jsp";
        }
    }



    //http://localhost:8080/ssm/admin/student/updatePage?id=1
    //跳转到修改页面
    @RequestMapping("/admin/student/updatePage")
    public String updatePage(int id,Model model){

        StudentInfo studentInfo = studentService.selectById(id);
        model.addAttribute("student_info",studentInfo);

        List<MajorInfo> list = majorService.findAll();
        model.addAttribute("major_list",list);

        return "/jsp/admin/student/student_edit.jsp";

    }

    //执行学生新增
    @RequestMapping("/admin/student/updateSave")
    public String updateSave(StudentInfo studentInfo, Model model, HttpSession session){

        studentInfo.setOperateTime(new Date());
        AdminInfo adminInfo = (AdminInfo) session.getAttribute("login_admin");
        studentInfo.setOperator(adminInfo.getId());

        int row = studentService.update(studentInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行学生修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行学生修改操作失败");
            return "/result.jsp";
        }

    }


    //http://localhost:8080/ssm/admin/student/studentinfo.do?action=findall&stu_num=1901
    //action: findall
    //stu_num: 1901
    @RequestMapping("/admin/student/studentinfo.do")
    public String check(int stu_num,Model model){

        List<StudentAnswerInfo> studentAnswerInfos = studentAnswerService.studentAnswer(stu_num);

        model.addAttribute("student_answer",studentAnswerInfos);

        return "/jsp/admin/answer/score_look.jsp";
    }


    //http://localhost:8080/ssm/admin/student/delete?id=1

    //http://localhost:8080/ssm/student/personalcenter/detail
    @RequestMapping("/student/personalcenter/detail")
    public String detail(HttpServletRequest request, Model model){

        StudentInfo studentInfo = (StudentInfo) request.getSession().getAttribute("login_student");

        StudentInfo student = studentService.selectAcademyAndMajor(studentInfo.getId());
        student.setStudentPassWord(studentInfo.getStudentPassWord());

        request.getSession().setAttribute("student",student);

        model.addAttribute("student_info",student);
        model.addAttribute("academyInfo",student.getAcademyInfo());
        model.addAttribute("majorInfo",student.getMajorInfo());

        return "/jsp/student/personalcenter/student_detail.jsp";
    }


    //http://localhost:8080/ssm/student/personalcenter/updatePage
    //跳转到修改页面
    @RequestMapping("/student/personalcenter/updatePage")
    public String updateStudent(HttpServletRequest request,Model model){

        StudentInfo student = (StudentInfo) request.getSession().getAttribute("student");

        model.addAttribute("student_info",student);
        model.addAttribute("academyInfo",student.getAcademyInfo());
        model.addAttribute("majorInfo",student.getMajorInfo());

        return "/jsp/student/personalcenter/student_edit.jsp";

    }

    //action: update
    //studentNum: 1901
    //studentName: 林一
    //studentGender: 1
    //studentProvince: 四川
    //studentPhone: 1221212121
    //http://localhost:8080/ssm/student/personalcenter/updateSave
    //执行学生修改
    @RequestMapping("/student/personalcenter/updateSave")
    public String updateAndSave(StudentInfo studentInfo, Model model, HttpSession session){


        studentInfo.setOperateTime(new Date());
        StudentInfo student = (StudentInfo) session.getAttribute("student");

        studentInfo.setOperator(student.getId());
        studentInfo.setId(student.getId());
        studentInfo.setMajorInfoId(student.getMajorInfo().getId());

        int row = studentService.update(studentInfo);
        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行学生修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行学生修改操作失败");
            return "/result.jsp";
        }

    }




    //http://localhost:8080/ssm/student/personalcenter/enterModifyPassword
    @RequestMapping("/student/personalcenter/enterModifyPassword")
    public String modifyPassword(){

        return "/jsp/student/personalcenter/modify_password.jsp";

    }

    //http://localhost:8080/ssm/student/personalcenter/modifyPassword
    //action: modifyPassword
    //original_pass: 111
    //new_pass: 111
    //confirm_new_pass: 111
    @RequestMapping("/student/personalcenter/modifyPassword")
    public String modifyPassword(String original_pass,String new_pass,String confirm_new_pass,
                                 HttpServletRequest request,Model model) {

        StudentInfo student = (StudentInfo) request.getSession().getAttribute("student");
        int studentNum = student.getStudentNum();

        if (student.getStudentPassWord().equals(original_pass)) {
            if (new_pass != null && new_pass.equals(confirm_new_pass)) {

                int row = studentService.modifyPassword(studentNum,new_pass);
                if (row != 0) {
                    model.addAttribute("tip_info", "恭喜你，密码修改成功");
                    return "/result.jsp";
                }else {
                    model.addAttribute("tip_info", "很抱歉，密码修改失败");
                    return "/result.jsp";
                }

            } else {
                model.addAttribute("tip_info", "很抱歉，密码修改失败，新密码不能为空且必须一致");
                return "/result.jsp";
            }
        } else {
            model.addAttribute("tip_info", "很抱歉，密码修改失败，请输入正确的原密码");
            return "/result.jsp";
        }

    }



}
