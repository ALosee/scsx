package cn.zyj.service.impl;

import cn.zyj.bean.ClassInfo;
import cn.zyj.mapper.ClassMapper;
import cn.zyj.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<ClassInfo> findAll() {
        try {
            return classMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查找班级信息异常",e);
        }
    }

    @Override
    public int save(ClassInfo classInfo) {

       int ret = classMapper.save(classInfo);
       return ret;
    }


    @Override
    public ClassInfo selectById(int id) {
        try {
            return classMapper.selectById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("查找班级信息异常",ex);
        }

    }


    @Override
    public int updateSave(ClassInfo classInfo) {
        int ret = classMapper.updateSave(classInfo);
        return ret;
    }

    @Override
    public int deleteById(int id) {
        int ret = classMapper.deleteById(id);
        return ret;
    }
}
