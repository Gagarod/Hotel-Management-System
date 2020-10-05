package Hotel.Management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class AddCustomer extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4;
	JRadioButton r1,r2,r3,r4;
	JComboBox c1;
	Choice c2;
	JButton b1,b2;
	public AddCustomer() {
		JLabel title=new JLabel("NEW CUSTOMER FORM ");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma",Font.PLAIN,18));
		title.setBounds(100,20,300,30);
	    add(title);
	    
	    ImageIcon i1=new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/fifth.png"));	
		Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT); 
		ImageIcon i3=new ImageIcon(i2);	
		JLabel icon=new JLabel(i3);
		icon.setBounds(400,50,300,400);
		add(icon);

	    JLabel l1=new JLabel("ID");
		l1.setBounds(35,80,100,20);
	    add(l1);
	    String s1[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
        c1 = new JComboBox(s1);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,80,150,25);
        add(c1);
	    
	    JLabel l2=new JLabel("ID Number");
		l2.setBounds(35,120,100,20);
	    add(l2);
	    t1 = new JTextField();
        t1.setBounds(200,120, 150,25);
        add(t1);
	    
	    JLabel l3=new JLabel("Name");
		l3.setBounds(35,160,100,20);
	    add(l3);
	    t2 = new JTextField();
        t2.setBounds(200,160, 150,25);
        add(t2);
	    
	    JLabel l4=new JLabel("Gender");
		l4.setBounds(35,200,100,20);
	    add(l4);
	    ButtonGroup G=new ButtonGroup();
        r1 = new JRadioButton("MALE");
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,200,60,25);
        add(r1);
        r2 = new JRadioButton("FEMALE");
        r2.setBackground(Color.WHITE);
        r2.setBounds(270,200, 80, 25);
        add(r2);
        G.add(r1);
        G.add(r2);
        
	    JLabel l5=new JLabel("Country");
		l5.setBounds(35,240,100,20);
	    add(l5);
	    t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);
	    
	    
	    JLabel l6=new JLabel("Allocated Room Number");
		l6.setBounds(35,280,150,20);
	    add(l6);
	    c2=new Choice();
	    try{
            conn c = new conn();
            String str = "select * from room where available='Available' and status='Cleaned'";
            ResultSet rs = c.s.executeQuery(str);

            while(rs.next()) {
            	c2.add(rs.getString("room_number"));
            }
	    }
        catch(Exception e1){
              e1.printStackTrace();
           }
	    c2.setBounds(200,280,150,25);
	    add(c2);
	    JLabel l7=new JLabel("Checked In");
		l7.setBounds(35,320,100,20);
	    add(l7);
	    ButtonGroup G1=new ButtonGroup();
        r3 = new JRadioButton("Yes");
        r3.setBackground(Color.WHITE);
        r3.setBounds(200,320,60,25);
        add(r3);
        r4 = new JRadioButton("No");
        r4.setBackground(Color.WHITE);
        r4.setBounds(270,320, 80, 25);
        add(r4);
        G1.add(r3);
        G1.add(r4);
        
        
	    JLabel l8=new JLabel("Deposit");
		l8.setBounds(35,360,100,20);
	    add(l8);
	    t4 = new JTextField();
        t4.setBounds(200,360, 150,25);
        add(t4);
        
        b1 = new JButton("Add Customer");
		b1.addActionListener(this);
		b1.setBounds(50, 410, 120, 25);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		add(b1);

		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBounds(200, 410, 120,25);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(100,150,800,550);
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String id=(String)c1.getSelectedItem();
		String number=t1.getText();
		String name=t2.getText();
		String country=t3.getText();
		String status=null;
		String deposit=t4.getText();
		String room=(String)c2.getSelectedItem();
		String gender=null;
		if(r1.isSelected()) {
			gender="Male";
		}
		else if(r2.isSelected()) {
			gender="Female";
		}
		if(r3.isSelected()) {
			status="Yes";
		}
		else if(r4.isSelected()) {
			status="No";
		}
		if(ae.getSource()==b1) {
			 conn c = new conn();
	         String str1 = "INSERT INTO customer values( '"+id+"', '"+number+"', '"+name+"','"+gender+"', '"+country+"', '"+room+"','"+status+"', '"+deposit+"')";             
	         String str2="update room set available='Occupied' where room_number='"+room+"'";
	         try {
	              c.s.executeUpdate(str1);
	              c.s.executeUpdate(str2);
	              JOptionPane.showMessageDialog(null,"Customer Added");
	          	  new Reception().setVisible(true);
	              this.setVisible(false);         
	         } catch (Exception e) {
	             e.printStackTrace();
		    }
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddCustomer();

	}

}
