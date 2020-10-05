package Hotel.Management.System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddDriver  extends JFrame implements ActionListener {  
    JTextField t1,t2,t3,t4, t5;
    JComboBox c1,c2;
    JButton b1,b2;
	public AddDriver(){
		JLabel title=new JLabel("Add Drivers");
		title.setFont(new Font("Tahoma",Font.BOLD,18));
	    title.setBounds(150,10,150,30);
	    add(title);
	    
	    JLabel name=new JLabel("Name");
	    name.setFont(new Font("Tahoma",Font.PLAIN,14));
	    name.setBounds(60,70,100,30);
	    add(name);
	    t1 = new JTextField();
		t1.setBounds(200, 70, 150, 30);
		add(t1);
	        
	    
	    JLabel age=new JLabel("Age");
	    age.setFont(new Font("Tahoma",Font.PLAIN,14));
	    age.setBounds(60,110,100,30);
	    add(age);
	    t2 = new JTextField();
		t2.setBounds(200,110, 150, 30);
		add(t2);
	    
	    
	    JLabel gender=new JLabel("Gender");
	    gender.setFont(new Font("Tahoma",Font.PLAIN,14));
	    gender.setBounds(60,150,100,30);
	    add(gender);
	    c1=new JComboBox(new String []{"Male","Female"});
		c1.setBackground(Color.WHITE);
		c1.setBounds(200, 150, 150, 30);
		add(c1);

	    JLabel car=new JLabel("Car Company");
	    car.setFont(new Font("Tahoma",Font.PLAIN,14));
	    car.setBounds(60,190,100,30);
	    add(car);
	    t3 = new JTextField();
		t3.setBounds(200,190, 150, 30);
		add(t3);
	    

	    JLabel model=new JLabel("Car Model");
	    model.setFont(new Font("Tahoma",Font.PLAIN,14));
	    model.setBounds(60,230,100,30);
	    add(model);
	    t4 = new JTextField();
		t4.setBounds(200,230, 150, 30);
		add(t4);
	    

	    JLabel available=new JLabel("Available");
	    available.setFont(new Font("Tahoma",Font.PLAIN,14));
	    available.setBounds(60,270,100,30);
	    add(available);
	    c2=new JComboBox(new String []{"Available","Busy"});
		c2.setBackground(Color.WHITE);
		c2.setBounds(200,270, 150, 30);
		add(c2);
	    
	    JLabel location=new JLabel("Location");
	    location.setFont(new Font("Tahoma",Font.PLAIN,14));
	    location.setBounds(60,310,100,30);
	    add(location);
	    t5 = new JTextField();
		t5.setBounds(200,310, 150, 30);
		add(t5);
		
		ImageIcon i1  = new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 360,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,50,500,320);
        add(l1);
		
		b1 = new JButton("Add");
		b1.addActionListener(this);
		b1.setBounds(60, 360, 120, 30);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		add(b1);

		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBounds(200, 360, 120, 30);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		add(b2);
	          	    
	    
	    getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setBounds(40, 150, 940, 470);
        setVisible(true);	    
	}

	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			 try{
				 conn c = new conn();
	             String name = t1.getText();
	             String age = t2.getText();
	             String gender = (String)c1.getSelectedItem();
	             String company  = t3.getText();
	             String model = t4.getText();
	             String available = (String)c2.getSelectedItem();
	             String location = t5.getText();
	             String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"', '"+available+"','"+location+"')";
		       	 c.s.executeUpdate(str);
			     JOptionPane.showMessageDialog(null, "Room Successfully Added");
	             this.setVisible(false);     
			 }
			 catch(Exception e){
                 System.out.println(e);
             }      
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}
	public static void main(String[] args) {
		new AddDriver();

	}

}
