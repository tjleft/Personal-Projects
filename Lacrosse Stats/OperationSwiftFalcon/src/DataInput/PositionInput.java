package DataInput;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PositionInput {

	public PositionInput(Shot newShot, int shotID) {

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1));

		JButton attack = new JButton("Attack");
		panel.add(attack);

		JButton middie = new JButton("Offensive Middie");
		panel.add(middie);

		JButton fogo = new JButton("FOGO");
		panel.add(fogo);

		JButton lsm = new JButton("Long Stick Middie");
		panel.add(lsm);

		JButton dmid = new JButton("Defensive Middie");
		panel.add(dmid);

		JButton defense = new JButton("Close Defensemen");
		panel.add(defense);

		JButton goalie = new JButton("Goalie");
		panel.add(goalie);

		JFrame p = new JFrame();
		p.setSize(200, 400);
		p.setContentPane(panel);
		p.setVisible(true);

		ActionListener positionInput = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				newShot.setPositionID(Integer.parseInt(e.getActionCommand()), 0);
				p.dispose();
				Details test = new Details(newShot, shotID);
			}
		};
		
		attack.setActionCommand("1");
		attack.addActionListener(positionInput);
		
		defense.setActionCommand("2");
		defense.addActionListener(positionInput);
		
		middie.setActionCommand("3");
		middie.addActionListener(positionInput);
		
		dmid.setActionCommand("4");
		dmid.addActionListener(positionInput);
		
		lsm.setActionCommand("5");
		lsm.addActionListener(positionInput);
		
		goalie.setActionCommand("6");
		goalie.addActionListener(positionInput);
		
		fogo.setActionCommand("7");
		fogo.addActionListener(positionInput);
		
	}

}
