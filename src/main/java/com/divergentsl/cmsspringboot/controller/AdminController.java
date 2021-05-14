package com.divergentsl.cmsspringboot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.divergentsl.cmsspringboot.service.AdminService;


@Controller
//@RequestMapping("/adminController")
public class AdminController  {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AdminService adminService;

	public AdminController() {
		super();
	}

	@PostMapping("/adminLogin")
	protected String check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (adminService.login(username, password)) {
			return "AdminHome";
		} else {
			request.setAttribute("error", "Incorrect Username & Password");
			return "index";
		}

	}
	
	 @GetMapping("/adminLogin")
	    public String adminLogin() {
	    	return "AdminLogin";
	    }

}
