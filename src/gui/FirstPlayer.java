package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import model.pieces.Piece;

public class FirstPlayer extends JPanel {
	//JComboBox
	JComboBox<String> dead;
	JProgressBar c1;
	public FirstPlayer(String z) {
		setOpaque(false);
		c1=new JProgressBar(JProgressBar.VERTICAL,0,6);
		c1.setSize(30,400);
		c1.setValue(0);
		c1.setOpaque(false);
		c1.setVisible(true);
		c1.setForeground(Color.LIGHT_GRAY);
		JTextArea a = new JTextArea(z);
		a.setForeground(Color.WHITE);
		a.setFont(new Font("Times New Romans", Font.PLAIN, 12));
		setLayout(new BorderLayout());
		a.setEditable(false);
		a.setOpaque(false);
		a.setSize(100,100);
		this.dead=new JComboBox<String>();
		dead.setOpaque(false);
		add(a,BorderLayout.NORTH);
		//JTextArea c = new JTextArea("HELLO");
		//c.setSize(100,100);
		//c.setEditable(false);
		setLayout(new BorderLayout());
		add(c1,BorderLayout.CENTER);
		add(dead,BorderLayout.SOUTH);
		
	}
	
}
