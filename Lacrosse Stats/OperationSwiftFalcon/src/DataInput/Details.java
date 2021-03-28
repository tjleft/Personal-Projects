package DataInput;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Details {

	boolean handCount = false;
	boolean releaseCount = false;
	boolean typeCount = false;
	boolean fakeCount = false;
	boolean contestedCount = false;
	
	public Details(Shot newShot, int shotID) {
		
		JFrame p = new JFrame();
		
		
		
		ActionListener I = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
				if(command.equals("R") | command.equals("L")) {
					newShot.setHand(command.charAt(0));
					handCount = true;
				}
				if(command.equals("OH") |  command.equals("SA") | command.equals("UH")) {
					newShot.setRelease(command);
					releaseCount = true;
				}
				if(command.equals("On The Run") |  command.equals("Step Down") | command.equals("Inside Move")) {
					newShot.setType(command);
					typeCount= true;
				}
				if(command.equals("0") |  command.equals("1")) {
					newShot.setFake(Integer.parseInt(command)==1);
					fakeCount = true;
				}
				if(command.equals("01") |  command.equals("11")) {
					newShot.setContested(Integer.parseInt(command)==11);
					contestedCount = true;
				}
				if(handCount & releaseCount & typeCount & fakeCount & contestedCount) {
					p.dispose();
					if(newShot.isAssist()) {
						AssistInput test = new AssistInput(newShot, shotID);
					} else {
						GameDetails test = new GameDetails(newShot, shotID);
					}
				}
			}
		};
		
		JPanel holder = new JPanel();
		holder.setLayout(new GridLayout(1, 5));
		
		//hand
		JPanel hand = new JPanel();
		hand.setLayout(new GridLayout(3,1));
		
		JLabel handInput = new JLabel("Which hand?");
		hand.add(handInput);
		
		JButton right = new JButton("Right Hand");
		hand.add(right);
		right.setActionCommand("R");
		right.addActionListener(I);
		
		JButton left = new JButton("Left Hand");
		hand.add(left);
		left.setActionCommand("L");
		left.addActionListener(I);
		
		holder.add(hand);
		
		//release
		JPanel release = new JPanel();
		release.setLayout(new GridLayout(4,1));
		
		JLabel releaseInput = new JLabel("What Release?");
		release.add(releaseInput);
		
		JButton over = new JButton("Overhand");
		release.add(over);
		over.setActionCommand("OH");
		over.addActionListener(I);
		
		JButton side = new JButton("Sidearm");
		release.add(side);
		side.setActionCommand("SA");
		side.addActionListener(I);
		
		JButton under = new JButton("Underhand");
		release.add(under);
		under.setActionCommand("UH");
		under.addActionListener(I);
		
		holder.add(release);
		
		//type
		JPanel type = new JPanel();
		type.setLayout(new GridLayout(4,1));
		
		JLabel typeInput = new JLabel("What Type of shot?");
		type.add(typeInput);
		
		JButton run = new JButton("On the Run");
		type.add(run);
		run.setActionCommand("On The Run");
		run.addActionListener(I);
		
		JButton stepdown = new JButton("Step Down");
		type.add(stepdown);
		stepdown.setActionCommand("Step Down");
		stepdown.addActionListener(I);
		
		JButton inside = new JButton("Inside Move");
		type.add(inside);
		inside.setActionCommand("Inside Move");
		inside.addActionListener(I);
		
		holder.add(type);
		
		//fake
		JPanel fake = new JPanel();
		fake.setLayout(new GridLayout(3,1));
		
		JLabel fakeInput = new JLabel("Was there a fake?");
		fake.add(fakeInput);
		
		JButton yes = new JButton("Yes");
		fake.add(yes);
		yes.setActionCommand("1");
		yes.addActionListener(I);
		
		JButton no = new JButton("No");
		fake.add(no);
		no.setActionCommand("0");
		no.addActionListener(I);
		
		holder.add(fake);
		
		//contested
		JPanel contested = new JPanel();
		contested.setLayout(new GridLayout(3,1));
		
		JLabel contestedInput = new JLabel("Was it contested?");
		contested.add(contestedInput);
		
		JButton yes1 = new JButton("Yes");
		contested.add(yes1);
		yes1.setActionCommand("11");
		yes1.addActionListener(I);
		
		JButton no1 = new JButton("No");
		contested.add(no1);
		no1.setActionCommand("01");
		no1.addActionListener(I);
		
		holder.add(contested);
		
		p.setContentPane(holder);
		p.setSize(new Dimension(700, 400));
		p.setVisible(true);
	}
}
