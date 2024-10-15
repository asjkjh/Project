package javaprgms;
//Accessing individual results of a student
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded successfully");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
		System.out.println("connection estsblished");
		String s="select * from student where id=?";
		PreparedStatement psmt=con.prepareStatement(s);
		System.out.println("Enter the id");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		psmt.setInt(1, id);
		ResultSet res=psmt.executeQuery();
		if(res.next()) {
			id=res.getInt(1);
			String name=res.getString(2);
			int marks1=res.getInt(3);
			int marks2=res.getInt(4);
			int marks3=res.getInt(5);
			System.out.println(id+" "+name+" "+marks1+" "+marks3);
		}
		else {
			System.out.println("Invalid id");
			
		}
		
	}

}
