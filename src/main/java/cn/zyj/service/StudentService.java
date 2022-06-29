package cn.zyj.service;

import cn.zyj.bean.StudentInfo;

import java.util.List;

public interface StudentService {

    //学生登录
     StudentInfo login(String studentName, String studentPass);

     //查询学生考试信息
    StudentInfo queryStudentExamInfo(int id);

    //查询全部学生
    List<StudentInfo> selectAll();

    //通过id查询
    StudentInfo selectById(int id);

    //更新学生信息
    int update(StudentInfo studentInfo);

    //新增学生
    int save(StudentInfo studentInfo);


    StudentInfo selectAcademyAndMajor(Integer id);

    int modifyPassword(int id,String newPassword);

    //根据学号删除学生信息
    int deleteStudent(int id);
}
