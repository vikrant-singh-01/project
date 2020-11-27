package Bank;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RegisterJdbc extends JFrame implements ActionListener
{
	JLabel l1;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1;
	
  	RegisterJdbc()
	{
  		this.setSize(400,280);
	    this.setTitle("Add Member ");
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JPanel mainPanel = new JPanel();
	 	JPanel tp = new JPanel();
	 	
	 	Border bor = BorderFactory.createTitledBorder("Sign Up :----");
		tp.setBorder(bor);
		tp.setLayout(new GridLayout(8,3));		
	    	    
	    
		//create Member name
		tp.add(l1=new JLabel("User Name"));
		tp.add(l1=new JLabel("::"));
		tp.add(t2=new JTextField(10));
		
		//create Father name
		tp.add(l1=new JLabel("Employee Name "));
		tp.add(l1=new JLabel("::"));
		tp.add(t3=new JTextField(10));
		
		//create Address
		tp.add(l1=new JLabel("Address "));
		tp.add(l1=new JLabel("::"));
		tp.add(t4=new JTextField(10));
		
		//create Address
		tp.add(l1=new JLabel("Password"));
		tp.add(l1=new JLabel("::"));
		tp.add(t5=new JTextField(10));
		
		//create Address
		tp.add(l1=new JLabel("Mobile No. "));
		tp.add(l1=new JLabel("::"));
		tp.add(t6=new JTextField(10));
		
		//create button
		tp.add(b1=new JButton("Submit Data"));
		tp.add(l1=new JLabel());
		
		b1.addActionListener(this);
		    mainPanel.add(tp);
		    this.add(mainPanel);
		    this.setVisible(true);
		    this.setLocation(70, 110);
	}
 public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1){
		
		String s2=t2.getText(); //get name
		String s3=t3.getText(); //get father name
		String s4=t4.getText();
	    String s5=t5.getText();
	    String s6=t6.getText();
		//if(s1.length()==0||s2.length()==0||s3.length()==0)
		if(s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0||s6.length()==0)
            JOptionPane.showMessageDialog(b1,"Please fill all TextBox ", "Response",JOptionPane.INFORMATION_MESSAGE);
		else
		 {
			try{
				Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cbse","root","mysql");
                PreparedStatement ps=con.prepareStatement("insert into stud(sname,sfname,sadd,spassword,smobile) values(?,?,?,?,?)");
                ps.setString(1, s2);
                ps.setString(2, s3);
                ps.setString(3, s4);
                ps.setString(4, s5);
                ps.setString(5, s6);
               
                int i=ps.executeUpdate();
                System.out.println("i is =>"+i);
                if(i>0){
                	 JOptionPane.showMessageDialog(b1,"Your Signup Successfully", "Response",JOptionPane.INFORMATION_MESSAGE);
 					//t1.setText("");
 					t2.setText("");
 					t3.setText("");
 					t4.setText("");
 					t5.setText("");
 					t6.setText("");
                }
               
              
			}catch(Exception a){
				a.printStackTrace();
			}
			}
	   }
	}
 public static void main(String arg[])
 {
	new RegisterJdbc(); 
   }
 }
