package gui;

import javax.swing.JButton;

public class PieceButton extends JButton {
int i;
int j;
public PieceButton(int i,int j) {
	super();
	this.i=i;
	this.j=j;
}
public int getI() {
	return i;
}
public void setI(int i) {
	this.i = i;
}
public int getJ() {
	return j;
}
public void setJ(int j) {
	this.j = j;
}

}
