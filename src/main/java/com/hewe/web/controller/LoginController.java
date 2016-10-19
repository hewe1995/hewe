package com.hewe.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hewe.domain.UserModel;
import com.hewe.service.IUserService;
import com.hewe.util.model.WebUtil;
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
	public String registerView(ModelMap map) {
		log.debug("view register");
		RegisterForm register = new RegisterForm();
		map.put("registerForm", register);

		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@Valid RegisterForm register, BindingResult result, ModelMap map) {
		log.debug("register excute");
		if (result.hasErrors()) {
			log.debug("has errors");
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError rr : list) {
				log.debug(rr.getObjectName());
				log.debug(rr.getDefaultMessage());
				log.debug(rr.getCode());
				log.debug(rr.getArguments()[0]);
			}
			return "register";
		}
		UserModel user = userService.findUserByName(register.getUsername());
		if (user != null) {
			log.debug("has exit");
			map.put("message", "用户已存在,<a href='login'>登录</a>");
			return "message";
		}
		user = new UserModel();
		try {
			BeanUtils.copyProperties(register, user);
		} catch (BeansException e) {
			e.printStackTrace();
			log.debug("bean copy defaild");
			map.put("message", "注册失败,<a href='register'>重试</a>");
			return "message";
		}
		user.setCreateDate(new Date());
		user.setStatus(1);
		user.setId(WebUtil.makeId());

		userService.add(user);
		log.debug("添加成功,user信息:" + user.getId() + "|" + user.getUsername());
		return "redirect:/login";
	}

	@RequestMapping("/isExit")
	@ResponseBody
	public String userIsExit(@RequestParam(value = "username", required = true) String username) {
		log.debug("IsExit :" + username);
		if (username == null || username.trim().equals("") || username.length() > 10 || username.length() < 4) {
			return "2";
		}
		UserModel user = userService.findUserByName(username);
		if (user != null){
			log.debug("user exit");
			return "1";
		}
		return "0";
	}
}
