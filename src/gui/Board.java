package gui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

public class Board extends JPanel {
public PieceButton [][] q;
SecondWindow n;
public Board(SecondWindow secondWindow, PieceButton [][] r) {
	this.setOpaque(false);
	this.q=r;
	n=secondWindow;
	for (int i = 0; i < 7; i++) {
		for (int j = 0; j < 6; j++) {
			q[i][j]=new PieceButton(i,j);
			q[i][j].setContentAreaFilled(false);
			q[i][j].addActionListener(new piece());
			add(q[i][j]);
			//q[i][j].addActionListener();
			//q[i][j].setActionCommand(arg0);
		}}
	Game game=n.n;
	for(int i=0;i<7;i++) {
		for(int j=0;j<6;j++) {
			Piece piece=game.getCellAt(i, j).getPiece();
			if(piece != null) {
				if ((piece instanceof SideKick) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/charmander.png")).getImage())
							.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s SideKick");
				}

				if ((piece instanceof SideKick) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/sq.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Sidekick");
				}

				if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/aruup1.png")).getImage())
							.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s Armored");
				}

				if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/aruup2.png")).getImage())
							.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Armored");
				}

				if ((piece instanceof Super) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/su1.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s Super");
				}

				if (piece instanceof Super && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/su2.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Super");
				}

				if ((piece instanceof Speedster && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/spd1.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s Speedster");
				}

				if ((piece instanceof Speedster && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/spd2.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Speedster");
				}

				if ((piece instanceof Tech && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/tech1.png")).getImage())
							.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s Tech");
				}

				if ((piece instanceof Tech && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/tech2.png")).getImage())
							.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Tech");
				}

				if ((piece instanceof Ranged && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged1.png")).getImage())
							.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s Ranged");
				}

				if ((piece instanceof Ranged && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged2.png")).getImage())
							.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Ranged");
				}

				if ((piece instanceof Medic && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/med1.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p1.getName() + "'s Medic");
				}

				if ((piece instanceof Medic && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
					q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/med2.png")).getImage()).getScaledInstance(70,
							50, java.awt.Image.SCALE_SMOOTH)));
					q[i][j].setToolTipText(n.p2.getName() + "'s Medic");
				}

							}
										}
													}
}
	public Board(SecondWindow secondWindow) {
		this.setOpaque(false);
	this.n=secondWindow;
		//setBounds(100,0,800,570);
		setLayout(new GridLayout(7,6));
		 q=new PieceButton[7][6];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				q[i][j]=new PieceButton(i,j);
				q[i][j].setContentAreaFilled(false);
				q[i][j].addActionListener(new piece());
				add(q[i][j]);
				//q[i][j].addActionListener();
				//q[i][j].setActionCommand(arg0);
			}}
		Game game=n.n;
		for(int i=0;i<7;i++) {
			for(int j=0;j<6;j++) {
				Piece piece=game.getCellAt(i, j).getPiece();
				if(piece != null) {
					if ((piece instanceof SideKick) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/charmander.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s SideKick");
					}

					if ((piece instanceof SideKick) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/sq.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Sidekick");
					}

					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))&& ((Armored)piece).isArmorUp()) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/aruup1.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Armored"+" Armor Up");
					}
					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))&& !((Armored)piece).isArmorUp()) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/ardoo1.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Armored"+" Armor Down");
					}

					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)) && ((Armored)piece).isArmorUp()) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/aruup2.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Armored"+ " Armor Up");
					}
					if ((piece instanceof Armored) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)) && !((Armored)piece).isArmorUp()) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/ardoo2.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Armored"+ " Armor Down");
					}
					if ((piece instanceof Super) && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/su1.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Super"+" Power Used:"+((Super)piece).isPowerUsed());
					}

					if (piece instanceof Super && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/su2.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Super"+ " Power Used:"+((Super)piece).isPowerUsed());
					}

					if ((piece instanceof Speedster && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/spd1.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Speedster");
					}

					if ((piece instanceof Speedster && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/spd2.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Speedster");
					}

					if ((piece instanceof Tech && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/tech1.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Tech"+" Power Used:"+((Tech)piece).isPowerUsed());
					}

					if ((piece instanceof Tech && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/tech2.png")).getImage())
								.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Tech"+" Power Used:"+((Tech)piece).isPowerUsed());
					}

					if ((piece instanceof Ranged && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged1.png")).getImage())
								.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Ranged"+" Power Used:"+((Ranged)piece).isPowerUsed());
					}

					if ((piece instanceof Ranged && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/Ranged2.png")).getImage())
								.getScaledInstance( 70, 50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Ranged"+" Power Used:"+((Ranged)piece).isPowerUsed());
					}

					if ((piece instanceof Medic && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p1)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/med1.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p1.getName() + "'s Medic"+" Power Used:"+((Medic)piece).isPowerUsed());
					}

					if ((piece instanceof Medic && (game.getCellAt(i, j).getPiece().getOwner().equals(n.p2)))) {
						q[i][j].setIcon(new ImageIcon(((new ImageIcon("resources/med2.png")).getImage()).getScaledInstance(70,
								50, java.awt.Image.SCALE_SMOOTH)));
						q[i][j].setToolTipText(n.p2.getName() + "'s Medic"+" Power Used:"+((Medic)piece).isPowerUsed());
					}

								}else {
									q[i][j].setIcon(null);
									q[i][j].setToolTipText("empty cell");
								}
											}
														}
	
		
		
	}
	public class piece implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			/*if(n.n.getPlayer1().getPayloadPos()==6) {
				ThirdWindow tw= new ThirdWindow(n,n.n.getPlayer1());
				tw.setVisible(true);
			}
			if(n.n.getPlayer2().getPayloadPos()==6) {
				ThirdWindow tw= new ThirdWindow(n,n.n.getPlayer2());
				tw.setVisible(true);
			}*/
			QueueObj z=n.getPlay();
			PieceButton o=(PieceButton)arg0.getSource();
			
			//if(z.IsEmpty()) {
				if(n.n.getCellAt(o.getI(),o.getJ()).getPiece()!=null) {
					z.enqueue(n.n.getCellAt(o.getI(), o.getJ()).getPiece());
					n.setPlay(z);
				}
				else { 
					Point qw=new Point(o.getI(),o.getJ());
					z.enqueue(qw);
					n.setPlay(z);}}}}
					/*while(!z.IsEmpty())
						z.dequeue();
					n.setPlay(z);
					JOptionPane.showMessageDialog(n,
					        "This cell contains no piece");here
					
				}}else {
					while(!z.IsEmpty())
						z.dequeue();
					n.setPlay(z);
					JOptionPane.showMessageDialog(n,
					        "Choose piece first thing");
			}}}}
			
				/*if(z.peek() instanceof Piece) {
				z.add(Direction.DOWNRIGHT);
				n.setPlay(z);
			}
				else {
					n.setPlay(null);
					JOptionPane.showMessageDialog(n,
					        "Please choose a piece then the direction.");
				//	    System.exit(0);
				}
		}
			else{
				n.setPlay(null);
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
		}}*/

