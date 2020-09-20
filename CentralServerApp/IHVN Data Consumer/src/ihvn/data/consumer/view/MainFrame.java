/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihvn.data.consumer.view;

import ihvn.data.consumer.controller.MainController;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;

/**
 *
 * @author rsuth
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public static int fileCount = 0;
    public static AtomicInteger currCount = new AtomicInteger(0);
    MainController main = new MainController(this);
    
    public MainFrame() {
        initComponents();
        
         Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainFrame.this.startCheckingForFiles();
                MainFrame.this.startSettingProgress();
            }
          }, 3000);
        
        
        
    }
    
    
    public  void startCheckingForFiles()
    {
        if(main.initDb())//ftry to establish db connection first
        {
            do
             {
                 try {
                     System.out.println("no file to process. waiting for 3 seconds");
                     Thread.sleep(3000);//sleep for about 3seconds
                      System.out.println("Searching for files");
                 } catch (InterruptedException ex) {
                    ex.printStackTrace();
                 }

                
             }while(!main.newFilesExists());
            //once new files are found start processing
            MainFrame.currCount.set(0);
             main.readXMLs();//check again
             
             //perform ETL
             

        }
        else{
            System.out.println("An error occured");
        }
    }
    
    private void startSettingProgress()
    {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
              // Your database code here
              //MainFrame.this.setProgress(MainController.counter);
              
              MainFrame.this.setProgress(MainFrame.currCount.get());
              
              if(MainFrame.currCount.get()+10 > MainFrame.fileCount)
              {
                  System.out.println(MainFrame.currCount.get());
                   MainFrame.this.setProgress(MainFrame.currCount.get());
                  
              }
            
              
            }
          }, 100, 10);
        
    }
    
    public void setProgress(int patientCount)
    {
       
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                //MainFrame
               // MainFrame.this.totalPatient = patientCount;
                //MainFrame.this.txtPatientCount.setText("Processed Patient "+patientCount+" of "+MainFrame.this.totalPatient);
                if(patientCount -1 == MainFrame.fileCount)
                {
                    //MainFrame.this.txtPatientCount.setText("Processed Patient "+patientCount+" of "+MainFrame.totalPatient);
                
                    int progress = 100;
                    myProgressBar.setString( "Processed Files "+MainFrame.currCount+" of "+MainFrame.fileCount + ":  "+progress +" % complete");
                    myProgressBar.setValue(progress);
                    MainFrame.this.txtPatientCount.setText("Processed file "+MainFrame.currCount+" of "+MainFrame.fileCount);
                }
                else{
                     
                    int progress = (MainFrame.fileCount > 0) ? (patientCount *100) / MainFrame.fileCount : 0;
                    myProgressBar.setString( "Processed Patient "+patientCount+" of "+MainFrame.fileCount + ":  "+progress +" % complete");
                    myProgressBar.setValue(progress);
                     MainFrame.this.txtPatientCount.setText("Processed File "+MainFrame.currCount+" of "+MainFrame.fileCount);
                }
               
                //System.out.println("progress:"+progress);
                //System.out.println("Patinet count:"+patientCount);
                //System.out.println("total count:"+MainFrame.totalPatient);
                jpProgressPanel.repaint();
               
            }
            
        
        });
        
        
       // revalidate();
       
       // jpExtractionPanel.repaint();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpProgressPanel = new javax.swing.JPanel();
        myProgressBar = new javax.swing.JProgressBar();
        txtPatientCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpProgressPanelLayout = new javax.swing.GroupLayout(jpProgressPanel);
        jpProgressPanel.setLayout(jpProgressPanelLayout);
        jpProgressPanelLayout.setHorizontalGroup(
            jpProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProgressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jpProgressPanelLayout.setVerticalGroup(
            jpProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProgressPanelLayout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(myProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtPatientCount.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jpProgressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtPatientCount, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jpProgressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPatientCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpProgressPanel;
    private javax.swing.JProgressBar myProgressBar;
    private javax.swing.JLabel txtPatientCount;
    // End of variables declaration//GEN-END:variables
}
