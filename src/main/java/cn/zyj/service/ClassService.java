package cn.zyj.service;

import cn.zyj.bean.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassService {

    //查询班级信息
    List<ClassInfo> findAll();

    //保存班级
    int save(ClassInfo classInfo);

    //通过id查询 班级
    ClassInfo selectById(int id);

    //修改班级信息
    int updateSave(ClassInfo classInfo);

    //删除班级信息
    int deleteById(int id);

}
