package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;

public class Arrows extends JPanel{
JButton up;
JButton down;
JButton right;
JButton left;
JButton upright;
JButton upleft;
JButton downright;
JButton downleft;
SecondWindow n;
public Arrows(SecondWindow secondWindow) {
	this.setOpaque(false);
this.n=secondWindow;
	setLayout(new GridLayout(3,3));
	up = new JButton();
	up.setIcon(new ImageIcon(
			((new ImageIcon("resources/up.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	up.setName("UP");
	down = new JButton();
	down.setIcon(new ImageIcon(
			((new ImageIcon("resources/down.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	right = new JButton();
	right.setIcon(new ImageIcon(
			((new ImageIcon("resources/right.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	left = new JButton();
	left.setIcon(new ImageIcon(
			((new ImageIcon("resources/left.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	upright = new JButton();
	upright.setIcon(new ImageIcon(
			((new ImageIcon("resources/upright.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	upleft = new JButton();
	upleft.setIcon(new ImageIcon(
			((new ImageIcon("resources/upleft.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	downright = new JButton();
	downright.setIcon(new ImageIcon(
			((new ImageIcon("resources/downright.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	downleft = new JButton();
	downleft.setIcon(new ImageIcon(
			((new ImageIcon("resources/downleft.png")).getImage()).getScaledInstance(20, 10, java.awt.Image.SCALE_SMOOTH)));
	add(upleft);
	add(up);
	add(upright);
	add(left);
	JButton mid = new JButton();
	add(mid);
	add(right);
	add(downleft);
	add(down);
	add(downright);
	up.addActionListener(new up());
	down.addActionListener(new down());
	right.addActionListener(new right());
	left.addActionListener(new left());
	upright.addActionListener(new upright());
	upleft.addActionListener(new upleft());
	downright.addActionListener(new downright());
	downleft.addActionListener(new downleft());
	up.setContentAreaFilled(false);
	down.setContentAreaFilled(false);
	right.setContentAreaFilled(false);
	left.setContentAreaFilled(false);
	upleft.setContentAreaFilled(false);
	upright.setContentAreaFilled(false);
	downright.setContentAreaFilled(false);
	downleft.setContentAreaFilled(false);
	mid.setContentAreaFilled(false);
	
	
}
private class up implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.UP);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
				   // System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}	
	}}
private class down implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.DOWN);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
				  //  System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}	
	}}
private class left implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.LEFT);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
			//	    System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			  //  System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}	
	}}
private class right implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.RIGHT);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
			//	    System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			//    System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			  //  System.exit(0);
			}	
	}}
private class upleft implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.UPLEFT);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
			//	    System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			  //  System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}	
			
	}}
private class upright implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.UPRIGHT);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
//				    System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
//			    System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
	//		    System.exit(0);
			}	
	}}
private class downleft implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.DOWNLEFT);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
			//	    System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			  //  System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}	
	}}
private class downright implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		if(z!=null) {
		if(z.size()==1) {
			if(z.peek() instanceof Piece) {
			z.enqueue(Direction.DOWNRIGHT);
			n.setPlay(z);
		}
			else {
				while(!z.IsEmpty()){z.dequeue();}
				JOptionPane.showMessageDialog(n,
				        "Please choose a piece then the direction.");
			//	    System.exit(0);
			}
	}
		else{
			while(!z.IsEmpty()){z.dequeue();}
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			  //  System.exit(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(n,
			        "Please choose a piece then the direction.");
			    //System.exit(0);
			}	
	}}

}
