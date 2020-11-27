package Bank;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class Transfer extends JFrame implements ActionListener {
	JLabel l1;
	JTextField t1,t2,t3;
	JButton b1;
	
  	Transfer()
	{
  		this.setSize(400,280);
	    this.setTitle("Transfer ");
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JPanel mainPanel = new JPanel();
	 	JPanel tp = new JPanel();
	 	
	 	Border bor = BorderFactory.createTitledBorder("Transfer :----");
		tp.setBorder(bor);
		tp.setLayout(new GridLayout(4,3));		
	    	    
	    
		//create Member name
		tp.add(l1=new JLabel("Sender"));
		tp.add(l1=new JLabel("::"));
		tp.add(t1=new JTextField(10));
		
		//create Father name
		tp.add(l1=new JLabel("Receiver "));
		tp.add(l1=new JLabel("::"));
		tp.add(t2=new JTextField(10));
		
		//create Address
		tp.add(l1=new JLabel("Balance "));
		tp.add(l1=new JLabel("::"));
		tp.add(t3=new JTextField(10));
		tp.add(b1=new JButton("Submit Data"));
		tp.add(l1=new JLabel());
		
		b1.addActionListener(this);
		    mainPanel.add(tp);
		    this.add(mainPanel);
		    this.setVisible(true);
		    this.setLocation(70, 110);	
}
  	public void actionPerformed(ActionEvent e) {
  		
  				try{
  					Class.forName("com.mysql.jdbc.Driver");
  	                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cbse","root","mysql");
  	              String sql,sql2,sql21,i="";
  	            int acno,bal1,b2=0;
  	            acno=Integer.parseInt(t1.getText());
  	            bal1=Integer.parseInt(t3.getText());
  	            sql2="select * from account where acno='"+acno+"'";
  	          java.sql.Statement st=con.createStatement();
              ResultSet rs = st.executeQuery(sql2);		
              int b1=0;
              
              if(rs.next()){
              	int bal = rs.getInt(8);
              	
              	b1=bal;
              	String f=rs.getString(7);
              	i=f;
              }
              if(i.equals("C")){
              	JOptionPane.showMessageDialog(this,"Account is Closed");
              	System.exit(0);
              }
              else{
              int s=b1-bal1;
              sql="update account set acbal='"+s+"'where acno="+acno+";";
              java.sql.Statement st1=con.createStatement();
              st1.executeUpdate(sql);
              }
              String sql3,sql4,v="";
	            int acno1,bal11=0;
	            acno1=Integer.parseInt(t2.getText());
	            sql3="select * from account where acno='"+acno1+"'";
	          java.sql.Statement st5=con.createStatement();
            ResultSet rs1 = st5.executeQuery(sql3);		
            if(rs1.next()){
            	int hello = rs1.getInt(8);
            	String sta=rs1.getString(7);
            	
            	b2=hello;
            	v=sta;
            }
            if(v.equals("C")){
            	JOptionPane.showMessageDialog(this,"Account is Closed");
            	System.exit(0);
            }
            else{
            int s1=b2+bal1;
            sql21="update account set acbal='"+s1+"'where acno="+acno1+";";
            java.sql.Statement st9=con.createStatement();
            st9.executeUpdate(sql21);
            JOptionPane.showMessageDialog(this,"Transferred Succesfully");
            new mainpage().setVisible(true);
            this.dispose();
           	}
            }
  				catch(Exception a){
  					a.printStackTrace();
  				}
  		}
  	
  	public static void main(String arg[])
  	 {
  		new Transfer(); 
  	   }

}