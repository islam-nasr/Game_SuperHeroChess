package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import exceptions.InvalidPowerUseException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

public class UsePowerButton extends JPanel {
	JButton power;
	SecondWindow n;
	public UsePowerButton(SecondWindow secondWindow) {
		setOpaque(false);
		this.n=secondWindow;
		setLayout(new FlowLayout());
		power=new JButton();
		power.setText("Use Power");
		power.addActionListener(new UsePower());
		add(power);
		power.setContentAreaFilled(false);
		power.setForeground(Color.LIGHT_GRAY);
		power.setFont(new Font("Showcard Gothic",Font.PLAIN, 15));
	}
	private class UsePower implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(n.n.checkWinner()) {
				JOptionPane.showMessageDialog(n,
				        "game ended can't make further actions");
			}
			else {
			QueueObj z=n.getPlay();
			
			if(z.size()==2) {
				if(z.peek() instanceof Ranged||(z.peek() instanceof Super)){
						Ranged x2=null;
						Super x3=null;
				if(z.peek() instanceof Ranged) {
					 x2= (Ranged) z.dequeue();
				}
				else{
						x3= (Super) z.dequeue();
					}
					if(z.peek() instanceof Direction) {
						Direction d= (Direction) z.dequeue();
				
						if(x3==null) {
							if(x2.isPowerUsed()) {
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "Power already used");}
							else {
							try {
								x2.usePower(d, null, null);
							} catch (InvalidPowerUseException e) {
								// TODO Auto-generated catch block
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "Cant use power in this direction");
							} catch (WrongTurnException e) {
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "Wrong turn exception.");
							
							}}}
						else {
							if(x3.isPowerUsed()) {
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "Power already used");}
							else {
								
							
							try {
								x3.usePower(d, null, null);
							} catch (InvalidPowerUseException e) {
								// TODO Auto-generated catch block
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "Cant use power in this direction");
							} catch (WrongTurnException e) {
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "Wrong turn exception.");
							}
						}}}
						
					}
					
				
				else {		if(z.peek() instanceof Tech) {
					Tech x6= (Tech) z.dequeue();
					if(x6.isPowerUsed()) {
						while(!z.IsEmpty()){z.dequeue();}
						JOptionPane.showMessageDialog(n,
						        "Power already used");
					}
					if(z.peek() instanceof Piece) {
						Piece target=(Piece) z.dequeue();
						try {
							x6.usePower(null, target, null);
						} catch (InvalidPowerUseException e) {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Cant use power in this direction");
							
						} catch (WrongTurnException e) {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Wrong turn exception.");
						}
					}
					else {
						while(!z.IsEmpty())
							z.dequeue();
						JOptionPane.showMessageDialog(n,
						        "To use tech hacking or restoring power must choose two pieces then use power");
					}
						
					}
				
				else {
							if(z.peek() instanceof Medic) {
						Medic x5= (Medic) z.dequeue();
						if(x5.isPowerUsed()) {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Power already used");
						}
						
						if(z.peek() instanceof Direction) {
							Direction d=(Direction) z.dequeue();
							Piece p=null;
							
							if(n.n.getCurrentPlayer().equals(n.n.getPlayer1())) {
									int i=n.f1.dead.getSelectedIndex();
								p=(Piece) ((n.n.getPlayer1().getDeadCharacters()).get(i));
							}
							else {
								int i=n.f2.dead.getSelectedIndex();
								p=(Piece)((n.n.getPlayer2().getDeadCharacters()).get(i));}
							
						try {
							x5.usePower(d, p, null);
						} catch (InvalidPowerUseException e) {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Cant use power in this direction");
						} catch (WrongTurnException e) {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Wrong turn exception.");
						}
						
						
						}
						else {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Piece is not activatable power hero.");
						}
						}}}}
						
						
					
			else {
				if(z.size()==3) {
					if(z.peek() instanceof Tech) {
						Tech x6=(Tech)z.dequeue();
						if(!x6.isPowerUsed()) {
						if(z.peek() instanceof Piece) {
							Piece p=(Piece) z.dequeue();
							if(z.peek() instanceof Point) {
								Point po=(Point) z.dequeue();
								try {
									x6.usePower(null, p, po);
								} catch (InvalidPowerUseException e) {
									while(!z.IsEmpty()){z.dequeue();}
									JOptionPane.showMessageDialog(n,
									        "Cant use power in this direction");
								} catch (WrongTurnException e) {
									while(!z.IsEmpty()){z.dequeue();}
									JOptionPane.showMessageDialog(n,
									        "Wrong turn exception.");
								}
							} else {
								while(!z.IsEmpty()){z.dequeue();}
								JOptionPane.showMessageDialog(n,
								        "To use teleport choose two pieces then an empty cell then click power.");
							}}
						else {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "To use teleport choose two pieces then an empty cell then click power.");
						}
							
							
						}
						else {
							while(!z.IsEmpty()){z.dequeue();}
							JOptionPane.showMessageDialog(n,
							        "Power already used");
						}
						
					}
					else {
						while(!z.IsEmpty()){z.dequeue();}
						JOptionPane.showMessageDialog(n,
						        "To use teleport choose two pieces then an empty cell then click power.");
					}
				}
				else {
					while(!z.IsEmpty())
						z.dequeue();
					JOptionPane.showMessageDialog(n,
					        "Choose charecter then direction then usePower.");
				}
				}
			//call method to reconstruct the board
		Game game=n.n;
		PieceButton [][] pb=n.board.q;
		for(int i=0;i<7;i++) {
			for(int j=0;j<6;j++) {
				Piece piece=game.getCellAt(i, j).getPiece();
				if(piece != null) {
					if ((piece instanceof SideKick) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/charmander.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s SideKick");
					}

					if ((piece instanceof SideKick) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/sq.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Sidekick");
					}

					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))&& ((Armored)piece).isArmorUp()) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/aruup1.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Armored"+" Armor Up");
					}
					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))&& !((Armored)piece).isArmorUp()) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/ardoo1.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Armored"+" Armor Down");
					}

					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)) && ((Armored)piece).isArmorUp()) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/aruup2.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Armored"+ " Armor Up");
					}
					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)) && !((Armored)piece).isArmorUp()) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/ardoo2.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Armored"+ " Armor Down");
					}
					if ((piece instanceof Super) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/su1.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Super"+" Power Used:"+((Super)piece).isPowerUsed());
					}

					if (piece instanceof Super && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/su2.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Super"+ " Power Used:"+((Super)piece).isPowerUsed());
					}

					if ((piece instanceof Speedster && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/spd1.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Speedster");
					}

					if ((piece instanceof Speedster && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/spd2.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Speedster");
					}

					if ((piece instanceof Tech && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/tech1.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Tech"+" Power Used:"+((Tech)piece).isPowerUsed());
					}

					if ((piece instanceof Tech && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/tech2.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Tech"+" Power Used:"+((Tech)piece).isPowerUsed());
					}

					if ((piece instanceof Ranged && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged1.png")).getImage())
								.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Ranged"+" Power Used:"+((Ranged)piece).isPowerUsed());
					}

					if ((piece instanceof Ranged && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged2.png")).getImage())
								.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Ranged"+" Power Used:"+((Ranged)piece).isPowerUsed());
					}

					if ((piece instanceof Medic && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/med1.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p1.getName() + "'s Medic"+" Power Used:"+((Medic)piece).isPowerUsed());
					}

					if ((piece instanceof Medic && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						pb[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/med2.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						pb[i][j].setToolTipText(n.p2.getName() + "'s Medic"+" Power Used:"+((Medic)piece).isPowerUsed());
					}

								}
									
				else {
					pb[i][j].setIcon(null);
					pb[i][j].setToolTipText("empty cell");
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
	n.current.setText("Current Player "+n.n.getCurrentPlayer().getName());
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
			}
			
		}
		
}}
