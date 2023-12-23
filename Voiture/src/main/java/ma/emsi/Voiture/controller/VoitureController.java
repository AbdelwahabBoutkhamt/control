package ma.emsi.Voiture.controller;

import jakarta.ws.rs.Path;
import ma.emsi.Voiture.model.Voiture;
import ma.emsi.Voiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureController {

    @Autowired
    VoitureRepository voitureRepository;

    @GetMapping("/voitures")
    public List<Voiture> findAllVoitures() {
        return voitureRepository.findAll();
    }

    @GetMapping("/voitures/{id}")
    public Voiture findVoitureById(@PathVariable Long id) throws Exception {
        return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistante"));
    }

}
