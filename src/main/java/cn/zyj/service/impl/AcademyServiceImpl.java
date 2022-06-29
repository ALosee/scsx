package cn.zyj.service.impl;

import cn.zyj.bean.AcademyInfo;
import cn.zyj.mapper.AcademyMapper;
import cn.zyj.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {

    @Autowired
    AcademyMapper academyMapper;

    public List<AcademyInfo> findAll(){
        try {
            List<AcademyInfo> all = academyMapper.findAll();
            return all;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询学院列表异常",e);
        }
    }

    @Override
    public int save(AcademyInfo academyInfo) {

        try{

            int row = academyMapper.save(academyInfo);

            return row;
        }catch (Exception e){

            e.printStackTrace();
            throw new RuntimeException("新增学院信息异常",e);
        }

    }

    @Override
    public AcademyInfo selectById(int id) {

        try {
            AcademyInfo academyInfo = academyMapper.selectById(id);
            return academyInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询学院信息异常",e);
        }
    }

    @Override
    public int update(AcademyInfo academyInfo) {

        try {
            int row = academyMapper.update(academyInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改学院信息异常",e);
        }
    }

    @Override
    public int deleteById(int id) {
        try {
            int row = academyMapper.deleteById(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("根据id删除学院信息",e);
        }
    }

    @Override
    public int deleteByIds(int[] ids) {

        try {
           return academyMapper.deleteByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("批量删除学院信息异常",e);
        }

    }


}
