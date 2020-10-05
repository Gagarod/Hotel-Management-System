package Hotel.Management.System;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.*;

public class Department extends JFrame implements ActionListener{
	JButton b1,b2;
	JTable t1;
	public Department() {
	
		t1=new JTable();
	
		
		t1=new JTable();
		t1.setBounds(0,50,600,350);
		add(t1);
		
	    b1=new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(140,400, 120, 30);
		b1.addActionListener(this);
		add(b1);	
			   	    
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);	
		b2.setForeground(Color.WHITE);
		b2.setBounds(340,400, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		
		JLabel l1 = new JLabel("Department");
		l1.setBounds(130, 10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(410, 10,100,20);
		add(l2);
		
		
		getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(200,155,600,500);
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String str1 = "select * from department ";
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
		new Department().setVisible(true);
	}

}
