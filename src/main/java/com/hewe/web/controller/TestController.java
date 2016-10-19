package com.hewe.web.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hewe.web.form.Person;

@Controller
@RequestMapping(path = "/test")
public class TestController {
	private static final Logger log = Logger.getLogger(TestController.class);

	@GetMapping("/")
	public String showForm(Person person) {
		return "form";
	}

	@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String form(@Valid Person person, BindingResult result) {

		if (result.hasErrors()) {
			return "form";
		}
		log.debug(person.toString());
		return "success";
	}

}
