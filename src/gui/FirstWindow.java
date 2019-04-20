package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import sun.audio.*;


public class FirstWindow extends JFrame{
JTextArea p1;
JTextArea name1;
JTextArea name2;
JTextArea p2;
JButton start;
	
	public FirstWindow(String a, String b) {
		/*//super();
		//setIconImage("firstback.jpg");
		pack();
		//JLabel x= new JLabel();
		//setIconImage(Image("D:/firstback.jpg"));
		//x.setBounds(0,0,1000,1000);
		//x.setVisible(true);
		//add(x);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		setSize(1000, 700);
		p1=new JTextArea(a);
		p1.setEditable(false);
		p2=new JTextArea(b);
		p2.setEditable(false);
		p1.setBounds(50,200,300,100);
		name1=new JTextArea("Player 1 name:");
		p2.setBounds(500,200,300,100);
		name1.setBounds(10,10,300,100);
		name1.setEditable(false);
		name2=new JTextArea("Player 2 name:");
		name2.setEditable(false);
		name2.setBounds(500,10,300,100);
		add(name1);
		add(p1);
		add(name2);
		add(p2);
		start=new JButton();
		start.setLabel("START");
		start.addActionListener(new start());
		start.setBounds(300,300,200,200);
		add(start);
		setVisible(true);
		//JLabel back=new JLabel();
	
		//back.setIcon(new ImageIcon("D:/firstback.jpg"));
		//back.setBounds(0, 0, this.getX(), this.getY());
		//getContentPane().add(back);
		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		pack();
		setLayout(null);
		
		//image
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("resources/ss.png")));
		
		p1 = new JTextArea(a);
		p1.setEditable(false);
		p1.setOpaque(false);
		p1.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
		p1.setForeground(Color.black); 
		
		p2 = new JTextArea(b);
		p2.setEditable(false);
		p2.setOpaque(false);
		p2.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
		p2.setForeground(Color.black); 
		p1.setBounds(300, 150, 350, 100);
		p2.setBounds(900, 150, 350, 100);
		add(p1);
		add(p2);
		
		
	//	ImageIcon img1 = new ImageIcon("D:/vs.jpg");
		//vs.setIcon(img1);
		//vs.setBounds(600, 150, 300, 800);
		//add(vs);
		
		start = new JButton();
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		ImageIcon img = new ImageIcon(""
				+ "resources/start2.gif");
		start.setIcon(img);
		//start.setFont(new Font("Britannic ", Font.BOLD, 40));  (SIZE AND FONT)
		//start.setForeground(Color.red); (COLOR OF TEXT)
		start.addActionListener(new start());
		start.setBounds(525, 500, 350, 200);
		add(start);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
	}
	private class start implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			pika();
			setVisible(false);
			SecondWindow x= new SecondWindow(p1.getText(),p2.getText());
			x.setVisible(true);	
			aw.stop(loop);
			
		}
			}
	public static void main(String[]args) {
		String player1x= JOptionPane.showInputDialog(null,"Enter Player 1 Name");
		String player2x= JOptionPane.showInputDialog(null,"Enter Player 2 Name");
		FirstWindow z=new FirstWindow(player1x,player2x);
		z.setVisible(true);
		
	}	static AudioPlayer aw= AudioPlayer.player;
	static AudioStream am;
	static AudioData as;
	static ContinuousAudioDataStream loop=null;
	public static void pika() {
	
		try {
			am=new AudioStream(new FileInputStream("resources/pika.wav"));
			as=am.getData();
			loop=new ContinuousAudioDataStream(as);}
			catch(IOException error) {
				System.out.println("not found music");
			}
			aw.start(loop);
		}
	
			}

