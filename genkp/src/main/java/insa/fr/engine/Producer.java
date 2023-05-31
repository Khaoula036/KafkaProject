package insa.fr.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*********************
 * @author tondeur-h
 *********************/

@Service
public class Producer {
    
    //private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    
    @Value("${application.topic}")
    private String TOPIC;
   
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        //logger.info(String.format("#### -> Producing message -> %s", message));
       
        try
        {
        this.kafkaTemplate.send(TOPIC, message);
        } 
        catch (Exception e) 
        {
            //logger.info(String.format("#### -> Error sending message -> %s", message));      
        }
    }
}
