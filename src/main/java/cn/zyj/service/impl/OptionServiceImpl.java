package cn.zyj.service.impl;

import cn.zyj.bean.OptionInfo;
import cn.zyj.bean.PaperInfo;
import cn.zyj.mapper.OptionMapper;
import cn.zyj.mapper.PaperMapper;
import cn.zyj.service.OptionService;
import cn.zyj.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {


    @Autowired
    OptionMapper optionMapper;


    @Override
    public OptionInfo selectIdType(int questionNumId, String optionType) {
        try {
            OptionInfo optionInfo = optionMapper.selectIdType(questionNumId, optionType);

            return optionInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("查询试题选项异常",e);
        }
    }

    @Override
    public int update(OptionInfo optionInfo) {
        try {
            int row = optionMapper.update(optionInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("修改试题选项异常",e);
        }
    }
}
