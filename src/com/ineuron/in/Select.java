package com.ineuron.in;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Select {

	public static void main(String[] args) {

		RowSetFactory rsf = null;
		JdbcRowSet jrs = null;
		try {

			rsf = RowSetProvider.newFactory();
			jrs = rsf.createJdbcRowSet();

			jrs.setUrl("jdbc:mysql:///school");
			jrs.setUsername("root");
			jrs.setPassword("Sagar@123");

			String selectQuery = "select sname, sage, saddress from student";
			jrs.setCommand(selectQuery);
			jrs.execute();

			// retrieving records forward
			while (jrs.next()) {
				System.out.println(jrs.getString(1) + "\t\t" + jrs.getInt(2) + "\t\t" + jrs.getString(3));
			}

			// retrieving records backward
			System.out.println("-----------------------");
			while (jrs.previous()) {
				System.out.println(jrs.getString(1) + "\t\t" + jrs.getInt(2) + "\t\t" + jrs.getString(3));
			}

			// retrieving records randomly
			System.out.println("-------------------------");
			jrs.absolute(2);
			System.out.println(jrs.getString(1) + "\t\t" + jrs.getInt(2) + "\t\t" + jrs.getString(3));

			System.out.println("-------------------------");
			jrs.relative(2);
			System.out.println(jrs.getString(1) + "\t\t" + jrs.getInt(2) + "\t\t" + jrs.getString(3));

			System.out.println("-------------------------");
			jrs.absolute(-4);
			System.out.println(jrs.getString(1) + "\t\t" + jrs.getInt(2) + "\t\t" + jrs.getString(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				jrs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
