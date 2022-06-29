package cn.zyj.service.impl;

import cn.zyj.bean.MajorInfo;
import cn.zyj.mapper.MajorMapper;
import cn.zyj.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorMapper majorMapper;

    @Override
    public List<MajorInfo> findAll() {

        try {
            List<MajorInfo> majorInfos = majorMapper.findAll();
            return majorInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询专业信息失败",e);
        }
    }

    @Override
    public int save(MajorInfo majorInfo) {
        return 0;
    }

    @Override
    public MajorInfo selectById(int id) {
        return null;
    }

    @Override
    public int update(MajorInfo majorInfo) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        try {
            int row = majorMapper.deleteById(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id删除专业信息出错",e);
        }
    }

    @Override
    public int deleteByIds(int[] ids) {

        try {
            return majorMapper.deleteByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("批量删除专业信息出错",e);
        }
    }
}
