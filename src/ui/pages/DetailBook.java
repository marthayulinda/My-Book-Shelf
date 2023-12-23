/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.pages;

import entity.MyBookShelf;
import service.BookShelfService;

/**
 *
 * @author Martha
 */
public class DetailBook extends javax.swing.JFrame {
    private MyBookShelf myBookShelf;
    private BookShelfService bookShelfService;
   
    
    
    public DetailBook(int selectedIsbn) {
        myBookShelf = bookShelfService.getByIsbn(selectedIsbn);
        initComponents();
        setLabels(myBookShelf);
    }
    
     public DetailBook() {
        initComponents();
    }
    
     public void setMyBook(MyBookShelf myBookShelf) {
        this.myBookShelf = myBookShelf;
        
        setLabels(this.myBookShelf);
    }
     
    private void setLabels(MyBookShelf myBookShelf) {
    
        if (myBookShelf != null) {
        lblDetailISBN.setText(String.valueOf(myBookShelf.getIsbn()));
        lblDetailTitle.setText(myBookShelf.getTitle());
        lblDetailAuthor.setText(myBookShelf.getAuthor());
        lblDetailPublisher.setText(myBookShelf.getPublisher());
        lblDetailYear.setText(String.valueOf(myBookShelf.getYear()));
        lblDetailTotalPages.setText(String.valueOf(myBookShelf.getTotalPages()));
    } else {
        // Jika myBookShelf kosong (null), atur label menjadi "-" atau tindakan lainnya
        lblDetailISBN.setText("-");
        lblDetailTitle.setText("-");
        lblDetailAuthor.setText("-");
        lblDetailPublisher.setText("-");
        lblDetailYear.setText("-");
        lblDetailTotalPages.setText("-");
    }
    }
    
      public void setBookShelfService(BookShelfService bookShelfService) {
        this.bookShelfService = bookShelfService;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDetailISBN = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblDetailTitle = new javax.swing.JLabel();
        lblActivity = new javax.swing.JLabel();
        lblDetailAuthor = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        lblStatus2 = new javax.swing.JLabel();
        lblDetailPublisher = new javax.swing.JLabel();
        lblStatus3 = new javax.swing.JLabel();
        lblDetailYear = new javax.swing.JLabel();
        lblDetailTotalPages = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jPanel1.setDoubleBuffered(false);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detail Todo");
        jLabel1.setOpaque(true);

        lblDetailISBN.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailISBN.setForeground(new java.awt.Color(51, 51, 51));
        lblDetailISBN.setText("-");
        lblDetailISBN.setOpaque(true);

        lblID.setBackground(new java.awt.Color(102, 102, 102));
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ISBN");
        lblID.setOpaque(true);

        lblDetailTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblDetailTitle.setText("-");
        lblDetailTitle.setOpaque(true);

        lblActivity.setBackground(new java.awt.Color(102, 102, 102));
        lblActivity.setForeground(new java.awt.Color(255, 255, 255));
        lblActivity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActivity.setText("Title");
        lblActivity.setOpaque(true);

        lblDetailAuthor.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailAuthor.setForeground(new java.awt.Color(51, 51, 51));
        lblDetailAuthor.setText("-");
        lblDetailAuthor.setOpaque(true);

        lblStatus.setBackground(new java.awt.Color(102, 102, 102));
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Author");
        lblStatus.setOpaque(true);

        lblStatus1.setBackground(new java.awt.Color(102, 102, 102));
        lblStatus1.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus1.setText("Publisher");
        lblStatus1.setOpaque(true);

        lblStatus2.setBackground(new java.awt.Color(102, 102, 102));
        lblStatus2.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus2.setText("Year");
        lblStatus2.setOpaque(true);

        lblDetailPublisher.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailPublisher.setForeground(new java.awt.Color(51, 51, 51));
        lblDetailPublisher.setText("-");
        lblDetailPublisher.setOpaque(true);

        lblStatus3.setBackground(new java.awt.Color(102, 102, 102));
        lblStatus3.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus3.setText("T. Pages");
        lblStatus3.setOpaque(true);

        lblDetailYear.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailYear.setForeground(new java.awt.Color(51, 51, 51));
        lblDetailYear.setText("-");
        lblDetailYear.setOpaque(true);

        lblDetailTotalPages.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailTotalPages.setForeground(new java.awt.Color(51, 51, 51));
        lblDetailTotalPages.setText("-");
        lblDetailTotalPages.setOpaque(true);

        btnClose.setBackground(new java.awt.Color(255, 0, 51));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.setBorderPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetailYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetailISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetailTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetailAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetailPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetailTotalPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetailISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetailTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetailAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetailPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDetailYear, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetailTotalPages, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(DetailBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblActivity;
    private javax.swing.JLabel lblDetailAuthor;
    private javax.swing.JLabel lblDetailISBN;
    private javax.swing.JLabel lblDetailPublisher;
    private javax.swing.JLabel lblDetailTitle;
    private javax.swing.JLabel lblDetailTotalPages;
    private javax.swing.JLabel lblDetailYear;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JLabel lblStatus3;
    // End of variables declaration//GEN-END:variables


}
