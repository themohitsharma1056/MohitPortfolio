package com.mohit.portfolio.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MohitController{
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/projects")
	public String projects() {
		return "projects";
	}
	@GetMapping("/skills")
	public String skills() {
		return "skills"; 
	}
	
	@GetMapping("/explore")
	public String explore() {
		return "explore";
	}
	
}
