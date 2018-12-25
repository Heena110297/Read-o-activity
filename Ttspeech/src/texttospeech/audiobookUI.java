

package texttospeech;

import java.awt.BorderLayout;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 import javax.speech.*;
import javax.speech.synthesis.Voice;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.adobe.acrobat.*;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import javafx.embed.swing.SwingNode;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;






public class audiobookUI extends javax.swing.JFrame {
   
    
    String speaktext;
    Play th;
    Speaking ss;
    private Connection con = null;
    private Object fileRenderPanel;
    
    public audiobookUI() {
        this.con = null;
         initComponents();
    }    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        search = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        play = new javax.swing.JButton();
        resume = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        speedSlider = new javax.swing.JSlider();
        pitchSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ChooseFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jToggleButton1.setText("jToggleButton1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        fileChooser.setDialogTitle("");
        fileChooser.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dictionary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), java.awt.Color.blue)); // NOI18N

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clear))
        );

        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(274, 359));
        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jDesktopPane1.add(jInternalFrame1);
        jInternalFrame1.setBounds(0, 0, 380, 370);
        try {
            jInternalFrame1.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jTabbedPane1.addTab("tab1", jDesktopPane1);

        play.setText("Play");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        resume.setText("Resume");
        resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeActionPerformed(evt);
            }
        });

        pause.setText("Pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        speedSlider.setMajorTickSpacing(100);
        speedSlider.setMaximum(400);
        speedSlider.setMinorTickSpacing(10);
        speedSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        speedSlider.setName("Speed"); // NOI18N
        speedSlider.setOpaque(false);
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        pitchSlider.setMajorTickSpacing(50);
        pitchSlider.setMaximum(200);
        pitchSlider.setMinorTickSpacing(10);
        pitchSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        pitchSlider.setPaintLabels(true);
        pitchSlider.setPaintTicks(true);
        pitchSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pitchSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Speed");

        jLabel2.setText("Pitch");

        ChooseFile.setText("Choose File");
        ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFileActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Search Web");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setText("Type Query");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pause, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChooseFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(pitchSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(play)
                            .addComponent(resume)
                            .addComponent(pause)
                            .addComponent(ChooseFile)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pitchSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getAccessibleContext().setAccessibleName("jFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void actionPerformed(java.awt.event.ActionEvent evt) {
     
    
            }
    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
       Voice alan = new Voice("alan",Voice.GENDER_FEMALE, Voice.AGE_CHILD, null);
        ss = new Speaking();
        th = new Play(ss,jTextArea2.getText(),alan);
        th.start();
    }//GEN-LAST:event_playActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        try
        {
        ss.st_op();
        } catch (EngineException ex) {
            ex.printStackTrace();
        }  
    }//GEN-LAST:event_pauseActionPerformed

    private void resumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeActionPerformed
        One   th1 = new One(ss);
      th1.start();
    }//GEN-LAST:event_resumeActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {                                       
            jTextArea3.setText("");
            con = Dbcon.getConnection();
            PreparedStatement ps;
            String meaning;
            String sql = "SELECT definition FROM entries where word =LOWER(?) ";
           // String sql = "{call getMeaning (?, ?)}";
             /*
            CREATE DEFINER=`root`@`localhost` PROCEDURE `getMeaning`(IN WORD VARCHAR(45),OUT MEANING VARCHAR(255))
            BEGIN
            SELECT definition INTO MEANING
            FROM entries
            WHERE word = WORD;
            END
            */
            ps = con.prepareStatement(sql);
            String word = jTextField1.getText();
            ps.setString(1, word.trim().toLowerCase());
            try
            {
            ResultSet rs = ps.executeQuery();
           // while(rs.next())
            rs.absolute(1);
            meaning = rs.getString("definition");
            jTextArea3.append("1.");
            jTextArea3.append(meaning);
            jTextArea3.append("\n\n");
            rs.absolute(2);
            meaning = rs.getString("definition");
            jTextArea3.append("2.");
            jTextArea3.append(meaning);
            jTextArea3.append("\n");
            }
            catch(SQLException ex)
            {
                jTextArea3.setText("Sorry :)\n");
                jTextArea3.append("Your Search could not be completed\nPlease try again !");
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        jTextField1.setText(" ");
        jTextArea3.setText(" ");
    }//GEN-LAST:event_clearActionPerformed

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        // TODO add your handling code here:
        Speaking s = new Speaking();
        s.change_speed((float)speedSlider.getValue());
        
    }//GEN-LAST:event_speedSliderStateChanged

    private void pitchSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pitchSliderStateChanged
        // TODO add your handling code here:
        Speaking s = new Speaking();
        s.change_speed((float)pitchSlider.getValue());
        
    }//GEN-LAST:event_pitchSliderStateChanged

    private void ChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFileActionPerformed

