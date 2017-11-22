package com.Jakibah.SQL;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class PacketOut extends Packet{
	
	public PacketOut(String IP, String Command){
		super(IP, Command);
		
	}
	
	public void Send(String Username, String Password){
		try {
			if(lastIP.equals("Nothing")){
				lastConnection = DriverManager.getConnection("jdbc:mysql://" + this.getIP(), Username, Password);
				lastIP = "jdbc:mysql://" + this.getIP();
			}else if(!lastIP.equals("jdbc:mysql://" + this.getIP())){
				lastConnection = DriverManager.getConnection("jdbc:mysql://" + this.getIP(),  Username, Password);
				lastIP = "jdbc:mysql://" + this.getIP();
				}
			Statement mystmt = lastConnection.createStatement();
			String sql = this.getCommand();
			mystmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Sent SQL Opackage: " + this.getCommand());
	}

	

}
