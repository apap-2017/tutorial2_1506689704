package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonFormat.Value;

@Controller

public class HelloController {
	
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false, defaultValue="dunia") String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
		
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String greeting (@RequestParam(value = "a",  required = false) Long a,Long b, Model model, Model model2, Model model3)
	{
		if(a == null && b == null) {
				model.addAttribute("a", 0);
				model2.addAttribute("b", 0);
				model3.addAttribute("c", 0);
		}else if(a == null) {
				model.addAttribute("a", 0);
				model2.addAttribute("b", b);
				model3.addAttribute("c", 0);
		}else if(b == null) {
				model.addAttribute("a", a);
				model2.addAttribute("b", 0);
				model3.addAttribute("c", 0);
		}else {
				model.addAttribute("a", a);
				model2.addAttribute("b", b);
				long hasil = a*b;
				model3.addAttribute("c", hasil);
			}		
		return "perkalian";
	}
	
}