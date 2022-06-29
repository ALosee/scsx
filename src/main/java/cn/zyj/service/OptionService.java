package cn.zyj.service;

import cn.zyj.bean.OptionInfo;
import cn.zyj.bean.PaperInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OptionService {

    //根据试题id&选项类型查询选项信息
    OptionInfo selectIdType(@Param("questionNumId") int questionNumId, @Param("optionType") String optionType);

    //修改试题信息
    int update(OptionInfo optionInfo);

}
