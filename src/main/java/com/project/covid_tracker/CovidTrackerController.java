package com.project.covid_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CovidTrackerController {
	
	@Autowired
	CovidTrackerService service;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("allStats",service.allStats);
		return "index.jsp";
	}

}
