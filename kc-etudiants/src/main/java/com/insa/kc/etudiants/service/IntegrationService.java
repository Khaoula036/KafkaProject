package com.insa.kc.etudiants.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insa.kc.etudiants.entity.Etudiants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matthieu Bouchez
 */

@Service
public class IntegrationService {
    
    @Autowired
    EtudiantsService etudiantsService;
    
    
    /**
     * Mapping JSON => Entities & Intégration en base
     * @param message 
     * @param topic 
     */
    public void integrateMessage(String message, String topic) {
        
        JSONObject jsonMessage = new JSONObject(message);
        
        Etudiants bemEtudiants;

            try {
                //init & read mapper
                ObjectMapper mvtMapper = new ObjectMapper();
                bemEtudiants= mvtMapper.readValue(jsonMessage.toString(), Etudiants.class);
                  
                etudiantsService.save(bemEtudiants);
            } catch (JsonProcessingException ex) {
                //ex.printStackTrace();
             }
    }
    
}
