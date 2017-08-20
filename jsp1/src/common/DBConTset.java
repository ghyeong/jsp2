package common;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConTset {
	
	public static void main(String[] args) {
		
		Connection con;
		Statement st;
		try {
			con = DBConnector.getCon();
			System.out.println("연결성공");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			while(rs.next()) {
				System.out.print(rs.getString("user_no"));
				System.out.print(rs.getString("id"));
				System.out.print(rs.getString("password"));
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
