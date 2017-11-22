package com.Jakibah.SQL;

import java.sql.Connection;


public abstract class Packet {

	protected static Connection lastConnection;
	protected static String lastIP = "Nothing";
	
	
	private String IP, Command;
	
	public Packet(String IP, String Command){
		this.IP = IP;
		this.Command = Command;
	}
	
	
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getCommand() {
		return Command;
	}

	public void setCommand(String command) {
		Command = command;
	}


	public abstract void Send(String Username, String Password);
	
}
