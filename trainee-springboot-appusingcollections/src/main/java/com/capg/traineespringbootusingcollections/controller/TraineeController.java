package com.capg.traineespringbootusingcollections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capg.traineespringbootusingcollections.model.Trainee;
import com.capg.traineespringbootusingcollections.service.TraineeService;


@Controller
public class TraineeController {
	@Autowired
	TraineeService service;
	
@GetMapping
public String getLoginPage()
{
	return "loginpage";
}
@PostMapping("/login")
public String redirectToOperations(@RequestParam("username") String name,@RequestParam("password") String password,Model m)
{
	if(name.equals("harsh")&& password.equals("kumar"))
	{
		return "firstpage";
	}
	else {
		m.addAttribute("invalid","invalid username and password");
		return "loginpage";
	}
}
@PostMapping("/add")
public String addTrainee(@ModelAttribute Trainee t1,Model m)
	{
		service.addTrainee(t1);
		m.addAttribute("added","addedSuccessfully");
		m.addAttribute("trainee",t1);
		return "firstpage";
	
	}
@PostMapping("/remove")
public String removeTrainee(@RequestParam ("id") int id,Model m)
	{
	
		if(service.removeTrainee(id))
		{
			m.addAttribute("remove","Removed successfully");
			return "firstpage";
		}
		else
		{
			m.addAttribute("remove","trainee not found");
		return "firstpage";
		}
	}

}
