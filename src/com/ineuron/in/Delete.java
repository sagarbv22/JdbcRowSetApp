package com.ineuron.in;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Delete {

	public static void main(String[] args) {
		
		RowSetFactory rsf = null;
		JdbcRowSet jrs = null;

		String url = "jdbc:mysql:///school";
		String user = "root";
		String password = "Sagar@123";
		String command = "select sid,sname,sage,saddress from student";

		try {
			rsf = RowSetProvider.newFactory();
			jrs = rsf.createJdbcRowSet();
			jrs.setUrl(url);
			jrs.setUsername(user);
			jrs.setPassword(password);

			jrs.setCommand(command);
			jrs.execute();

			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the Age of Student to be deleted::");
			int age = sc.nextInt();
			
			while (jrs.next()) {
				
				int sage = jrs.getInt(3);
				if(sage>=age)
					jrs.deleteRow();
				
			}
			System.out.println("Records deleted succesfully....");
			sc.close();
			jrs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
