package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import gui.Board.piece;
import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

public class MoveButton extends JPanel {
JButton move;
SecondWindow n;
public MoveButton(SecondWindow secondWindow) {
	setOpaque(false);
	this.n=secondWindow;
	setLayout(new FlowLayout());
	move=new JButton();
	move.setText("Move");
	move.setContentAreaFilled(false);
	move.addActionListener(new piece());
	move.setForeground(Color.LIGHT_GRAY);
	move.setFont(new Font("Showcard Gothic",Font.PLAIN, 15));
	add(move);
}
private class piece implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		if(n.n.checkWinner()) {
			JOptionPane.showMessageDialog(n,
			        "game ended can't make further actions");
		}
		else {
		// n.n.getCurrentPlayer().setPayloadPos(6);
		QueueObj z=n.getPlay();
		boolean f=true;
	if(z.size()==2) {
	if(z.peek() instanceof Piece) {
		Piece x=(Piece) z.dequeue();
		int i=x.getPosI();
		int j=x.getPosJ();
		if(z.peek() instanceof Direction) {
			Direction d= (Direction) z.dequeue();
			if(z.IsEmpty()) {
		try {
			x.move(d);
		} catch (UnallowedMovementException e) {
			f=false;
			JOptionPane.showMessageDialog(n,
			        x+" can't move in this direction.");
		} catch (OccupiedCellException e) {
			f=false;
			JOptionPane.showMessageDialog(n,
			        "Cell contains friendly piece.");
		} catch (WrongTurnException e) {
			f=false;
			JOptionPane.showMessageDialog(n,
			        "Not your turn.");
		}
		}
			else {
				f=false;
				while(!z.IsEmpty())
					z.dequeue();
				JOptionPane.showMessageDialog(n,
				        "Choose charecter then direction then click on move button.");
			}
	}
		else {
			f=false;
			while(!z.IsEmpty())
				z.dequeue();
			JOptionPane.showMessageDialog(n,
			        "Choose charecter then direction then click on move button.");
		}
		if(f) {
			/*setnewboard();
		}*/
			PieceButton [][] pb=n.board.q;
			Game game=n.n;
			for(int in=0;in<7;in++) {
				for(int jn=0;jn<6;jn++) {
					Piece piece=game.getCellAt(in, jn).getPiece();
					if(piece != null) {
						if ((piece instanceof SideKick) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/charmander.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s SideKick");
						}

						if ((piece instanceof SideKick) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/sq.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Sidekick");
						}

						if ((piece instanceof Armored) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1))&& ((Armored)piece).isArmorUp()) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/aruup1.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Armored"+" Armor Up");
						}
						if ((piece instanceof Armored) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1))&& !((Armored)piece).isArmorUp()) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/ardoo1.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Armored"+" Armor Down");
						}

						if ((piece instanceof Armored) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2)) && ((Armored)piece).isArmorUp()) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/aruup2.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Armored"+ " Armor Up");
						}
						if ((piece instanceof Armored) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2)) && !((Armored)piece).isArmorUp()) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/ardoo2.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Armored"+ " Armor Down");
						}
						if ((piece instanceof Super) && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/su1.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Super"+" Power Used:"+((Super)piece).isPowerUsed());
						}

						if (piece instanceof Super && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/su2.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Super"+ " Power Used:"+((Super)piece).isPowerUsed());
						}

						if ((piece instanceof Speedster && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/spd1.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Speedster");
						}

						if ((piece instanceof Speedster && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/spd2.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Speedster");
						}

						if ((piece instanceof Tech && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/tech1.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Tech"+" Power Used:"+((Tech)piece).isPowerUsed());
						}

						if ((piece instanceof Tech && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/tech2.png")).getImage())
									.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Tech"+" Power Used:"+((Tech)piece).isPowerUsed());
						}

						if ((piece instanceof Ranged && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged1.png")).getImage())
									.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Ranged"+" Power Used:"+((Ranged)piece).isPowerUsed());
						}

						if ((piece instanceof Ranged && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged2.png")).getImage())
									.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Ranged"+" Power Used:"+((Ranged)piece).isPowerUsed());
						}

						if ((piece instanceof Medic && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p1)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/med1.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p1.getName() + "'s Medic"+" Power Used:"+((Medic)piece).isPowerUsed());
						}

						if ((piece instanceof Medic && (game.getCellAt(in, jn).getPiece().getOwner().equals(n.p2)))) {
							pb[in][jn].setIcon(new ImageIcon(((new ImageIcon("resources/med2.png")).getImage()).getScaledInstance(70,
									50, java.awt.Image.SCALE_SMOOTH)));
							pb[in][jn].setToolTipText(n.p2.getName() + "'s Medic"+" Power Used:"+((Medic)piece).isPowerUsed());
						}

									
									}
										
					else {
						pb[in][jn].setIcon(null);
						pb[in][jn].setToolTipText("empty cell");
					}
					
												}
															}
				
					int pl=n.n.getPlayer1().getPayloadPos();
				
						n.f1.c1.setValue(pl);
					n.f1.dead.removeAllItems();
				//	JComboBox<String> de=new JComboBox<String>();
					ArrayList<Piece> x2=n.n.getPlayer1().getDeadCharacters();
					for (int k = 0; k < x2.size(); k++) {
					n.f1.dead.addItem(x2.get(k).getClass().getSimpleName());
					}
					
					
						int pl2=n.n.getPlayer2().getPayloadPos();
						JProgressBar prog2=n.f2.c2;
							prog2.setValue(pl2);
				//	JComboBox<String> de2=new JComboBox<String>();
					n.f2.dead.removeAllItems();
					ArrayList<Piece> xw=n.n.getPlayer2().getDeadCharacters();
					for (int k = 0; k < xw.size(); k++) {
					n.f2.dead.addItem(xw.get(k).getClass().getSimpleName());
					}
						
					
					
			
			}
				
			 
				
		
	}
	else {
		while(!z.IsEmpty())
			z.dequeue();
		JOptionPane.showMessageDialog(n,
		        "Choose charecter then direction then click on move button.");
	}
	}
	else {
		while(!z.IsEmpty())
			z.dequeue();
		JOptionPane.showMessageDialog(n,
		        "Choose charecter then direction then click on move button.");
	}
	if(n.n.getPlayer1().getPayloadPos()>=6) {
		n.aw2.stop(n.loop2);
		ThirdWindow tw= new ThirdWindow(n,n.n.getPlayer1());
		tw.setVisible(true);
	}
	if(n.n.getPlayer2().getPayloadPos()>=6) {
		n.aw2.stop(n.loop2);
		ThirdWindow tw= new ThirdWindow(n,n.n.getPlayer2());
		tw.setVisible(true);
	}
	/*if(n.n.checkWinner()) {
		ThirdWindow tw= new ThirdWindow(n,n.n.getCurrentPlayer());
		tw.setVisible(true);
		//n.setVisible(false);
	}*/
	
	
	n.current.setText("Current Player "+n.n.getCurrentPlayer().getName());
}
	
	}
	}}
