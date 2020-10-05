package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.*;
import java.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
	JTable t1;
	JButton b1,b2;
	public CustomerInfo() {
 
		t1=new JTable();
		t1.setBounds(0,40,1010,320);
		add(t1);
		
		JLabel l1=new JLabel("ID");
		l1.setBounds(40,10,70,20);
		add(l1);

		JLabel l2=new JLabel("Number");
		l2.setBounds(150,10,70,20);
		add(l2);
		
		JLabel l3=new JLabel("Name");
		l3.setBounds(290,10,70,20);
		add(l3);
		
		JLabel l4=new JLabel("Gender");
		l4.setBounds(420,10,70,20);
		add(l4);
		
		JLabel l5=new JLabel("Country");
		l5.setBounds(540,10,70,20);
		add(l5);
		
		JLabel l6=new JLabel("Room No.");
		l6.setBounds(660,10,70,20);
		add(l6);
		
		JLabel l7=new JLabel("Checked-in status");
		l7.setBounds(765,10,120,20);
		add(l7);
		
		JLabel l8=new JLabel("Deposit");
		l8.setBounds(920,10,70,20);
		add(l8);
		
		b1=new JButton("Load Data");
	
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(350,380,120, 30);
		b1.addActionListener(this);
		add(b1);			
	   	    
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);	
		b2.setForeground(Color.WHITE);
		b2.setBounds(500,380, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(0,150,1020,470);
	    setVisible(true);	   	
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try{
                conn c = new conn();
                String str = "select * from customer";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
               }
            catch(Exception e1){
                  e1.printStackTrace();
               }
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new CustomerInfo();

	}

}