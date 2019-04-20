package exceptions;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class TCPClient extends JFrame implements Runnable  {
  
  private static Socket clientSocket = null;
  private static PrintStream os = null;
  private static DataInputStream is = null;
  public  static BufferedReader inputLine = null;
  private static boolean closed = false;
  public  static int portNumber ;
  private static String input=null;
  private static boolean flag=false;
public TCPClient() {
	
}
  public static void main(String[] args) throws IOException {
	 // String player1x= 
	  TCPClient c=new TCPClient();
	    boolean inputport = true;
	    System.out.print(" Enter The Server Number");
	    while (inputport){
	    	//inputLine = new BufferedReader(new InputStreamReader(System.in));
	    	input=JOptionPane.showInputDialog(null,"Enter Server Number You Want To Connect To");
	    	if (input.equals("1")) {
	    		//if(inputLine.readLine().equals("1")){
	    		portNumber = 6700;
	    		inputport =false;
	    	}else {
		    	if (input.equals("2")) {
		   // if (inputLine.readLine().equals("2")){
			    portNumber =6800;
			    inputport =false;
		    }else{
			    System.out.print("Please Enter The Right Server Number");
		  }
	  }
	    }
	    
    String host = "localhost";
    c.setExtendedState(JFrame.MAXIMIZED_BOTH);
	c.setLayout(new BorderLayout());
	JTextArea chat=new JTextArea();
	c.add(chat,BorderLayout.WEST);
	//a.setBorderLayou(BorderLayout.WEST);
	c.setVisible(true);
    if (args.length < 2) {
      System.out
          .println("New Client is Created and"
              + "using host=" + host + ", portNumber=" + portNumber);
      chat.setText(chat.getText()+'\n'+"New Client is Created and"
              + "using host=" + host + ", portNumber=" + portNumber);
    } else {
      host = args[0];
      portNumber = Integer.valueOf(args[1]).intValue();
    }

    try {
    	if(flag==true) {			////
      clientSocket = new Socket(host, portNumber);
      inputLine = new BufferedReader(new InputStreamReader(System.in));
      
      os = new PrintStream(clientSocket.getOutputStream());
      is = new DataInputStream(clientSocket.getInputStream());
      
    	}} catch (UnknownHostException e) {
      System.err.println("Don't know about host " + host);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to the host "
          + host);
    }

  
    if (clientSocket != null && os != null && is != null) {
      try {

        new Thread(new TCPClient()).start();
        while (!closed) {
          os.println(inputLine.readLine().trim());
        }
        
        os.close();
        is.close();
        clientSocket.close();
      } catch (IOException e) {
        System.err.println("IOException:  " + e);
      }
    }
  }

  
  @SuppressWarnings("deprecation")
public void run() {
         
    String responseLine;
    try {
      while ((responseLine = is.readLine()) != null) {
        System.out.println(responseLine);
        if (responseLine.indexOf("** Bye") != -1)
          break;
      }
      closed = true;
    } catch (IOException e) {
      System.err.println("IOException:  " + e);
    }
  }
  private class start implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			flag=true;
		}
		
		}
}