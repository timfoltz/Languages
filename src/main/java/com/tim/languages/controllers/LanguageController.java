package com.tim.languages.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tim.languages.models.Language;
import com.tim.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		
		return "/languages/index.jsp";
	}
	
	@RequestMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language") Language Language) {
		return "/languages/new.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language Language, BindingResult result) {
		if(result.hasErrors()) {
			return"/languages/new.jsp";
		} else {
			languageService.createLanguage(Language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findLanguage(id);
		model.addAttribute("lang",lang);
		return "/languages/show.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findLanguage(id);
		model.addAttribute("language",lang);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}/", method=RequestMethod.PUT)
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return"/languages/edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	

}
