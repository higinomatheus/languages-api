package br.com.alura.languagesapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/language")
    public String putLanguage(@RequestBody Language language) {
        Optional<Language> lang = repository.findById(language.getId());
        if (!lang.isEmpty()) {
            repository.save(language);
            return "Language updated";
        } else {
            return "Language NOT updated";
        }
    }

    @DeleteMapping("/language")
    public String deleteImage(@RequestParam String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Language deleted";
        } else {
            return "Invalid id";
        }
    }
}