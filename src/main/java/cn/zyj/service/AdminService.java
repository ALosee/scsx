package cn.zyj.service;

import cn.zyj.bean.AdminInfo;

public interface AdminService {


    //管理员登录
    AdminInfo login(String adminName, String adminPass);

    //更新
    int update(AdminInfo adminInfo);




}
