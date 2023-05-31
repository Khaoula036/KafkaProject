package com.insa.kc.etudiants.repository;

import com.insa.kc.etudiants.entity.Etudiants;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TONDEUR Hervé
 */
public interface EtudiantsRepository extends CrudRepository<Etudiants, Integer> {
    
    /**
     *
     * @param identifiant
     * @return
     */
    Etudiants findByidentifiant(String identifiant);
    
}
