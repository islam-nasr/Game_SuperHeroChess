package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class CancelButton extends JPanel {
JButton cancel;
SecondWindow n;
public CancelButton(SecondWindow secondWindow) {
	setOpaque(false);
	this.n=secondWindow;
	setLayout(new FlowLayout());
	cancel=new JButton();
	cancel.setText("Cancel");
	cancel.setContentAreaFilled(false);
	cancel.addActionListener(new cancels());
	cancel.setForeground(Color.LIGHT_GRAY);
	cancel.setFont(new Font("Showcard Gothic",Font.PLAIN, 15));
	add(cancel);
	
}
private class cancels implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		QueueObj z=n.getPlay();
		while(!z.IsEmpty())
			z.dequeue();
	}
	}
}
