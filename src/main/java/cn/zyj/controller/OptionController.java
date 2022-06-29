package cn.zyj.controller;

import cn.zyj.bean.OptionInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/admin/option")
public class OptionController {
    
    
    @Autowired
    OptionService optionService;

    //跳转到新增页面
    @RequestMapping("/update_page")
    public String updatePage(int questionNumId,String optionType, Model model){

        OptionInfo optionInfo = optionService.selectIdType(questionNumId,optionType);

        model.addAttribute("option_info",optionInfo);

        return "/jsp/admin/option/option_edit.jsp";

    }

    //执行学院新增
    @RequestMapping("/update_save")
    public String updateSave(OptionInfo optionInfo, Model model, HttpSession session){

        optionInfo.setOperateTime(new Date());

        AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
        optionInfo.setOperator(adminInfo.getId());

        int row = optionService.update(optionInfo);

        if (row != 0){
            model.addAttribute("tip_info","恭喜你，执行选项修改成功");
            return "/result.jsp";
        }else{
            model.addAttribute("tip_info","很抱歉，执行选项修改失败");
            return "/result.jsp";
        }

    }



}
