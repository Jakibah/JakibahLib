package com.Jakibah.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jakibah.SQL.PacketIn;

public class Packet0001 extends PacketIn {

	public Packet0001(String IP) {
		super(IP, "Select * From data Where Name='Aris'");
	}

	@Override
	public void Process(ResultSet myrs) {
		try {
			System.out.println(myrs.getString("Surname"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
