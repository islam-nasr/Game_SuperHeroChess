package exceptions;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.swing.JOptionPane;


@SuppressWarnings("unused")
public class TCPServer extends Thread {

  //private static ServerSocket serverSocket = null;
  private static Socket clientSocket = null;
  private static final int ClientsNum = 10;
  private static final clientThread[] threads = new clientThread[ClientsNum];
  private static final String input=null;
  ServerSocket s; 
  
  public TCPServer (ServerSocket x){
	  this.s=x;
	  
  }
  
  public void run(){

	   
	  

	    while (true) {
	    	
	      try {
	        clientSocket = s.accept();
	        int i = 0;
	        for (i = 0; i < ClientsNum; i++) {
	          if (threads[i] == null) {
	            (threads[i] = new clientThread(clientSocket, threads)).start();
	            break;
	          }
	        }
	        if (i == ClientsNum) {
	          PrintStream os = new PrintStream(clientSocket.getOutputStream());
	          os.println("Server Can't accept more clients");
	          os.close();
	          clientSocket.close();
	        }
	      } catch (IOException e) {
	        System.out.println(e);
	      }
	    }
  }

}


class clientThread extends Thread {

  private String clientName = null;
  private DataInputStream is = null;
  private PrintStream os = null;
  private Socket clientSocket = null;
  private int ClientsNum;
  private final clientThread[] threads;

  public clientThread(Socket clientSocket, clientThread[] threads ) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    ClientsNum = threads.length;
  }

  @SuppressWarnings("deprecation")
public void run() {
    int ClientsNum = this.ClientsNum;
    clientThread[] threads = this.threads;

    try {
      is = new DataInputStream(clientSocket.getInputStream());
      os = new PrintStream(clientSocket.getOutputStream());
      String name;
      while (true) {
    	 // input=JOptionPane.showInputDialog(null,"Enter Your name");
        os.println("Enter your name.");
        name = is.readLine().trim();
        
       
        
        if (name.indexOf('@') == -1) {
        	/*int j = 0;
        	
        	for(int i=0;i<threads.length;i++) {
        	clientThread a=	threads[i];
        	if(threads[i]==null)
        	if(a.clientName.equals(name)) {
        		j+=1;
        	}
        	
        	}
        	if(j==1)
          
        	else {
                os.println("A user with this name already available.");

        	}*/
        	break;
        } else {
          os.println("The name should not contain '@' character.");
        }
      }

      os.println("Welcome " + name
          + " to our chat room.\nTo leave enter quit in a new line.");
      
      synchronized (this) {
        for (int i = 0; i < ClientsNum; i++) {
          if (threads[i] != null && threads[i] == this) {
            clientName = "@" + name;
            break;
          }
        }
     
        for (int i = 0; i < ClientsNum; i++) {
          if (threads[i] != null && threads[i] != this) {
            threads[i].os.println("** A new user " + name
                + " entered the chat room !!! **");
          }
        }
      }
      
      while (true) {
        String line = is.readLine();
        if (line.startsWith("quit")) {
          break;
        }
        
        
      if (line.startsWith("getMemberList")) {
      for(clientThread i : threads){
    	  if(i!=null)
    	  this.os.println(i.clientName)  ;
      }
      }
      
   

         
        if (line.startsWith("@")) {
        	String q=line.substring(line.length()-1);
        	line=line.substring(0, line.length()-1);
        	 String[] words = line.split("\\s", 2);
        	 if (words.length > 1 && words[1] != null) {
        	 words[1] = words[1].trim();
        	 if (!words[1].isEmpty()) {
        	 synchronized (this) {
        	 for (int i = 0; i < ClientsNum; i++) {
        	 if (threads[i] != null && threads[i] != this && threads[i].clientName != null && threads[i].clientName.equals(words[0])) {
        	if( threads[i].clientSocket.getLocalPort()==this.clientSocket.getLocalPort()) {
        		if(Integer.parseInt(q)==0) {
        			
        			this.os.println("Cannot Send Message with This TTL");
        			break;
        		}}
        		else {
        			if( threads[i].clientSocket.getLocalPort()!=this.clientSocket.getLocalPort()) {
        				if(Integer.parseInt(q)<=1) {
        					
        					this.os.println("Cannot Send Message with This TTL because user in another server");
        				/*	this.os.println(threads[i].clientSocket.getPort());
        					this.os.println(this.clientSocket.getPort());
        					this.os.println(threads[i].clientSocket.getLocalPort());
        					this.os.println(this.clientSocket.getLocalPort());*/
                			break;
        				}
        			}
        		}
        	
        		 
        		 
        		 threads[i].os.println("<" + name + "> " + words[1]);
                 
                   this.os.println(">" +"to " + threads[i].clientName + " > " + words[1]);
                    break;
                  }
                }
              }
            }
          }
        } else {
          synchronized (this) {
            for (int i = 0; i < ClientsNum; i++) {
              if (threads[i] != null && threads[i].clientName != null) {
                threads[i].os.println("<" + name + "> " + line);
              }
            }
          }
        }
      }
      synchronized (this) {
        for (int i = 0; i < ClientsNum; i++) {
          if (threads[i] != null && threads[i] != this
              && threads[i].clientName != null) {
            threads[i].os.println("** The user " + name
                + " is leaving the chat room ! **");
          }
        }
      }
      os.println("**Bye " + name + " **");

      synchronized (this) {
        for (int i = 0; i < ClientsNum; i++) {
          if (threads[i] == this) {
            threads[i] = null;
          }
        }
      }

      is.close();
      os.close();
      clientSocket.close();
    } catch (IOException e) {
    }
  }
}
