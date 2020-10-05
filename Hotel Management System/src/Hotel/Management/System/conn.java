package Hotel.Management.System;
import java.sql.*;
public class conn {

	Connection c;
	Statement s;
	conn(){
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","1234");
			s=c.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
