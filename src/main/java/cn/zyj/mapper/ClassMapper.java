package cn.zyj.mapper;

import cn.zyj.bean.ClassInfo;
import cn.zyj.bean.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {

    //查询班级信息
    List<ClassInfo> findAll();

    //保存班级信息
    int save(ClassInfo classInfo);

    //通过id查询 班级
    ClassInfo selectById(@Param("id") int id);

    //修改班级信息
    int updateSave(ClassInfo classInfo);

    //删除
    int deleteById(@Param("id") int id);

}
