package com.beosbank.jbdevg.jbdatavirt.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BeosbankVDBClient {

	public static void main(String[] args) {
		
		String url ="jdbc:teiid:beosbank.1@mm://127.0.0.1:31000;user=teiidUser;password=Admin01#";
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Transactions.MoneyTransfer ");
			while(rs.next()){
				System.out.println(String.format("|%10s|%-25s|%6s|", rs.getString("code"),rs.getString("sender_name"),rs.getDouble("amount_sent_without_taxes")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
