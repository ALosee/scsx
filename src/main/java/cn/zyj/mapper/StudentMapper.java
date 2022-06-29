package cn.zyj.mapper;

import cn.zyj.bean.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    //根据id进行查找
    StudentInfo selectById(@Param("id") int id);

    //管理员登录功能
    StudentInfo login(@Param("studentNum") String studentNum, @Param("studentPassword") String studentPassword);

    StudentInfo queryStudentExamInfo(int id);

    //查询全部学生
    List<StudentInfo> selectAll();

    //更新学生信息
    int update(StudentInfo studentInfo);

    //新增学生
    int save(StudentInfo studentInfo);


    int modifyPassword(int id, String newPassword);

    int deleteStudent(int id);
}
