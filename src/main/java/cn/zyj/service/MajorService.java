package cn.zyj.service;

import cn.zyj.bean.MajorInfo;

import java.util.List;


public interface MajorService {

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

    int deleteByIds(int[] ids);
}
