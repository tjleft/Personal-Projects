package DataInput;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AssistInput {
	
	public AssistInput(Shot newShot, int shotID) {

		int count = 0;
	    String file = "C:\\Player20.csv";
	    ArrayList<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	            count++;
	        }
	        
	    } catch (Exception e) {
	      //Some error logging
	    }
	    
		JFrame frame = new JFrame("Demo");
		
	    ActionListener l = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		newShot.setPlayerID(Integer.parseInt(e.getActionCommand()), 1);
				frame.dispose();
				AssistPosInput test = new AssistPosInput(newShot, shotID);
	    	}
	    };
	    
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(count, 1));
		int buttonListLength = 0;
		ArrayList<JButton> buttonList = new ArrayList<>();
		for (int index = 0; index < count; index++) {
			if(Integer.parseInt(content.get(index)[3]) >= newShot.getYear()-5) {
				buttonList.add(new JButton(content.get(index)[1] + " " + content.get(index)[2]));
				buttonList.get(buttonListLength).setActionCommand(content.get(index)[0]);
				buttonList.get(buttonListLength).addActionListener(l);
				panel.add(buttonList.get(buttonListLength));
				buttonListLength++;
			}
		}
		JScrollPane scrollPane = new JScrollPane(panel);
		
		frame.add(scrollPane);
		frame.setSize(500, 800);
		frame.setVisible(true);

	}
}
