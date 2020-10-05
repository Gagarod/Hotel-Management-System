package Hotel.Management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class UpdateRoom extends JFrame implements ActionListener {

	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3;
	public UpdateRoom() {
	
		JLabel title= new JLabel("Update Room Status");
	    title.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    title.setForeground(Color.BLUE);
		title.setBounds(30, 20, 250, 30);
	    add(title);
		
	  
	    
	    JLabel l1 = new JLabel("Guest ID");
		l1.setBounds(30,80, 120, 20);
		add(l1);
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
	    c1.setBounds(200,80,150,20);
	    add(c1);
	    
     	JLabel l2 = new JLabel("Room Number");
		l2.setBounds(30,130, 120, 20);
		add(l2);
		t1=new JTextField();
		t1.setBounds(200,130,150,20);
		add(t1);
		
		JLabel l3 = new JLabel("Availability");
		l3.setBounds(30,180, 120, 20);
		add(l3);
		t2=new JTextField();
		t2.setBounds(200,180,150,20);
		add(t2);
		JLabel l5 = new JLabel("(Available/Occupied)");
		l5.setBounds(215,200, 150, 15);
		add(l5);
		
		JLabel l4 = new JLabel("Clean Status");
    	l4.setBounds(30,230, 120, 20);
		add(l4);	
		t3=new JTextField();
		t3.setBounds(200,230,150,20);
		add(t3);
		JLabel l6 = new JLabel("(Cleaned/Dirty)");
		l6.setBounds(225,250, 150, 15);
		add(l6);
		
		
		b1 = new JButton("Check");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);	
		b1.setForeground(Color.WHITE);
		b1.setBounds(130, 300, 120, 30);
		add(b1);
		
		b2 = new JButton("Update");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);	
		b2.setForeground(Color.WHITE);
		b2.setBounds(40, 350, 120, 30);
		add(b2);

		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setBackground(Color.BLACK);	
		b3.setForeground(Color.WHITE);
		b3.setBounds(220, 350, 120, 30);
		add(b3);
		
	    ImageIcon i1  = new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l7 = new JLabel(i3);
	    l7.setBounds(400,80,550,300);
	    add(l7);

		
		getContentPane().setBackground(Color.WHITE);
		setBounds(0, 200, 1000, 450);
	    setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			 conn c = new conn();
			 String room=null;
			 String s1 = c1.getSelectedItem();
			 try {                	             
                 ResultSet rs1 = c.s.executeQuery("select * from customer where id_number = '"+s1+"'");                
                 while(rs1.next()){                  
                     t1.setText(rs1.getString("room"));
                     room = rs1.getString("room"); 
                 }
             }
			 catch(Exception ee){ee.printStackTrace();}
             try{       
                 ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                 while(rs2.next()){
                     t2.setText(rs2.getString("available")); 
                     t3.setText(rs2.getString("status"));
                 }
             }catch(Exception ee){
            	 ee.printStackTrace();
             }
		}
		else if(ae.getSource()==b2) {
			try{
                conn c = new conn();
                String str = "update room set status = '"+t3.getText()+"' where room_number = '"+t1.getText()+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Update Sucessful");              
                new Reception().setVisible(true);
                setVisible(false);
                }catch (Exception ee){
                     ee.printStackTrace();
                }
		}
		else if(ae.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new UpdateRoom();

	}

}