/*public void resetnewboard() {
	PieceButton [][] q=new PieceButton[7][6];
	this.n.board=new Board(n,q);
	/*Game game=n.n;
	for (int i = 0; i < 7; i++) {
		for (int j = 0; j < 6; j++) {
			q[i][j]=new PieceButton(i,j);
			q[i][j].addActionListener(new piece());
			add(q[i][j]);
			//q[i][j].addActionListener();
			//q[i][j].setActionCommand(arg0);
		}}
	for(int i=0;i<7;i++) {
		for(int j=0;j<6;j++) {
			Piece piece=game.getCellAt(i, j).getPiece();
			if(piece != null) {
				if(piece instanceof SideKick)
					q[i][j].setText("SideKick");
				if(piece instanceof Armored) 
					q[i][j].setText("Armored");
				if(piece instanceof Super) 
					q[i][j].setText("Super");
				if(piece instanceof Tech) 
					q[i][j].setText("Tech");
				if(piece instanceof Speedster) 
					q[i][j].setText("Speedster");
				if(piece instanceof Ranged) 
					q[i][j].setText("Ranged");
				if(piece instanceof Medic) 
					q[i][j].setText("Medic");

							}
										}
													}
	////
	if(n.n.getCurrentPlayer()==n.n.getPlayer1()) {
		int pl=n.n.getCurrentPlayer().getPayloadPos();
		JProgressBar prog=new JProgressBar(0,6);
		prog.setValue(pl);
		n.f1.c1=prog;
		JComboBox<Piece> de=new JComboBox<Piece>();
		ArrayList<Piece> x2=n.n.getCurrentPlayer().getDeadCharacters();
		for (int k = 0; k < x2.size(); k++) {
		de.addItem(x2.get(k));
		}
		n.f1.dead=de;}
		else {
			int pl=n.n.getCurrentPlayer().getPayloadPos();
			JProgressBar prog=new JProgressBar(0,6);
			prog.setValue(pl);
			n.f2.c2=prog;
			n.f2.dead.removeAll();
		JComboBox<Piece> de=new JComboBox<Piece>();
		ArrayList<Piece> x2=n.n.getCurrentPlayer().getDeadCharacters();
		for (int k = 0; k < x2.size(); k++) {
		de.addItem(x2.get(k));
		}
		n.f2.dead=de;	
		}
		
/////
}*/
	
	

