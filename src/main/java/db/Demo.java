package db;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Demo
{
	@Test
	public void dbTest() throws SQLException
	{
		String dburl = "jdbc:mysql://localhost:3306/demodb";
		String un = "root";
		String pw = "Emids123";

		// lunch Db
		Connection con = DriverManager.getConnection(dburl, un, pw);

		// sending query to Db(path)
		Statement stmt = con.createStatement();

		// Send query
		ResultSet result = stmt.executeQuery("select * from EmpInfo where Name ='Raghus'");
		
		// To point 1st index
		while(result.next())
		{
			// Get the value
			String name = result.getString("Name");
			String id = result.getString("ID");
			String dept = result.getString("Dept");
			String gender = result.getString("Gender");
			System.out.println(name+" "+id+" "+dept+" "+gender);
		}
		con.close();

	}

}
