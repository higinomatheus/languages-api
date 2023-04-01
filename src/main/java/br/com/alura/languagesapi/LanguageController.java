package br.com.alura.languagesapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/language")
    public List<Language> getLanguage() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping("/language")
    public ResponseEntity<Language> postLanguage(@RequestBody Language language) {
        Language lang = repository.insert(language);
        return new ResponseEntity<>(lang, HttpStatus.CREATED);
    }
}
