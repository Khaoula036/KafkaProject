package com.saniia.kc.adtmvt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insa.kc.etudiants.service.IntegrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KcAdtmvtApplicationTests {
    
    @Autowired
    IntegrationService integrationService;

    @Test
    public void testIntegration() throws JsonProcessingException {
        String jsonString = "{\n" +
"	\"patient_movement\": {\n" +
"		\"dcMsgType\": \"ADT\",\n" +
"		\"dcMsgTypeDesc\": \"Admission externe\",\n" +
"		\"dcMsgStructure\": \"ADT_A01\",\n" +
"		\"dcMsgControlId\": \"31015578\",\n" +
"		\"dcMsgSequenceId\": \"28439798\",\n" +
"		\"dcMsgIpgId\": \"A03\",\n" +
"		\"dcMsgIpgNamespace\": \"IPG\",\n" +
"		\"dcMsgIpgAction\": \"ADD_ENTREE_HOPITAL\",\n" +
"		\"dcZbeDate\": \"20201208153600\",\n" +
"		\"dcZbeAction\": \"INSERT\",\n" +
"		\"typeDeMvt\": \"M\",\n" +
"		\"age\": 61,\n" +
"		\"ddn\": \"1960-04-14\",\n" +
"		\"cp\": \"59440\",\n" +
"		\"ville\": \"DOMPIERRE SUR HELPE\",\n" +
"		\"codePays\": \"FRA\",\n" +
"		\"ipp\": \"596296\",\n" +
"		\"iep\": \"688332300\",\n" +
"		\"uf\": \"8004\",\n" +
"		\"ufHebergement\": \"8004\",\n" +
"		\"dateIn\": \"2020-12-08 15:36:00\",\n" +
"		\"dateOut\": \"2020-12-08 23:59:00\",\n" +
"		\"dateMvt\": \"20201208153650\",\n" +
"		\"batiment\": \"\",\n" +
"		\"etablissement\": \"\",\n" +
"		\"chambre\": \"\",\n" +
"		\"lit\": \"\",\n" +
"		\"typeEntree\": \"A04\",\n" +
"		\"typeSortie\": \"\",\n" +
"		\"codeNationalite\": \"FRA\",\n" +
"		\"sexe\": \"M\",\n" +
"		\"medecinTraitant\": \"BOMBECKE BENOIT\",\n" +
"		\"medecinTraitantLocalisation\": \"\",\n" +
"		\"medecinTraitantId\": \"998910\"\n" +
"	},\n" +
"	\"bem_patients\": {\n" +
"		\"adresse\": \"16    RTEDE CARTIGNIES\",\n" +
"		\"cp\": \"59440\",\n" +
"		\"ddn\": \"1960-04-14\",\n" +
"		\"ipp\": \"596296456\",\n" +
"		\"nom\": \"\",\n" +
"		\"nomMar\": \"MACARET\",\n" +
"		\"numss\": \"12356789435612\",\n" +
"		\"prenom\": \"ALAIN\",\n" +
"		\"tel\": \"0637190495\",\n" +
"		\"ville\": \"DOMPIERRE SUR HELPE\",\n" +
"		\"messageControlId\": \"31015578\",\n" +
"		\"sequenceNumber\": \"EH_8909520_1\",\n" +
"		\"sexe\": \"M\",\n" +
"		\"iep\": \"688332300\",\n" +
"		\"ufh\": \"8004\",\n" +
"		\"cac\": \"8004EXBC\",\n" +
"		\"uhm\": \"8004\",\n" +
"		\"chambre\": \"\",\n" +
"		\"lit\": \"\",\n" +
"		\"datedebsej\": \"2020-12-08 15:36:00\",\n" +
"		\"datefinsej\": \"2020-12-08 23:59:00\",\n" +
"		\"typesortie\": \"\",\n" +
"		\"statutpat\": \"O\",\n" +
"		\"typeentre\": \"A04\",\n" +
"		\"identifiant\": \"EH_8909520_1\",\n" +
"		\"patientclass\": \"O\",\n" +
"		\"dateenv\": \"20201208153650\",\n" +
"		\"uuid\": \"596296\"\n" +
"	}\n" +
"}";
        
        integrationService.integrateMessage(jsonString, "ADTMVT");
    }

}