int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
    
    try {
        File file = fileChooser.getSelectedFile();
        String f = file.getAbsolutePath();
        
        PDDocument doc = PDDocument.load(file); // put path to your input pdf file here
		    String text =  new PDFTextStripper().getText(doc);
		   // System.out.println("Text in PDF: " + text );
                    //jTextArea2.read( new FileReader( file.getAbsolutePath() ), null );
                    jTextArea2.setText(text);
		    
		    // write the content to text file
		    PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Toshiba\\Desktop\\null.txt")); // put path to your output text file here
		   // Path p = Files.write(Paths.get(f), text.getBytes(), StandardOpenOption.CREATE ,);
                    //String s;			
            //s = p.getFileStore();
        
        
        Viewer viewer = null;
        jInternalFrame1.setLayout(new BorderLayout());
        jInternalFrame1.setVisible(true);
        viewer = new Viewer();
       
        //frame.add(viewer, BorderLayout.CENTER);
        InputStream input = null;
        
        input = new FileInputStream (new File(f));
        
        viewer.setDocumentInputStream(input);
        viewer.setProperty("Default_Page_Layout", "SinglePage");
        viewer.setProperty("Default_Zoom_Type", "FitPage");
        viewer.setProperty("Default_Magnification", "100");
        viewer.activate();
        
         jInternalFrame1.getContentPane().add(viewer, BorderLayout.CENTER);
        jInternalFrame1.setSize(jDesktopPane1.getWidth(),jDesktopPane1.getHeight());
        jInternalFrame1.setLocation(0,0);
      // jInternalFrame1.setBounds(jDesktopPane1.getBounds());

        
        jInternalFrame1.pack();
        jInternalFrame1.show();
    } catch (Exception ex) {
        Logger.getLogger(audiobookUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
  
          
   

    }//GEN-LAST:event_ChooseFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
  
 		
 	}
    
    
    
   public void mouseReleased(MouseEvent e) {
    if (jTextArea2.getSelectedText() != null) { // See if they selected something 
        String s = jTextArea2.getSelectedText();
        s = s.trim();
        for(int i =0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch==' ') {
            
                s = s.substring(0,i);
            
            break;
            }
        }
        jTextField1.setText(s);
    }
} 
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
            java.util.logging.Logger.getLogger(audiobookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(audiobookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(audiobookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(audiobookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          //JFrame.pack();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new audiobookUI().setVisible(true);
            }
        });
        
    }
     
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseFile;
    private javax.swing.JButton clear;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton pause;
    private javax.swing.JSlider pitchSlider;
    private javax.swing.JButton play;
    private javax.swing.JButton resume;
    private javax.swing.JButton search;
    private javax.swing.JSlider speedSlider;
    // End of variables declaration//GEN-END:variables

    private void createAndSetSwingContent(SwingNode swingNode, JPanel viewerComponentPanel) {
        
       
     SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
             swingNode.setContent(viewerComponentPanel);
         }
     });
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}