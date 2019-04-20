/*package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.game.Player;

public class ThirdWindow extends JFrame {
SecondWindow n;
Player pn;

public ThirdWindow(SecondWindow n, Player currentPlayer) {
	
		// TODO Auto-generated constructor stub
	
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.n=n;
	pn=currentPlayer;
	setLayout(new FlowLayout());
	JButton x=new JButton();
	x.setText("Reset Game");
	JButton y= new JButton();
	y.setText("End Game");
	x.addActionListener(new reset());
	y.addActionListener(new end());
	add(x);
	add(y);
	JTextArea winner=new JTextArea(pn.getName()+"  WON");
	add(winner);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}*/
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.game.Player;

public class ThirdWindow extends JFrame {
	SecondWindow n;
	Player pn;

	public ThirdWindow(SecondWindow n, Player currentPlayer) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("resources/gameover2.png")));
		this.n = n;
		pn = currentPlayer;
		//setLayout(new FlowLayout());
		JPanel q=new JPanel();
		q.setLayout(new FlowLayout());
		
	
		JButton x = new JButton();
		x.setOpaque(false);
		x.setContentAreaFilled(false);
		x.setText("Reset Game");
		x.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		x.setForeground(Color.GREEN);
		JButton y = new JButton();
		y.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		y.setForeground(Color.red);
		y.setOpaque(false);
		y.setContentAreaFilled(false);
		y.setText("End Game");
		x.addActionListener(new reset());
		y.addActionListener(new end());
		q.add(x);
		q.add(y);
		JTextArea winner = new JTextArea(pn.getName());
		winner.setBounds(630, 400, 400, 400);
		winner.setOpaque(false);
		winner.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		winner.setForeground(Color.WHITE);
		winner.setEditable(false);

		q.setBounds(425,600,500,500);
		q.setOpaque(false);
		add(q);
		add(winner,BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
private class reset implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		n.setVisible(false);
	setVisible(false);
	SecondWindow x= new SecondWindow(n.n.getPlayer1().getName(),n.n.getPlayer2().getName());
	x.setVisible(true);	
	}
	}
private class end implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
	System.exit(ABORT);
	//n.setVisible(false);
	}
	}

}
