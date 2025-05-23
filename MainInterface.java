import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainInterface {
    JFrame mainFrame;
    JPanel formPanel, SecondFormPanel;
    JLabel titleLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainInterface().PatientInfo());
    }

    public void PatientInfo() {
        formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        titleLabel = new JLabel("Patient Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        formPanel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        HelperMethods.addLabelTextField(formPanel, gbc, "Primary Care Physician", 0, 1);
        HelperMethods.addLabelTextField(formPanel, gbc, "Last Name", 1, 1);
        HelperMethods.addLabelTextField(formPanel, gbc, "First Name", 2, 1);
        HelperMethods.addLabelTextField(formPanel, gbc, "Middle Name", 3, 1);
        HelperMethods.addRadioGroup(formPanel, gbc, "Honorifics", new String []{"Mr.", "Ms."}, 0, 2);
        
        HelperMethods.addRadioGroup(formPanel, gbc, "Gender", new String[]{"Male", "Female"}, 1, 2);

        HelperMethods.addBackNextBtn(formPanel, gbc, 7, 8);

        mainFrame = HelperMethods.createBaseWindow("I-70 Clinic", formPanel);
        mainFrame.setVisible(true);
    }
    
    /** 
    public void ResponsibleParty() {
        SecondFormPanel = new JPanel();

		addLabelTextField(SecondFormPanel, gbc, "Person Responsible for Bill ", 0, 1);
		addBirthdateComboBoxes(SecondFormPanel, gbc, 1, 1);
		addLabelTextField(SecondFormPanel, gbc, "Address (If Different)", 0, 2);
		addLabelTextField(SecondFormPanel, gbc, "Phone Number", 1, 2);
		
		addLabelTextField(SecondFormPanel, gbc, "Occupation", 0, 3);
		addLabelTextField(SecondFormPanel, gbc, "Employer", 1, 3);
		addLabelTextField(SecondFormPanel, gbc, "Employer Address", 0, 4);
		addLabelTextField(SecondFormPanel, gbc, "Employer Phone Number", 1, 4);
    }
    **/
}
