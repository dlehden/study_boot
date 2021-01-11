package com.mert.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasin Mert on 25.02.2017.
 */
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mert.model.User;
import com.mert.service.RoleService;
import com.mert.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {


	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	//toast ui grid test 
	@RequestMapping(value = "/all-test")
	public @ResponseBody ModelAndView gridTest(User search) {  //User model 로 데이터 매칭 바인딩
		System.out.println("all-test실행");
		System.out.println(search.getName() + "name 변수가전달됌22");
		ModelAndView modelAndView = new ModelAndView();
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr

		modelAndView.addObject("mode", "MODE_return");
		modelAndView.addObject("user_data", search.getName());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.setViewName("user");
		
		System.out.println(modelAndView.getModel());
		return modelAndView;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		System.out.println("all실행");
		ModelAndView modelAndView = new ModelAndView();
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
		modelAndView.addObject("users", userService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.setViewName("user");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/all");
		user.setPassword(userService.findUser(user.getId()).getPassword());
		user.setActive(userService.findUser(user.getId()).getActive());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		userService.save(user);
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new User());
		modelAndView.addObject("user", userService.findUser(id));
		modelAndView.addObject("roles", roleService.findAll());
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.setViewName("user");
		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/all");
		modelAndView.addObject("rule", new User());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		userService.delete(id);
		return modelAndView;
	}

	private User getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
}







