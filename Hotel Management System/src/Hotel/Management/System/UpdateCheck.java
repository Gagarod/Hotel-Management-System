package Hotel.Management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class UpdateCheck extends JFrame implements ActionListener{

	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	public UpdateCheck() {
		ImageIcon i1=new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/nine.jpg"));	
		JLabel icon=new JLabel(i1);
		icon.setBounds(400,50,500,300);
		add(icon);
		
		JLabel l1 = new JLabel("Check-In Details");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(90, 30, 200, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Customer-ID");
		l2.setBounds(30, 80, 100, 20);
		add(l2);
		c1=new Choice();
		try{
	            conn c = new conn();
	            String str = "select * from customer";
	            ResultSet rs = c.s.executeQuery(str);

	            while(rs.next()) {
	            	c1.add(rs.getString("id_number"));
	            }
	       }
	    catch(Exception e1){
	              e1.printStackTrace();
        }
		c1.setBounds(200, 80, 150, 25);
		add(c1);

		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30, 120, 100, 20);
		add(l3);
		t1=new JTextField();
		t1.setBounds(200,120, 150,25);
        add(t1);

		JLabel l4 = new JLabel("Name");
		l4.setBounds(30, 160, 100, 20);
		add(l4);
		t2=new JTextField();
		t2.setBounds(200,160, 150,25);
        add(t2);

		JLabel l5 = new JLabel("Check-In");
		l5.setBounds(30, 200, 100, 20);
		add(l5);
		t3=new JTextField();
		t3.setBounds(200,200, 150,25);
        add(t3);

		JLabel l6 = new JLabel("Amount Paid");
		l6.setBounds(30,240, 100, 20);
		add(l6);
		t4=new JTextField();
		t4.setBounds(200,240, 150,25);
        add(t4);

		JLabel l7 = new JLabel("Pending Amount");
		l7.setBounds(30, 280, 100, 20);
		add(l7);
		t5=new JTextField();
		t5.setBounds(200,280, 150,25);
        add(t5);
		
        b1=new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(30,340, 100, 30);
		b1.addActionListener(this);
		add(b1);	
	   	    
		b2=new JButton("Update");
		b2.setBackground(Color.BLACK);	
		b2.setForeground(Color.WHITE);
		b2.setBounds(150,340, 100, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);	
		b3.setForeground(Color.WHITE);
		b3.setBounds(270,340, 100, 30);
		b3.addActionListener(this);
		add(b3);
		
		getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(10,150,980,500);
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			
	        try {
	        	conn c = new conn();
	        	String room=null;
		        String id =  c1.getSelectedItem();
		        String str="select * from customer where id_number='"+id+"'";		        
	            ResultSet rs=c.s.executeQuery(str);   
	            while(rs.next()) {
	            
	            	 t1.setText(rs.getString("room"));    
                     t2.setText(rs.getString("name"));    
                     t3.setText(rs.getString("checkedin"));    
                     t4.setText(rs.getString("deposit")); 
                     room=t1.getText();
	            }
	            ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
	            String total = "";
	            while(rs2.next()){
                    total = rs2.getString("price");                     
                }
                String paid = t4.getText();
                int pending = Integer.parseInt(total)- Integer.parseInt(paid); 
                t5.setText(Integer.toString(pending));
                
            
	            
	        } catch (Exception e) {
	             e.printStackTrace();
		    }
		}
		else if(ae.getSource()==b2) {
			try{
                conn c = new conn();
                
                String s1 = c1.getSelectedItem();
                String s2 = t1.getText(); //room_number;    
                String s3 = t2.getText(); //name    
                String s4 = t3.getText(); //status;    
                String s5 = t4.getText(); //deposit    

                c.s.executeUpdate("update customer set room = '"+s2+"', name = '"+s3+"', checkedin = '"+s4+"', deposit = '"+s5+"' where id_number = '"+s1+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reception().setVisible(true);
                setVisible(false);
            }catch(Exception ee){
                System.out.println(ee);
            }			
		}
		else if(ae.getSource()==b3) {
			new Reception().setVisible(true);
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new UpdateCheck().setVisible(true);;
	}

}
