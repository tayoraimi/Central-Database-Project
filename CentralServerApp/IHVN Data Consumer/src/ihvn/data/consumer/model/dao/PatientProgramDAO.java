/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihvn.data.consumer.model.dao;

import ihvn.data.consumer.model.xml.PatientIdentifierType;
import ihvn.data.consumer.model.xml.PatientProgramType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rsuth
 */
public class PatientProgramDAO {
     public List<PatientProgramType> getAllPatientPrograms(int patientId)
    {
        String query = "SELECT patient_program.*, program.name AS program_name FROM patient_program "
                + " JOIN program ON program.program_id=patient_program.program_id "
                + "WHERE patient_id="+patientId;  
              
            Statement stmt = null;
            ResultSet rs = null;
            Connection con = null;
            List<PatientProgramType> allIdentifiers = new ArrayList<>();
            //System.out.println("Connection list "+Database.connectionPool.totalConnections());
            try {
                con = Database.connectionPool.getConnection();
                stmt = con.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);
                
                stmt.setFetchSize(Integer.MIN_VALUE);
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                   // PatientProgramType patientProgram = buildPatientProgram(rs);
                   
                    //allIdentifiers.add(patientProgram);
                    
                }
                //rs.close();
                //stmt.close();
                return allIdentifiers;
            } catch (SQLException ex) {
                //screen.updateStatus(ex.getMessage());
                ex.printStackTrace();
                return null;
                
            } finally {
                try {
                    rs.close();
                    stmt.close();
                    //Database.connectionPool.free(con);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    //Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
    }
    
  
}
