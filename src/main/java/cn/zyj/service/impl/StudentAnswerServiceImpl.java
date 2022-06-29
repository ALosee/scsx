package cn.zyj.service.impl;

import cn.zyj.bean.StudentAnswerInfo;
import cn.zyj.bean.StudentInfo;
import cn.zyj.mapper.StudentAnswerMapper;
import cn.zyj.mapper.StudentMapper;
import cn.zyj.service.StudentAnswerService;
import cn.zyj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAnswerServiceImpl implements StudentAnswerService {

    @Autowired
    StudentAnswerMapper studentAnswerMapper;

    @Override
    public int registerExam(int studentNum) {
        try {
            return studentAnswerMapper.registerExam(studentNum);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("学生答题异常",e);
        }
    }

    @Override
    public void save(List<StudentAnswerInfo> list) {
        try {
            for (StudentAnswerInfo studentAnswerInfo : list) {
                studentAnswerMapper.save(studentAnswerInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增学生答题信息异常",e);
        }
    }

    @Override
    public List<StudentAnswerInfo> studentAnswer(int id) {

        List<StudentAnswerInfo> studentAnswerInfos = null;
        try {
            studentAnswerInfos = studentAnswerMapper.studentAnswer(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增学生答题信息异常",e);
        }
        return studentAnswerInfos;
    }
}
