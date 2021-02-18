package com.tim.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tim.languages.models.Language;
import com.tim.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, 
							String name, 
							String creator, 
							Integer version) {
		Language lang = findLanguage(id);
		lang.setName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		return languageRepository.save(lang);
	}
	
	public Language deleteLanguage(Long id) {
		Language lang = findLanguage(id);
		languageRepository.deleteById(id);
		return lang;
	}

	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
}
