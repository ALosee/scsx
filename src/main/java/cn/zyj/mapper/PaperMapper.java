package cn.zyj.mapper;


import cn.zyj.bean.PaperInfo;

import java.util.List;

public interface PaperMapper {

    //查询试卷列表
    List<PaperInfo> findAll();

    //新增试卷信息
    int save(PaperInfo paperInfo);

    //根据id查询试卷信息
    PaperInfo selectById(int id);

    //修改试卷信息
    int update(PaperInfo paperInfo);

    //删除试卷信息
    int deleteById(int id);

    //关联查询试卷&选项
    List<PaperInfo> findExam();

    //根据试题编号 获取对应的试题正确答案，试题的分数
    PaperInfo findPaperMes(int questionNum);







}
