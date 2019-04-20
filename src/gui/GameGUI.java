package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameGUI extends JFrame{
	FirstWindow x;

public GameGUI(String a,String b) {
	this.pack();
	this.setLayout(null);
	
	x=new FirstWindow(a,b);
	x.setVisible(true);
	add(x);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
	
	
	
public static void main(String[]args) {
	String player1x= JOptionPane.showInputDialog(null,"Enter Your Name");
	String player2x= JOptionPane.showInputDialog(null,"Enter Your Name");
	GameGUI z=new GameGUI(player1x,player2x);
	z.setVisible(true);
	
}
}