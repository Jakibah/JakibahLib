package com.Jakibah.SQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class PacketIn extends Packet {

	public PacketIn(String IP, String Command) {
		super(IP, Command);
		
	}

	public void Send(String Username, String Password) {
		try {
			if(lastIP.equals("Nothing")){
				lastConnection = DriverManager.getConnection("jdbc:mysql://" + this.getIP(), Username, Password);
				lastIP = "jdbc:mysql://" + this.getIP();
			}else if(!lastIP.equals("jdbc:mysql://" + this.getIP())){
				lastConnection = DriverManager.getConnection("jdbc:mysql://" + this.getIP(), Username, Password);
				lastIP = "jdbc:mysql://" + this.getIP();
				}
			Statement mystmt = lastConnection.createStatement();
			String sql = this.getCommand();
			ResultSet myrs = mystmt.executeQuery(sql);
			System.out.println("Sent SQL Ipackage: " + this.getCommand());
			while(myrs.next()){
				Process(myrs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public abstract void Process(ResultSet myrs);

}
