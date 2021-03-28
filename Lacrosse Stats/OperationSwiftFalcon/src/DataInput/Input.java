package DataInput;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Input {
	
	public Input(Shot newShot, int shotID) {
		
		JPanel holder = new JPanel();
		holder.setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,3));
		
		JButton topLeft = new JButton("Top Left");
		centerPanel.add(topLeft);
		
		JButton topMiddle = new JButton("Top Middle");
		centerPanel.add(topMiddle);
		
		JButton topRight = new JButton("Top Right");
		centerPanel.add(topRight);
		
		JButton middleLeft = new JButton("Middle Left");
		centerPanel.add(middleLeft);
		
		JButton NA = new JButton("NA");
		centerPanel.add(NA);
		
		JButton middleRight = new JButton("Middle Right");
		centerPanel.add(middleRight);
		
		JButton bottomLeft = new JButton("Bottom Left");
		centerPanel.add(bottomLeft);
	
		JButton bottomMiddle = new JButton("Bottom Middle");
		centerPanel.add(bottomMiddle);
		
		JButton bottomRight = new JButton("Bottom Right");
		centerPanel.add(bottomRight);
		
		holder.add(centerPanel, BorderLayout.CENTER);
		
		
		
		JFrame p = new JFrame();
		p.setContentPane(holder);
		p.setSize(new Dimension(400, 300));
		p.setVisible(true);
		
		ActionListener ac = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				newShot.setGoalLoc(e.getActionCommand()); 
				p.dispose();
				PlayerInput PI = new PlayerInput(newShot, shotID);
			}
		};
		
		topLeft.setActionCommand("TL");
		topLeft.addActionListener(ac);
		topMiddle.setActionCommand("TM");
		topMiddle.addActionListener(ac);
		topRight.setActionCommand("TR");
		topRight.addActionListener(ac);
		middleLeft.setActionCommand("ML");
		middleLeft.addActionListener(ac);
		middleRight.setActionCommand("MR");
		middleRight.addActionListener(ac);
		bottomLeft.setActionCommand("BL");
		bottomLeft.addActionListener(ac);
		bottomMiddle.setActionCommand("BM");
		bottomMiddle.addActionListener(ac);
		bottomRight.setActionCommand("BR");
		bottomRight.addActionListener(ac);
		NA.setActionCommand("NA");
		NA.addActionListener(ac);
		
	}
}
