package cn.zyj.controller;


import cn.zyj.bean.PaperInfo;
import cn.zyj.bean.StudentAnswerInfo;
import cn.zyj.bean.StudentInfo;
import cn.zyj.service.ClassService;
import cn.zyj.service.PaperService;
import cn.zyj.service.StudentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentExamController {

    @Autowired
    PaperService paperService;
    @Autowired
    StudentAnswerService studentAnswerService;
    @Autowired
    ClassService classService;

    @RequestMapping("/exam")
    public String toExamPage(Model model, HttpSession session) {
        StudentInfo studentInfo = (StudentInfo) session.getAttribute("login_student");
        //验证学生是否交卷
        int examFlag = studentAnswerService.registerExam(studentInfo.getStudentNum());
        //若之前没有进行答题
        if (examFlag == 0) {
            //组装答题页面数据（拿到试题paper）
            List<PaperInfo> exam = paperService.findExam();
            model.addAttribute("paper_list", exam);
            return "/jsp/student/index.jsp";
        } else {//若进行答题
            model.addAttribute("tip_info", "您已经参与过测试，不允许重复测试");
            return "/main.jsp";
        }
    }

    @RequestMapping("/answer")
    public String studentAnswer(int[] questionNum, HttpServletRequest request, Model model) {

        List<StudentAnswerInfo> list = new ArrayList<>();

        //获取当前登录的学生信息
        StudentInfo login_student = (StudentInfo) request.getSession().getAttribute("login_student");
        //获取学生总分
        int total = 0;
        for (int num : questionNum) {
            StudentAnswerInfo studentAnswerInfo = new StudentAnswerInfo();
            String studentType = request.getParameter(num + "_optionType");//考生所选答案
            PaperInfo paperMes = paperService.findPaperMes(num);
            String answerType = paperMes.getQuestionAnswer();
            //如果所选类型跟题目答案一致
            if (studentType != null && studentType.equals(answerType)) {
                studentAnswerInfo.setStudentScore(paperMes.getQuestionScore());
            } else {////如果所选类型跟题目答案不一致
                studentAnswerInfo.setStudentScore(0);
            }
            //组装完学生答题数据
            studentAnswerInfo.setStudentNumId(login_student.getStudentNum());
            studentAnswerInfo.setQuestionNumId(String.valueOf(num));
            studentAnswerInfo.setAnswerType(studentType);
            Date date = new Date();
            studentAnswerInfo.setCreateTime(date);
            studentAnswerInfo.setCreator(login_student.getId());
            studentAnswerInfo.setOperator(login_student.getId());
            studentAnswerInfo.setOperateTime(date);
            studentAnswerInfo.setDeleteFlag(1);
            list.add(studentAnswerInfo);

            //获取学生的总分
            total += studentAnswerInfo.getStudentScore();
        }
        //将总分以及学生交卷状态存到StudentInfo中，
        login_student.setTotalScore(total);
        model.addAttribute("totalScore", total);
        //修改考生交卷状态
        login_student.setExamFlag(1);//表示已交卷

        //根据总分进行分班

        //获取班级信息，拿到分数范围
        //后台执行查找所有班级信息的操作，遍历班级信息，假设学生总分在此班级分数范围内

        //login_student.setClassId();

        //其实根据学生id对exam_flag以及total_score字段以及class_id进行数据修改
        //........
        studentAnswerService.save(list);
        return "/main.jsp";

    }
}
