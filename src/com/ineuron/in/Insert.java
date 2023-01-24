package com.ineuron.in;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Insert {

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

			jrs.moveToInsertRow();
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("Enter the Name::");
				String name = sc.next();
				System.out.print("Enter the Address::");
				String address = sc.next();
				System.out.print("Enter the Age::");
				int age = sc.nextInt();

				jrs.updateString(2, name);
				jrs.updateInt(3, age);
				jrs.updateString(4, address);

				jrs.insertRow();

				System.out.println("Row Inserted Sucessfully..");
				System.out.print("Do you still want to insert[Yes/No]::");
				String option = sc.next();
				if (option.equalsIgnoreCase("No")) {
					break;
				}
			}

			sc.close();
			jrs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
