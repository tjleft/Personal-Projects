package DataInput;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameDetails {

	boolean manUpCount = false;
	boolean transitionCount = false;
	
	public GameDetails(Shot newShot, int shotID) {
		
		JFrame p = new JFrame();
	
		ActionListener I = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
				if(command.equals("01") | command.equals("11")) {
					newShot.setTransition(command.equals("11"));
					transitionCount = true;
				}
				if(command.equals("0") |  command.equals("1") | command.equals("2")) {
					newShot.setManUp(command);
					manUpCount = true;
				}
				if(manUpCount & transitionCount) {
					FileWriter fileWriter;
					try {
						String dir = "C:\\";
						if(!newShot.getFolderName().equals("")) {
						    File folder = new File(dir+newShot.getFolderName());
						    if(!folder.exists()) {
						    	folder.mkdir();
						    }
						    dir = dir+newShot.getFolderName();
						}
						fileWriter = new FileWriter(dir + "\\" + newShot.getFileName() + ".csv", true);
						PrintWriter printWriter = new PrintWriter(fileWriter);
						printWriter.println(newShot.toString());
						printWriter.close();
						System.out.println(newShot.toString());
					} catch (IOException exception) {
						exception.printStackTrace();
					}
					p.dispose();
				}
			}
		};
		
		JPanel holder = new JPanel();
		holder.setLayout(new GridLayout(1, 2));
		
		//manup
		JPanel manUp = new JPanel();
		manUp.setLayout(new GridLayout(4,1));
		
		JLabel manUpInput = new JLabel("Was there a power play?");
		manUp.add(manUpInput);

		JButton yes = new JButton("Yes");
		manUp.add(yes);
		yes.setActionCommand("1");
		yes.addActionListener(I);
		
		JButton no = new JButton("No");
		manUp.add(no);
		no.setActionCommand("0");
		no.addActionListener(I);
		
		JButton flag = new JButton("Flag Down");
		manUp.add(flag);
		flag.setActionCommand("2");
		flag.addActionListener(I);
		
		holder.add(manUp);
		
		//transition
		JPanel transition = new JPanel();
		transition.setLayout(new GridLayout(3,1));
		
		JLabel releaseInput = new JLabel("Was there transition?");
		transition.add(releaseInput);
		
		JButton yes1 = new JButton("yes");
		transition.add(yes1);
		yes1.setActionCommand("11");
		yes1.addActionListener(I);
		
		JButton no1 = new JButton("no");
		transition.add(no1);
		no1.setActionCommand("01");
		no1.addActionListener(I);
		
		holder.add(transition);
		
		p.setContentPane(holder);
		p.setSize(new Dimension(700, 400));
		p.setVisible(true);
	}
	
}
