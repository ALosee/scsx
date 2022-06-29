package cn.zyj.controller;

import cn.zyj.bean.PieInfo;
import cn.zyj.bean.StudentInfo;
import cn.zyj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chart")
public class ChartsController {


    @Autowired
    private StudentService studentService;

    @RequestMapping("/score_chart")
    @ResponseBody
    public List<StudentInfo> ScoreChart(){

        List<StudentInfo> studentInfos = studentService.selectAll();

/*        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentName("张三");
        studentInfo.setTotalScore(85);

        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setStudentName("李四");
        studentInfo1.setTotalScore(78);

        studentInfos.add(studentInfo);
        studentInfos.add(studentInfo1);
        */

        return studentInfos;

    }


/*    @RequestMapping("/class_chart")
    @ResponseBody
    public List<PieInfo> classChart(){

        int classA = 0;
        int classB = 0;
        int classC = 0;

        List<StudentInfo> studentInfos = studentService.selectAll();

        for(StudentInfo item : studentInfos){
            if(item != null) {
                int classId = item.getClassId();

                if (classId == 1) {
                    classA += 1;
                } else if (classId == 2) {
                    classB += 1;
                } else if (classId == 3) {
                    classC += 1;
                }
            }else break;
        }
        List<PieInfo> pieInfos = new ArrayList<>();

        pieInfos.add(new PieInfo(classA,"特级班"));
        pieInfos.add(new PieInfo(classB,"高级班"));
        pieInfos.add(new PieInfo(classC,"普通班"));

*//*
        pieInfos.add(new PieInfo(3,"班级一"));
        pieInfos.add(new PieInfo(1,"班级二"));
        pieInfos.add(new PieInfo(4,"班级三"));
        pieInfos.add(new PieInfo(2,"班级四"));*//*

        return pieInfos;

    }*/
//    @RequestMapping("/class_chart")
//    @ResponseBody
//    public

    @RequestMapping("/count_chart")
    @ResponseBody
    public List<PieInfo> classChart(){

        int classA = 0;
        int classB = 0;
        int classC = 0;
        int classId = 0;
        List<PieInfo> pieInfos = new ArrayList<>();

        pieInfos.add(new PieInfo(1,"特级班"));
        pieInfos.add(new PieInfo(1,"高级班"));
        pieInfos.add(new PieInfo(1,"普通班"));


//        pieInfos.add(new PieInfo(3,"班级一"));
//        pieInfos.add(new PieInfo(1,"班级二"));
//        pieInfos.add(new PieInfo(4,"班级三"));
//        pieInfos.add(new PieInfo(2,"班级四"));

        return pieInfos;

    }

//    @RequestMapping("/count_chart")
//    @ResponseBody
//    public List<PieInfo> countChart(){
//
//        ArrayList<PieInfo> pieInfos = new ArrayList<>();
//
//        pieInfos.add(new PieInfo(3,"班级一"));
//        pieInfos.add(new PieInfo(1,"班级二"));
//        pieInfos.add(new PieInfo(4,"班级三"));
//        pieInfos.add(new PieInfo(2,"班级四"));
//
//
//        return pieInfos;
//
//    }




}
