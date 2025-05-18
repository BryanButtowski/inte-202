package main;

import javax.swing.*;
import java.awt.*;

public class MedicalClinicRegistrationForm {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MedicalClinicRegistrationForm().createForm());
    }

    public void createForm() {
        JFrame frame = new JFrame("I-70 Medical Clinic Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(220, 255, 235));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1 - Title
        JLabel title = new JLabel("Patient Information", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 6;
        panel.add(title, gbc);
        gbc.gridwidth = 1;

        // Row 2
        addField(panel, gbc, "Last Name", 0, 1);
        addField(panel, gbc, "First Name", 1, 1);
        addField(panel, gbc, "Middle Name", 2, 1);

        // Row 3
        addRadioGroup(panel, gbc, "Honorifics", new String[]{"Mr.", "Mrs."}, 0, 2);
        addField(panel, gbc, "Birthdate", 1, 2);
        addField(panel, gbc, "Age", 2, 2);
        addRadioGroup(panel, gbc, "Gender", new String[]{"Male", "Female"}, 3, 2);

        // Row 4
        addField(panel, gbc, "Social Security Number", 0, 3);
        addField(panel, gbc, "Marital Status", 1, 3);
        addField(panel, gbc, "Home Phone Number", 2, 3);

        // Row 5
        addField(panel, gbc, "Work Phone Number", 0, 4);
        addField(panel, gbc, "Cell Phone Number", 1, 4);

        // Row 6
        addField(panel, gbc, "Street Address", 0, 5);
        addField(panel, gbc, "City", 1, 5);
        addField(panel, gbc, "Region", 2, 5);
        addField(panel, gbc, "Zip Code", 3, 5);

        // Row 7
        addField(panel, gbc, "P.O. Box", 0, 6);
        addField(panel, gbc, "Country", 1, 6);
        addRadioGroup(panel, gbc, "Ethnicity", new String[]{"Hispanic", "Non-hispanic"}, 2, 6);
        addField(panel, gbc, "Race", 3, 6);

        // Row 8
        addField(panel, gbc, "Occupation", 0, 7);
        addField(panel, gbc, "Employer", 1, 7);
        addField(panel, gbc, "Employer Phone Number", 2, 7);

        // Row 9 - Button
        JButton nextButton = new JButton("NEXT");
        gbc.gridx = 3; gbc.gridy = 8; gbc.gridwidth = 1;
        panel.add(nextButton, gbc);

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, String label, int x, int y) {
        gbc.gridx = x; gbc.gridy = y;
        panel.add(new JLabel(label + ":"), gbc);
        gbc.gridx = x; gbc.gridy = y + 1;
        panel.add(new JTextField(15), gbc);
    }

    private void addRadioGroup(JPanel panel, GridBagConstraints gbc, String label, String[] options, int x, int y) {
        gbc.gridx = x; gbc.gridy = y;
        panel.add(new JLabel(label + ":"), gbc);
        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        for (String option : options) {
            JRadioButton radio = new JRadioButton(option);
            group.add(radio);
            radioPanel.add(radio);
        }
        gbc.gridx = x; gbc.gridy = y + 1;
        panel.add(radioPanel, gbc);
    }
}
