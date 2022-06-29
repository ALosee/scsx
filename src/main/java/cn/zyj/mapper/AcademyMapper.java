package cn.zyj.mapper;


import cn.zyj.bean.AcademyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcademyMapper {

    //查询学院列表
    List<AcademyInfo> findAll();

    //新增学院信息
    int save(AcademyInfo academyInfo);

    //根据id查询学院信息
    AcademyInfo selectById(int id);

    //修改学院信息
    int update(AcademyInfo academyInfo);

    //删除学院信息
    int deleteById(int id);

    /**
     * 批量删除
     */
    int deleteByIds(@Param("ids") int[] ids);


}
