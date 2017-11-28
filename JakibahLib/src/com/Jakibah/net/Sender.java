package com.Jakibah.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender {

	public static void Send(String IP, int port, byte[] buffer){
		try {
			InetAddress address = InetAddress.getByName(IP);
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
			DatagramSocket socket = new DatagramSocket();
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace();
		}
		System.out.println("Sent NET package: " + new String(buffer));
	}
	
}
