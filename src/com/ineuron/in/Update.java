package com.ineuron.in;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Update {

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

			while (jrs.next()) {
				int age = jrs.getInt(3);
				if (age < 15) {
					int updatedage = age + 3;
					jrs.updateInt(3, updatedage);
					jrs.updateRow();
				}
			}
			System.out.println("Records updated succesfully....");
			jrs.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
