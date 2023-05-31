package com.insa.kc.etudiants.service;

import com.insa.kc.etudiants.entity.Etudiants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insa.kc.etudiants.repository.EtudiantsRepository;

/**
 *
 * @author Tondeur Hervé
 */
@Service
public class EtudiantsService {
    
    @Autowired
    EtudiantsRepository etudiantsRepo;
    
    public Etudiants findByiep(String identifiant) {
        return etudiantsRepo.findByidentifiant(identifiant);
    }
    
    public void save(Etudiants betd) {
        etudiantsRepo.save(betd);
    }
    
}
