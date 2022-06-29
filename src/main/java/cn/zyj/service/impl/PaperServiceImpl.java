package cn.zyj.service.impl;

import cn.zyj.bean.PaperInfo;
import cn.zyj.mapper.PaperMapper;
import cn.zyj.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaperServiceImpl implements PaperService {


    @Autowired
    PaperMapper paperMapper;

    public List<PaperInfo> findAll(){

        try {

            List<PaperInfo> all = paperMapper.findAll();

            return all;
        }catch (Exception e){

            e.printStackTrace();

            throw new RuntimeException("查询试题列表异常",e);

        }

    }

    @Override
    public int save(PaperInfo paperInfo) {

        try{

            int row = paperMapper.save(paperInfo);

            return row;
        }catch (Exception e){

            e.printStackTrace();
            throw new RuntimeException("新增试题信息异常",e);
        }

    }

    @Override
    public PaperInfo selectById(int id) {

        try {
            PaperInfo paperInfo = paperMapper.selectById(id);
            return paperInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询试题信息异常",e);
        }
    }

    @Override
    public int update(PaperInfo paperInfo) {

        try {
            int row = paperMapper.update(paperInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改试题信息异常",e);
        }
    }

    @Override
    public int deleteById(int id) {
        try {
            int row = paperMapper.deleteById(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("根据id删除试题信息",e);
        }
    }

    @Override
    public List<PaperInfo> findExam() {
        try {
            return paperMapper.findExam();
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("关联查询考题与选项异常",e);
        }
    }

    @Override
    public PaperInfo findPaperMes(int questionNum) {
        try {
            return paperMapper.findPaperMes(questionNum);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据题目编号查询题目信息异常",e);
        }
    }
}
