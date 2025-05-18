package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	JFrame mainFrame;
	JPanel hdPanel, bgPanel; 
	JLabel hdLabel, shdLabel, titleLabel;
	
	ImageIcon logo, mainBG;
	
	public void FirstFrame() {
		
		logo = new ImageIcon("logo.png");
		Image image = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		mainBG = new ImageIcon("bg.png");

	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5, 10, 5, 10);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		
		hdPanel = new JPanel();
		hdPanel.setBackground(new Color(180, 227, 192));
		hdPanel.setBounds(0, 0, 1400, 70);
		hdPanel.setLayout(new BoxLayout(hdPanel, BoxLayout.Y_AXIS));
		
		bgPanel = new JPanel() {
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(mainBG.getImage(), 0, 0, getWidth(), getHeight(), this);
        	}
		};
		bgPanel.setLayout(null); 
		
		
		
		hdLabel = new JLabel("I-70 MEDICAL CLINIC REGISTRATION FORM");
		hdLabel.setFont(new Font("Arial", Font.BOLD, 24));
		hdLabel.setIcon(new ImageIcon(image));
		hdLabel.setIconTextGap(10);
		hdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		shdLabel = new JLabel("Please print and fill-out completely");
		shdLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		shdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		titleLabel = new JLabel("Patient Information", JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 6;
		
		/*
		addLabelField() {
		
		}*/
		
		
		
		mainFrame = new JFrame("I-70 Clinic");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setSize(getMaximumSize());
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);	
		mainFrame.setLayout(null);
		mainFrame.setIconImage(logo.getImage());
		
		hdPanel.add(hdLabel);
		hdPanel.add(shdLabel);
		mainFrame.setContentPane(bgPanel);
		bgPanel.add(hdPanel);
	}
	/*
	private void addLabelField(JPanel panel, GridBagConstraints gbc, String label, int x, int y) {
		gbc.gridx = x; gbc.gridy = y;
		panel.add(new JLabel(label + ":"), gbc);
		gbc.gridx = x; gbc.gridy = y;
		panel.add(new JTextField(15), gbc);
	}*/
}
