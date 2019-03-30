package com.qqchatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.yychat.model.Message;

public class ServerReceiverThread extends Thread{
	 
	Socket s;
     public ServerReceiverThread(Socket s){//
    	 this.s=s;
     }
     public void run(){
    	 ObjectInputStream ois;
    	 ObjectOutputStream oos;
    	 Message mess;
		try {
			//接受信息
			ois = new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();
			System.out.println(mess.getSender()+"对"+mess.getReceiver()+"说"+mess.getContent());
			
			Socket s1=(Socket)StertServer.hmSocket.get(mess.getReceiver());
			oos=new ObjectOutputStream(s1.getOutputStream());
			 oos.writeObject(mess);
		} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
			 
		}
    	 
     }}