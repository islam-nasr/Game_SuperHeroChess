package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import model.pieces.Piece;

public class SecondPlayer extends JPanel {
JProgressBar c2;
JComboBox<String> dead;
	public SecondPlayer(String z) {
		setOpaque(false);
		c2=new JProgressBar(JProgressBar.VERTICAL,0,6);
		c2.setSize(30,400);
		c2.setValue(0);
		c2.setOpaque(false);
		c2.setVisible(true);
		c2.setForeground(Color.LIGHT_GRAY);
		JTextArea a = new JTextArea(z);
		setLayout(new BorderLayout());
		a.setEditable(false);
		a.setFont(new Font("Times New Romans", Font.PLAIN, 12));
		a.setSize(100,100);
		a.setForeground(Color.WHITE);
	
		a.setOpaque(false);
		 dead=new JComboBox<String>();
		 dead.setSize(50,100 );
		 dead.setOpaque(false);
		add(a,BorderLayout.NORTH);
		//JTextArea c = new JTextArea("HELLO");
		//c.setSize(100,100);
		//c.setEditable(false);
		setLayout(new BorderLayout());
		add(c2,BorderLayout.CENTER);
		add(dead,BorderLayout.SOUTH);
	}
}
