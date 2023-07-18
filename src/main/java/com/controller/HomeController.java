package com.controller;

import com.entities.todo;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model m) {
		String str = "home";
		m.addAttribute("page",str);
		List<todo> list = (List<todo>)context.getAttribute("list");
		m.addAttribute("todos",list);
		return "home";
	}
	@RequestMapping("/add")
	public String addTodo(Model m) {
		
		todo t = new todo();
		m.addAttribute("page","add");
		m.addAttribute("todo",t);
		return "home";
	}
	@RequestMapping(value = "/saveTodo",method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") todo t, Model m) {
		t.setDate(new Date());
		List<todo> list = (List<todo>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg","successfully added....");
		
		return "home";
	}

}



