package com.hewe.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hewe.domain.UserModel;
import com.hewe.service.IUserService;
import com.hewe.web.form.RegisterForm;

@Controller
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);

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

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap map, HttpServletRequest request) {
		UserModel user = (UserModel) request.getSession().getAttribute("user");
		if (user == null) {
			log.debug("user not login");
			map.put("message", "请先<a href='login'>登录</a>");
			return "message";
		}
		request.getSession().removeAttribute("user");
		log.info("user: " + user.getUsername() + " logout");
		map.put("message", "已经退出");
		return "message";
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String registerView() {

		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@Valid RegisterForm form, BindingResult result) {
		log.debug("register excute");
		return "register";
	}
}
