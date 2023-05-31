package com.insa.kc.etudiants.controller;

import com.insa.kc.etudiants.service.IntegrationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TONDEUR Hervé
 */
@RestController
public class ConsumerController {
    
    @Autowired
    IntegrationService integrationService;
    
    @Value("${spring.kafka.consumer.topic-name}")
    private String topic;
    
    /**
     * Appel au service d'intégration
     * @param message 
     */
    @KafkaListener(topics = "${spring.kafka.consumer.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        integrationService.integrateMessage(message, topic);
    }
	
	 /***************************************************************************
     * Ce service est prévu pour être appelé dzans le cas d'un test de bon
     * fonctionnement, dans ce cas il retournera une réponse json
     * {"reponse":"42"} si le service est disponible, sinon ce sera un retour de
     * statut http 500
     ***************************************************************************/
    @GetMapping(value = "/isalive", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "[PROD] : Interroger le service pour connaitre sont état, retourne la réponse à la question sur l'univers et tout et tout.")
    private String bem_isAlive() 
    {
        String rep = "{\"reponse\":\"42\"}";
        return rep;
    }
    
}
