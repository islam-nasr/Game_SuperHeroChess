package exceptions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class start extends JFrame {
	
	public start(ServerSocket s1,ServerSocket s2) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.pack();
	
		
		
		JTextArea current=new JTextArea("Server 1 is running now on port number"+ " "+s1.getLocalPort()+'\n'+
				"Server 2 is running now on port number"+ " "+s2.getLocalPort()+'\n');
		current.setForeground(Color.BLACK);
		current.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		
		this.add(current,BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
public static void main (String[]args) throws IOException{
	
	ServerSocket s1 = new ServerSocket(6700);
	ServerSocket s2 = new ServerSocket(6800);
start s=new start(s1,s2);
	TCPServer server1 = new TCPServer(s1);
	System.out.println("Server 1 is Created on Port Number : " + s1.getLocalPort());
	TCPServer server2 = new TCPServer(s2);
	System.out.println("Server 2 is Created on Port Number : " + s2.getLocalPort());
	server1.start();
	server2.start();
	
}
}


