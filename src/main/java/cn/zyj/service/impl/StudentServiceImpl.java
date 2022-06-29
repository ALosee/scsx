package cn.zyj.service.impl;

import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.MajorInfo;
import cn.zyj.bean.StudentInfo;
import cn.zyj.mapper.MajorMapper;
import cn.zyj.mapper.StudentMapper;
import cn.zyj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    MajorMapper majorMapper;


    //学生登录
    @Override
    public StudentInfo login(String studentName, String studentPass) {
        try {
            return studentMapper.login(studentName, studentPass);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("学生登录失败", e);
        }
    }

    @Override
    public StudentInfo queryStudentExamInfo(int num) {
        try {
            return studentMapper.queryStudentExamInfo(num);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询学生考试信息异常", e);
        }
    }

    @Override
    public List<StudentInfo> selectAll() {
        //查询所有的学生
        List<StudentInfo> studentInfos = studentMapper.selectAll();
        /*
        return studentMapper.selectAll().stream().peek((item) -> {
            MajorInfo majorInfo = majorMapper.selectByIdForAcademy(item.getMajorInfoId());
            item.setMajorInfo(majorInfo);
            item.setAcademyInfo(majorInfo.getAcademyInfo());
        }).collect(Collectors.toList());
         */
        return studentInfos;
    }


    @Override
    public StudentInfo selectById(int id) {
        try {
            StudentInfo studentInfo = studentMapper.selectById(id);
            MajorInfo majorInfo = majorMapper.selectById(studentInfo.getMajorInfoId());
            studentInfo.setMajorInfo(majorInfo);
            return studentInfo;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("学生查询失败", e);
        }
    }

    @Override
    public int update(StudentInfo studentInfo) {
        int ret = studentMapper.update(studentInfo);
        return ret;
    }


    @Override
    public int save(StudentInfo studentInfo) {
        return studentMapper.save(studentInfo);
    }

    @Override
    public StudentInfo selectAcademyAndMajor(Integer id) {
        try {
            StudentInfo studentInfo = studentMapper.selectById(id);
            MajorInfo majorInfo = majorMapper.selectByIdForAcademy(studentInfo.getMajorInfoId());
            AcademyInfo academyInfo = majorInfo.getAcademyInfo();
            studentInfo.setMajorInfo(majorInfo);
            studentInfo.setAcademyInfo(academyInfo);

            return studentInfo;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("学生查询失败",e);
        }

    }

    @Override
    public int modifyPassword(int id,String newPassword) {
        return studentMapper.modifyPassword(id,newPassword);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }


}
