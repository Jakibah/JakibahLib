package com.Jakibah.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Reciever {
	public static byte[] buffer = new byte[256];
	public static DatagramSocket socket;
	public static NetProcessor mnp;
	
	public static void Init(String IP, int port, NetProcessor np){
		mnp = np;
		Thread listener = new Thread(new Runnable(){
			
			@Override
			public void run() {
				while(true){
				Listen();
				}
			}
			
		});
		try {
			socket = new DatagramSocket(port, InetAddress.getByName(IP));
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
		listener.start();
		
	}
	
	public static void Listen(){
		buffer = new byte[256];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		try {
			socket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mnp.Process(packet);
	}

	
	
}
