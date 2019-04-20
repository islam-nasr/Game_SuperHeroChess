package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CompleteActions extends JPanel {

	public CompleteActions(Board q,ArrowsPowerAttack apa) {
	
		setLayout(new BorderLayout());
		add(q,BorderLayout.CENTER);
		apa.setVisible(true);
		add(apa,BorderLayout.SOUTH);
	}
}
