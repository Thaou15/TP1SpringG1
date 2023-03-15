package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.ChefO;
import com.inti.repository.IChefORepository;

@Controller
public class MainController {
	
	@Autowired
	IChefORepository icr;
	
	@GetMapping("ajoutChefO")
	public String ajoutChefOrchestre()
	{
		return"formChefO";
	}
	@PostMapping("saveChefO")
	public String saveVoiture(@ModelAttribute ("chefO") ChefO chefO)
	{
		 icr.save(chefO);
			
		return "redirect:/ajoutChefO";
	}
	
	

}
