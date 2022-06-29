package cn.zyj.service.impl;

import cn.zyj.bean.AdminInfo;
import cn.zyj.mapper.AdminMapper;
import cn.zyj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //管理员登录功能
    @Override
    public AdminInfo login(String username, String password) {



        try {
            AdminInfo adminInfo = adminMapper.login(username, password);

            return adminInfo;
        }catch (Exception e){

            e.printStackTrace();
            throw new RuntimeException("登录异常",e);
        }



    }

    @Override
    public int update(AdminInfo adminInfo) {
        return adminMapper.update(adminInfo);
    }
}
