/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihvn.data.consumer.controller;

import ihvn.data.consumer.model.dao.FacilityDAO;
import ihvn.data.consumer.model.dao.PatientBiometricDAO;
import ihvn.data.consumer.model.dao.PatientDAO;
import ihvn.data.consumer.model.dao.PatientIdentifierDAO;
import ihvn.data.consumer.model.dao.VisitDAO;
import ihvn.data.consumer.model.xml.Container;
import ihvn.data.consumer.model.xml.DemographicsType;
import ihvn.data.consumer.model.xml.MessageDataType;
import ihvn.data.consumer.model.xml.MessageHeaderType;
import ihvn.data.consumer.model.xml.PatientBiometricType;
import ihvn.data.consumer.model.xml.PatientIdentifierType;
import ihvn.data.consumer.model.xml.VisitType;
import java.util.List;

/**
 *
 * @author rsuth
 */
public class ContainerController {
    
    private int facilityId = 0;
    private String datimId = "";
    private String messageUUID = "";
    private Container container;
    private String patientUUID = "";
    
    //visit 
    public void saveContainer(Container cnt)
    {
        this.container = cnt; 
        MessageHeaderType messageHeader = this.container.getMessageHeader(); 
        MessageDataType messageData = this.container.getMessageData();
        //get the facility
        patientUUID = messageData.getDemographics().getPatientUuid();
        datimId = messageHeader.getFacilityDatimCode();
        messageUUID = messageHeader.getMessageUniqueID();
        
        facilityId = 0;//FacilityDAO.getFacilityWithDatimCode(messageHeader.getFacilityDatimCode());
        
        //save patient demographics details
        DemographicsType demo = messageData.getDemographics();
        
        //patientUUID = PatientDAO.getPatientIdWithUUID(demo.getPatientUUID());
        
        PatientDAO.insertOrUpdatePatient(demo, datimId, messageUUID);
        
        //save patient biometrics
        if(this.container.getMessageData().getPatientBiometrics() != null){
             this.savePatientBiometrics();
        }
       
        //save the patient identifiers
        this.savePatientIdentifiers();
        
        //save visits
        this.saveVisits();
        
    }
    
    
    private void savePatientBiometrics()
    {
        List<PatientBiometricType> biometrics = this.container.getMessageData().getPatientBiometrics();
        //first delete any existing biometrics record for ths patient 
        //PatientBiometricDAO.deleteExisitingBiometrics(patientId);
        //now insert the biometrics afresh
        PatientBiometricDAO.savePatientBiometrics(patientUUID, datimId, messageUUID,  biometrics);
    }
    
    
    
    private void savePatientIdentifiers()
    {
        List<PatientIdentifierType> identifiers = this.container.getMessageData().getPatientIdentifiers();
        //PatientIdentifierDAO.deleteExisitingIdentifiers(patientId);
        PatientIdentifierDAO.savePatientIdentifiers(datimId, messageUUID, identifiers);
    }
    
    private void saveVisits()
    {
        List<VisitType> allVisits = this.container.getMessageData().getVisits();
        //VisitDAO.deleteVisits(patientId);
      
        //long firstVisitId = VisitDAO.saveVisits(patientId, facilityId, allVisits);
        VisitDAO.saveVisits(datimId, messageUUID, allVisits);

        // save the encounters
        String patientUUID = this.container.getMessageData().getDemographics().getPatientUuid();
        long firstEncounterId = VisitDAO.saveEncounters(patientUUID, datimId, messageUUID, this.container.getMessageData().getEncounters());

        //save obs
        VisitDAO.saveObs(datimId, messageUUID, this.container.getMessageData().getObs());  
    }
    
   
    
    
    
    
    
    
}
