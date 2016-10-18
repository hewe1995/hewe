package com.hewe.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hewe.domain.FileModel;
import com.hewe.domain.UserModel;
import com.hewe.service.IFileService;
import com.hewe.util.model.Page;

@Controller
@RequestMapping(path = "/client")
public class ClientController {

	private static final Logger log = Logger.getLogger(ClientController.class);

	@Resource(name = "fileService")
	private IFileService fileService;

	@RequestMapping(path = "/myFiles", method = RequestMethod.GET)
	public String currentUserFile(@RequestParam(value = "pageIndex", required = false) String pageIndex, ModelMap map,
			HttpServletRequest request) {
		log.debug("currentUserFile excute");
		Page page = null;
		UserModel user = (UserModel) request.getSession().getAttribute("user");

		if (user == null) {
			log.debug("user not login");
			map.put("message", "请先<a href='login'>登录</a>");
			return "message";
		}
		Map<String, Object> sqlConditions = new HashMap<String, Object>();
		sqlConditions.put("user_id", user.getId());
		if (pageIndex == null) {
			log.debug("pageIndex null");
			page = fileService.getPageDataFile(null, sqlConditions);
			log.info("page : totalrecord:" + page.getTotalRecord() + "currentINdex :" + page.getCurrentPageNum());
			map.put("filePage", page);
			return "currentUserFile";
		}
		page = fileService.getPageDataFile(pageIndex, sqlConditions);
		log.info("page : totalrecord:" + page.getTotalRecord() + "currentINdex :" + page.getCurrentPageNum());
		map.put("filePage", page);
		return "currentUserFile";
	}

	@RequestMapping(path = "/showFile", method = RequestMethod.GET)
	public String allFile(@RequestParam("pageIndex") String pageIndex, ModelMap map) {
		log.debug("allfile");
		Page page = null;
		if (pageIndex == null || pageIndex.trim().equals("0")) {
			page = fileService.getPageDataFile(null);
		} else {
			page = fileService.getPageDataFile(pageIndex);
		}
		map.put("filePage", page);

		return "client_showFile";
	}
	@RequestMapping(path = "/myInfo", method = RequestMethod.GET)
	public String myInfo(HttpServletRequest request, ModelMap map){
		
		UserModel user = (UserModel) request.getSession().getAttribute("user");

		if (user == null) {
			log.debug("user not login");
			map.put("message", "请先<a href='login'>登录</a>");
			return "message";
		}
		
		return "myInfo";
	}
}
