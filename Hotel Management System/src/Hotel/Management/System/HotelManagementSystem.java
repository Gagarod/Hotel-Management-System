package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class HotelManagementSystem extends JFrame implements ActionListener{	
    HotelManagementSystem(){
		setBounds(20,150,984,407);
		ImageIcon i1=new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/first.jpg"));	
		JLabel l1=new JLabel(i1);
		l1.setBounds(0,0,984,407);
		add(l1);
		JLabel l2=new JLabel("Hotel Management System");
		l2.setBounds(20,280,600,100);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Serif",Font.PLAIN,50));
		l1.add(l2);
		JButton b1=new JButton("Next");
		b1.setBounds(820,325,75,28);
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.WHITE);
		b1.addActionListener(this);
		l1.add(b1);
		setLayout(null);
		setVisible(true);
		while(true) 
		{
			l2.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e){}
			l2.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
	}
    public void actionPerformed(ActionEvent e) {
    	new Login()/*.setVisible(true)*/;
    	this.setVisible(false);
    }
	public static void main(String args[]) {
		new HotelManagementSystem();
	}
}
