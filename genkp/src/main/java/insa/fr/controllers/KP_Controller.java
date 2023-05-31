package insa.fr.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import insa.fr.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/********************
 * @author tondeur-h
 ********************/

@RestController
@RequestMapping(value = "/insa")
@Api(value = "Envoie des données vers Kafka Producer")
public class KP_Controller 
{    
 
    private final Producer producer;

    
    private final String service=this.getClass().getName();

    //associé la classe producer au producer attendu dans le controleur
    @Autowired
    KP_Controller(Producer producer) {this.producer = producer;}

     /***************************************************************************
     * Ce service est prévu pour être appelé dans le cas d'un test de bon
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
    
    
    //message pour l'autodoc du service
    @ApiOperation(value = "Send Message to Kafka Topic http://localhost:port/insa/kppublish")
    //definition du service kppublish de saniia
    @PostMapping(value = "/kppublish")
    public ResponseEntity<Object> sendMessageToKafkaTopic(@RequestBody() String message)
    {
       
        this.producer.sendMessage(message);  //envoyer message lu dans le body vers Kafka vers le topic paramètrè sur le service

        return new ResponseEntity<>("{\"reponse\":\"Inserted\"}", HttpStatus.CREATED);  //retourner réussite en cas d'échec c'est le gestionnaire d'exceptions qui prend le relais.
    }
}
