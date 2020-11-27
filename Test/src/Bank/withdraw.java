package Bank;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class withdraw extends javax.swing.JFrame {

    public withdraw() {
        initComponents();
    }

    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Withdraw");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        

        jLabel1.setText("Account No.");

        jLabel2.setText("Amount Withdraw");
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup())
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
           .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton1)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                   .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addContainerGap(140, Short.MAX_VALUE))
                ));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    
        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cbse","root","mysql");
            String sql,sql2;
            int acno,bal1;
            acno=Integer.parseInt(jTextField1.getText());
            bal1=Integer.parseInt(jTextField2.getText());
            sql2="select * from account where acno='"+acno+"'";
            java.sql.Statement st=con.createStatement();
            ResultSet rs = st.executeQuery(sql2);		
            String s1="";int b1=0;
            if(rs.next()){
            	String status = rs.getString(7);
            	int bal = rs.getInt(8);
            	System.out.println(bal);
            	System.out.println(status);
            	s1=status;
            	b1=bal;
            }
            
            int s=b1-bal1;
            if(s1.equals("N")){
            sql="update account set acbal='"+s+"'where acno="+acno+";";
            java.sql.Statement st1=con.createStatement();
            st1.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Withdraw Done");
            new mainpage().setVisible(true);
            this.dispose();

            jTextField1.setText("");
            jTextField2.setText("");
        }
            if(s1.equals("O")){
                sql="update account set acbal='"+s+"'where acno="+acno+";";
                java.sql.Statement st1=con.createStatement();
                st1.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Withdraw Done");
                new mainpage().setVisible(true);
                this.dispose();

                jTextField1.setText("");
                jTextField2.setText("");
            }
            if(s1.equals("C")){
            	JOptionPane.showMessageDialog(this,"Account Closed");
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"error"+e.getMessage());
        }
}
 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  new mainpage().setVisible(true);
        this.dispose();        
    }public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new withdraw().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    
    
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
    

}

