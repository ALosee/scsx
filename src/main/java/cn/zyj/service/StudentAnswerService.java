package cn.zyj.service;


import cn.zyj.bean.StudentAnswerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAnswerService {

    //验证考生是否已答题
    int registerExam(int studentNum);

    //保存学生答题信息
    void save(List<StudentAnswerInfo> list);

    //id查询学生答题情况
    List<StudentAnswerInfo> studentAnswer(int id);

}
