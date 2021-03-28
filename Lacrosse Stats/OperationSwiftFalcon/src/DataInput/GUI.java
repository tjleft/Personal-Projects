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
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {

	int shotID;
	int quarterIDnum;
	char result;
	boolean shot;
	int year;
	String folder;
	String name;
	
	public GUI(String gameID) {

		JPanel text = new JPanel();
		text.setLayout(new GridLayout(6, 1));

		JLabel title = new JLabel("Enter Folder Name, File Name, and Year of Game you are statting.");
		text.add(title);

		JLabel title2 = new JLabel("Please make sure your player csv file is updated and located in your C drive.");
		text.add(title2);
		
		JTextField folderName = new JTextField("Enter Folder Name Here", 30);
		text.add(folderName);
		
		JTextField fileName = new JTextField("Enter File Name Here", 30);
		text.add(fileName);
		
		JTextField textField = new JTextField("Enter Year Here", 20);
		text.add(textField);
		
		JFrame input = new JFrame();
		input.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JButton submit = new JButton("Submit");
		text.add(submit);

		input.add(text);
		input.setSize(500, 300);
		input.setVisible(true);
		
        
        
        
		shotID = 1;
		quarterIDnum = 1;
		
		JPanel holder = new JPanel();
		holder.setLayout(new BorderLayout());

		//Game Descriptions
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));

		JButton Delete = new JButton("Previous QuarterID");
		bottomPanel.add(Delete);
		
		JLabel qIDTracker = new JLabel("Current QuarterID: " + quarterIDnum);
		bottomPanel.add(qIDTracker);
		
		JButton quarterID = new JButton("Next QuarterID");
		bottomPanel.add(quarterID);
		holder.add(bottomPanel, BorderLayout.SOUTH);

		// Shot Stuff
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(4, 1));

		JButton Shot = new JButton("Shot");
		leftPanel.add(Shot);

		JButton Goal = new JButton("Goal");
		leftPanel.add(Goal);
		
		JButton Save = new JButton("Save");
		leftPanel.add(Save);
		
		JButton Pipe = new JButton("Pipe");
		leftPanel.add(Pipe);
		
		holder.add(leftPanel, BorderLayout.WEST);

		// Field Picture
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		BufferedImage myPicture;
		
		try {
			myPicture = ImageIO.read(new File("C:\\field.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			centerPanel.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		centerPanel.setSize(new Dimension(600, 350));
		holder.add(centerPanel);

		JFrame p = new JFrame();
		p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		p.setContentPane(holder);
		p.setSize(new Dimension(700, 400));
		
		ActionListener yearInput = new ActionListener() { 
        	
        	public void actionPerformed(ActionEvent e) { 
        		
        		folder = folderName.getText();
        		name = fileName.getText();
        		year = Integer.parseInt(textField.getText());
        		input.setVisible(false);
        		p.setVisible(true);
        	}
        };
        
		submit.addActionListener(yearInput);
		
		//Listeners
		ActionListener ac = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String command = e.getActionCommand();
				
				if(command.equals("Goal") | command.equals("Shot") | command.equals("Save") | command.equals("Pipe")) {
					
					if (command.equals("Goal")) {
						result = 'G';
					} else if (command.equals("Save")) {
						result = 'S';
					} else if (command.equals("Pipe")) {
						result = 'P';
					} else {
						result = 'M';
					}
				}
				
				if(command.equals("QuarterID")) {
					nextQuarter();
					qIDTracker.setText("Current QuarterID: " + quarterIDnum);
				}
				if(command.equals("Delete")) {
					quarterIDnum--;
					qIDTracker.setText("Current QuarterID: " + quarterIDnum);
				}
			}
		};
				
		MouseListener l = new MouseListener() {
			
            
			// values to be stored and used
			Point start = new Point();
			Point end = new Point();

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				start.x = e.getX();
				start.y = e.getY();

				convertPoint(start);

				// System.out.println(start);
			}

			@Override
			public void mouseReleased(MouseEvent e) { 
				
                Shot newShot = new Shot(shotID, quarterIDnum);
                shotID ++;
                newShot.setYear(year);
                newShot.setFileName(name);
                newShot.setFolderName(folder);
                
				end.x = e.getX();
				end.y = e.getY();

				convertPoint(end);

				newShot.setResult(result);

				if (isDragged(start, end)) {
					newShot.setAssist(true);
					newShot.setaX((double) end.x/10);
					newShot.setaY((double) end.y/10-1);
				} else {
					newShot.setAssist(false);
					newShot.setaX(0);
					newShot.setaY(0);
					newShot.setPositionID(0, 1);
				}

				newShot.setsX((double) start.x/10);
				newShot.setsY((double) start.y/10-1);
				Input test = new Input(newShot, shotID);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
		centerPanel.addMouseListener(l);
		
		Shot.setActionCommand("Shot");
		Shot.addActionListener(ac);
		
		Goal.setActionCommand("Goal");
		Goal.addActionListener(ac);
		
		Save.setActionCommand("Save");
		Save.addActionListener(ac);
		
		Pipe.setActionCommand("Pipe");
		Pipe.addActionListener(ac);
		
		quarterID.setActionCommand("QuarterID");
		quarterID.addActionListener(ac);
		
		Delete.setActionCommand("Delete");
		Delete.addActionListener(ac);
//		
//		Opponent.setActionCommand("Opponent");
//		Opponent.addActionListener(ac);
	
	}
	
	public void nextQuarter() {
		quarterIDnum ++;
		if(quarterIDnum > 13) {
			quarterIDnum = 13;
		}
	}
	
	public void addShot() {
		shotID ++;
	}

	
	public void convertPoint(Point start) {
		double x = (start.x - 310)*-1;
		double y = start.y - 100;
		start.setLocation(x, y);
	}
	
	public boolean isDragged(Point start, Point End) {
		
		double distance = start.distance(End);
		
		return distance > 10;
	}
}
