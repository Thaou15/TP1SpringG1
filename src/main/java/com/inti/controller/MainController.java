package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;


import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.ChefO;

import com.inti.repository.IChefORepository;

@Controller
public class MainController {
	
	@Autowired
	ISolisteRepository isr;
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
	
	@GetMapping("listeChefO")
	public String listeChefO(Model m)
	{
		
	    m.addAttribute("listeChef",icr.findAll());
	   
		return"listeChefO";
	}
	
	
	@GetMapping("getChefO")
	public String getChefO(@RequestParam("numChef") int numChef, Model m)
	{
		ChefO chefo = icr.findById(numChef).get();
		
		m.addAttribute("chefO", chefo);
		
		return"afficherChefO";
	}
	
	@GetMapping("delete/{numChef}")
	public String deleteChefO(@PathVariable("numChef") int numChef)
	{
		icr.deleteById(numChef);
		
		return "redirect:/listeChefO";
	}
	
	@GetMapping("update/{numChef}")
	public String ModifChefO(@PathVariable("numChef") int numChef, Model m)
	{
		m.addAttribute("chef",icr.getReferenceById(numChef));
		
		return "modifC";
	}
	
	@PostMapping("modifC")
	public String updateVoiture(@ModelAttribute ("chefO") ChefO chefo)
	{
		
		 icr.save(chefo);
			
		return "redirect:/listeChefO";
	}
	
	
	@GetMapping("formSoliste")
	public String formSoliste()
	{
		return "formSoliste";
	}

	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste S)
	{
		isr.save(S);
		
		return "redirect:/formSoliste";
	}
		
	@GetMapping("listeSoliste")
	public String listeSoliste(Model m)
	{
		m.addAttribute("listeS", isr.findAll());
		
		return "listeSoliste";
	}
	
	@GetMapping("deleteSoliste/{id}")
	public String deleteSoliste(@PathVariable("id") int id)
	{
		isr.deleteById(id);
		
		return "redirect:/listeSoliste";
	}
	
	@GetMapping("modifSoliste/{id}")
	public String modifSoliste(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("soliste", isr.getReferenceById(id));
		
		return "modifSoliste";
	}
	
	@PostMapping("updateSoliste")
	public String updateSoliste(@ModelAttribute("vol") Soliste s)
	{
		isr.save(s);
		
		return "redirect:/listeSoliste";
	}

	}

