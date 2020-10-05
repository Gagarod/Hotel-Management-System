package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	Dashboard(){
		mb=new JMenuBar();
		add(mb);
		m1=new JMenu("HOTEL_MANAGEMENT");
		mb.add(m1);
		m2=new JMenu("ADMIN");
		mb.add(m2);
		
		i1=new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);

		i2=new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3=new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4=new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		mb.setBounds(0,0,1020,30);
		ImageIcon im1=new ImageIcon(getClass().getResource("/Hotel/Management/System/icons/third.jpg"));	
		JLabel l1=new JLabel(im1);
		l1.setBounds(0,0,1020,730);
		add(l1);
		JLabel l2=new JLabel("THE TAJ GROUP WELCOMES YOU");
		l2.setBounds(200, 30, 650, 100);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Tahoma",Font.PLAIN,40));
		l1.add(l2);
		setLayout(null);
		setBounds(0,0,1020,735);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception().setVisible(true);;
		}
		else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")){
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")){
			new AddDriver().setVisible(true);
		}
	}
	public static void main(String args[]) {
		new Dashboard();
	}

}
