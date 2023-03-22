package com.inti.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Concert;
import com.inti.model.Lieu;
import com.inti.model.Oeuvre;
import com.inti.repository.IChefORepository;
import com.inti.repository.IConcertRepository;
import com.inti.repository.ILieuRepository;
import com.inti.repository.IOeuvreRepository;

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

import com.inti.model.ChefO;


@Controller
public class MainController {

	@Autowired
	IOeuvreRepository ior;

	@Autowired
	IConcertRepository iconr;

	@Autowired
	ILieuRepository ilr;

	@Autowired
	ISolisteRepository isr;

	@Autowired
	IChefORepository icr;

	@GetMapping("createOeuvre")
	public String createOeuvreForm() {
		return "createOeuvreForm";
	}

	@PostMapping("createOeuvre")
	public String createOeuvre(@ModelAttribute("oeuvre") Oeuvre o, @RequestParam("idConcert") int idC, @RequestParam("idChef") int numChef) {
		Concert c = iconr.findById(idC).get();
		ChefO co = icr.findById(numChef).get();
		o.setConcert(c);
		o.setChefo(co);
//		List<Oeuvre> listOeuvre = c.getListOeuvres();
//		listOeuvre.add(o);
//		c.setListOeuvres(listOeuvre);
//		
//		System.out.println(listOeuvre);
		ior.save(o);
//		iconr.save(c);

		return "redirect:/createOeuvre";
	}

	@GetMapping("readOeuvre")
	public String readOeuvre(Model m) {
		List<Oeuvre> listOeuvre = ior.findAll();
		m.addAttribute("listeOeuvre", listOeuvre);
		return "readOeuvre";
	}

	@GetMapping("deleteOeuvre/{id}")
	public String deleteOeuvre(@PathVariable int id) {
		ior.deleteById(id);
		return "redirect:/readOeuvre";
	}

	@GetMapping("updateOeuvre/{id}")
	public String updateOeuvreForm(@PathVariable int id, Model m) {
		m.addAttribute("oeuvre", ior.getReferenceById(id));
		int idC = ior.findById(id).get().getConcert().getId();
		m.addAttribute("idC", idC);
		return "updateOeuvreForm";
	}

	@PostMapping("updateOeuvre")
	public String updateOeuvre(@ModelAttribute("oeuv") Oeuvre o, @RequestParam("concert") int idC) {
		o.setConcert(iconr.findById(idC).get());
		ior.save(o);
		return "redirect:/readOeuvre";
	}

	@GetMapping("createConcert")
	public String createConcertForm() {
		return "createConcertForm";
	}

	@PostMapping("createConcert")
	public String createConcert(@ModelAttribute("concert") Concert c, @RequestParam("idLieu") int idL) {
		c.setLieu(ilr.findById(idL).get());
		iconr.save(c);
		return "redirect:/createConcert";
	}

	@GetMapping("readConcert")
	public String readConcert(Model m) {
		List<Concert> listConcert = iconr.findAll();
		m.addAttribute("listeConcert", listConcert);
		return "readConcert";
	}

	@GetMapping("deleteConcert/{id}")
	public String deleteConcert(@PathVariable int id) {
		iconr.deleteById(id);
		return "redirect:/readConcert";
	}

	@GetMapping("updateConcert/{id}")
	public String updateConcertForm(@PathVariable int id, Model m) {
		m.addAttribute("concert", iconr.getReferenceById(id));
		int idL = iconr.findById(id).get().getLieu().getId();
		m.addAttribute("idL", idL);
		return "updateConcertForm";
	}

	@PostMapping("updateConcert")
	public String updateConcert(@ModelAttribute("conc") Concert c, @RequestParam("lieu") int idL) {
		c.setLieu(ilr.findById(idL).get());
		iconr.save(c);
		return "redirect:/readConcert";
	}

	@GetMapping("createLieu")
	public String createLieuForm() {
		return "createLieuForm";
	}

	@PostMapping("createLieu")
	public String createLieu(@ModelAttribute("lieu") Lieu l) {
		ilr.save(l);
		return "redirect:/createLieu";
	}

	@GetMapping("readLieu")
	public String readLieu(Model m) {
		List<Lieu> listLieu = ilr.findAll();
		m.addAttribute("listeLieu", listLieu);
		return "readLieu";
	}

	@GetMapping("deleteLieu/{id}")
	public String deleteLieu(@PathVariable int id) {
		ilr.deleteById(id);
		return "redirect:/readLieu";
	}

	@GetMapping("updateLieu/{id}")
	public String updateLieuForm(@PathVariable int id, Model m) {
		m.addAttribute("lieu", ilr.getReferenceById(id));
		return "updateLieuForm";
	}

	@PostMapping("updateLieu")
	public String updateLieu(@ModelAttribute("li") Lieu l) {
		ilr.save(l);
		return "redirect:/readLieu";
	}

	

	@GetMapping("ajoutChefO")
	public String ajoutChefOrchestre() {
		return "formChefO";
	}

	@PostMapping("saveChefO")
	public String saveVoiture(@ModelAttribute("chefO") ChefO chefO) {
		icr.save(chefO);

		return "redirect:/ajoutChefO";
	}

	@GetMapping("listeChefO")
	public String listeChefO(Model m) {

		m.addAttribute("listeChef", icr.findAll());

		return "listeChefO";
	}

	@GetMapping("getChefO")
	public String getChefO(@RequestParam("numChef") int numChef, Model m) {
		ChefO chefo = icr.findById(numChef).get();

		m.addAttribute("chefO", chefo);

		return "afficherChefO";
	}

	@GetMapping("delete/{numChef}")
	public String deleteChefO(@PathVariable("numChef") int numChef) {
		icr.deleteById(numChef);

		return "redirect:/listeChefO";
	}

	@GetMapping("update/{numChef}")
	public String ModifChefO(@PathVariable("numChef") int numChef, Model m) {
		m.addAttribute("chef", icr.getReferenceById(numChef));

		return "modifC";
	}

	@PostMapping("modifC")
	public String updateVoiture(@ModelAttribute("chefO") ChefO chefo) {

		icr.save(chefo);

		return "redirect:/listeChefO";
	}
	
	@GetMapping("formSoliste")
	public String formSoliste() {
		return "formSoliste";
	}

	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste S) {
		isr.save(S);

		return "redirect:/formSoliste";
	}

	@GetMapping("listeSoliste")
	public String listeSoliste(Model m) {
		m.addAttribute("listeS", isr.findAll());

		System.out.println("abc" + isr.findAll());

		return "listeSoliste";
	}

	@GetMapping("deleteSoliste/{id}")
	public String deleteSoliste(@PathVariable("id") int id) {
		isr.deleteById(id);

		return "redirect:/listeSoliste";
	}

	@GetMapping("modifSoliste/{id}")
	public String modifSoliste(@PathVariable("id") int id, Model m) {
		m.addAttribute("soliste", isr.getReferenceById(id));

		return "modifSoliste";
	}

	@PostMapping("updateSoliste")

	public String updateSoliste(@ModelAttribute("sol") Soliste s)
	{

		isr.save(s);

		return "redirect:/listeSoliste";
	}

}
