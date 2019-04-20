package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.game.Game;

public class ArrowsPowerAttack extends JPanel {
Arrows arrow;
MoveButton move;
UsePowerButton usePower;
SecondWindow n;
CancelButton cancel;
public ArrowsPowerAttack(SecondWindow secondWindow) {
	this.setOpaque(false);
	this.n=secondWindow;
	//setBounds(100,850,100,100);
	setLayout(new FlowLayout());
	arrow=new Arrows(secondWindow);
	move=new MoveButton(secondWindow);
	usePower= new UsePowerButton(secondWindow);
	cancel=new CancelButton(secondWindow);
JButton helptech=new JButton();
	
	helptech.setToolTipText( "For hacking or returning superpower choose the tech then the target and click power. "+"To use teleporting of tech choose tech then target to be teleported then empty cell then power button");
	helptech.setText("Tech power");
	helptech.setOpaque(false);
	helptech.setContentAreaFilled(false);
	helptech.setForeground(Color.LIGHT_GRAY);

	add(helptech);
	
JButton helpranged=new JButton();
	
	helpranged.setToolTipText("To use power of Ranged (throwing arrow to first enemy) you must choose the hero then the direction then click on use power");
	helpranged.setText("Ranged Power");
	helpranged.setOpaque(false);
	helpranged.setContentAreaFilled(false);
	helpranged.setForeground(Color.LIGHT_GRAY);
	add(helpranged);
JButton helpsuper=new JButton();
	
	helpsuper.setToolTipText("To use power of super (attacking 2 cells in given direction) you must choose the hero then the direction then click on use power");
	helpsuper.setText("Super Power");
	helpsuper.setOpaque(false);
	helpsuper.setContentAreaFilled(false);
	helpsuper.setForeground(Color.LIGHT_GRAY);
	add(helpsuper);
	add(cancel);
	add(arrow);
	add(move);
	add(usePower);
JButton helpmedic=new JButton();
	
	helpmedic.setToolTipText("For reviving choose the medic and choose direction to revive and choose dead piece from combo box then power button");
	helpmedic.setText("Medic Revive");
	add(helpmedic);
	helpmedic.setOpaque(false);
	helpmedic.setContentAreaFilled(false);
	helpmedic.setForeground(Color.LIGHT_GRAY);
	JButton helpmove=new JButton();
	
	helpmove.setToolTipText("To move choose the character then arrow then click on move");
	helpmove.setText("Move help");
	helpmove.setOpaque(false);
	helpmove.setContentAreaFilled(false);
	helpmove.setForeground(Color.LIGHT_GRAY);
	add(helpmove);



}
}
