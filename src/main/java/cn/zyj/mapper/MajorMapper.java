package cn.zyj.mapper;


import cn.zyj.bean.AcademyInfo;
import cn.zyj.bean.MajorInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorMapper {

    //查询专业列表
    List<MajorInfo> findAll();

    //新增专业信息
    int save(MajorInfo majorInfo);

    //根据id查询专业信息
    MajorInfo selectById(int id);

    //修改专业信息
    int update(MajorInfo majorInfo);

    //根据id删除专业信息
    int deleteById(int id);

    int deleteByIds(@Param("ids") int[] ids);

    //
    MajorInfo selectByIdForAcademy(@Param("id") int id);


}
