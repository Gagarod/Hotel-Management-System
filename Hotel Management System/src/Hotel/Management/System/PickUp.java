package Hotel.Management.System;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.*;

public class PickUp extends JFrame implements ActionListener{

	Choice c1;
	JButton b1,b2;
	JTable t1;
	public PickUp() {
		// TODO Auto-generated constructor stub

		JLabel l1 = new JLabel("PickUp Service");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//l1.setForeground(Color.BLUE);
		l1.setBounds(420, 30, 200, 30);
		add(l1);
		
		t1=new JTable();
		
		JLabel l2 = new JLabel("Type of Car");
		l2.setBounds(50, 100, 100, 20);
		add(l2);
		
		c1=new Choice();
		try{
            conn c = new conn();
            String str = "select * from driver";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()) {
            	c1.add(rs.getString("company"));
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }
		c1.setBounds(150,100,200,25);
		add(c1);
		
		t1=new JTable();
		t1.setBounds(0,200,1000,300);
		add(t1);
		
	    b1=new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(300,520, 120, 30);
		b1.addActionListener(this);
		add(b1);	
			   	    
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);	
		b2.setForeground(Color.WHITE);
		b2.setBounds(550,520, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(30, 160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Age");
		l4.setBounds(200, 160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(330, 160,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Company");
		l6.setBounds(460, 160,100,20);
		add(l6);
                
        JLabel l7 = new JLabel("Model");
		l7.setBounds(620, 160,100,20);
		add(l7);
		        
        JLabel l8 = new JLabel("Availability");
		l8.setBounds(750, 160,100,20);
		add(l8);
        
        JLabel l9 = new JLabel("Location");
		l9.setBounds(890, 160,100,20);
		add(l9);
			
		getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(10,125,1000,605);
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String str1 = "select * from driver where company = '"+c1.getSelectedItem()+"'";
				conn c=new conn();
				ResultSet rs;
				rs=c.s.executeQuery(str1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			setVisible(false);			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PickUp().setVisible(true);
	}

}
