package cn.zyj.controller;

import cn.zyj.bean.PaperInfo;
import cn.zyj.bean.AdminInfo;
import cn.zyj.service.PaperService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/paper")
public class PaperInfoController extends HttpServlet {

	@Autowired
	private PaperService paperService;

	@RequestMapping("/findByPage")
	public String findByPage(@RequestParam(defaultValue = "1")int pageNum, Model model){

		int pageSize = 5;//定义每页显示几条条数据

		PageHelper.startPage(pageNum,pageSize);

		List<PaperInfo> all = paperService.findAll();

		PageInfo<PaperInfo> pageInfo = new PageInfo<>(all);

		model.addAttribute("paperInfos",all);
		model.addAttribute("pageInfo",pageInfo);

		return "/jsp/admin/paper/paper_list.jsp";

	}


	//跳转到新增页面
	@RequestMapping("/addPage")
	public String addPage(){

		return "/jsp/admin/paper/paper_add.jsp";

	}

	//执行新增
	@RequestMapping("/addSave")
	public String addSave(PaperInfo paperInfo, Model model, HttpSession session){

		paperInfo.setCreateTime(new Date());

		AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
		paperInfo.setCreator(adminInfo.getId());

		int row = paperService.save(paperInfo);

		if (row != 0){

			model.addAttribute("tip_info","恭喜你，执行试题新增成功");

			return "/result.jsp";
		}else{
			model.addAttribute("tip_info","很抱歉，执行试题新增操作失败");

			return "/result.jsp";

		}

	}


	//跳转到新增页面
	@RequestMapping("/updatePage")
	public String updatePage(int id,Model model){

		PaperInfo paperInfo = paperService.selectById(id);

		model.addAttribute("paper_info",paperInfo);

		return "/jsp/admin/paper/paper_edit.jsp";

	}

	//执行更新
	@RequestMapping("/updateSave")
	public String updateSave(PaperInfo paperInfo, Model model, HttpSession session){

		paperInfo.setOperateTime(new Date());

		AdminInfo adminInfo = (AdminInfo)session.getAttribute("login_admin");
		paperInfo.setOperator(adminInfo.getId());

		int row = paperService.update(paperInfo);

		if (row != 0){

			model.addAttribute("tip_info","恭喜你，执行试题修改成功");

			return "/result.jsp";
		}else{
			model.addAttribute("tip_info","很抱歉，执行试题修改操作失败");

			return "/result.jsp";

		}

	}

	@RequestMapping("/delete")
	public String deleteById(int id,Model model){

		int row = paperService.deleteById(id);

		List<PaperInfo> all = paperService.findAll();

		model.addAttribute("paper_list",all);

		if (row != 0){

			model.addAttribute("tip_info","执行试题删除成功");

			return "/jsp/admin/paper/paper_list.jsp";
		}else{
			model.addAttribute("tip_info","执行试题删除操作失败");

			return "/jsp/admin/paper/paper_list.jsp";

		}

	}


}
