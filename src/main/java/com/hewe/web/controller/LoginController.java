package com.hewe.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hewe.domain.UserModel;
import com.hewe.service.IUserService;

@Controller
public class LoginController {

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginView() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap map) {
		if (username.trim().equals("") || password.trim().equals("")) {
			return "redirect:/login";
		}

		UserModel user = userService.findUser(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			map.put("message", "login success");
			return "success";
		}
		return "error";
	}
}
