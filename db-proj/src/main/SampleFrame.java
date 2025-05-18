package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class SampleFrame extends JFrame implements ActionListener{
	
	JButton nextButton;
	JLabel nextLabel; 
	
	
	SampleFrame() {
		nextButton = new JButton("Next");
		nextButton.setBounds(200, 100, 200, 100);
		//nextButton.setText("Next");
		nextButton.setFocusable(false);
		nextButton.setFont(new Font("Comics Sans", Font.BOLD, 25));
		nextButton.setForeground(Color.cyan);
		nextButton.setBackground(Color.gray);
		nextButton.setBorder(BorderFactory.createEtchedBorder());
		// nextButton.setEnabled(false);
		nextButton.addActionListener(this);
		
		            
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(null);
		this.setSize(getMaximumSize());
		this.setVisible(true);
		this.add(nextButton);	
		//this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nextButton) {
			System.out.println("poop");
		}
	}

	}