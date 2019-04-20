package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Queue;

import javax.management.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class SecondWindow extends JFrame {
Game n;
Player p1;
Player p2;
QueueObj play;
int c=3;
Board board;
ArrowsPowerAttack wq;
FirstPlayer f1;
SecondPlayer f2;
JTextArea current;
public static AudioPlayer aw2= AudioPlayer.player;
public static AudioStream am2;
public static AudioData as2;
public static ContinuousAudioDataStream loop2=null;

	public SecondWindow(String a, String b) {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(new JLabel(new ImageIcon("resources/aw.png")));
		play=null;
		p1=new Player(a);
		p2=new Player(b);
		n=new Game(p1,p2);
		current=new JTextArea("Current Player "+a);
		current.setForeground(Color.LIGHT_GRAY);
		current.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		setLayout(new BorderLayout());
		setSize(1000, 700);
		f1=new FirstPlayer(a);
		//f1.setSize(500,500);
		add(f1,BorderLayout.WEST);
		f2= new SecondPlayer(b);
		add(f2,BorderLayout.EAST);
		board=new Board(this);
		play=new QueueObj(3);
		add(current,BorderLayout.NORTH);
		current.setOpaque(false);
		
		
		
		
		beg();
		
		
		
		
		
		//ArrowsPowerAttack apa=new ArrowsPowerAttack();
		///apa.setBounds(100,500,1200,100);
		//CompleteActions x = new CompleteActions(board,apa);
		add(board,BorderLayout.CENTER);
		wq=new ArrowsPowerAttack(this);
		add(wq,BorderLayout.SOUTH);
		//add(board,BorderLayout.CENTER);
		//add(apa,BorderLayout.SOUTH);
		//addAction(board);
		///setBackground("/SHC_M2/firstback.jpg");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public QueueObj getPlay() {
		return play;
	}

	public void setPlay(QueueObj play) {
		this.play = play;
	}

	public void addAction(Board a) {
		Component [] com= a.getComponents();
	for (int i = 0; i < com.length; i++) {
		JButton b= (JButton) (com[i]);
		//b.addActionListener(new action());
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//if(e.getActionCommand()==)
				
			}
			
		});
	}
	
	}
	public static void beg() {

		try {
			am2=new AudioStream(new FileInputStream("resources/balabizo5.wav"));
			as2=am2.getData();
			loop2=new ContinuousAudioDataStream(as2);}
			catch(IOException error) {
				System.out.println("not found music");
			}
			aw2.start(loop2);
		}
	
	//private class action implements ActionListener{
		//public void actionPerformed(ActionEvent arg0) {
			
		//}
	//}

}
