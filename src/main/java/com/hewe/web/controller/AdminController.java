package com.hewe.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hewe.domain.UserModel;
import com.hewe.service.IUserService;
import com.hewe.util.model.Page;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String adminView() {

		return "admin1";
	}

	@RequestMapping(path = "/allUser", method = { RequestMethod.GET, RequestMethod.POST })
	public String allUser(@RequestParam("pageIndex") String pageIndex, ModelMap map) {
		Page page = null;
		if (pageIndex == null || pageIndex.trim().equals("0")) {
			page = userService.getPageDataUser(null);
		} else {
			page = userService.getPageDataUser(pageIndex);
		}
		List<UserModel> list = page.getList();
		if (list != null) {
			for (UserModel user : list) {
				System.out.println(user.getPassword());
			}
		}
		map.put("userPage", page);
		return "admin_user";
	}
}
