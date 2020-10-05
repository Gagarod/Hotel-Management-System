package Hotel.Management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener{

	JButton b1,b2,b3;
	Choice c1;
	JTextField t1;
	public CheckOut() {
	
		JLabel l1 = new JLabel("Check Out");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(30, 20, 100, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Customer-ID");
		l2.setBounds(30, 80, 100, 30);
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
		c1.setBounds(150, 80, 150, 30);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30, 130, 100, 30);
		add(l3);
		t1=new JTextField();
		t1.setBounds(150,130, 150,30);
        add(t1);
		
	    b1=new JButton("CheckOut");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(30,200, 120, 30);
		b1.addActionListener(this);
		add(b1);	
		   	    
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);	
		b2.setForeground(Color.WHITE);
		b2.setBounds(170,200, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3= new JButton(i3);
        b3.setBounds(310,80,20,20);
    	b3.addActionListener(this);
        add(b3);
		
    	ImageIcon i4 = new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
		l4.setBounds(350, 0, 400, 250);
		add(l4);
        
		getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(100,220,800,300);
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {			
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str1 = "Delete from customer where id_number = "+id;
            String str2 = "update room set available = 'Available',status='Dirty'  where room_number = "+room;
                        
            conn c = new conn();
            try{
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Check Out Successful");
                new Reception().setVisible(true);
                setVisible(false);
            }catch(SQLException ee){
            	ee.printStackTrace();
            }
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			setVisible(false);			
		}
		else if(ae.getSource()==b3) {
			 try {
		        	conn c = new conn();
		        	String room=null;
			        String id =  c1.getSelectedItem();
			        String str="select * from customer where id_number='"+id+"'";		        
		            ResultSet rs=c.s.executeQuery(str);   
		            while(rs.next()) {		            
		            	 t1.setText(rs.getString("room"));    	                
	                     room=t1.getText();
		            }
		            
		     }catch(Exception e) {
		         e.printStackTrace();
			 }
			 
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CheckOut().setVisible(true);;
	}
}
