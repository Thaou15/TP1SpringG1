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


@Controller
public class MainController {
	
	@Autowired
	ISolisteRepository isr;
	
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

