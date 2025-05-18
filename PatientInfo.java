package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class PatientInfo extends JFrame implements ActionListener{

	JFrame mainFrame;
	JPanel hdPanel, bgPanel, formPanel; 
	JLabel hdLabel, shdLabel, titleLabel, dateLabel;
	JButton nextButton;
	
	ImageIcon logo, mainBG;
	
	public void FirstFrame() {
		
		logo = new ImageIcon("logo.png");
		Image image = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		mainBG = new ImageIcon("bg.png");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    hdPanel = new JPanel();
		hdPanel.setBackground(new Color(180, 227, 192));
		hdPanel.setBounds(0, 0, screenSize.width, 70);
		hdPanel.setLayout(new BoxLayout(hdPanel, BoxLayout.Y_AXIS));
		
		hdLabel = new JLabel("I-70 MEDICAL CLINIC REGISTRATION FORM");
		hdLabel.setFont(new Font("Arial", Font.BOLD, 24));
		hdLabel.setIcon(new ImageIcon(image));
		hdLabel.setIconTextGap(10);
		hdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		shdLabel = new JLabel("Please print and fill-out completely");
		shdLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		shdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		hdPanel.add(hdLabel);
		hdPanel.add(shdLabel);
		
		bgPanel = new JPanel() {
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(mainBG.getImage(), 0, 0, getWidth(), getHeight(), this);
        	}
		};
		bgPanel.setLayout(new BorderLayout());
		
		formPanel = new JPanel(new GridBagLayout());
		formPanel.setOpaque(false);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(20, 10, 20, 10);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		
		
		titleLabel = new JLabel("Patient Information", JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		gbc.gridwidth = 6;
		formPanel.add(titleLabel);
        gbc.gridwidth = 1;
        
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate currentDate = LocalDate.now();
        dateLabel = new JLabel("Date: " + date.format(currentDate));
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
        hdPanel.add(dateLabel, gbc);

        
		addLabelTextField(formPanel, gbc, "Last Name", 0, 1);
		addLabelTextField(formPanel, gbc, "First Name", 1, 1);
		addLabelTextField(formPanel, gbc, "Middle Name", 2, 1);
		addLabelTextField(formPanel, gbc, "Primary Care Physician", 3, 1);
		
		addLabelTextField(formPanel, gbc, "Honorifics", 0, 2);
		addLabelTextField(formPanel, gbc, "Birthdate", 1, 2);
		addLabelTextField(formPanel, gbc, "Age", 2, 2);
		addRadioGroup(formPanel, gbc, "Gender", new String[] {"Male", "Female"}, 3, 2);
		
		addLabelTextField(formPanel, gbc, "Social Security Number", 0, 3);
		addLabelTextField(formPanel, gbc, "Marital Status", 1, 3);
		
		addLabelTextField(formPanel, gbc, "Home Phone Number", 0, 4);
		addLabelTextField(formPanel, gbc, "Work Phone Number", 1, 4);
		addLabelTextField(formPanel, gbc, "Cell Phone Number", 2, 4);

		addLabelTextField(formPanel, gbc, "Street Address", 0, 5);
		addLabelTextField(formPanel, gbc, "City", 1, 5);
		addLabelTextField(formPanel, gbc, "Region", 2, 5);
		addLabelTextField(formPanel, gbc, "Zip Code", 3, 5);
		
		addLabelTextField(formPanel, gbc, "P.O Box", 0, 6);
		addLabelTextField(formPanel, gbc, "Country", 1, 6);
		addLabelTextField(formPanel, gbc, "Race", 2, 6);   
        addRadioGroup(formPanel, gbc, "Ethnicity", new String[]{"Hispanic", "Non-hispanic"}, 3, 6);
   
		
		addLabelTextField(formPanel, gbc, "Occupation", 0, 7);
		addLabelTextField(formPanel, gbc, "Employer", 1, 7);
		addLabelTextField(formPanel, gbc, "Employer Phone Number", 2, 7);
				
				
		mainFrame = new JFrame("I-70 Clinic");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setSize(screenSize.width - 100, screenSize.height - 100);
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);	
		mainFrame.setLayout(null);
		mainFrame.setIconImage(logo.getImage());
		
		nextButton = new JButton("Next");
        gbc.gridx = 7;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        formPanel.add(nextButton, gbc);
		
		bgPanel.add(hdPanel, BorderLayout.NORTH);
		bgPanel.add(formPanel, BorderLayout.CENTER);
		mainFrame.setContentPane(bgPanel);
	}


	private void addLabelTextField(JPanel panel, GridBagConstraints gbc, String label, int x, int y) {
		gbc.gridx = x * 2;
		gbc.gridy = y;
		JLabel tempLabel = new JLabel(label + ":");
	    tempLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    panel.add(tempLabel, gbc);
		gbc.gridx = x * 2 + 1; 
		gbc.gridy = y;
		panel.add(new JTextField(15), gbc);
	}
	
	private void addRadioGroup(JPanel panel, GridBagConstraints gbc, String label, 
								String[] options, int x, int y) {
        gbc.gridx = x * 2;; 
        gbc.gridy = y;
        JLabel tempLabel = new JLabel(label + ":");
        tempLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tempLabel, gbc);
        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        for (String option : options) {
            JRadioButton radio = new JRadioButton(option);
            group.add(radio);
            radioPanel.add(radio);
        }
        gbc.gridx = x * 2 + 1; 
        gbc.gridy = y + 1;
        panel.add(radioPanel, gbc);
		
	}
}
